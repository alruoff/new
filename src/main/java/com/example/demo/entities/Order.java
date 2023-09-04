package com.example.demo.entities;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Data
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "technology",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Technology technology;
}
