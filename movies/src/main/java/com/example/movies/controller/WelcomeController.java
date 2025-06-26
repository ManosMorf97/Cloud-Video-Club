package com.example.movies.controller;

import com.example.movies.Api_url;
import com.example.movies.dao.DAO;
import com.example.movies.model.Bookmark;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"https://frontend-service:3000", Api_url.API_URL},methods = {RequestMethod.POST,RequestMethod.GET})
public class WelcomeController {

    private DAO<Bookmark> bookmarkDAO;

    public WelcomeController(DAO<Bookmark> bookmarkDAO) {
        this.bookmarkDAO = bookmarkDAO;
    }

    @PostMapping("/Welcome")
    @ResponseBody
    public ResponseEntity<String> addBookmark(@RequestBody Bookmark bookmark){
        bookmarkDAO.Create(bookmark);
        return new ResponseEntity<String>("The movie has been added", HttpStatus.OK);

    }

    @GetMapping("/users")
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok("List of users");
    }

}
