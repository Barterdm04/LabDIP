/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dip.lab2;

/**
 *
 * @author dbarter1
 */
public class TipCalculatorService {
    private TipCalculator tipCalculator;
    
    public TipCalculatorService(TipCalculator tipCalculator){
        this.tipCalculator = tipCalculator;
    }
    
    public void calculateTip(){
        System.out.println("Your tip amount is: $" + tipCalculator.getTip());
    }
}
