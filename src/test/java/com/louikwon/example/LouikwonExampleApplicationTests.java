package com.louikwon.example;

import com.louikwon.example.java8.dto.Car;
import com.louikwon.example.java8.example.ExecuteAroundPattern;
import com.louikwon.example.java8.example.FunctionalInterfaceExample;
import com.louikwon.example.java8.example.LamdaChain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LouikwonExampleApplicationTests {

	/**
	 * 실행어라운트 패턴(동작파라미터화) 테스트
	 * @throws IOException
	 */
	@Test
	public void executeAroundPatternTest() throws IOException {
		//한줄만 읽어야 할 때
		String result = ExecuteAroundPattern.printFile((BufferedReader br) -> br.readLine());

		Assert.assertEquals("test1" , result );

		//두줄을 읽어야 할 때
		String resultMultiLine = ExecuteAroundPattern.printFile(
				(BufferedReader br) -> br.readLine() + br.readLine() );


		Assert.assertEquals("test1test2" , resultMultiLine );
	}

	@Test
	public void predicate_실행예제() {
		List<String> originalList = Arrays.asList("liverpool", "manchester united", "manchester city");
		//체크할 조건으로 함수형 인터페이스 인스턴스 생성.
		Predicate<String> manContainPredicate = (String s) -> s.contains("man");
		List<String> manContainList = FunctionalInterfaceExample.filter(originalList, manContainPredicate);

		Assert.assertEquals(manContainList.size(), 2);

	}

	@Test
	public void consumer_실행예제() {
		FunctionalInterfaceExample.forEach(
				Arrays.asList(1,2,3,4,5,6,7,8,9) ,
				(Integer i) -> {
					Integer sum = i;
					sum = sum + 1;
					System.out.print(" Sum is " + sum);
				}
		);
	}

	@Test
	public void function_실행예제() {
		List<Integer> resultList = FunctionalInterfaceExample.map(
			Arrays.asList("everton", "sunderland", "leedsunited"),
				(String s) -> s.length()
		);

		List<Integer> checkList = Arrays.asList(7, 10, 11);

		Assert.assertEquals(checkList, resultList);
	}
}
