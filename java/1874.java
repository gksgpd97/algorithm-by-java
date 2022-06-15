import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> st = new Stack<>();
        int chk = 1;
        String str = "";
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
        {
            if (st.empty() != true && st.peek() == arr[i]){
                st.pop();
                sb.append("-\n");
            }
            else{
                for (int j = chk; j <= arr[i]; j++){
                    st.push(j);
                    sb.append("+\n");
                }
                if (st.peek() == arr[i]){
                    st.pop();
                    sb.append("-\n");
                    chk = arr[i]+1;
                }
                else{
                    str = "NO";
                    break;
                }
            }
            
        }
        if (!str.equals("NO"))
            str = sb.toString();
        bw.write(str);
        bw.flush();
        bw.close();
        br.close();
    }
}
//고정값이면 String 연산 대신에 StringBuilder를 쓰자. 128메가바이트 제한인데 전자는 초과고 후자는 안초과 ㅎㄷㄷ
