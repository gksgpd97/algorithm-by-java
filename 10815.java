import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arrM = new int[M];
        for (int i = 0; i < M; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        Arrays.sort(arrN);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) 
            sb.append(binarySearch(arrN, N, arrM[i])).append('\n');
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
    }

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
}