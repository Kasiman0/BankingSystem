CREATE table Clients (
    id BIGSERIAL PRIMARY KEY,
    Full_name VARCHAR(50) NOT NULL,
    Date_of_birth DATE NOT NULL,
    Passport_number CHAR(14) NOT NULL UNIQUE,
    email VARCHAR(20) NOT NULL UNIQUE,
    Phone_number CHAR(13) NOT NULL UNIQUE,
    Postal_code CHAR(6),
    Address VARCHAR(100),
    Client_status VARCHAR(10) NOT NULL DEFAULT 'ACTIVE',
    Registration_date DATE
);
ALTER TABLE Clients
ADD CONSTRAINT clientStatuses
CHECK ( Сlient_status IN ('ACTIVE', 'BLOCKED', 'SUSPENDED') );

