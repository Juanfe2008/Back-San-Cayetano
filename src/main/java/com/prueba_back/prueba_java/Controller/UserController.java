package com.prueba_back.prueba_java.Controller;

import com.prueba_back.prueba_java.Dto.UserDto;
import com.prueba_back.prueba_java.Response.UserSaveResponse;
import com.prueba_back.prueba_java.Response.UsersResponse;
import com.prueba_back.prueba_java.Service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UserController {


    @Autowired
    private ServiceUser serviceUser;


    @GetMapping(value = "/list")
    public ResponseEntity<UsersResponse> listUsers(){

        return new ResponseEntity<UsersResponse>(serviceUser.listAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<UserSaveResponse> usersSave(@RequestBody UserDto users){
        return new ResponseEntity<UserSaveResponse>(serviceUser.save(users),HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<UserSaveResponse> usersUpdate(@RequestBody UserDto users){
        return new ResponseEntity<UserSaveResponse>(serviceUser.update(users),HttpStatus.CREATED);
    }
}
