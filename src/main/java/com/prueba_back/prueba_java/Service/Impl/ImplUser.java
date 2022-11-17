package com.prueba_back.prueba_java.Service.Impl;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Entity.Users;
import com.prueba_back.prueba_java.Mappers.UsersMapper;
import com.prueba_back.prueba_java.Repository.UserRepository;
import com.prueba_back.prueba_java.Response.UserSaveResponse;
import org.modelmapper.ModelMapper;
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

            String PasswordEncryp = EncriptarDesencriptar.Encriptar(userDto.getPassword());
            String UserNameEncryp = EncriptarDesencriptar.Encriptar(userDto.getUsername());

            Users users = new Users();

            if(userDto != null){
                users.setNameUser(userDto.getName());
                users.setLastname(userDto.getName());
                users.setUsername(UserNameEncryp);
                users.setPassword(PasswordEncryp);
                users.setPhone(userDto.getPhone());
                users.setAddres(userDto.getAddres());
                users.setEmail(userDto.getEmail());
                users.setIdentification(userDto.getIdentification());
                users.setTotalValue(userDto.getTotalValue());
                users.setTotalValue(0F);
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
    public UserSaveResponse update( UserDto userDto) {
        try{

            Users users = this.userRepository.findByIdUsers(userDto.getId());
            users.setId(userDto.getId());
            users.setTotalValue(userDto.getTotalValue());
            this.userRepository.save(users);
            return usersMapper.toResponseUserSave(users,200,"Actualizado exitosamente","200");

        }catch (Exception e){
            return UserSaveResponse.builder()
                    .codResponse(400)
                    .message(e.toString())
                    .status("400")
                    .build();
        }

    }
}
