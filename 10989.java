import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] counter = new int[10001];
        while (N > 0){
            counter[Integer.parseInt(br.readLine())]++;
            N--;
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
            while (counter[i] > 0) {
                sb.append(i).append('\n');
                counter[i]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}