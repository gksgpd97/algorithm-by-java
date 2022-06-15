import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = (br.readLine()).split("");
        LinkedList<String> link = new LinkedList<>();
        ListIterator<String> list = link.listIterator();
        for (int i = 0; i < str.length; i++) list.add(str[i]);
        int N = Integer.parseInt(br.readLine());
        String comm = "";
        String c = "";
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            comm = st.nextToken();
            if (comm.equals("L")){
                if (list.hasPrevious())
                    list.previous();
            }else if (comm.equals("D")){
                if (list.hasNext())
                    list.next();
            }else if (comm.equals("B")){
                if (list.hasPrevious()){
                    list.previous();
                    list.remove();
                }
            }else if (comm.equals("P")){
                c = st.nextToken();
                list.add(c);
            } 
        }
        for (String cc : link)
            bw.write(cc);
        bw.flush();
        bw.close();
        br.close();
    }
}
