package com.kodilla.ecommercee.domain.product;

import com.kodilla.ecommercee.data.CartEntity;
import com.kodilla.ecommercee.domain.group.Group;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Product")
public class Product {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="PRODUCT_ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="PRICE")
    private double price;

    @ManyToMany
    @JoinTable(
            name = "JOIN_PRODUCT_CART",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")}
    )
    private List<CartEntity> carts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group groupId;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, double price, Group groupId) {
        this(name, description, price);
        this.groupId = groupId;
    }

    public void addToCart(CartEntity cart) {
        this.carts.add(cart);
        cart.getProductsList().add(this);
    }
}
