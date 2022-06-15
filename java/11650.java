import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] I = new int[N][2];
        
        
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            I[i][0] = Integer.parseInt(st.nextToken());
            I[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(I, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if (a[0] == b[0])
                    return (a[1] - b[1]);
                else
                    return (a[0] - b[0]);
            }
        });

        for(int i = 0; i < N; i++){
            bw.write(I[i][0] + " " + I[i][1] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
