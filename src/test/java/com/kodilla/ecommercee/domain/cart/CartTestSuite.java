package com.kodilla.ecommercee.domain.cart;

import com.kodilla.ecommercee.domain.cart.dao.CartDao;
import com.kodilla.ecommercee.domain.product.Product;
import com.kodilla.ecommercee.domain.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {
    @Autowired
    private CartDao cartDao;

    @Test
    public void saveCart() {
        //Given
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        List<Product> productList = new ArrayList<>();
        productList.add(product4);

        Cart cart1 = new Cart(user1, product1);
        Cart cart2 = new Cart(user2, product2, product3);
        Cart cart3 = new Cart(user3, productList);

        //When
        cartDao.save(cart1);
        cartDao.save(cart2);
        cartDao.save(cart3);

        //Then
        Assert.assertEquals(cart1, cartDao.findById(cart1.getId()).get());
        Assert.assertEquals(cart2, cartDao.findById(cart2.getId()).get());
        Assert.assertEquals(cart3, cartDao.findById(cart3.getId()).get());

        //CleanUp
        cartDao.deleteById(cart1.getId());
        cartDao.deleteById(cart2.getId());
        cartDao.deleteById(cart3.getId());
    }
}
