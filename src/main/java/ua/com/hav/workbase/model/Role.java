package ua.com.hav.workbase.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String value;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "roles_mappings",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "mapping_id"))
//    private List<AccessRight> mappings = new ArrayList<>();

//    @Transient
//    private List<String> stringMapppings = new ArrayList<>();
}
