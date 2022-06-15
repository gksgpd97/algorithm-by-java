import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int errorFlag = 0;
        int T = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < T; idx++){
            String[] cmd = (br.readLine()).split("");
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Deque<Integer> arr = new LinkedList<>();

            int size = str.length();
            if (size > 2){
                str = str.substring(1, size - 1);
                String[] tmp = str.split(",");
                for (int i = 0; i < tmp.length; i++){
                    arr.addLast(Integer.parseInt(tmp[i]));
                }    
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
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!arr.isEmpty()){
                    if (reverse == 0)
                        sb.append(Integer.toString(arr.removeFirst()));
                    else if (reverse == 1)
                        sb.append(Integer.toString(arr.removeLast()));
                    if (arr.size() != 0)
                        sb.append(",");
                }
                sb.append("]\n");
                String s = sb.toString();
                bw.write(s);
            }
            reverse = 0;
        }

		bw.flush();
        bw.close();
        br.close();
	}
}