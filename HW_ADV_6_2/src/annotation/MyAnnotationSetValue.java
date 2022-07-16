package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * аннотация @Target(ElementType.METHOD) указывает на то - где может быть применена аннатоция которая помечена ею,
 * флаг - ElementType.METHOD указывает на то, что помеченная аннотация может применяться только над методами.
 */
@Target(ElementType.METHOD)
/**
 * аннотация @Retention(RetentionPolicy.RUNTIME) указывает на то - где будет жить аннатоция которая помечена ею,
 * флаг - RetentionPolicy.RUNTIME указывает на то, что помеченная аннотация будет жить RUNTIME.
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * аннотация @MyAnnotationSetValue, пользовательская аннатация которая служит
 * для передачи двух параметров типа - int: value1 и value2.
 * по умолчанию value1 = 5700, value2 = 6500.
 * Методы помеченные этой аннотацией могут получать поля этой аннотации в качестве параметров для использования
 */
public @interface MyAnnotationSetValue {
    /**
     * поле value1 аннотации @MyAnnotationSetValue,
     * по умолчанию value1 = 5700
     */
    int value1() default 5700;

    /**
     * поле value2 аннотации @MyAnnotationSetValue,
     * по умолчанию value2 = 6500
     */
    int value2() default 6500;

}
