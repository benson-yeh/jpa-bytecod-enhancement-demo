package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PersonDetail")
@Data
public class PersonDetail {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @OneToOne
    @JoinColumn(name="PersonId",referencedColumnName = "Id")
    private Person person;
}
