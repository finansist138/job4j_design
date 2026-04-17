CREATE OR REPLACE PROCEDURE delete_by_id(p_id integer)
    LANGUAGE 'plpgsql'
AS $$
BEGIN
    DELETE FROM products WHERE id = p_id;
END
$$;