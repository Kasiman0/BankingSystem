package by.softclub.test.clientservice.dto;

import by.softclub.test.clientservice.entity.ClientStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClientUpdateRequest {

    @NotNull
    private long id;

    @Size(max = 50)
    private String fullName;

    @Size(max = 20)
    private String email;

    @Size(max = 13)
    private String phoneNumber;

    @Size(max = 6)
    private String postalCode;

    @Size(max = 100)
    private String address;

    private ClientStatus status;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public ClientStatus getStatus() { return status; }
    public void setStatus(ClientStatus status) { this.status = status; }
}
