package by.softclub.test.clientservice.utils;

import by.softclub.test.clientservice.dto.RegistrationDto;
import by.softclub.test.clientservice.models.Registration;
import org.springframework.stereotype.Service;

@Service
public class RegistrationMapper {
    public static RegistrationDto mapToRegistrationDto(Registration registration)
    {
        RegistrationDto dto = new RegistrationDto();
        dto.setId(registration.getId());
        dto.setCity(registration.getCity());
        dto.setHouseFlatName(registration.getHouseFlatName());
        dto.setRegion(registration.getRegion());
        dto.setZip(registration.getZip());
        return dto;
    }

    public Registration mapToRegistration(RegistrationDto dto)
    {
        Registration registration = new Registration();
        registration.setId(dto.getId());
        registration.setCity(dto.getCity());
        registration.setHouseFlatName(dto.getHouseFlatName());
        registration.setRegion(dto.getRegion());
        registration.setZip(dto.getZip());
        return registration;
    }
}
