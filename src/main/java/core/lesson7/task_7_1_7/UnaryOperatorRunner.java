package core.lesson7.task_7_1_7;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorRunner {

    public static void main(String[] args) {
        System.out.println(sqrt().apply(5));

    }

    public static UnaryOperator<Integer> sqrt() {
        return (Integer x) -> x * x;
    }

//    public static UnaryOperator<Integer> sqrt() {
//        UnaryOperator<Integer> square = x -> x * x;
//        square.apply(5); // 25
//        return square;
//    }
}
