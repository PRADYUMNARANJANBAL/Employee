package employee.controller;

import employee.entities.Employee1;
import employee.entities.TaxDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxController {

    @GetMapping("/employees/tax-deduction")
    public TaxDetails calculateTax() {

        Employee1 employee = fetchEmployeeDetails();


        double totalSalary = calculateTotalSalary(employee);


        TaxDetails taxDetails = calculateTaxDetails(totalSalary);

        return taxDetails;
    }

    private Employee1 fetchEmployeeDetails() {

        return new Employee1("123", "John", "Doe", 700000, "2023-05-16");
    }

    private double calculateTotalSalary(Employee1 employee) {

        return employee.getSalary() * 12;
    }

    private TaxDetails calculateTaxDetails(double totalSalary) {

        double taxAmount = calculateTaxAmount(totalSalary);
        double cessAmount = calculateCessAmount(totalSalary);
        return new TaxDetails(totalSalary, taxAmount, cessAmount);
    }

    private double calculateTaxAmount(double totalSalary) {

        double taxAmount = 0;
        if (totalSalary > 1000000) {
            taxAmount += (totalSalary - 1000000) * 0.20;
            totalSalary = 1000000;
        }
        if (totalSalary > 500000) {
            taxAmount += (totalSalary - 500000) * 0.10;
            totalSalary = 500000;
        }
        if (totalSalary > 250000) {
            taxAmount += (totalSalary - 250000) * 0.05;
        }
        return taxAmount;
    }

    private double calculateCessAmount(double totalSalary) {

        double cessAmount = 0;
        if (totalSalary > 2500000) {
            cessAmount = (totalSalary - 2500000) * 0.02;
        }
        return cessAmount;
    }
}



