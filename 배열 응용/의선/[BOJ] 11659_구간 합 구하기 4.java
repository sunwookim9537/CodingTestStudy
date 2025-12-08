import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt(); 
        int n = sc.nextInt(); 
        
        
        int[] S = new int[m + 1];
        
    
        for(int i = 1; i <= m; i++){
            
            S[i] = S[i-1] + sc.nextInt(); 
        }
        
       
        for(int i = 0; i < n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            
            System.out.println(S[end] - S[start - 1]);
        }
    }
}