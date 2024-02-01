package employee.entities;

import lombok.Data;

@Data
 public class TaxDetails {
    private double totalSalary;
    private double taxAmount;
    private double cessAmount;

    public TaxDetails(double totalSalary, double taxAmount, double cessAmount) {
    }


}