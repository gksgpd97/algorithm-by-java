import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.addAll(set);
        Collections.sort(tmp);
        
        for(int i = 0; i < tmp.size(); i++){
            bw.write(tmp.get(i)+"");
            if (i != tmp.size() - 1)
                bw.write(" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
