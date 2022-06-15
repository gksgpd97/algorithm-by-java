// N Queen 문제 , 아직 덜 품
import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int arr[][] = new int[4][4];
    static int group1[][] = new int[4][4];
    static int group2[][] = new int[4][4];
    static int visited[] = new int[4];
    static int visitedG1[] = new int[4];
    static int visitedG2[] = new int[4];
    public static void main(String[] args) throws IOException{

        //대각선 우하방향
        int groupCnt = 1;
        for (int r=0; r <4; r++){
            for(int c= 0; c<4; c++){
                if (group1[r][c] !=0 )
                    continue;
                int nr = r;
                int nc = c;
                while(nr < 4 && nc<4){
                    group1[nr][nc] = groupCnt;
                    nr++;
                    nc++;
                }
                groupCnt++;
            }
        }
        //대각선 좌하방향
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
            if()
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