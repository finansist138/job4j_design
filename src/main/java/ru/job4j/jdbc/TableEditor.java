package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        String driver = properties.getProperty("driver_class");
        if (driver != null) {
            Class.forName(driver);
        }
        this.connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );
    }

    private void executeStatement(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String sql = String.format("CREATE TABLE IF NOT EXISTS %s ();", tableName);
        executeStatement(sql);
    }

    public void dropTable(String tableName) {
        String sql = String.format("DROP TABLE IF EXISTS %s;", tableName);
        executeStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format("ALTER TABLE %s ADD COLUMN %s %s;", tableName, columnName, type);
        executeStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format("ALTER TABLE %s DROP COLUMN %s;", tableName, columnName);
        executeStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName);
        executeStatement(sql);
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (in == null) {
                throw new IllegalArgumentException("Файл настроек app.properties не найден!");
            }
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String tableName = "test_table";
        try (TableEditor editor = new TableEditor(properties)) {

            editor.createTable(tableName);
            System.out.println(editor.getTableScheme(tableName));

            editor.addColumn(tableName, "id", "serial primary key");
            System.out.println(editor.getTableScheme(tableName));

            editor.addColumn(tableName, "item_name", "varchar(200)");
            System.out.println(editor.getTableScheme(tableName));

            editor.renameColumn(tableName, "item_name", "title");
            System.out.println(editor.getTableScheme(tableName));

            editor.dropColumn(tableName, "title");
            System.out.println(editor.getTableScheme(tableName));

            editor.dropTable(tableName);
            System.out.println("Таблица успешно удалена.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}