import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));       
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.valueOf(st.nextToken());
        long max = Long.valueOf(st.nextToken());
        long answer = 0;
        for (long i = min; i <= max; i++){
            int sr = (int)Math.sqrt(i);
            int flag = 0; //제곱ㄴㄴ수
            for (long j = 2; j <= (long)sr; j++){
                if (i % (j*j) == 0){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                answer++;
        }
        bw.write(Long.toString(answer));
        bw.flush();
        bw.close();
        br.close();
        
	}
}
/*
1 2 3 4 5 6 7 8 9 10
x x x o x x x o o x
*/