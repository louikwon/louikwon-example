package com.louikwon.example;

import com.louikwon.example.java8.example.StrategyPattern;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DesignPatternTest {
    @Test
    public void 람다사용전_전략패턴_실행예제() {
        //기존 방식
        StrategyPattern.IsEmail emailValid = new StrategyPattern().new IsEmail();
        StrategyPattern.Validator emailValidator = new StrategyPattern().new Validator(emailValid);
        boolean isEmail = emailValidator.validate("test@daum.net");

        Assert.assertTrue(isEmail);

        StrategyPattern.IsPhoneNumber phoneNumberValid = new StrategyPattern().new IsPhoneNumber();
        StrategyPattern.Validator phoneNumberValidator = new StrategyPattern().new Validator(phoneNumberValid);
        boolean isPhone = phoneNumberValidator.validate("02-1111-1111");

        Assert.assertTrue(isPhone);
    }

    @Test
    public void 람다사용한_전략패턴() {
        //람다를 직접 전달하여 새로운 클래스를 구현할 필요가 없다.
        StrategyPattern.Validator emailValidator = new StrategyPattern().new Validator(
                (String s) -> s.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")
        );
        boolean isEmail = emailValidator.validate("test@daum.net");

        Assert.assertTrue(isEmail);

        StrategyPattern.Validator phoneNumberValidator = new StrategyPattern().new Validator(
                (String s) -> s.matches("^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$")
        );
        boolean isPhone = phoneNumberValidator.validate("02-1111-1111");

        Assert.assertTrue(isPhone);
    }

}
