package cn.johnyu.demo.service;

import cn.johnyu.demo.domain.Person;
import cn.johnyu.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepository repository;
    @Transactional
    @Override
    public List<Person> saveAll(List<Person> personList) {
        personList.forEach(p->repository.save(p));
        return personList;
    }
}
