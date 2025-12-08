import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N= sc.nextInt();
		sc.nextLine();
		int cnt=0;
		for(int i=1; i<=N;i++) {
			int sum=0;
			for(int i2=i; i2<=N; i2++) {
				sum+=i2;
				if(sum==N) {
					//System.out.println(i+" "+i2);
					cnt++;
					break;
				}
				if(sum>N) {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}