import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));       
        //짝수는 무조건 가능
        //홀수는 짝수+홀수로 표현 가능
        //짝수 소수는 2밖에 없음
        //홀수는 2+홀수로 표현하면 됨
        int N = 2000000;
        long[] arr=new long[N+1];
        ArrayList<Long> prime = new ArrayList<>();
        arr[0]=arr[1]=1;
        for(int i=2;i<=N;i++) {
            if(arr[i]==0) { //0은소수 1은 합성수
                prime.add(Long.valueOf(i));
                for(int j=i*2;j<=N;j=j+i) {
                    arr[j]=1;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.valueOf(st.nextToken());
            long B = Long.valueOf(st.nextToken());

            if (A+B<=3)
                bw.write("NO\n");
            else if ((A+B)%2==0){
                bw.write("YES\n");
            }
            else{
                if (A+B>=4 && A+B<=N){
                    int sub = (int)(A+B-2);
                    if (arr[sub] == 0)
                        bw.write("YES\n");
                    else
                        bw.write("NO\n");
                }
                else if (A+B>N){
                    long sub = A+B-2;
                    int flag = 0;
                    for (int j = 0; j < prime.size(); j++){
                        if (sub % prime.get(j) == 0){
                            flag = 1;
                            break;
                        }    
                    }
                    if (flag == 0)
                        bw.write("YES\n");
                    else
                        bw.write("NO\n");
                }
                
            }

            
        }
        
        bw.flush();
        bw.close();
        br.close();
        
	}
}
