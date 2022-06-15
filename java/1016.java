import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));       
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.valueOf(st.nextToken());
        long max = Long.valueOf(st.nextToken());

        int N = (int)(max - min + 1);
        int sr = (int)Math.sqrt(max);
        int[] arr=new int[N];
        
        for(int i=2;i<=sr;i++) {
            long sqr = (long) i * i;
            long s = min % sqr == 0 ? min/sqr : (min/sqr)+1;           
            for(long j= s; sqr*j<=max;j++) {
                arr[(int)((j*sqr)-min)]=1;
            }
            
        }
        int answer = 0;
        for (int i = 0; i <= max-min; i++){
            if (arr[i] == 0)
                answer++;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
        
	}
}
/*
에바 이거 규칙을 어케 발견해
1 2 3 4 5 6 7 8 9 10
x x x o x x x o o x
*/
//607940
//607926