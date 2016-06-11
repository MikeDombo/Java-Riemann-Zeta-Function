import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class Bernoulli {

    public static BigDecimal Bernoulli(int args) {
        int N = args;
        // precompute binomial coefficients
        BigInteger[][] binomial = new BigInteger[N+1][N+1];
        for (int n = 1; n <= N; n++) binomial[0][n] = BigInteger.ZERO;
        for (int n = 0; n <= N; n++) binomial[n][0] = BigInteger.ONE;

        // bottom-up dynamic programming
        for (int n = 1; n <= N; n++)
            for (int k = 1; k <= N; k++)
                binomial[n][k] = binomial[n-1][k-1].add(binomial[n-1][k]);


        // now compute Bernoulli numbers
        BigRational[] bernoulli = new BigRational[N+1];
        bernoulli[0] = new BigRational(1, 1);
        bernoulli[1] = new BigRational(-1, 2);
        for (int k = 2; k < N; k++) {
            bernoulli[k] = new BigRational(0, 1);
            for (int i = 0; i < k; i++) {
                BigRational coef = new BigRational(binomial[k + 1][k + 1 - i], BigInteger.ONE);
                bernoulli[k] = bernoulli[k].minus(coef.times(bernoulli[i]));
            }
            bernoulli[k] = bernoulli[k].divides(new BigRational(k+1, 1));
        }
        String returned = bernoulli[N-1].toString();
        BigDecimal returner = new BigDecimal(N);
        if (returned.indexOf("/")>=0){
        String[] rationals = returned.split("/");
        BigDecimal rational1 = new BigDecimal(rationals[0]);
        returner = rational1.divide(new BigDecimal(rationals[1]), 30, RoundingMode.HALF_UP);
        }
        else {
         BigDecimal toReturn = new BigDecimal(bernoulli[N-1].toString());
         returner = toReturn;
        }
       // System.out.println(returner);
        return returner;

    }
}