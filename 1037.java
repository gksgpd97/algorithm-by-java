import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        if (N == 1)
            answer = arr[0] * arr[0];
        else{
            Arrays.sort(arr);
            answer = arr[0] * arr[N-1];
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
        
	}
}