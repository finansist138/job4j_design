CREATE
OR REPLACE FUNCTION log_prices()
RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO history_of_price (name, price, date)
    VALUES (NEW.name, NEW.price, now());
    RETURN NEW;
END;
$$
    LANGUAGE 'plpgsql';

CREATE TRIGGER tax_trigger_after
    AFTER INSERT
    ON products
    FOR EACH ROW
EXECUTE PROCEDURE log_prices();