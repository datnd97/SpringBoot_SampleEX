package com.security.demospringsecurity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String picture;

}
