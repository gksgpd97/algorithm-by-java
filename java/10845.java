import java.util.*;
import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        String comm = "";
        int X = 0;
        int last = 0;
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            comm = st.nextToken();
            if (comm.equals("push")){
                X = Integer.parseInt(st.nextToken());
                q.offer(X);
                last = X;
            }else if (comm.equals("pop")){
                if (q.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(Integer.toString(q.poll())+"\n");
            }else if (comm.equals("size")){
                bw.write(Integer.toString(q.size())+"\n");
            }else if (comm.equals("empty")){
                if (q.isEmpty())
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }else if (comm.equals("front")){
                if (q.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(Integer.toString(q.peek())+"\n");
            }else if (comm.equals("back")){
                if (q.isEmpty())
                    bw.write("-1\n");
                else
                    bw.write(Integer.toString(last)+"\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}