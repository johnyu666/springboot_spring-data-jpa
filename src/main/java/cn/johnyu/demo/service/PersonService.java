package cn.johnyu.demo.service;

import cn.johnyu.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService {

    public List<Person> saveAll(List<Person> personList);
}
