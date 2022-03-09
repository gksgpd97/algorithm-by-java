import java.util.Scanner;
import java.util.Arrays;
class Main {
    public static int binarySearch(int[] A, int N, int m){
        int min = 0;
        int max = N - 1;
        int mid = (min + max) / 2;
        while(min <= max){
            if (m > A[mid]){
                min = mid + 1;
                mid = (min + max) / 2;
            }
            else if (m < A[mid]){
                max = mid - 1;
                mid = (min + max) / 2;
            }
            else if (m == A[mid])
                return (1);
        }
        return (0);
    }
    public static void main(String[] args){
        //입력 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++)
            A[i] = Integer.parseInt(sc.next());

        int M = sc.nextInt();
        int[] m = new int[M];
        for(int i = 0; i < M; i++)
            m[i] = Integer.parseInt(sc.next());

        //정렬하기
        Arrays.sort(A);

        //이분탐색하기
        //출력하기
        for(int i = 0; i < M; i++)
            System.out.println(binarySearch(A, N, m[i]));   
    }
}