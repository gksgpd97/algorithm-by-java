import java.util.*;
import java.io.*;
public class Main {
    static int[] arr = new int[8];
    static int[] visited = new int[9];
    static int N;
    static int M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
       
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        bt(0);
        
        bw.flush();
        bw.close();
        br.close();
        
	}
    public static void bt(int k)throws IOException{
        if (k == M){
            for (int i=0; i<M; i++){
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }
        for (int i=1; i<=N; i++){
            if (k==0){
                arr[k] = i;
                bt(k+1);
            }
            if (k!=0 && arr[k-1]<=i){
                arr[k] = i;
                bt(k+1);
            }
            
        }
    }
}