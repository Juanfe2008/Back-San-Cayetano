package com.prueba_back.prueba_java.Mappers;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Response.UserSaveResponse;
import com.prueba_back.prueba_java.Response.UsersResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersMapper {
    public UsersResponse toResponseUserDto(List<Users> users, Integer codeResponse, String message, String status){
        return UsersResponse.builder()
                .message(message)
                .codResponse(codeResponse)
                .status(status)
                .usersDto(toUser(users))
                .build();
    }

    public List<UserDto> toUser(List<Users> users){
        if (users != null && !users.isEmpty()){
            return users.stream().map(this::toUserMapp)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public UserDto toUserMapp(Users users){
        if (users != null){
            return UserDto.builder()
                    .id(users.getId())
                    .name(users.getNameUser())
                    .lastName(users.getLastname())
                    .addres(users.getAddres())
                    .identification(users.getIdentification())
                    .username(users.getUsername())
                    .phone(users.getPhone())
                    .email(users.getEmail())
                    .totalValue(users.getTotalValue())
                    .build();
        }
        return null;
    }

    public UserSaveResponse toResponseUserSave(Users users, Integer codeResponse, String message, String status){
        return UserSaveResponse.builder()
                .codResponse(codeResponse)
                .message(message)
                .status(status)
                .usersDto(toUserSave(users))
                .build();
    }

    public UserDto toUserSave(Users users){
        UserDto userDto = new UserDto();

        if (users != null){
            userDto.setName(users.getNameUser());
            userDto.setLastName(users.getLastname());
            userDto.setUsername(users.getUsername());
            userDto.setPassword(users.getPassword());
            userDto.setPhone(users.getPhone());
            userDto.setEmail(users.getEmail());
            userDto.setAddres(users.getAddres());
            userDto.setIdentification(users.getIdentification());
            userDto.setTotalValue(users.getTotalValue());

            return userDto;
        }
        return null;
    }
}
