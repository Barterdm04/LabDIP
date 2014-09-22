package dip.lab2;

// An useful import if you need it.
import java.text.NumberFormat;
// Another useful import if you need it.
import javax.swing.JOptionPane;

/**
 * Just a test class for input and output.
 *
 * 1. Create instances of low-level classes using Liskov Substitution principle.
 * 2. Create an instance of your high-level class.
 * 3. Pass one of your calculator instances to the high-level class and
 *    check the results.
 * 4. Now switch to a different calculator instance and pass that to the
 *    high-level class. Did it work? Are the low-level instances
 *    interchangeable? The DIP requires this.
 * 
 * @author Dylan Barter
 */
public class Startup {
     
    public static void main(String[] args) {       
        
        //Create each tip calculator instance through the TipCalculator interface (Liskov).  Insert service quality and either bag numbers or bill amount
        TipCalculator bagTipCalculator = new BaggageServiceTipCalculator(ServiceQuality.GOOD, 6);
        TipCalculator foodTipCalculator = new FoodServiceTipCalculator(ServiceQuality.FAIR, 96.85);
        
        //Create instance of high-level class
        
        TipCalculatorService CalcService = new TipCalculatorService();
        
        //formatting purposes
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        
        //Print out results
        System.out.println("The tip amount for the baggage handler is: " + nf.format(CalcService.calculateTip(bagTipCalculator)));        
        System.out.println("The tip amount for the restaurant bill is: " + nf.format(CalcService.calculateTip(foodTipCalculator)));
    }

}
