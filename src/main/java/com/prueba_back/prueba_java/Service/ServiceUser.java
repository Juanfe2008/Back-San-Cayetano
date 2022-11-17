package com.prueba_back.prueba_java.Service;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Response.UserSaveResponse;
import com.prueba_back.prueba_java.Response.UsersResponse;


public interface ServiceUser {

    public UserSaveResponse save(UserDto userDto);

    public UsersResponse listAll();

    public UserDto listById(Long id);

    public UserSaveResponse update( UserDto userDto);

}
