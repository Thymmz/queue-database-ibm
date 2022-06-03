package com.walmart.queuedatabase.controller;

import com.walmart.queuedatabase.model.People;
import com.walmart.queuedatabase.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/{personid}")
    public Optional<People> getPersonbyId(@PathVariable("personid") String personid){
        return peopleService.getPersonById(personid);
    }

    @GetMapping()
    public List<People> getAllPeople(){
        return peopleService.getAllPeople();
    }

    @DeleteMapping("/{personid}")
    public void deletePerson(@PathVariable("personid") String personid){
        peopleService.deletePersonFromDb(personid);
    }
}

