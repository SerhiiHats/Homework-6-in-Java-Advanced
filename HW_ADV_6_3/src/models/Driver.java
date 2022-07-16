package models;

import java.time.LocalDate;

public class Driver extends Employee{

    private String responsibilities;
    private String insuranceName;
    private LocalDate insuranceFinishDay;

    public Driver(int id, String name, double salary, int year, int month, int day, String responsibilities) {
        super(id, name, salary, year, month, day);
        this.responsibilities = responsibilities;
    }

    public Driver(int id, String name, double salary, int year, int month, int day, String responsibilities, String insuranceName, int year1, int month1, int day1) {
        super(id, name, salary, year, month, day);
        this.responsibilities = responsibilities;
        this.insuranceName = insuranceName;
        this.insuranceFinishDay = LocalDate.of(year1, month1, day1);

    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public LocalDate getInsuranceFinishDay() {
        return insuranceFinishDay;
    }

    public void setInsuranceFinishDay(LocalDate insuranceFinishDay) {
        this.insuranceFinishDay = insuranceFinishDay;
    }

    /** Метод getSupplementOfSalary в своем теле
     * обращается к методу getWorkExperience - получает стаж сотрудника и
     * в зависимости от стажа сотрудника определяет надбавку к базовому окладу.
     * Метод возвращает тип double - которая является надбавкой к основному окладу сотрудника.
     */
    public double getSupplementOfSalary(){
        double supplement = 1;
        int dayExperience = getWorkExperience(getStartDateOfJobs());
       if (dayExperience > 30 && dayExperience <= 180) {
           supplement = 0.1;
       }
        if (dayExperience > 180 && dayExperience <= 365) {
            supplement = 0.2;
        }
        if (dayExperience > 365 && dayExperience <= 545) {
            supplement = 0.3;
        }
        if (dayExperience > 545 && dayExperience <= 730) {
            supplement = 0.4;
        }
        if (dayExperience > 730 && dayExperience <= 1095) {
            supplement = 0.5;
        }
        if (dayExperience > 1095 && dayExperience <= 1460) {
            supplement = 0.6;
        }
        if (dayExperience > 1460 && dayExperience <= 1825) {
            supplement = 0.7;
        }

        return supplement;
    }

    @Override
    public String toString() {
        return "Водитель: " + super.getName() +   ", дата принятия на работу: " + super.getStartDateOfJobs() + ", обязаности: " + responsibilities
                + ", \nбазовый оклад: " + super.getSalary() + " грн., стаж для определения надбавки: " + getWorkExperience(super.getStartDateOfJobs()) +  " дней, \nнадбавка: " + (getSupplementOfSalary() * 100) + " %, оклад с учетом надбавки: " + ((int)((1 + getSupplementOfSalary()) * super.getSalary()*100)) / 100d +" грн.\n" +
                (insuranceName == null ? "нет в наличии актуальной страховки" : "в наличии актуальная страховка: " + insuranceName + " срок действия до: " + insuranceFinishDay);
    }

  }
