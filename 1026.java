import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        StringTokenizer ast = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(ast.nextToken());
        }
        StringTokenizer bst = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            B[i] = Integer.parseInt(bst.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < N; i++){
            sum += A[i]*B[i];
        }
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
