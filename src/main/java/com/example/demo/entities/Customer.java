package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName; // иное, чем логин
    private Boolean is_blocked;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
    private String email;
    private String position;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    public Customer(String name, Boolean is_blocked, LocalDateTime created_at,
                    LocalDateTime updated_at, String email, String position, User user) {
        this.fullName = name;
        this.is_blocked = is_blocked;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.email = email;
        this.position = position;
        this.user = user;
    }
    public Customer() {
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(Boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }
}
//    @OneToMany
////    @OnDelete(action= OnDeleteAction.NO_ACTION)
////    @JoinTable (name = "technology",
////            joinColumns = @JoinColumn(name = "id"),
////            inverseJoinColumns = @JoinColumn(name = "id"))
//    private Collection<Technology> technologies = new ArrayList<>(); // набор записей в таблице

/*

        @OneToOne(fetch = FetchType.EAGER)
        @JoinTable(name = "user",
                joinColumns = @JoinColumn(name = "id"),
                inverseJoinColumns = @JoinColumn(name = "id"))


    @OneToOne(mappedBy = "customer", cascade =  // есть все, кроме REMOVE
    {
           CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
           CascadeType.REFRESH
    })
    private User user;

 */