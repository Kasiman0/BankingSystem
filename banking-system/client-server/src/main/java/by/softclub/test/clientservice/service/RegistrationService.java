package by.softclub.test.clientservice.service;

import by.softclub.test.clientservice.dto.RegistrationDto;
import by.softclub.test.clientservice.models.Registration;
import by.softclub.test.clientservice.repo.RegistrationRepository;
import by.softclub.test.clientservice.utils.RegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationMapper registrationMapper;
    private Integer id;
    private String city;
    private String houseFlatName;
    private String region;
    private String zip;

    public List<RegistrationDto> readAll() {
        List<Registration> registrations = registrationRepository.findAll();
        return registrations.stream()
                .map(RegistrationMapper::mapToRegistrationDto)
                .collect(Collectors.toList());
    }

    public Registration getById(Integer id) {
        Registration registration = registrationRepository.findById(id).orElse(null);
        return registration;
    }

    public void addRegistration(String city, String houseFlatName, String region, Integer zip) {
        addRegistration((Long) null, (String) null, (String) null, (String) null, (Integer) null);
    }

    public void addRegistration(Long id, String city, String houseFlatName, String region, Integer zip) {
        Registration registration = new Registration();
        registration.setId(id);
        registration.setCity(city);
        registration.setHouseFlatName(houseFlatName);
        registration.setRegion(region);
        registration.setZip(zip);
    }
}
