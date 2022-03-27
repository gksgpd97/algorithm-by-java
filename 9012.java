import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();
            if (str.length() % 2 != 0)
                bw.write("NO\n");
            else
            {
                String[] arr = str.split("");
                int result = validPs(str, arr);
                if (result == 0)
                    bw.write("NO\n");
                else
                    bw.write("YES\n");
            }
        }
    
        bw.flush();
        bw.close();
        br.close();
    }
    public static int validPs(String str, String[] arr){
        int l_cnt = 0;
        int r_cnt = 0;
        for (int i = 0; i < str.length(); i++){
            if (arr[i].equals("(")){
                l_cnt++;
            }
            else if (arr[i].equals(")")){
                r_cnt++;
                if (r_cnt > l_cnt){
                    return 0;
                }
            }
            if (l_cnt > (str.length()/2) || r_cnt > (str.length()/2)){
                return 0;
            }
        }
        return 1;
    }
}
