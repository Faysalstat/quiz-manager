package com.assesment.securityservice.serviceImp;

import com.assesment.securityservice.dto.*;
import com.assesment.securityservice.entity.UserCredential;
import com.assesment.securityservice.exception.OperationFailedException;
import com.assesment.securityservice.mapper.UserCredentialMapper;
import com.assesment.securityservice.repository.UserCredentialRepository;
import com.assesment.securityservice.service.AuthService;
import com.assesment.securityservice.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {

    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserCredentialMapper userCredentialMapper;

    @Autowired
    private JwtService jwtService;

    @Override
    public String saveUser(UserCredentialDto userCredentialDto) throws OperationFailedException {
        if(repository.findByEmail(userCredentialDto.getEmail()).isPresent()){
            throw new OperationFailedException("User Already Exists");
        }
        userCredentialDto.setPassword(passwordEncoder.encode(userCredentialDto.getPassword()));
        try {
            repository.save(userCredentialMapper.toEntity(userCredentialDto));
        }catch (Exception e){
            return "user added to the system failed";
        }

        return "user added to the system";
    }

    @Override
    public LoginResponse generateToken(String username) {
        UserCredential userCredential = repository.findByEmail(username).orElseThrow();
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtService.generateToken(userCredential));
        loginResponse.setUserName(userCredential.getEmail());
        loginResponse.setUserRole(userCredential.getUserRole());
        return loginResponse;
    }

    @Override
    public Boolean validateToken(String token) {
        try{
            jwtService.validateToken(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserCredentialDto getUserByUserName(String username) {
        return userCredentialMapper.toDto(repository.findByEmail(username).orElseThrow());
    }

    private UserClientDTO toCustomerDto(UserRegistrationDto userRegistrationDto){
            if (userRegistrationDto == null) {
                return null;
            }

            UserClientDTO userClientDto = new UserClientDTO();
            userClientDto.setId(userRegistrationDto.getId());
            userClientDto.setFirstName(userRegistrationDto.getFirstName());
            userClientDto.setLastName(userRegistrationDto.getLastName());
            userClientDto.setPhoneNumber(userRegistrationDto.getPhoneNumber());
            userClientDto.setEmail(userRegistrationDto.getEmail());
            userClientDto.setDateOfBirth(userRegistrationDto.getDateOfBirth());
            userClientDto.setGender(userRegistrationDto.getGender());
            userClientDto.setAddress(userRegistrationDto.getAddress());
            userClientDto.setState(userRegistrationDto.getState());
            userClientDto.setCreditScore(userRegistrationDto.getCreditScore());
            userClientDto.setPanCardNumber(userRegistrationDto.getPanCardNumber());
            userClientDto.setCountry(userRegistrationDto.getCountry());
            userClientDto.setClientType(userRegistrationDto.getUserRole());
            // Assuming other fields are not applicable or omitted for CustomerDTO

            return userClientDto;
        }

}
