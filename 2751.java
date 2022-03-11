import java.util.Scanner;
class Main{
    public static int[] arr;
    public static int[] tmp;

    public static void mergeSort(int st, int en){
        if (st < en){
            int mid = (st + en) / 2;
            mergeSort(st, mid);
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
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        sc.close();
        
        mergeSort(0, N-1);
        
        for(int i = 0; i < N; i++){
        	sb.append(arr[i]).append('\n');
        }
        
        System.out.println(sb);
    }
}