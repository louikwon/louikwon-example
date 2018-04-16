package com.louikwon.example.java8.example;

public class StrategyPattern {
    public interface InputValidatation {
        boolean execute(String s);
    }

    public class IsEmail implements InputValidatation {
        public boolean execute(String s) {
            return s.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");
        }
    }

    public class IsPhoneNumber implements InputValidatation {
        public boolean execute(String s) {
            return s.matches("^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$");
        }
    }

    public class Validator {
        private final InputValidatation validatation;

        public Validator(InputValidatation validatation) {
            this.validatation = validatation;
        }

        public boolean validate(String s) {
            return validatation.execute(s);
        }
    }
}
