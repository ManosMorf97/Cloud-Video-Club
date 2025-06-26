package com.example.movies.controller;

import com.example.movies.Api_url;
import com.example.movies.dao.DAO;
import com.example.movies.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"https://frontend-service:3000", Api_url.API_URL},methods = {RequestMethod.POST})
public class SignUpController {

    private DAO<User> dao;

    public SignUpController(DAO<User> dao){
        this.dao=dao;
    }

    @PostMapping("/SignUp")
    @ResponseBody
    public ResponseEntity<String> insertNewUser(@RequestBody User user){
        if(dao.Create(user))
            return new ResponseEntity<>("The user has created",HttpStatus.OK);
        else
            return new ResponseEntity<>("That user already exists",HttpStatus.NOT_ACCEPTABLE);
    }

}
