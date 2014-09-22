package dip.lab1.student.solution1;

/**
 * A simple implementation sub-class of Employee. These are low-level classes
 * in the DIP. Does it meet the rules of DIP? If not fix it.
 *
 * @author your name goes here
 */
public class SalariedEmployee implements Employee {
    private double annualSalary;
    private double annualBonus;


    public SalariedEmployee(double annualSalary, double annualBonus) {
        setAnnualSalary(annualSalary);
        setAnnualBonus(annualBonus);
    }
    
    public void setAnnualSalary(double annualSalary) {
        if (annualSalary < 0){
            throw new IllegalArgumentException("Salary must be greater than or equal to zero");
        }
        this.annualSalary = annualSalary;
    }

    public double getAnnualBonus() {
        return annualBonus;
    }

    public void setAnnualBonus(double annualBonus) {
        if (annualBonus < 0){
            throw new IllegalArgumentException("Bonus must be greater than or equal to zero");
        }
        this.annualBonus = annualBonus;
    }
    
    public double getAnnualCompensation(){
        return annualSalary + annualBonus;
    }
    
    
}
