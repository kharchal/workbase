package ua.com.hav.workbase.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Person person;

    @Min(0)
    @Max(100000)
//    @Pattern(regexp = "[0-9]+")
    private Integer balance = 0;

    @ManyToOne
    private Level level;
//    private Info info;

    public Client(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return (person == null) ? "" : person.getName() + " " + person.getSurname();
    }
}
