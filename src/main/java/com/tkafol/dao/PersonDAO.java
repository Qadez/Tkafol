package com.tkafol.dao;

import java.util.List;

import com.tkafol.model.Person;
 
public interface PersonDAO {
 
    public void addPerson(Person p);
    public List<Person> listPersons();
}