package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.PersonDetail;
import com.example.demo.repository.PersonDetailRepository;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DemoApplicationTests {

  @Autowired PersonRepository personRepository;

  @Autowired PersonDetailRepository personDetailRepository;

  @Test
  public void contextLoad() {}

  @Test
  @Sql("classpath:/data.sql")
  @Transactional
  void findAllPersonThenFetchPersonDetail() {
    var personList = personRepository.findAll();
    personList.forEach(data -> data.getPersonDetail());
  }

  @Test
  @Sql("classpath:/data.sql")
  @Transactional
  void findAllPerson() {
    var personList = personRepository.findAll();
  }


}
