package com.assesment.securityservice.mapper;

import com.assesment.securityservice.dto.UserCredentialDto;
import com.assesment.securityservice.entity.UserCredential;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialMapper {
    public UserCredentialDto toDto(UserCredential entity) {
        if (entity == null) {
            return null;
        }

        UserCredentialDto dto = new UserCredentialDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setUserRole(entity.getUserRole());
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public UserCredential toCreateEntity(UserCredentialDto dto) {
        if (dto == null) {
            return null;
        }

        UserCredential entity = new UserCredential();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setGender(dto.getGender());
        entity.setUserRole(dto.getUserRole());
        entity.setPassword(dto.getPassword());
        return entity;
    }
    public UserCredential toUpdateEntity(UserCredentialDto dto) {
        if (dto == null) {
            return null;
        }

        UserCredential entity = new UserCredential();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setGender(dto.getGender());
        entity.setUserRole(dto.getUserRole());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
