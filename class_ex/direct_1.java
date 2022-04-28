//direct 방향배열
//BFS에서 필요함
//간단상식. 배열은 메모리에 일렬로 저장된다. 다차원이더라도.
/* 위 3x3 배열을하드코딩해주세요.그리고 좌표 하나를 입력 받아주세요.(y, x)
입력 받은 좌표에서 바로 윗칸, 아랫칸, 왼쪽칸, 오른쪽칸의합을 Direct 기법을 이용해서 출력 해 주세요.
*/
import java.util.*;
import java.io.*;
class Main{
    static int[][] arr = {
        {3, 5, 4}, 
        {1, 1, 2}, 
        {1, 3, 9} 
    };
    static int[] dy = {-1,1,0,0}; //상하좌우
    static int[] dx = {0,0,-1,1};
    public static void main(String arg[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny<0 || nx<0 || ny>2 || nx>2)
                continue;
            sum += arr[ny][nx];
        }
        System.out.println(sum);
    }
}