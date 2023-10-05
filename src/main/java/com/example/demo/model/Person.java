package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Data
public class Person {
  @Id
  @GeneratedValue
  @Column(name = "Id")
  private Long id;

  @Column(name = "name")
  private String name;

  @OneToOne(mappedBy = "person",fetch = FetchType.LAZY)
  @LazyToOne(LazyToOneOption.PROXY)
  private PersonDetail personDetail;
}
