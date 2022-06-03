package com.walmart.queuedatabase.controller;

import com.walmart.queuedatabase.model.People;
import com.walmart.queuedatabase.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

//    @GetMapping("/{personID}")
//    public People getPersonbyId(@RequestParam("personID") String personID){
//        return peopleService.getPersonById(personID);
//    }

    @GetMapping()
    public List<People> getAllPeople(){
        return peopleService.getAllPeople();
    }
}

