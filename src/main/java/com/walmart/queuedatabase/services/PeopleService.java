package com.walmart.queuedatabase.services;

import com.walmart.queuedatabase.dao.PeopleDao;
import com.walmart.queuedatabase.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    public PeopleService(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

//    public People getPersonById(String personID){
//        return peopleDao.getPeopleByPersonid(personID);
//    }

    public List<People> getAllPeople(){
        return peopleDao.findAll();
    }
}
