package handler;

import annotation.MyAnnotationSetValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Calculator {
    /**
     * метод simpleCalculator класса Calculator, помечен аннатацией @MyAnnotationSetValue
     * метод принимает от аннатоции в качестве параметров два поля аннатации и проводит над ними расчеты
     * получение полей аннотации в методе simpleCalculator осуществлено средствами рефлексии
     */
    @MyAnnotationSetValue()
    public void simpleCalculator() {
        System.out.println("Method simpleCalculator: ");
        Class<?> cl = Calculator.class;
        try {
            Method met = cl.getDeclaredMethod("simpleCalculator");
            MyAnnotationSetValue my = met.getAnnotation(MyAnnotationSetValue.class);
            System.out.println("1. " + my.value1() + " + " + my.value2() + " = " + (my.value1() + my.value2()));
            System.out.println("2. " + my.value1() + " - " + my.value2() + " = " + (my.value1() - my.value2()));
            System.out.println("3. " + my.value1() + " * " + my.value2() + " = " + (my.value1() * my.value2()));
            System.out.println("4. " + my.value1() + " / " + my.value2() + " = " + (my.value2() != 0 ? (double) my.value1() / my.value2() : "Деление на ноль!"));

        } catch (NoSuchMethodException e) {
            System.out.println("Метод \"simpleCalculator\" не найден!");
        }


    }

}
