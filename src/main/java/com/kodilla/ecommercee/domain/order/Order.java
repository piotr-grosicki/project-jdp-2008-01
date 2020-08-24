package com.kodilla.ecommercee.domain.order;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ORDER")
@ToString
@NoArgsConstructor
public class Order {
    @Id
    private long id;
}
