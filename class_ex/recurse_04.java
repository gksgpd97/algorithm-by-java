//N castle 문제

import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int arr[][] = new int[4][4];
    static int visited[] = new int[4];
    public static void main(String[] args) throws IOException{
        dfs(0);
    }

    public static void dfs(int row){
        if(row == 4){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int col = 0; col < 4; col++){
            if(visited[col] == 1)
                continue;
            visited[col] = 1;
            arr[row][col] = 1;
            dfs(row+1);
            arr[row][col] = 0;
            visited[col] = 0;
        }
    }
}

/*
재귀호출 설계하는 법
1. 가지 수 신경쓰기
2. 깊이 신경쓰기


                   abc(0)
           abc(1)         abc(1)
      abc(2)  abc(2)   abc(2)  abc(2)

level=3 종료조건
branch=2 재귀호출횟수


*/
//과제 던전탐험2, 훈련반1 lv20.5까지