/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiondemo;

/**
 *
 * @author Tom
 */
public class FractionDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numerator = 5;
        int denominator = 6;
        int otherNumerator = 1;
        int otherDenominator = 3;

        int GCD;

        Fraction demoFractionObject = new Fraction(numerator, denominator);
        Fraction otherDemoFractionObject
                = new Fraction(otherNumerator, otherDenominator);
        Fraction sumFraction = new Fraction();
        Fraction differenceFraction = new Fraction();
        GCD = demoFractionObject.getGCD();

        System.out.println(demoFractionObject.getNumerator() + "/" + 
                demoFractionObject.getDenominator());
        System.out.println("GCD is " + GCD);
        if (GCD == 1) {
            System.out.println("This is also the simplified fraction");
        } else {
            System.out.println("Simplified fraction is "
                    + numerator / GCD + "/" + denominator / GCD);
        }
        System.out.println("Approximate value is "
                + demoFractionObject.decimalValueOfFraction());
        System.out.println(demoFractionObject.isEqualInReducedForm(otherDemoFractionObject));

        sumFraction = demoFractionObject.reducedAdd(otherDemoFractionObject);
        System.out.println("Sum is " + sumFraction.getNumerator() + 
                "/" + sumFraction.getDenominator());

        differenceFraction = demoFractionObject.reducedSubtract(otherDemoFractionObject);
        System.out.println("Difference is " + differenceFraction.getNumerator() + 
                "/" + differenceFraction.getDenominator());
    }

}
