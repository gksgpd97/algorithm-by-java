/*
M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우

M = 2 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우

M = 3 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우
*/

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int M;
    static int N;
    static int arr[] = new int[5];
    static int visited[] = new int[7];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 

        if (M == 1){
            dfs1(0);
        }
        else if (M == 2){
            
        }
        else if (M == 3){
            dfs3(0);
        }
        
    }

    public static void dfs1(int x){
        if (x == N){ //종료조건, base condition
            for(int i = 0; i < N; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= 6; i++){
            arr[x] = i;
            dfs1(x+1);
        }
        return;
    }

    public static void dfs2(int x){
        if (x == N){
            return;
        }
        for (int i = 1; i <= 6; i++){
            if (visited[i-1] != 1){
                visited[i] = 1;
                arr[x] = i;
                dfs2(x+1);
                visited[i] = 0;
            }
        }
    }

    public static void dfs3(int x){
        if (x == N){
            for(int i = 0; i < N; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= 6; i++){
            if (visited[i] != 1){ // 이전경로에서 눈금이 선택되었는가
                visited[i] = 1;//이후 경로에서 눈금선택 못하도록
                arr[x] = i;
                dfs3(x+1);
                visited[i] = 0;    
            }
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