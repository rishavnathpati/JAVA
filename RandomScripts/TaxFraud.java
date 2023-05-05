package RandomScripts;
// Develop a user-defined exception class to throw exception if the tax paid by a person is less than 30%
// of his/her yearly income. A person is characterized by his/her PAN number and yearly salary. Show the
// usage of the user-defined exception in a try-catch-finally block and in throws clause

public class TaxFraud {

    public static void main(String[] args) {
        int salary = 100000;
        System.out.println("Salary amount: " + salary);
        int tax = 3000;
        System.out.println("Tax amount: " + tax);

        try {
            if (tax < (salary * 0.3)) {
                throw new TaxException("Tax amount is less than 30% of salary");
            }
        } catch (TaxException e) {
            e.printStackTrace();
            // System.out.println(e.getMessage());
        }
    }
}

class TaxException extends Exception {
    public TaxException(String message) {
        super(message);
    }

    public TaxException() {
        super("TaxFraud default from TaxException()");
    }

    // @Override
    // public String getMessage() {
    //     return "TaxFraud default from getMessage()";
    // }

    @Override
    public String toString() {
        return "TaxException from toString() " + getMessage();
    }
}
