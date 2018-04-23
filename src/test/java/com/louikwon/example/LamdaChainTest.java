package com.louikwon.example;

import com.louikwon.example.java8.dto.Car;
import com.louikwon.example.java8.example.LamdaChain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LamdaChainTest {
    @Test
    public void comparing_조합예제() {
        List<Car> carList = new ArrayList();
        carList.add(
                Car.builder().name("BMWX6").price(1000).year(2015).build()
        );
        carList.add(
                Car.builder().name("K7").price(600).year(2017).build()
        );
        carList.add(
                Car.builder().name("MINI").price(600).year(2014).build()
        );
        carList.add(
                Car.builder().name("CRUZE").price(300).year(2013).build()
        );


        LamdaChain lamdaChain = new LamdaChain();

        Optional<List<Car>> optionalCarList = lamdaChain.comparatorChain(carList);
        if (optionalCarList.isPresent()) {
            List<Car> carListCheckList = optionalCarList.orElse(new ArrayList<>());
            Assert.assertEquals(Integer.valueOf(2014) , carListCheckList.get(1).getYear());
        }
    }

    @Test
    public void predicate_조합예제() {
        Car car1 = Car.builder()
                .name("K7")
                .color("red")
                .price(5000)
                .build();

        Car car2 = Car.builder()
                .name("K5")
                .color("blue")
                .price(4000)
                .build();

        LamdaChain lamdaChain = new LamdaChain();

        Assert.assertEquals(true, lamdaChain.PredicateChain(car1));

        Assert.assertEquals(true, lamdaChain.PredicateChain(car2));

    }
}
