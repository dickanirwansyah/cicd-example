package com.microservice.servicejob.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "theme_park_ride")
@ToString
public class ThemeParkRide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "thril_factor")
    private Integer thrilFactor;
    @Column(name = "vomit_factor")
    private Integer vomitFactor;

    public ThemeParkRide(String name, String description, Integer thrilFactor, Integer vomitFactor){
        this.name = name;
        this.description = description;
        this.thrilFactor = thrilFactor;
        this.vomitFactor = vomitFactor;
    }
}
