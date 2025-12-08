import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
  Scanner sc= new Scanner(System.in);
		int[][] graph=new int[9][9];

//		for(int i=0; i<9; i++) {
//			String tmp=sc.nextLine();
//			String[] t= tmp.split(" ");
//			for(int i2=0; i2<9; i2++) {
//				graph[i][i2]=Integer.parseInt(t[i2]);
//				
//			}
//		}
		int maxNum=Integer.MIN_VALUE;
		int row=0;
		int col=0;
		for(int i=0; i<9; i++) {
			for(int i2=0; i2<9; i2++) {
				graph[i][i2]=sc.nextInt();
				 if (graph[i][i2] > maxNum ) {
					 maxNum=graph[i][i2]; //사실 배열에 넣지 않고 비교하는게 시간 복잡도에 도움이 된다. 
					 row=i+1;
					 col=i2+1;
				 }
			}
		
		}
		System.out.println(maxNum);
		System.out.print(row+" "+col);

  }
}