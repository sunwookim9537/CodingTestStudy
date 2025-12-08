import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int N= sc.nextInt();
		int[] numN= new int[N];
		//투포인터 : 정렬된 배열에서의 특정 조건을 만족하는 요소/쌍이나 부분 배열을 찾을때 사용
		// 배열이나 리스트에서 두개의 포인터(변수)를 사용해 효율적으로 특정 구간을 찾거나, 두 배열ㅇㄹ 합치거나, 복잡도를 줄일 때 사용 
		//-> 합이 특정값이 되는 두 원소 찾기, 연속된 부분 배열의 합 구하기 , 두정렬 배열 병합에 유용
		
		for(int i=0; i<N; i++) {
			numN[i]=sc.nextInt();
		}
		//정렬하기
		Arrays.sort(numN);
		int[] visit=new int[N];
		int cnt=0; //좋은 숫자 찾기 
		for(int i=0; i<N; i++) {
			int lt=0;
			int rt=N-1;
//			System.out.println(i);
			while(lt<rt) {//같으면 안됨
				// 자체 숫자 하나만으로도 크면 break.
				//System.out.println(i+" ."+lt+"/"+rt);
				if(lt==i) {
					lt+=1;
					continue;
				}
				if(rt==i) {
					rt-=1;
                    continue;
				}
			
				int sum=numN[lt]+numN[rt];
			
				//
				if(sum>numN[i]) {
					rt-=1;
				}
				else if(sum==numN[i]) {
		
					cnt+=1;
					break;
				}
				else if(sum<numN[i]) {
					lt+=1;
				}
				
			}
		}
		System.out.println(cnt);
	}

}