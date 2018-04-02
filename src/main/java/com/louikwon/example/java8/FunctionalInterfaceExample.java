package com.louikwon.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *  java8의 대표적인 함수형 인터페이스를 사용해 보는 예제
 */
public class FunctionalInterfaceExample {
    /**
     * predicate를 이용하여 특정 조건을 만족시키는 항목으로 구성된 list를 반환 하는 예제.
     * @param list 체크할 데이터 셋.
     * @param p  조건.
     * @param <T> 체크할 데이터 형식
     * @return 조건을 만족하는 데이터 셋.
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> resultList = new ArrayList<>();
        for (T s: list) {
            if (p.test(s)) {
                resultList.add(s);
            }
        }
        return resultList;
    }

    /**
     * Consumer 를 이용하여 특정 동작을 실행. Consumer는 void 를 반환
     * * T 형식의 객체를 인수로 받아서 어떤 동작을 수행하고 싶을 때 사용
     * @param list 데이터셋
     * @param c consumer
     * @param <T> list  형색
     */
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for(T i : list) {
            c.accept(i);
        }
    }

    /**
     * 제네릭 형식 T를 인수로 받아서 제네릭 형식 R 객체를 반환하는 apply 라는 추상 메서드를 정의.
     * 입력을 출력으로 매핑하는 람다를 정의 할 때 활용할 수 있다.
     * String 리스트를 인수로 받아 각 String의 길이를 포함하는 Integer 리스트로 변환하는 map  이라는 메서드를 정의하는 예제
     * @param list 데이터셋
     * @param f function
     * @param <T> 인수 형식
     * @param <R> 반환형식
     * @return
     */
    public static <T,R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> resultList = new ArrayList<>();
        for (T s : list) {
            resultList.add(f.apply(s));
        }
        return resultList;
    }
}
