import java.util.Scanner;

public class Fraction {

    private int numerator;
    private int denominator;

    // CONSTRUCTORS

    public Fraction(int numerator, int denominator) { //FINISHED
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator) { //FINISHED
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(String toParse) {
        String delims = "[/]";
        String[] tokens = toParse.split(delims);
        numerator = Integer.valueOf(tokens[0]);
        denominator = Integer.valueOf(tokens[1]);
    }

    // METHODS

    public Fraction add(Fraction f) { //FINISHED
       int newnum;
       int newdenon;

        if(denominator == f.getDenominator()) {
            newnum = numerator + f.getNumerator();
            newdenon = denominator;
        } else {
             Fraction inter1 = new Fraction(numerator*f.getDenominator(), denominator*f.getDenominator());
             Fraction inter2 = new Fraction(f.getNumerator()*denominator, denominator*f.getDenominator());

             newnum = inter1.getNumerator() + inter2.getNumerator();
             newdenon = inter1.getDenominator();
        }

        Fraction newFrac = new Fraction(newnum, newdenon);
        newFrac.reduce();
        return newFrac;
    }

    public Fraction subtract(Fraction f) { //FINISHED
        int newnum;
        int newdenon;

        Fraction inter = new Fraction(f.getNumerator()*(-1), f.getDenominator());

        return add(inter);
    }

    public Fraction multiply(Fraction f) { //FINISHED
        int newnum = numerator * f.getNumerator();
        int newdenon = denominator * f.getDenominator();

        Fraction newFrac = new Fraction(newnum, newdenon);
        newFrac.reduce();
        return newFrac;
    }

    public Fraction divide(Fraction f) { //FINISHED
        int newnum;
        int newdenon;
        Fraction inter = new Fraction(f.getDenominator(), f.getNumerator());

        return multiply(inter);
    }

    public double toDecimal() { //FINISHED
        double dec;
        double decNum = numerator;
        double decDenon = denominator;

        decNum = decNum/decDenon;
        return decNum;
    }

    public int compareTo(Fraction f) { //FINISHED
        Fraction inter1 = new Fraction(numerator*f.getDenominator(), denominator*f.getDenominator());
        Fraction inter2 = new Fraction(f.getNumerator()*denominator, denominator*f.getDenominator());

        if(inter1.getNumerator()>inter2.getNumerator()) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() { //FINISHED
        return String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }

    public void reduce() { //CHECK
        int negNum = numerator;
        boolean negBool = false;

        if(numerator<0) {
            negNum = -numerator;
            negBool = true;
        }

        for(int i = 2; i<=negNum; i++) {
            if(negNum % i == 0 && denominator % i == 0) {
                negNum = negNum / i;
                denominator = denominator / i;
                i--;
            }
        }

        if (negBool) {
            numerator = -negNum;
        } else {
            numerator = negNum;
        }
    }

    // GETTERS AND SETTERS

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // CLASS RUNNER

    public static void main(String[] args) {

/*
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(3, 4);

        //Test Add
        System.out.println(f1.add(f2).toString());

        //Test Subtract
        System.out.println(f1.subtract(f2).toString());

        //Test Multiply
        System.out.println(f1.multiply(f2).toString());

        //Test Divide
        System.out.println(f1.divide(f2).toString());

        //Test toDecimal
        System.out.println(f1.toDecimal());

        //Test compareTo
        System.out.println(f1.compareTo(f2));
*/

        //Full Console Program
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        String s;

        System.out.println("Enter initial Fraction:");
        s = scan.nextLine();
        String delims = "[/]";
        String[] tokens = s.split(delims);

        Fraction f3 = new Fraction(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]));
        f3.reduce();

        while(cont) {
            System.out.println("Current Fraction is: " + f3.toString());
            System.out.println();
            System.out.println("Next Operation: ");
            s = scan.nextLine();

            if(s.equals("+")) {
                System.out.println("Enter Fraction You Would Like to Add: ");
                s = scan.nextLine();
                String[] tokens2 = s.split(delims);
                Fraction f4 = new Fraction(Integer.valueOf(tokens2[0]), Integer.valueOf(tokens2[1]));

                f3 = f3.add(f4);
                f3.reduce();
            } else if(s.equals("-")) {
                System.out.println("Enter Fraction You Would Like to Subtract: ");
                s = scan.nextLine();
                String[] tokens2 = s.split(delims);
                Fraction f4 = new Fraction(Integer.valueOf(tokens2[0]), Integer.valueOf(tokens2[1]));

                f3 = f3.subtract(f4);
                f3.reduce();
            } else if(s.equals("*")) {
                System.out.println("Enter Fraction You Would Like to Multiply: ");
                s = scan.nextLine();
                String[] tokens2 = s.split(delims);
                Fraction f4 = new Fraction(Integer.valueOf(tokens2[0]), Integer.valueOf(tokens2[1]));

                f3 = f3.multiply(f4);
                f3.reduce();
            } else if(s.equals("/")) {
                System.out.println("Enter Fraction You Would Like to Divide: ");
                s = scan.nextLine();
                String[] tokens2 = s.split(delims);
                Fraction f4 = new Fraction(Integer.valueOf(tokens2[0]), Integer.valueOf(tokens2[1]));

                f3 = f3.divide(f4);
                f3.reduce();
            } else if(s.equals("<") || s.equals(">")) {
                System.out.println("Enter Fraction You Would Like to Compare: ");
                s = scan.nextLine();
                String[] tokens2 = s.split(delims);
                Fraction f4 = new Fraction(Integer.valueOf(tokens2[0]), Integer.valueOf(tokens2[1]));

                int which = f3.compareTo(f4);
                if(which == 0) {
                    System.out.println(f3.toString() + " is larger than " + f4.toString());
                } else {
                    System.out.println(f4.toString() + " is larger than " + f3.toString());
                }
            } else if(s.equals(".")) {
                System.out.println(f3.toDecimal());
            } else {
                cont = false;
            }
            System.out.println();

        }

    }
}
