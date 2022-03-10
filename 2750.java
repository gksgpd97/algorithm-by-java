import java.util.Scanner;
import java.util.Arrays;
class Main{
    public static void main(String[] args){
        //입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        //정렬하기
        int flag;
        for (int i = N; i > 0; i--){
            flag = 1;
            for (int j = 0; j < i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    flag = 0;
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (flag == 1)
                break;
        }
        for (int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
}