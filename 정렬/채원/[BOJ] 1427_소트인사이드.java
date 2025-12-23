import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedArrayType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		char[] digits= br.readLine().toCharArray();
        Arrays.sort(digits);
		StringBuilder sb= new StringBuilder();
		for(int i=digits.length-1;i>=0; i--) {
			sb.append(digits[i]);
		}
		
		System.out.println(sb.toString());
	}

}
