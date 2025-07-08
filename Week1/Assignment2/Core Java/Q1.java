// 1)        Given:
// public class TaxUtil {
//    double rate = 0.15;

//    public double calculateTax(double amount) {
//        return amount * rate;
//    }
// }
// Would you consider the method calculateTax() a 'pure function'? Why or why not?
// If you claim the method is NOT a pure function, please suggest a way to make it pure.
// '''



// Answer:
// Not a pure function, because it uses an instance variable rate (i.e., depends on external state).
// To make it pure:

// public class TaxUtil {
//     public double calculateTax(double amount, double rate) {
//         return amount * rate;
//     }
// }

// This is a pure function — it always returns the same result for the same input and has no side effects.
