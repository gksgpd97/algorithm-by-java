import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static List<Integer> list;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));       
        StringBuilder sb = new StringBuilder();
        arr=new int[1000001];
        list = new ArrayList<Integer>();  
        findPrime(1000000);
        int N = -1;
        
        while (true){
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            int l = 1;
            int r = list.size()-1;
            
            while(l<=r){
                if (list.get(l) + list.get(r) > N){
                    r--;
                }
                else if (list.get(l) + list.get(r) < N){
                    l++;
                }
                else if (list.get(l) + list.get(r) == N){
                    break;
                }
            }
            if (l > r)
                sb.append("Goldbach's conjecture is wrong.\n");
            else{
                sb.append(N);
                sb.append(" = ");
                sb.append(list.get(l));
                sb.append(" + ");
                sb.append(list.get(r));
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
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