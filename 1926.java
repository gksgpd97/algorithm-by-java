import java.util.*;
import java.io.*;
public class Main {
    static int[][] arr;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q;
    static int count = 0;
    static int max = 0;
    static int N;
    static int M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BFS();
        bw.flush();
        bw.close();
        br.close();
        
	}
    public static void BFS()throws IOException{
        int mx = 0;
        int num = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (arr[i][j] == 0 || visited[i][j]==1)
                    continue;
                num++;
                q = new LinkedList<>();
                visited[i][j] = 1;
                q.add(new int[]{i,j});
                int area = 0;
                while (!q.isEmpty()){
                    area++;
                    int[] cur = q.poll();
                    for (int dir=0; dir<4; dir++){
                        int nx = cur[0]+dx[dir];
                        int ny = cur[1]+dy[dir];
                        if (nx<0 || nx>=N || ny<0 || ny>=M)
                            continue;
                        if (arr[nx][ny] == 0 || visited[nx][ny]==1)
                            continue;
                        visited[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
                mx = (mx < area) ? area : mx;
            }
        }
        bw.write(num+"\n"+mx);
    }
}