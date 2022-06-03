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

    public People getPersonById(String personid){
        return peopleDao.findById(personid).orElseThrow(()-> new RuntimeException("Person not found with id :" + personid));
    }

    public List<People> getAllPeople(){
        return peopleDao.findAll();
    }

    public void savePersontoDb(People person){
        peopleDao.save(person);
    }

    public void deletePersonFromDb(String personid){
        People person = peopleDao.findById(personid).orElseThrow(()-> new RuntimeException("Person not found with id :" + personid));
        peopleDao.delete(person);
    }

    public void clearDb(){
        peopleDao.deleteAll();
    }
}
