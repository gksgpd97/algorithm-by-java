import java.util.*;
import java.io.*;
public class Main {
    static int[] arr = new int[9];
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
    // N = 4 M = 2
    public static void bt(int k)throws IOException{
        if (k==M){
            for(int i=0; i<M; i++){
                //System.out.println("print "+arr[i]+",");
                bw.write(arr[i]+" ");
            }
            //System.out.println("\n");
            bw.write("\n");
            return;
        }
        for(int i=1;i<=N;i++){
            //System.out.println("i: "+i);
            if(visited[i] == 0){
                if (k == 0){
                    arr[k] = i;
                    visited[i] = 1;
                    bt(k+1);
                    visited[i] = 0;   
                }
                if (k>=1 && arr[k-1]<i){
                    arr[k] = i;
                    visited[i] = 1;
                    bt(k+1);
                    visited[i] = 0;    
                }
                //System.out.println("k, i: "+k+","+i);
                // arr[k] = i;
                // visited[i] = 1;
                // bt(k+1);
                // visited[i] = 0;
            }
        }
    }
}
/*
visited
0 1 2 3 4 5 6 7 8
0 1 1

arr
0 1 2 3 4 5 6 7 8
1 2
*/