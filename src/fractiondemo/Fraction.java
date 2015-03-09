package fractiondemo;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {

        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numeratorArgument, int denominatorArgument) {

        if (denominatorArgument == 0) {
            numerator = 0;
            denominator = 1;
            return;
        }
        numerator = numeratorArgument;
        denominator = denominatorArgument;
    }

    public Fraction(Fraction sourceFraction) {

        if (sourceFraction == null) {
            System.exit(0);
        }

        numerator = sourceFraction.numerator;
        denominator = sourceFraction.denominator;

    }

    public boolean isEqualInReducedForm(Fraction otherFraction) {

        Fraction thisFractionInComparison = new Fraction(this);
        thisFractionInComparison.reduce();

        Fraction otherFractionInComparison = new Fraction(otherFraction);
        otherFractionInComparison.reduce();

        return thisFractionInComparison.equals(otherFractionInComparison);

    }

    public boolean equals(Fraction fractionB) {

        return ((numerator == fractionB.numerator) && (denominator == fractionB.denominator));
    }

    public boolean isReduced() {

        return (gcdCalculation(numerator, denominator) == 1);
    }

    public double decimalValueOfFraction() {

        return (double) this.numerator / (double) this.denominator;
    }

    public Fraction reducedAdd(Fraction otherFraction) {

        int resultNumerator = (this.numerator * otherFraction.denominator
                + this.denominator * otherFraction.numerator);
        int resultDenominator = (this.denominator * otherFraction.denominator);
        Fraction resultFraction = new Fraction(resultNumerator, resultDenominator);
        resultFraction.reduce();
        return resultFraction;
    }

    public Fraction reducedSubtract(Fraction otherFraction) {

        int resultNumerator = (this.numerator * otherFraction.denominator
                - this.denominator * otherFraction.numerator);
        int resultDenominator = (this.denominator * otherFraction.denominator);
        Fraction resultFraction = new Fraction(resultNumerator, resultDenominator);
        resultFraction.reduce();
        return resultFraction;
    }

    public Fraction reducedMultiply(Fraction otherFraction) {

        int resultNumerator = (this.numerator * otherFraction.numerator);
        int resultDenominator = (this.denominator * otherFraction.denominator);
        Fraction resultFraction = new Fraction(resultNumerator, resultDenominator);
        resultFraction.reduce();
        return resultFraction;
    }

    public Fraction reducedDivide(Fraction otherFraction) {

        int resultNumerator = (this.numerator * otherFraction.denominator);
        int resultDenominator = (this.denominator * otherFraction.numerator);
        Fraction resultFraction = new Fraction(resultNumerator, resultDenominator);
        resultFraction.reduce();
        return resultFraction;
    }

    public void reduce() {

        int gcd = gcdCalculation(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public void invert() {

        int temp = numerator;
        numerator = denominator;
        denominator = temp;
    }

    @Override
    public String toString() {

        return numerator + " / " + denominator;
    }

    private int gcdCalculation(int n1, int n2) { //Euclidean algorithm

        if (n2 == 0) {
            return n1;
        } else {
            return this.gcdCalculation(n2, n1 % n2);
        }
    }

}
