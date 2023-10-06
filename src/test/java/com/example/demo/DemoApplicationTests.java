package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonDetailRepository;
import com.example.demo.repository.PersonRepository;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

  @Autowired PersonRepository personRepository;

  @Autowired PersonDetailRepository personDetailRepository;

  @BeforeAll
  static void setUp() {}

  @Test
  public void contextLoad() {}

  @Test
  @Transactional
  @DisplayName("(有transaction)先取主檔再取子檔")
  void findAllPersonThenFetchPersonDetail() {
    var personList = personRepository.findAll();
    personList.forEach(data -> data.getPersonDetail());
  }

  @Test
  @Transactional
  @DisplayName("取得所有人員")
  void findAllPerson() {
    var personList = personRepository.findAll();
    var allPersonName =
        personList.stream().map(Person::getName).collect(Collectors.joining(","));
    System.out.println(allPersonName);
  }

  @Test
  @DisplayName("(無transaction)先取主檔再取子檔")
  void findPersonAndGetDetail() {
    Throwable t =
        assertThrows(
            Exception.class,
            () -> {
              var personList = personRepository.findAll();
              var detailList =
                  personList.stream().map(Person::getPersonDetail).collect(Collectors.toList());
            });
    System.out.println(t.getMessage());
  }
}
