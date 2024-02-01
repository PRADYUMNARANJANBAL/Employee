package employee.entities;

import lombok.Data;

@Data
public class Employee1 {
    private String code;
    private String firstName;
    private String lastName;
    private double salary;
    private String doj;

    public Employee1(String number, String john, String doe, int i, String date) {
    }


}