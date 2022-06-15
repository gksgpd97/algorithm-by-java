import java.util.Scanner;
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
    public static void main(String[] args){
        //입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        sc.close();
        mergeSort(0, N-1);
        
        for (int i = 0; i < N; i++)
            System.out.println(arr[i]);
    }
}