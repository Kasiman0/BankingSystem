CREATE table Clients (
    id BIGSERIAL PRIMARY KEY,
    fullName VARCHAR(50) NOT NULL,
    dob DATE NOT NULL,
    passportNumber CHAR(14) NOT NULL UNIQUE,
    email VARCHAR(20) NOT NULL UNIQUE,
    phoneNumber CHAR(13) NOT NULL UNIQUE,
    postalCode CHAR(6),
    address VARCHAR(100),
    clientStatus VARCHAR(10) NOT NULL DEFAULT 'ACTIVE',
    registrationDate DATE
);
ALTER TABLE Clients
ADD CONSTRAINT clientStatuses
CHECK ( clientStatus IN ('ACTIVE', 'BLOCKED', 'SUSPENDED') );

