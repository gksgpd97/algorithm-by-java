import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
class Main{
    public static int[] arr;
    public static int[] tmp;

    public static void printArray(int[] a) { 
        for (int i=0;i<a.length;i++) 
            System.out.print(a[i]+" ");
        System.out.println(); 
    }
    public static void mergeSort(int st, int en){
        System.out.println("st: "+ st + ", en: " + en); 
        if (st < en){
            int mid = (st + en) / 2;
            System.out.println("go st mid");
            mergeSort(st, mid);
            System.out.println("go mid en"); 
            mergeSort(mid + 1, en);
            int p = st; 
            int q = mid + 1; 
            int idx = p; 
            while (p<=mid || q<=en) { 
                if (q>en || (p<=mid && arr[p]<arr[q]))
                    tmp[idx++] = arr[p++]; 
                else
                    tmp[idx++] = arr[q++]; 
            } 
            for (int i=st;i<=en;i++)
                arr[i]=tmp[i];
            System.out.println("end sort: "+st+", "+en);
        }
        System.out.println("end devide: "+st+", "+en);
    }
    public static void main(String[] args) throws IOException{
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        br.close();
        mergeSort(0, N-1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++)
        {
            sb.append(arr[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}