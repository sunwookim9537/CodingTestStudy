import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//시간 초과 : 입력개수가 5,000,000개 scanner x
		//collections.sort/arrayList/scanner 조합은 터짐
		// 특히 scanner와 arrayList는 내부 오버헤드가 크다 
		// BufferedReader+StringTokenizer 사용할 것(연습)
		//primitive int[] 사용
		//Scanner sc= new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        //int n= sc.nextInt(); 대신
        int n= Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		ArrayList<Integer> a= new ArrayList<>();
		int[] ar =new int[n];
			
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			ar[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(ar);
		
		//Collections.sort(a);
		
		System.out.println(ar[k-1]);
		
	}

}
