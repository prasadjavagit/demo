package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CD {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="cd_fk")
    private Set<Musician> musicians=new HashSet<>();

}
