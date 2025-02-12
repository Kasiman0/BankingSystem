package by.softclub.test.clientservice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="Full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "Date_of_birth" , nullable = false)
    private LocalDate dob;

    @Column(name = "Passport_number", length = 14, nullable = false, unique = true) // остальное в другой таблице
    private String passportNumber;

    @Column(length = 20, nullable = false, unique = true)
    private String email;

    @Column(name = "Phone_number", length = 13, nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "Postal_Code", length = 6)
    private String postalCode;

    @Column(length = 100)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "Client_status", nullable = false)
    private ClientStatus clientStatus;

    @Column(name = "Registration_date")
    private LocalDate registrationDate;

    //история изменений тоже другая таблица?


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public ClientStatus getClientStatus() { return clientStatus; }
    public void setClientStatus(ClientStatus clientStatus) { this.clientStatus = clientStatus; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }
}
