package com.louikwon.example.java8.example;

import com.louikwon.example.java8.dto.Car;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

/**
 * 람다식을 조합하여 복합한 표현식을 만들자.
 * java8 in action p117
 */
public class LamdaChain {
    public Optional<List<Car>> comparatorChain() {
        //비교에 사용할 키를 추출하는 Funcation 기반의 Comparator
        Comparator<Car> c = comparing(Car::getPrice);

        List<Car> carList = new ArrayList();
        carList.add(
            Car.builder().name("BMWX6").price(1000).year(2015).build()          );
        carList.add(
            Car.builder().name("K7").price(600).year(2017).build()              );
        carList.add(
            Car.builder().name("MINI").price(600).year(2014).build()              );
        carList.add(
            Car.builder().name("CRUZE").price(300).year(2013).build()           );

        //가격을 내림차순으로 정렬 후 가격이 같으면 년도를 오름차순으로 정렬
        carList.sort(comparing(Car::getPrice)
                .reversed()
                .thenComparing(Car::getYear));

        return Optional.ofNullable(carList);
    }


}
