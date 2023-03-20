package Theory;
// Develop  and  test  an  object-oriented  application  to  simulate  the  rolling  of  two  dice.  The  application 
// should use an object of Random class once to roll the first die and again to roll the second die. The sum 
// of the two values should then be calculated. Each die can show an integer value from 1 to 6, so the sum 
// of the values will vary from 2 to 12, with 7 being the most frequent sum, and 2 and 12 the least frequent 
// (verify using code). Your application should roll the dice 1296 times. Use a one-dimensional array to tally 
// the number of times each possible sum appears. Display the results in a tabular format showing the sum 
// in  one  column  and  the  number  of  times  each  possible  sum  occurs  in  a  trial  of  1296  times  in  another 
// column and compute the Chi-square value defined by ∑ ((O-E)^2/E) where O and E are respectively observed 
// and  expected  number  of  occurrences  of  the  events  (2  to  12)  and  conclude  whether  the  dice  are 
// unbiased. (Chi-square value at 5% level of significance for ten degrees of freedom is 18.307)

import java.util.Random;

public class DiceRollSimulator {
    private static final int NUMBER_OF_SIDES = 6;
    private static final int NUMBER_OF_POSSIBLE_SUMS = 11;

    public int[] diceSums;

    public DiceRollSimulator() {
        diceSums = new int[NUMBER_OF_POSSIBLE_SUMS];
    }

    // Roll the dice n times and return the tally array of size 11 (2 to 12)
    public int[] simulate(int n) {
        Random random = new Random();
        int sum;
        for (int i = 0; i < n; i++) {
            int die1 = random.nextInt(1, NUMBER_OF_SIDES + 1);
            int die2 = random.nextInt(1, NUMBER_OF_SIDES + 1);
            sum = die1 + die2;
            // System.out.println("Roll " + (i + 1) + ": " + die1 + " + " + die2 + " = " + sum+2);
            diceSums[sum - 2]++;
        }

        return diceSums;
    }

    // Draw an ASCII distribution graph for tally array of size 11 (2 to 12)
    public void drawDistribution(int[] tally) {
        System.out.println("Sum\t\tTally");
        for (int i = 0; i < 11; i++) {
            System.out.println((i + 2) + "\t\t" + tally[i]);
        }

        int max = 0;
        for (int i = 0; i < 11; i++) {
            if (tally[i] > max) {
                max = tally[i];
            }
        }
        System.out.println("\n*********** Distribution Graph ***************");
        for (int i = 0; i < 11; i++) {
            System.out.print((i + 2) + "\t");
            for (int j = 0; j < tally[i] * 50 / max; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Compute Chi-square value tally array of size 11 (2 to 12) and N
    public double computeChiSquare(int[] tally, int N) {
        double[] expectedFreq = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0 };
        double chiSquare = 0.0;

        for (int i = 0; i < NUMBER_OF_POSSIBLE_SUMS; i++) {
            double observed = tally[i] / (double) N;
            double deviation = observed - expectedFreq[i] / 36.0;
            chiSquare += deviation * deviation / expectedFreq[i] / 36.0;
        }
        System.out.println("Chi-square value: " + chiSquare);
        return chiSquare;
    }

    // Check if the dice are unbiased based on the Chi-square value and 5% level of
    // significance for ten degrees of freedom
    public void checkUnbiased(double chiSquare) {
        if (chiSquare < 18.307) {
            System.out.println("The dice are unbiased");
        } else {
            System.out.println("The dice are biased");
        }
    }

    public static void main(String[] args) {
        int NUMBER_OF_TRIALS = 1296;

        DiceRollSimulator diceRollSimulator = new DiceRollSimulator();
        int[] tally = diceRollSimulator.simulate(NUMBER_OF_TRIALS);
        diceRollSimulator.drawDistribution(tally);
        double chiSquare = diceRollSimulator.computeChiSquare(tally, NUMBER_OF_TRIALS);
        diceRollSimulator.checkUnbiased(chiSquare);
    }
}