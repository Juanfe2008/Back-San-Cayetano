package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Mappers.UsersMapper;
import com.prueba_back.prueba_java.Repository.UserRepository;
import com.prueba_back.prueba_java.Response.UserSaveResponse;
import com.prueba_back.prueba_java.Response.UsersResponse;
import com.prueba_back.prueba_java.Service.ServiceUser;
import com.prueba_back.prueba_java.Utils.EncriptarDesencriptar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplUser implements ServiceUser {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UsersMapper usersMapper;


    @Override
    public UserSaveResponse save(UserDto userDto) {

        try{

            String PasswordEncryp = EncriptarDesencriptar.Encriptar(userDto.password());
            String UserNameEncryp = EncriptarDesencriptar.Encriptar(userDto.username());

            Users users = new Users();

            if(userDto != null){
                users.setNameUser(userDto.name());
                users.setLastname(userDto.lastName());
                users.setUsername(UserNameEncryp);
                users.setPassword(PasswordEncryp);
                users.setPhone(userDto.phone());
                users.setAddres(userDto.addres());
                users.setEmail(userDto.email());
                users.setIdentification(userDto.identification());
                userRepository.save(users);
                users.setPassword("");
                return usersMapper.toResponseUserSave(users,201,"Usuario Creado con Exitosamente","201");
            }
            return usersMapper.toResponseUserSave(null,201,"Fallo al crear el usuario","201");
        }catch (Exception e){
            return usersMapper.toResponseUserSave(null, 400, e.toString(),
                    "400");
        }


    }

    @Override
    public UsersResponse listAll() {

        try{

            List<Users> users =  userRepository.findAll();
            for (Users user : users) {
                user.setUsername(EncriptarDesencriptar.Desencriptar(user.getUsername()));
            }
            return usersMapper.toResponseUserDto(users,200,"Lista de usuarios consultada exitosamente","200");
        }catch (Exception e){
            return UsersResponse.builder()
                    .codResponse(400)
                    .message(e.toString())
                    .status("400")
                    .build();
        }

    }

    @Override
    public UserDto listById(Long id) {
        return null;
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        return null;
    }
}
