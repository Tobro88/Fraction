/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiondemo;

public class FractionDemo {

    public static void main(String[] args) {
        // TODO code application logic here
        int numerator = 11;
        int denominator = 12;
        int otherNumerator = 3;
        int otherDenominator = 7;

        Fraction demoFractionObject = new Fraction(numerator, denominator);
        Fraction otherDemoFractionObject
                = new Fraction(otherNumerator, otherDenominator);
        Fraction sumFraction = new Fraction();
        Fraction differenceFraction = new Fraction();
        
        System.out.println("Fraction A: " + demoFractionObject.toString());
        System.out.println("Fraction A is in its reduced form: "+demoFractionObject.isReduced());
        
        Fraction b = new Fraction(demoFractionObject);
        b.reduce();
        
        System.out.println("In reduced form A is: "+b.toString());
        System.out.println("Fraction B: " + otherDemoFractionObject.toString());
        sumFraction = demoFractionObject.reducedAdd(otherDemoFractionObject);
        System.out.println("Sum: " + sumFraction.toString());
        differenceFraction = demoFractionObject.reducedSubtract(otherDemoFractionObject);
        System.out.println("Difference: " + differenceFraction.toString());
        System.out.println("Fractions are equal in reduced form: "+
                demoFractionObject.isEqualInReducedForm(otherDemoFractionObject));
        System.out.println("Fractions are equal: "+demoFractionObject.equals(otherDemoFractionObject));
        System.out.println("Decimal value of Fraction A: "+demoFractionObject.decimalValueOfFraction());
        System.out.println("Ratio of A and B is: "+demoFractionObject.reducedDivide(otherDemoFractionObject));
        System.out.println("Product of A and B is: "+demoFractionObject.reducedMultiply(otherDemoFractionObject));        

    }

}
