CREATE TABLE deposits (
    id BIGSERIAL PRIMARY KEY,
    client_id INT NOT NULL,
    agreement_code CHAR(10) NOT NULL UNIQUE,
    agreement_type VARCHAR(10),
    amount DOUBLE PRECISION,
    interest_rate FLOAT NOT NULL,
    duration INT,
    sign_date DATE,
    end_date DATE,
    status VARCHAR(10) NOT NULL DEFAULT 'ACTIVE',
    replenishment BOOLEAN,
    withdrawal BOOLEAN,
    min_balance DOUBLE PRECISION,
    payment_frequency INT
);

ALTER TABLE deposits
    ADD CONSTRAINT depositStatuses
        CHECK ( status in ('ACTIVE', 'SUSPENDED', 'CLOSED') );

CREATE TABLE operation_history (
    id BIGSERIAL PRIMARY KEY,
    deposit_id INT NOT NULL,
    change_type CHAR(1) NOT NULL,
    operation CHAR(1),
    sum DOUBLE PRECISION,
    new_balance DOUBLE PRECISION,
    operation_date DATE

);

ALTER TABLE operation_history
    ADD CONSTRAINT operations
        CHECK ( type in ('W', 'R', 'A', 'S', 'C') );

CREATE TABLE agreement_conditions (
    id BIGSERIAL PRIMARY KEY,
    agreement_type VARCHAR(10) NOT NULL UNIQUE,
    replenishment BOOLEAN,
    withdrawal BOOLEAN,
    min_balance DOUBLE PRECISION,
    payment_frequency INT
);

ALTER TABLE deposits
    ADD CONSTRAINT agrTypes
        FOREIGN KEY (agreement_type) REFERENCES agreement_conditions(agreement_type);

INSERT INTO agreement_conditions(agreement_type) VALUES ('CUSTOM')