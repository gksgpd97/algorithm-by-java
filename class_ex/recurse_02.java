import java.io.*;

class Main {
    static int input;
    static String[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = Integer.parseInt(br.readLine());
        arr = new String[10];
        abc(0);
    }

    public static void abc(int x){
        if (x == input){ //종료조건, base condition
            for(int i = 0; i < x; i++)
                System.out.print(arr[i]);
            System.out.println();
            return;
        }
        arr[x] = "L";
        abc(x+1); //왼쪽 가지
        arr[x] = "R";
        abc(x+1); //오른쪽 가지
        return;
    }
}

/*
                   abc(0)
           abc(1)         abc(1)
      abc(2)  abc(2)   abc(2)  abc(2)

*/
//과제 던전탐험2, 훈련반1 lv20.5까지