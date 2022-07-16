package models;

import annatation.DayOfCalculationForExperience;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private LocalDate startDateOfJobs;

    public Employee(int id, String name, double salary, int year, int month, int day) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDateOfJobs = LocalDate.of(year, month, day);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getStartDateOfJobs() {
        return startDateOfJobs;
    }

    public void setStartDateOfJobs(LocalDate startDateOfJobs) {
        this.startDateOfJobs = startDateOfJobs;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", startDateOfJobs=" + startDateOfJobs +
                '}';
    }

    /**
     * Аннотация DayOfCalculationForExperience служит для передачи в метод getWorkExperience класса Employee
     * граничной даты по которую будет рассчитываться стаж работы сотрудника для дальнейшего определения надбавки к зарплате.
     * Если метод помечен аннотацией с дефолтным значение, граничная дата будет текущая дата.
     * Если метод помечен аннотацией с предустановленным значением типа String в формате "dd/MM/yyyy", граничная
     * дата для расчета стажа будет принята от аннотации которая передана в формате "dd/MM/yyyy".
     * Метод getWorkExperience принимает дату типа LocalDate принятия сотрудника на работу и
     * возвращает тип int - количество дней стажа сотрудника.
     */
    @DayOfCalculationForExperience(dateFinish = "01/01/2022")
    public int getWorkExperience(LocalDate startDateOfJobs) {
        LocalDate dateFinish = LocalDate.now();
        try {
            Class<?> cl = Class.forName("models.Employee");
            Method met = cl.getDeclaredMethod("getWorkExperience", LocalDate.class);
            DayOfCalculationForExperience anno = met.getAnnotation(DayOfCalculationForExperience.class);
            if (!anno.dateFinish().equals("0")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dateFinish = LocalDate.parse(anno.dateFinish(), formatter);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("клас не найден");
        } catch (NoSuchMethodException e) {
            System.out.println("метод не найден");
        }
        long dayOfExperience = ChronoUnit.DAYS.between(startDateOfJobs, dateFinish);
        return (int) dayOfExperience;
    }
}
