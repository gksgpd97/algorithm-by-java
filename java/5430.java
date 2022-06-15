import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] check;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        while(cnt > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int max = 0;
            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                int tmp = Integer.parseInt(st.nextToken());
                q.add(new int[]{tmp, i});
                if (tmp > max)
                    max = tmp;
            }
            int i = 1;
            while (true){
                int[] arr = q.poll();
                if (arr[0] < max){
                    q.add(arr);
                }
                else if (arr[0] >= max){
                    if (!q.isEmpty()){
                        int[] tmp = Collections.max(q, new Comparator<int[]>(){
                            public int compare(int[] a, int[] b){
                                if (a[0] < b[0]){
                                    return -1;
                                }
                                if (a[0] == b[0])
                                    return 0;
                                return 1;
                            }
                        });
                        max = tmp[0];
                    }
                    if (arr[1] == M){
                        bw.write(i+"\n");
                        break;
                    }
                    i++;
                }
            } 
            cnt--;
        }
		bw.flush();
        bw.close();
        br.close();
	}
}