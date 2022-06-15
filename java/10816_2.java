import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arrN[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            arrM[i] = Integer.parseInt(st2.nextToken());

        int[] counter = new int[20000001];
        for (int i = 0; i < N; i++){
            counter[10000000+arrN[i]]++;
        }
        for (int i = 0; i < M; i++){
            bw.write(counter[10000000+arrM[i]]+"");
            if (i != M)
                bw.write(" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
}
