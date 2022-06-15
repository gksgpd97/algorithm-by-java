import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int max_m = 0;
        if (M > N)
            max_m = getMeasure(N, M);
        else
            max_m = getMeasure(M, N);

        int min_m = (M / max_m) * N;
        
        bw.write(Integer.toString(max_m));
        bw.write("\n");
        bw.write(Integer.toString(min_m));
        bw.flush();
        bw.close();
        br.close();
        
	}

    public static int getMeasure(int min, int max){
        int mm = 0;
        for (int i = 1; i <= min; i++){
            if (min % i == 0 && max % i == 0){
                if (mm < i)
                    mm = i;
            }
        }
        return mm;
    }
}