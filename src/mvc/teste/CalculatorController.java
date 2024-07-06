/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.teste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Erick Stella
 */
public class CalculatorController {
    
    private CalculatorView theView;
    private CalculatorModel theModel;
    
    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theModel = theModel;
        this.theView = theView;
        
        this.theView.addCalculationListener(new CalculateListener());
    }
    
    class CalculateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            int firstNumber =0, secondNumber = 0;
            
            try {
                
                firstNumber = theView.getFirstNumber();
                secondNumber = theView.getSecondNumber();
                
                theModel.addTwoNumbers(firstNumber, secondNumber);
                
                theView.setCalcSolution(theModel.getCalculationValue());
            }
            catch(NumberFormatException ex){
                theView.displayErrorMessage("You need to enter 2 Integers.");
            }
        }
        
    }
}
