package dip.lab1.student.solution1;

import java.text.NumberFormat;

/**
 * Just a start and test class for this program. You may modify this class
 * in any way you see fit.
 *
 * @author jlombardo
 */
public class Startup {

    public static void main(String[] args) {


        //Low-level modules
        Employee emp1 = new HourlyEmployee(10.50, 2020);
        Employee emp2 = new SalariedEmployee(45000, 1250);
        Employee emp3 = new SalariedEmployee(90000,0);

        Employee emps[] = {emp1,emp2,emp3};
        
        
        // High-level module
        HRService hr = new HRService();

        // Just utility code to format numbers nice.
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        for (int i = 0; i <= emps.length; i++){
        System.out.println("Employee " + (i + 1) + " annual compensation: " +
            nf.format(hr.getAnnualCompensationForEmployee(emps[i])));
        }
    }

}
