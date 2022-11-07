package chapter5;

public class Chapter5 {
    public static void main(String[] args){
        flatMap();
    }

    /**
     * flatMap
     * 1. 스트림의 각 값을 다른 스트림으로 만든다.
     * 2. 모든 스트림을 하나의 스트림으로 연결한다.
     */
    public static void flatMap(){
        // flatMap -> 스트림의 각 값을 다른 스트림으로 만든다.
        FlatMapExample.practice2();
    }
}
