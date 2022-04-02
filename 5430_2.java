import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int errorFlag = 0;
        int T = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < T; idx++){
            String[] cmd = (br.readLine()).split("");
            int n = Integer.parseInt(br.readLine());
            String[] str = (br.readLine()).split("");
            Deque<Integer> arr = new LinkedList<>();
            int j = 1;
            while (j < (n+n-1+2)){
                if (j % 2 == 1)
                    arr.addLast(Integer.parseInt(str[j]));
                j += 2;
            }

            int reverse = 0;
            for (int i = 0; i < cmd.length; i++){
                if (cmd[i].equals("R")){
                    if (reverse == 0) reverse = 1;
                    else reverse = 0;
                }
                else if (cmd[i].equals("D")){
                    if (arr.size() == 0){
                        errorFlag = 1;
                        break;
                    }
                    else{
                        if (reverse == 0){
                            arr.removeFirst();
                        }
                        else if (reverse == 1){
                            arr.removeLast();
                        }
                    }
                }
            }

            if (errorFlag == 1){
                bw.write("error\n");    
                errorFlag = 0;
            }else{
                sb.append("[");
                while (!arr.isEmpty()){
                    if (reverse == 0)
                        sb.append(Integer.toString(arr.removeFirst()));
                    else
                        sb.append(Integer.toString(arr.removeLast()));
                    if (arr.size() != 0)
                        sb.append(",");
                }
                sb.append("]\n");
                String tmp = sb.toString();
                bw.write(tmp);
            }
            reverse = 0;
        }

        
   
		bw.flush();
        bw.close();
        br.close();
	}
}//시간초과 발생, 연결리스트인 데크로 풀어야함 