package com.walmart.queuedatabase.services;

import com.walmart.queuedatabase.dao.PeopleDao;
import com.walmart.queuedatabase.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleDao peopleDao;

    public PeopleService(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    public Optional<People> getPersonById(String personid){
        return peopleDao.findById(personid);
    }

    public List<People> getAllPeople(){
        return peopleDao.findAll();
    }

    public void savePersontoDb(People person){
        peopleDao.save(person);
    }
}
