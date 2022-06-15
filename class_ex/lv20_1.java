// import java.io.*;
/*
무한 재귀 막기
bbq()를 재귀적으로 4번 불러라
*/
class Main {
    public static void main(String[] args){
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bbq(0);
    }

    public static void bbq(int x){
        if (x == 5)
            return;
        bbq(x+1);
    }
}

/*
                   abc(0)
           abc(1)         abc(1)
      abc(2)  abc(2)   abc(2)  abc(2)

*/
//과제 던전탐험2, 훈련반1 lv20.5까지