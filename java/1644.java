import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static int[] arr;
    static List<Integer> list;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        arr=new int[N+1];
        list=new ArrayList<Integer>();
        
        findPrime(N);
        System.out.println("not mine:"+list.size());
        int answer = 0;
        for (int i = 0; i < list.size(); i++){
            int sum = 0;
            int j = i;
            while (sum <= N && j < list.size()){
                sum += list.get(j);
                
                if (sum == N){
                    answer++;
                }
                j++;
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
        
	}

    static void findPrime(int N) {
        //에라토스테네스의 체
        for(int i=2;i<=N;i++) {
            if(arr[i]==0) {
                list.add(i);
                for(int j=i;j<=N;j=j+i) {
                    arr[j]=1;
                }
            }
        }
    }
}
/*소수 많이 구하기
2 3 5 7 ...의 소수는 포함하면서 그들의 배수가 아닌것*/