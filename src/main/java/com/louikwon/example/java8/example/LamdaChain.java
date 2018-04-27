package com.louikwon.example.java8.example;

import com.louikwon.example.java8.dto.Car;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * 람다식을 조합하여 복합한 표현식을 만들자.
 * java8 in action p117
 */
public class LamdaChain {
    public Optional<List<Car>> comparatorChain(List<Car> carList) {
        //비교에 사용할 키를 추출하는 Funcation 기반의 Comparator
        Comparator<Car> c = comparing(Car::getPrice);

        //가격을 내림차순으로 정렬 후 가격이 같으면 년도를 오름차순으로 정렬
        carList.sort(comparing(Car::getPrice)
                .reversed()
                .thenComparing(Car::getYear));

        return Optional.ofNullable(carList);
    }

   public boolean predicateChain (Car car) {
        Predicate<Car> blueCar = (c -> "blue".equals(c.getColor()));

        //a.or(b).and(c) == (a || b) && c
        Predicate<Car> notBlueCarAndNameIsK7 = blueCar
                .or(c -> "K7".equals(c.getName()))
                .and(c -> c.getPrice() > 3000);


       return notBlueCarAndNameIsK7.test(car);
   }

   public int functionChain(Integer input) {
       Function<Integer, Integer> f = x -> x + 10;
       Function<Integer, Integer> g = x -> x * 20;

       //f를 실행한 반환값으로 g를 실행.
       Function<Integer, Integer> h = f.andThen(g);

       return h.apply(input);
   }

}
