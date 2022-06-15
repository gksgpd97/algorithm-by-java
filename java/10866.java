import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> dq = new ArrayList<>();
        String comm = "";
        int X = 0;
        int length = 0;
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            comm = st.nextToken();
            if (comm.equals("push_front")){
                X = Integer.parseInt(st.nextToken());
                dq.add(0, X);
                length++;
            }else if (comm.equals("push_back")){
                X = Integer.parseInt(st.nextToken());
                if (length == 0)
                    dq.add(0, X);
                else
                    dq.add(length, X);
                length++;
            }else if (comm.equals("pop_front")){
                if (length == 0)
                    bw.write("-1\n");
                else{
                    bw.write(Integer.toString(dq.get(0))+"\n");
                    dq.remove(0);
                    length--;
                }
            }else if (comm.equals("pop_back")){
                if (length == 0)
                    bw.write("-1\n");
                else{
                    bw.write(Integer.toString(dq.get(length - 1))+"\n");
                    dq.remove(length - 1);
                    length--;
                }
            }else if (comm.equals("size")){
                bw.write(Integer.toString(length)+"\n");
            }else if (comm.equals("empty")){
                if (length == 0)
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }else if (comm.equals("front")){
                if (length == 0)
                    bw.write("-1\n");
                else
                    bw.write(Integer.toString(dq.get(0))+"\n");
            }else if (comm.equals("back")){
                if (length == 0)
                    bw.write("-1\n");
                else
                    bw.write(Integer.toString(dq.get(length - 1))+"\n");
            }
            bw.flush();    
        }
        bw.close();
        br.close();
    }
}
