package com.urugondavishnu.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder //for builder methods
@AllArgsConstructor // constructor with all args
@NoArgsConstructor//constructor without any args
@ToString // .toString() method is establishes
@Getter
@Setter
@Entity // java class as database entity
@Table(name = "addresses")
public class Address {
    @Id //primary key for a table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tells the persistence provider (like Hibernate) to auto-generate the primary key using the database’s auto-increment feature.
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;

    @Column(name = "state")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}