import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int j = 0;
        int k = 0;
        while(true){
            int sum = rec(j, k);
            if (sum == S){
                answer++;
            }
        }
	}

    public static int rec(int start, int end){
        int ret = 0;
        for (int i = start; i < (start+end); i++){
            ret += arr[i];
        }
        return ret;
    }
}