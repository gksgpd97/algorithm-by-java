import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] check;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] str = br.readLine().split(" ");
			
			if("0".equals(str[0])) break;
			
			N = Integer.parseInt(str[0]);
			arr = new int[N];
			check = new boolean[N];
			
			for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(str[i+1]);
			
			find(0,0);
			bw.write("\n");
		}
		bw.flush();
	}
	
	public static void find(int start, int depth) throws IOException {
		if(depth == 6) {
			for (int i = 0; i < N; i++) {
				if(check[i]) {
					bw.write(arr[i] + " ");
				}
			}
			bw.write("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			check[i] = true;
			find(i+1, depth+1);
			check[i] = false;
		}
	}
}