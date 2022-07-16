import annotation.Math;
import handler.Summation;

import java.lang.reflect.Method;

/**
 * Домашнее задание 6
 * Задание 4
 * Создать свою аннотацию, которая будет содержать параметры для метода, выполнить сложение 2-х чисел.
 *
 * @Math(num1 = 100, num2 = 200)
 * public void mathSum(int num1, int num2)
 */

public class Main {
    public static void main(String[] args) {
        Summation summation = new Summation();
        Class<?> cl = summation.getClass();
        try {
            Method method = cl.getDeclaredMethod("mathSum", int.class, int.class);
            Math math = method.getAnnotation(Math.class);
            summation.mathSum(math.num1(), math.num2());
        } catch (NoSuchMethodException e) {
            System.out.println("Метод mathSum(int num1, int num2) не найден!");

        }


    }
}
