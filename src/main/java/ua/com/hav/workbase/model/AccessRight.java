package ua.com.hav.workbase.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "rights")
public class AccessRight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    private String entity;

    private String mapping;
    private String description;

    @ManyToMany
    @JoinTable(name = "roles_mappings",
        joinColumns = @JoinColumn(name = "mapping_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
