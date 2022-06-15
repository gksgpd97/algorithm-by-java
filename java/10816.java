import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arrN[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            arrM[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(arrN);
        for (int i = 0; i < M; i++){
            int idx = binarySearch(arrN, arrM[i]);
            //System.out.println("idx: "+idx);
            if (idx == -1)
                bw.write(0+"");
            else {
                int cnt = 0;
                while (idx < N && arrM[i] == arrN[idx]){
                    cnt++;
                    idx++;
                    //System.out.println("cnt: "+cnt);
                }
                bw.write(cnt + "");
            }
            if (i != M-1)
                bw.write(" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int binarySearch(int[] arrN, int m){
        int min = 0;
        int max = arrN.length-1;
        int mid = (min+max) / 2;
        while (min <= max){
            if (m < arrN[mid]){
                //System.out.println("1");
                max = mid - 1;
                mid = (min+max) / 2;
            }
            else if (m > arrN[mid]){
                //System.out.println("2");
                min = mid + 1;
                mid = (min+max) / 2;
            }
            else if (m == arrN[mid]){
                if (mid != 0 && m == arrN[mid - 1]){
                    //System.out.println("3");
                    mid = mid -1;
                }
                else{
                    //System.out.println("4");
                    return mid;
                }
            }
        }
        return -1;
    }
}
