//direct 방향배열
//BFS에서 필요함
//간단상식. 배열은 메모리에 일렬로 저장된다. 다차원이더라도.
/* 4 x 5 사이즈의 맵(문자 배열)을 준비합니다. 모든 칸의 값은 '_' (언더바)로 채워줍니다.
그리고 폭탄을 투하할 좌표(Y, X) 두 곳을 입력 받아주세요. 그리고 두 폭탄이 터진 후의 맵을 출력해 주세요.
폭탄이 터지면 상하좌우, 그리고 대각선 방향이 '#'으로 표시됩니다.
*/
import java.util.*;
import java.io.*;
class Main{
    static int[][] arr = new int[4][5];
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String arg[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int j = 0; j < 2; j++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
    
            int sum = 0;
            for (int i = 0; i < 8; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny<0 || nx<0 || ny>4 || nx>3)
                    continue;
                arr[nx][ny] = 1;
            }
        }
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 5; j++){
                if (arr[i][j] == 1)
                    System.out.print("# ");
                else
                    System.out.print("_ ");
            }
            System.out.println();
        }
    }
}