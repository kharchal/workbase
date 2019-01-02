package ua.com.hav.workbase.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 10)
    private String name;

    @Size(min = 3, max = 10)
    private String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
//        this.id = id;
    }
}
