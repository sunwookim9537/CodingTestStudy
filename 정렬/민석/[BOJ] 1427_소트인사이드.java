import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b[]=a.split("");
        int arr[]=new int[b.length];
        for(int i=0;i< b.length;i++){
            arr[i]=Integer.parseInt(b[i]);

        }
        int index=0;

        for(int i=0;i<arr.length;i++){
            int min=Integer.MIN_VALUE;
            for(int j=i;j<arr.length;j++){
                if(min<arr[j]){
                    min=arr[j];
                    index=j;

                }

            }
            int tmp=arr[i];
            arr[i]=arr[index];
            arr[index]=tmp;

        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }




    }






}
