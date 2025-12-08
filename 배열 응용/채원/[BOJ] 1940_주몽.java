import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//각 재료들은 고유한 번호를 가지고 있다
		// 갑옷은 두개의 재료로 만드는데 두재료의 고유한 번호를 
		//합쳐서 갑옷을 만들게 됨
		// 만들고 있는 재료를 가지고 갑옷을 몇개나 만들수있을지 궁금
		// n과 m이 주어졌을때 몇개의 갑옷을 만들수있을 까?
		//입력 n,m, n개의 재료들이 가진 고유한 번호
	Scanner sc= new Scanner(System.in);
		int N= sc.nextInt();
		int M= sc.nextInt();
		int cnt=0;
		String tmp= sc.nextLine();
		//System.out.println(tmp);
		//String[] numN= tmp.trim().split(" ");
		 int[] numN = new int[N];
        	for(int i=0; i<N; i++) {
            numN[i] = sc.nextInt();
        }
		for(int i=0; i<N-1; i++) {
			for(int i2=i+1; i2<N; i2++) {
				int a=Integer.valueOf(numN[i]);
				int b=Integer.valueOf(numN[i2]);
				//System.out.println(a+"."+b);
				if(a+b==M) cnt++; 
			}	
		}
		System.out.println(cnt);
	}

}
