package com.walmart.queuedatabase.dao;

import com.walmart.queuedatabase.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao extends JpaRepository<People, String> {
    //People getPeopleByPersonid(String personID);
}
