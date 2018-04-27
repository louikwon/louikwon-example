package com.louikwon.example;

import com.louikwon.example.java8.dto.Car;
import com.louikwon.example.java8.example.LamdaChain;
import com.louikwon.example.java8.example.OptionalExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LamdaChainTest {


    @Test
    public void predicate_조합예제() {
        Car car1 = Car.builder()
                .name("K7")
                .color("red")
                .price(5000)
                .build();

        Car car2 = Car.builder()
                .name("K5")
                .color("red")
                .price(4000)
                .build();
        LamdaChain lamdaChain = new LamdaChain();

        Assert.assertEquals(true, lamdaChain.predicateChain(car1));

        Assert.assertEquals(false, lamdaChain.predicateChain(car2));

    }

    @Test
    public void Function_조합예제() {
        LamdaChain lamdaChain = new LamdaChain();

        Assert.assertEquals(400, lamdaChain.functionChain(10));
    }


    @Test
    public void OptionalTest() {
        OptionalExample optionalExample = new OptionalExample();
        optionalExample.createOptional();
    }
}
