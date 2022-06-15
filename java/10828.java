import java.util.*;
import java.io.*;
class Main{
    int[] arr = new int[10001];
    int index = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        String comm = "";
        int X = 0;
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            comm = st.nextToken();
            if (comm.equals("push")){
                X = Integer.parseInt(st.nextToken());
                stack.push(X);
            }
            else if (comm.equals("pop")){
                if (stack.empty())
                    bw.write(Integer.toString(-1)+"\n");
                else
                    bw.write(Integer.toString(stack.pop())+"\n");
            }
            else if (comm.equals("size")){
                bw.write(Integer.toString(stack.size())+"\n");
            }
            else if (comm.equals("empty")){
                if (stack.empty())
                    bw.write(Integer.toString(1)+"\n");
                else
                    bw.write(Integer.toString(0)+"\n");
            }
            else if (comm.equals("top")){
                if (stack.empty())
                    bw.write(Integer.toString(-1)+"\n");
                else
                    bw.write(Integer.toString(stack.peek())+"\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}