import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.*;
import java.util.Scanner;

public class RiemannZetaFunction {
    public static void main(String[] args){
   /* if (isInteger(args[0])){
    run(Double.parseDouble(args[0]));
    }
    else {
    System.out.println("Enter a number!");
    }
    */
   System.out.println("\nEnter a number (Even (positive) and Negative Numbers Are Fast, \nMusn't be between 0 and 1)");
   Scanner kbReader = new Scanner(System.in);
   double argument = kbReader.nextDouble();
   run(argument);
}
 public static void run (double args) {//-259 to +50 these are first-fail numbers
    double answer =0.0;
    double power = args;
    double input = power;
    String output = "WOW SUCH ANSWER";
    BigDecimal answers = new BigDecimal(answer);
    if (args>=0){
    if(args==1){
    System.out.println("INFINITY");
    main(new String[1]);
    }
    else if(args==0){
    answer = -.5;
    output = "-.5";
    }
    else if (args%2==0){
    power /=2;
    BigDecimal bernoul = Bernoulli.Bernoulli(2*(int)power+1);
    answer = Math.pow(-1.0, (power)+1)*Math.pow((2*Math.PI), 2*power);
    BigDecimal multiplied = (bernoul.multiply(BigDecimal.valueOf(answer)));
    BigDecimal factor = Factorial((long)(2*power));
    factor = factor.multiply(new BigDecimal(2));
    answers = (multiplied.divide(factor, 30, RoundingMode.HALF_UP));
    output = answers+"";
}
    else if(!(power <= 1)){
    //if odd or fraction
    long bigNumber;
    if(power<2)
    bigNumber = 500000000;
    else
    bigNumber = 100000000;
    for (long i=1;i<bigNumber;i++){
    answer = answer+(1/(Math.pow(i,power)));
    output = answer+"";
    }
    }
    else System.out.println("Something went wrong with your input");
}
    else{
        BigDecimal bernoul = Bernoulli.Bernoulli((int)Math.abs(power)+2);
        BigDecimal abs = new BigDecimal(Math.abs(power)+1);
        answers = bernoul.divide(abs, 30, RoundingMode.HALF_UP);
        answers = answers.negate();
        output = answers+"";
    }
    //System.out.println(power);
    char zeta = 950;
    System.out.println ("\n"+zeta+"("+input+")="+output+"\nRun again? (Y/N)");
    Scanner kbReader = new Scanner(System.in);
    String inner = kbReader.nextLine();
    if(inner.toUpperCase().equals("Y")){
    main(new String[1]);
    }
    else
    return;
 }
 public static BigDecimal Factorial (long start){
     BigDecimal result = new BigDecimal(1);
       for (long i = 1; i <= start; i++) {
           result = result.multiply(new BigDecimal(i));
       }
       //System.out.println(result);
       return result;
    }
  public static boolean isInteger(String input) {
    try {
        Double.parseDouble( input );
        return true;
    }
    catch( Exception e ) {
        return false;
    }
}
} 