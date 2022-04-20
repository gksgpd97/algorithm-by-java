import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q;
    static int N;
    static int M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dist = new int[N][M];
        for(int i = 0; i < N; i++){
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        BFS();
        bw.flush();
        bw.close();
        br.close();
        
	}
    public static void BFS()throws IOException{
        q = new LinkedList<>();
        dist[0][0] = 1;
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int[] cur = q.poll();
            for (int dir=0; dir<4; dir++){
                int nx = cur[0]+dx[dir];
                int ny = cur[1]+dy[dir];
                if (nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;
                if (arr[nx][ny] == 0 || dist[nx][ny] > 0)
                    continue;
                dist[nx][ny] = dist[cur[0]][cur[1]]+1;
                q.add(new int[]{nx, ny});
            }   
        }
        bw.write(dist[N-1][M-1]+"");
    }
}