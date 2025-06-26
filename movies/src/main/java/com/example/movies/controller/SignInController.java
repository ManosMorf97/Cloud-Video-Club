package com.example.movies.controller;

import com.example.movies.Api_url;
import com.example.movies.dao.DAO;
import com.example.movies.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"https://frontend-service:3000", Api_url.API_URL},methods = {RequestMethod.POST})
public class SignInController {





    private DAO<User> dao;

    public SignInController(DAO<User> dao){
        this.dao=dao;
    }

    @PostMapping("/SignIn")
    @ResponseBody
    public ResponseEntity<String> log_in(@RequestBody User user){
        Optional<User> logged_in=dao.get(new User(user.getEmail(),user.getPassword()));
        if (logged_in==null){
            return new ResponseEntity<>("Wrong username and/or password", HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>("Welcome "+user.getEmail(), HttpStatus.OK);
        }

    }

}
