package com.louikwon.example.java8.example;

import com.louikwon.example.java8.dto.Car;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 다양한 Optional 활용법
 */
@Slf4j
public class OptionalExample {

    /**
     * Optional 객체 생성 예제
     */
    public void createOptional() {
       //List<Car> carList = null;

        List<Car> carList = new ArrayList<>();
        carList.add(new Car());

        //if (carList != null && carList.size() > 0 를 대체할 수 있다.
        Optional.ofNullable(carList)
            .orElseGet(Collections::emptyList)
            .stream().forEach(c -> {
               log.info(">> car " + c);
            });


        Car car = null;
        car = new Car();
        car.setName("CRUZE");
        String carName = Optional.ofNullable(car)
                .orElseThrow(() -> new RuntimeException("자동차가 없습니다."))
                .getName();

        log.info("car Name " + carName);

        Optional<String> of = Optional.empty();

        // 이렇게 할꺼면 하지마. 기존 널체크와 같다. Optional 을 쓸 이유가 없어.
        String result = of.isPresent() ? of.get() : null;


     }
}
