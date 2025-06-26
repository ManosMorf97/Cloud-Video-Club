package com.example.movies.controller;

import com.example.movies.Api_url;
import com.example.movies.dao.DAO;
import com.example.movies.model.Bookmark;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"https://frontend-service:3000", Api_url.API_URL},methods = {RequestMethod.POST,RequestMethod.DELETE})
public class BookmarkController {

    private DAO<Bookmark> bookmarkDAO;

    public BookmarkController(DAO<Bookmark> bookmarkDAO){
        this.bookmarkDAO=bookmarkDAO;
    }

    @PostMapping("/MyBookmarks")
    @ResponseBody
    public ArrayList<Bookmark> myBookmarks(@RequestBody Bookmark bookmark){//email only
        return (ArrayList<Bookmark>) bookmarkDAO.ListOf(bookmark);
    }

    @DeleteMapping("/MyBookmarks")
    @ResponseBody
    public void deleteBookmark(@RequestBody Bookmark bookmark){// all parameters
        bookmarkDAO.delete(bookmark);//
    }

}
