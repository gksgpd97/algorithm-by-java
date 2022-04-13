import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));       
        
        int N = 11*11*11*11*11*11;
        long[] arr=new long[N+1];
        ArrayList<Long> nn = new ArrayList<>();
        
        for(int i=2;i*i<=N;i++) {
            if(arr[i]==0) { //1은 ㅇㅇ수 0은 제곱ㄴㄴ수
                for(int j=i*i;j<=N;j=j+(i*i)) {
                    arr[j]=1;
                }
            }
            else if (arr[i]==1){
                nn.add((long)(i));
            }
        }
        // System.out.println(nn.get(0));
        // System.out.println(nn.get(1));
        // System.out.println(nn.get(2));
        // System.out.println(nn.get(3));
        // System.out.println(arr[8]);
        // System.out.println(arr[9]);
        // System.out.println(arr[10]);
        // System.out.println(arr[11]);
        // System.out.println(arr[12]);
        // System.out.println(arr[13]);
        // System.out.println(arr[14]);
        // System.out.println(arr[15]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.valueOf(st.nextToken());
        long max = Long.valueOf(st.nextToken());
        long answer = 0;
        for (long i = min; i <= max; i++){
            //int sr = (int)Math.sqrt(i);
            int flag = 0; //제곱ㄴㄴ수
            if (i <= N){
                if (arr[(int)i] == 0)
                    answer++;
            }
            else{
                for (int j = 0; j < nn.size(); j++){
                    if (i % nn.get(j) == 0){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    answer++;
            }
            
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
//607940
//607926