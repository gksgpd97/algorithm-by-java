import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(stA.nextToken());
        }
        StringTokenizer stBC = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(stBC.nextToken());
        int C = Integer.parseInt(stBC.nextToken());

        long sum = 0;
        for (int i = 0; i < N; i++){
            int div = A[i] - B;
            if (div <= 0)
                sum++;
            else if (div > 0){
                sum++;
                if (div % C != 0)
                    sum += ((div / C) + 1);
                else
                    sum += (div / C);
            }
        }
        bw.write(Long.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
//sum의 자료형이 변수였다. int는 범위초과로 틀림