/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiondemo;

/**
 * @author Tobro88
 */
public class Fraction {

    private int numerator;
    private int denominator;
    private int greatestCommonDivisor = 0;
    private int reducedNumerator;
    private int reducedDenominator;

    /**
     * Constructor with defined numerator and denominator values. Denominator can not be set to zero. If
     * <code>denominatorArgument</code> is zero the Fraction is initialized with numerator = 0 and denominator =1.
     *
     * In the constructor, also GCD is determined and the Reduced Numerator and Reduced Denominator are calculated.
     *
     * @param numeratorArgument the numerator of the fraction
     * @param denominatorArgument the denominator of the fraction
     * @author Tobro88
     */
    public Fraction(int numeratorArgument, int denominatorArgument) {
        // Here comes the constructor

        if (denominatorArgument == 0) {
            //System.out.println("Denominator can not be zero.");
            //System.out.println("Numerator set to 0,");
            //System.out.println("and Denominator set to 1");
            this.numerator = 0;
            this.denominator = 1;
            this.greatestCommonDivisor = this.gcdCalculation(0, 1);
            this.reducedNumerator = 0;
            this.reducedDenominator = 1;
            return;
        }
        this.numerator = numeratorArgument;
        this.denominator = denominatorArgument;
        this.greatestCommonDivisor = this.gcdCalculation(numeratorArgument,
                denominatorArgument);
        this.reducedNumerator = this.numerator / this.greatestCommonDivisor;
        this.reducedDenominator = this.denominator / this.greatestCommonDivisor;
    }

    /**
     * Constructor without initial numerator and denominator values. Default value for numerator = 0, and for
     * denominator = 1.
     *
     * In the constructor, also GCD is determined and the Reduced Numerator and Reduced Denominator are calculated.
     * Since numerator = 0 and denominator = 1 GCD is 1.
     *
     * @author Tobro88
     */
    public Fraction() {
        // Constructor in case no numerator/denominator is given yet
        this.numerator = 0;
        this.denominator = 1;
        this.greatestCommonDivisor = this.gcdCalculation(0, 1);
        this.reducedNumerator = 0;
        this.reducedDenominator = 1;

    }

    /**
     * @author Tobro88 true@return
     * @return
     */
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * @author Tobro88
     * @return
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * @author Tobro88
     * @return
     */
    public int getGCD() {
        return this.greatestCommonDivisor;
    }

    /**
     * @author Tobro88
     * @return
     */
    public int getReducedNumerator() {
        return this.reducedNumerator;
    }

    /**
     * @author Tobro88
     * @return
     */
    public int getReducedDenominator() {
        return this.reducedDenominator;
    }

    /**
     * Compares this Fraction with another Fraction based on the reduced numerator and denominator. For example the
     * method returns <code>true</code> if 2/4 is compared with 1/2.
     *
     * @param otherFraction the fraction object with which to compare
     * @author Tobro88
     * @return <code>true</code> if this fraction is the same in reduced form as <code>otherFraction</code> in reduced
     * form
     */
    public boolean isEqualInReducedForm(Fraction otherFraction) {

        return ((this.reducedNumerator == otherFraction.reducedNumerator)
                && (this.reducedDenominator
                == otherFraction.reducedDenominator));
    }

    /**
     * @param numeratorArgument
     * @author Tobro88
     */
    public void setNumerator(int numeratorArgument) {
        //if Numerator is changed other instances also need to be updated

        this.numerator = numeratorArgument;
        this.greatestCommonDivisor
                = this.gcdCalculation(this.numerator, this.denominator);
        this.reducedNumerator = this.numerator / this.greatestCommonDivisor;
        this.reducedDenominator = this.denominator / this.greatestCommonDivisor;
    }

    /**
     * @param denominatorArgument
     * @author Tobro88
     */
    public void setDenominator(int denominatorArgument) {
        //if Denominator is changed other instances also need to be updated

        this.denominator = denominatorArgument;
        this.greatestCommonDivisor
                = this.gcdCalculation(this.numerator, this.denominator);
        this.reducedNumerator = this.numerator / this.greatestCommonDivisor;
        this.reducedDenominator = this.denominator / this.greatestCommonDivisor;
    }

    /**
     * @author Tobro88
     * @return
     */
    public double decimalValueOfFraction() {
        return (double) this.numerator / (double) this.denominator;
    }

    /**
     * Returns the result (as a reduced <code>Fraction</code> object) of adding otherFraction to the class'
     * instantiation.
     *
     * @param otherFraction the Fraction that is added
     * @author Tobro88
     * @return
     */
    public Fraction reducedAdd(Fraction otherFraction) {

        Fraction resultFraction = new Fraction();


        resultFraction.setNumerator(this.numerator * otherFraction.denominator
                + this.denominator * otherFraction.numerator);
        resultFraction.setDenominator(this.denominator * otherFraction.denominator);
        return new Fraction(resultFraction.reducedNumerator,resultFraction.reducedNumerator);
    }

    /**
     * Returns the result (as a reduced <code>Fraction</code> object) of subtracting otherFraction from the class'
     * instantiation.
     *
     * @param otherFraction
     * @author Tobro88
     * @return
     */
    public Fraction reducedSubtract(Fraction otherFraction) {
        //method to subtract another Fraction from Fraction and reduce result
        //current method is obviously a placeholder
        Fraction resultFraction = new Fraction();


        resultFraction.setNumerator(this.numerator * otherFraction.denominator
                - this.denominator * otherFraction.numerator);
        resultFraction.setDenominator(this.denominator * otherFraction.denominator);
        return new Fraction(resultFraction.reducedNumerator,resultFraction.reducedNumerator);
    }

    /**
     * Returns the result (as a reduced <code>Fraction</code> object) of multiplying otherFraction to the class'
     * instantiation.
     *
     * @param otherFraction the Fraction that is added
     * @author Tobro88
     * @return
     */
    public Fraction reducedMultiply(Fraction otherFraction) {

        Fraction resultFraction = new Fraction();


        resultFraction.setNumerator(this.numerator * otherFraction.numerator);
        resultFraction.setDenominator(this.denominator * otherFraction.denominator);

        return new Fraction(resultFraction.reducedNumerator,resultFraction.reducedNumerator);
    }

    /**
     * @param n1
     * @param n2
     * @author Tobro88
     * @return
     */
    private int gcdCalculation(int n1, int n2) { //Euclidean algorithm
        if (n2 == 0) {
            return n1;
        } else {
            return this.gcdCalculation(n2, n1 % n2);
        }
    }

}
