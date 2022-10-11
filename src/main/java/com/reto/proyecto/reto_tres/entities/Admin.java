/*package com.reto.proyecto.reto_tres.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name = "costume")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String brand;

    @Column(length = 250)
    private String description;

    @Column(name = "year")
    private Integer anio;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("costumes")
    private Category category;

    

    
}
*/