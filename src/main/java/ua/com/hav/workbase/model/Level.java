package ua.com.hav.workbase.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String value;
}
