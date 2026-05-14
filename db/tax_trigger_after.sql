CREATE
    OR REPLACE FUNCTION tax()
RETURNS trigger AS
$$
BEGIN
    UPDATE products
    SET price = price * 1.22
    WHERE id = (SELECT id FROM inserted);
    RETURN new;
END;
$$
    LANGUAGE 'plpgsql';

CREATE TRIGGER tax_trigger_after
    AFTER INSERT
    ON products
    REFERENCING NEW TABLE AS
    inserted
    FOR EACH STATEMENT
    EXECUTE PROCEDURE tax();

CREATE
OR REPLACE FUNCTION tax_before()
    RETURNS trigger AS
$$
BEGIN
    NEW.price := NEW.price * 1.22;
    RETURN NEW;
END;
$$
    LANGUAGE 'plpgsql';

CREATE TRIGGER tax_trigger_before
    BEFORE INSERT
    ON products
    FOR EACH ROW
    EXECUTE PROCEDURE tax_before();