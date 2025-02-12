package by.softclub.test.clientservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientRequest {

    @NotEmpty
    @Size(max = 50)
    private String fullName;

    @NotEmpty
    private String dob;

    @NotEmpty
    @Size(max = 14)
    private String passportNumber;

    @NotEmpty
    @Size(max = 20)
    private String email;

    @NotEmpty
    @Size(max = 13)
    private String phoneNumber;

    @Size(max = 6)
    private String postalCode;

    @Size(max = 100)
    private String address;

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

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

}
