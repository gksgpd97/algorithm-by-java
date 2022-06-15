import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] op = new int[4];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            A[i] = Integer.parseInt(stA.nextToken());
        }
        StringTokenizer stOP = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(stOP.nextToken());
        }
        int cases = (fctrl(op[0]+op[1]+op[2]+op[3])) / (fctrl(op[0]) * fctrl(op[1]) * fctrl(op[2]) * fctrl(op[3]));
        int[] result = new int[cases];
        
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
    public static void fctrl(int n){
        if (n == 0)
            return 1;
        return n * fctrl(n - 1);
    }
}
//sum의 자료형이 변수였다. int는 범위초과로 틀림

