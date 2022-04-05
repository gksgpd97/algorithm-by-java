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
        for (int i = 0; i < N; i++){
            if (isPrime(arr[i]) == 1)
                answer++;
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
        
	}

    public static int isPrime(int n){
        if (n == 1)import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        for (int i = M; i <= N; i++){
            if (isPrime(i) == 1)
                bw.write(Integer.toString(i)+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
        
	}

    public static int isPrime(int n){
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else{
            for (int i = 2; i <= Math.sqrt(n); i++){
                if (n % i == 0)
                    return 0;
            }
        }
        return 1;
    }
}
            return 0;
        else if (n == 2)
            return 1;
        else{
            for (int i = 2; i < n; i++){
                if (n % i == 0)
                    return 0;
            }
        }
        return 1;
    }
}