import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N+1];

        for (int i = 0; i < N; i++){
            strs[i] = br.readLine();
        }
        strs[N] = "";
        Arrays.sort(strs, new Comparator<String>(){
           public int compare(String s1, String s2){
               if (s1.length() == s2.length())
                   return s1.compareTo(s2);
               else
                   return s1.length() - s2.length();
           } 
        });

        for (int i = 1; i <= N; i++){
            if (!strs[i].equals(strs[i-1]))
                bw.write(strs[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}