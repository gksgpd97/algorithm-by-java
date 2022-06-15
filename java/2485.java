import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] sub = new int[N-1];
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < N-1; i++){
            int b = Integer.parseInt(br.readLine());
            sub[i] = b - a;
            a = b;
        }
        Arrays.sort(sub);
        int mm = getMeasure(sub, sub[0]);
        

        int answer = 0;
        for (int i = 0; i < N-1; i++){
            answer += ((sub[i]-1) / mm);
        }
        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
        br.close();
        
	}

    public static int getMeasure(int[] arr, int min){
        int mm = 1;
        int flag = 1;
        for (int i = 1; i <= min; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[j] % i != 0){
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                mm = i;
            flag = 1;
        }
        return mm;
    }
}