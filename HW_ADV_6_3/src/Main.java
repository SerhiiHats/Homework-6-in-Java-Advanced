import models.Driver;
/**Домашнее задание 6
 Задание 3
 Создайте несколько классов, один класс наследует другой и использует аннотацию Inherited.
 Помимо этого, попробуйте ещё в проекте использовать 5 различных аннотаций.
 */

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver(2, "Vasiliy Petrov", 7500.50, 2020, 10, 20, "водитель служебного автомобиля");
        System.out.println("Водитель: " + driver.getName() + " стаж работы для начисления надбавки: " + driver.getWorkExperience(driver.getStartDateOfJobs()) + " дней");
        System.out.println();
        System.out.println(driver);
    }
}
