package com.louikwon.example.java8;

import java.io.*;

/**
 *  실행어라운드 패턴을 적용해 보는 예제
 *  java8 p93
 *  @author loui.kwon
 */
public class ExecuteAroundPattern {
    /**
     * 파일에서 한 행을 읽는 코드.
     * @return 파일 1라인.
     * @throws IOException
     */
    public static String printFile() throws IOException {
        //초기화 코드
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/loui.kwon/documents/example/louikwon-data.txt"))) {

            //실제 작업을 실행하는 부분
            return br.readLine();

        } //정리 - 마무리 코드
    }

    /**
     * 아래 예제들을 통해서 실행어라운드 패턴을 적용해 보자.
     * 동작을 파라미터화 하기 위해 함수형 인터페이스를 생성
     */
    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String executeProc(BufferedReader b) throws IOException;
    }

    /**
     * 함수형 인터페이스의 추상 메서드 구현을 직접 전달 가능
     * @param p 함수형 인터페이스의 추상 메소드 구현체
     * @return
     * @throws IOException
     */
    public static String printFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/loui.kwon/documents/example/louikwon-data.txt"))) {

           return p.executeProc(br);

        }
    }
}
