import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++)
            arr.add(i+1);
        bw.write("<");
        int i = 0;
        while (arr.size() > 0){
            if (arr.size() == 1){
                bw.write(arr.get(0)+"");
                arr.remove(0);
            }
            else{
                i += K - 1;
                while (i > arr.size()-1){
                    i -= arr.size();
                }
                bw.write(arr.get(i)+", ");
                arr.remove(i);
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
        br.close();
    }
}