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

    private String name; // имя заказа

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Customer owner; // менеджер, ведущий заказ

    private String declaration; // общая информация о заказе из Приложения

    @OneToOne(cascade = CascadeType.ALL)
    private Technology techno; // технологич. цепочка, по которой заказ будет выполняться

    private Boolean is_active;
}

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(name = "technology",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id"))
//    private Technology technology;

