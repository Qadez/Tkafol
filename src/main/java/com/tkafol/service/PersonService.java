package com.tkafol.service;

import java.util.List;

import com.tkafol.model.Person;
 
public interface PersonService {
 
    public void addPerson(Person p);
    public List<Person> listPersons();
     
}