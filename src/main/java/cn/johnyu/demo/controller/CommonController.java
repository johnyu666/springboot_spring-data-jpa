package cn.johnyu.demo.controller;

import cn.johnyu.demo.domain.Person;
import cn.johnyu.demo.repository.PersonRepository;
import cn.johnyu.demo.service.PersonService;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ConfigurationProperties(prefix = "author")
@Getter
@Setter
@Controller
public class CommonController {
    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonService service;
    private String name;
    private static final Logger logger= LoggerFactory.getLogger(CommonController.class.getName());
    @RequestMapping("/test")
    public String test1(Model model){
        model.addAttribute("name","John Yu");
        return "suc";
    }
    @RequestMapping(value = "/test2")
    public String test2(@RequestBody  Date birth){
        System.out.println(birth);
        return "suc";
    }
    @RequestMapping("/persons")
    @ResponseBody
    public List<Person> findAllPersons(){

        return repository.findAll();
    }

    @RequestMapping(value = "/persons",method = RequestMethod.POST)
    @ResponseBody
    public List<Person> addAllPersons(){
        List<Person> personList=new ArrayList<>();
        for (int i = 8; i < 11; i++) {
            Person p=new Person();
            p.setName("ppp"+i);
            p.setAge(i);
            p.setAddress("add"+i);
            p.setGender(true);
            personList.add(p);
        }
        return service.saveAll(personList);
    }
}
