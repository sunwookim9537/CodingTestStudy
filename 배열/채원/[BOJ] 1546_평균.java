import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
Scanner sc= new Scanner(System.in);
	       int n= sc.nextInt();
	       	sc.nextLine();
	       int maxValue=Integer.MIN_VALUE;
	        String[] scores= sc.nextLine().split(" ");
	        double answer=0;
	        double[] s= new double[n];
	        int i=0;
	        for(String t: scores) {
	        	int scoreN=Integer.parseInt(t);
	        	s[i]=scoreN;
	        	i++;
	        	maxValue= Math.max(maxValue,scoreN);
	        	
	        }
	      //  System.out.println(maxValue);

	        for(int i2=0; i2<n; i2++) {
	        //	System.out.println(s[i2]);
	        	double a=(s[i2]*100)/maxValue;
	        	//System.out.println(a);
	        	answer+=a;
	        }
	        answer/=n;
	        System.out.println(answer);
	        

  }
}