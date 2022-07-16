package annatation;

import java.lang.annotation.*;

/** Аннотация DayOfCalculationForExperience
 * служит для передачи в метод getWorkExperience класса Employee
 * граничной даты по которую будет рассчитываться стаж работы сотрудника для дальнейшего
 * определения надбавки к зарплате.
 * Если метод помечен аннотацией с дефолтным значение, граничная дата будет текущая дата.
 * Если метод помечен аннотацией с предустановленным значением типа String в формате "dd/MM/yyyy", граничная
 * дата для расчета стажа будет принята от аннотации которая передана в формате "dd/MM/yyyy".
  */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DayOfCalculationForExperience {
    String dateFinish() default "0";
}
