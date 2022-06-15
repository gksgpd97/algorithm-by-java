import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = (br.readLine()).split("");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(str));
        int N = Integer.parseInt(br.readLine());
        String comm = "";
        String c = "";
        int cur = list.size();
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            comm = st.nextToken();
            if (comm.equals("L")){
                if (cur != 0)
                    cur--;
            }else if (comm.equals("D")){
                if (cur != list.size())
                    cur++;
            }else if (comm.equals("B")){
                if (cur != 0){
                    list.remove(cur);
                    cur--;
                }
            }else if (comm.equals("P")){
                c = st.nextToken();
                list.add(cur, c);
                cur++;
            } 
        }
        for (int i = 0; i < list.size(); i++)
            bw.write(list.get(i));
        bw.flush();
        bw.close();
        br.close();
    }
}
