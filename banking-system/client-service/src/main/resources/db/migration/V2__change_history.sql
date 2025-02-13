CREATE TABLE Change_history (
    id BIGSERIAL PRIMARY KEY,
    type CHAR(1) NOT NULL,
    client_id INTEGER NOT NULL,
    column_name VARCHAR(20),
    old_value VARCHAR(100),
    new_value VARCHAR(100),
    change_date DATE
);

ALTER TABLE Change_history
    ADD CONSTRAINT types
        CHECK(type IN ('C', 'U', 'D'))