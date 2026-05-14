CREATE OR REPLACE FUNCTION delete_by_limit_data(p_limit integer)
    RETURNS integer AS $$
DECLARE
    deleted_rows integer;
BEGIN
    DELETE FROM products
    WHERE count <= p_limit;

    GET DIAGNOSTICS deleted_rows = ROW_COUNT;

    RETURN deleted_rows;
END;
$$ LANGUAGE 'plpgsql';