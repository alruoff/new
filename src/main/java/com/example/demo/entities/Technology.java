package com.example.demo.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="technology")
public class  Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nameOfSet")
    private String nameOfSet; // имя цепочки операций

    private Boolean is_actieve; // включить / выключить
    @CreationTimestamp
    private LocalDateTime created_at; // когда создана

    @Column(name = "description", columnDefinition = "text")
    private String description; // описание типового ТЗ в виде текста

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer author_id;
}
