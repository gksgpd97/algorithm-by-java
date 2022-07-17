from collections import deque

def BFS():
    global dx, dy, visited, maze
    q = deque()
    visited[0][0] = 1
    q.append([0, 0])
    while(len(q)!=0):
        now = q.popleft()
        for i in range(4): #상하좌우 탐색
            n = now[0] + dn[i]
            m = now[1] + dm[i]
            if (n>=0 and m>=0 and n<N and m<M):
                if(maze[n][m]!=0 and visited[n][m]==0):
                    visited[n][m] = 1
                    maze[n][m] = maze[now[0]][now[1]] +1
                    q.append([n, m])

global dx, dy, visited, maze
dn = [1,0,-1,0]
dm = [0,1,0,-1]
N, M = map(int, input().rstrip().split(" "))
maze = []
for _ in range(N):
    maze.append(list(map(int, input())))
visited = [[0 for _ in range(M)] for _ in range(N)]
BFS()
print(maze[N-1][M-1])



    