from collections import deque

def FireBFS():
    global dn, dm, maze, fire, visited
    q = deque()
    for i in range(N):
        for j in range(M):
            if (maze[i][j] == 'F'):
                visited[i][j] = 1
                q.append([i, j])
    while(len(q)!=0):
        now = q.popleft()
        for i in range(4): #상하좌우 탐색
            n = now[0] + dn[i]
            m = now[1] + dm[i]
            
            if (n>=0 and m>=0 and n<N and m<M):
                if((maze[n][m]=='.' or maze[n][m]=='J') and visited[n][m]==0):
                    
                    visited[n][m] = 1
                    fire[n][m] = fire[now[0]][now[1]] +1
                    q.append([n, m])


def peopleBFS():
    global dn, dm, maze, fire, people, visited
    q = deque()
    answer = 0
    flag = 0
    for i in range(N):
        for j in range(M):
            if (maze[i][j] == 'J'):
                visited[i][j] = 1
                q.append([i, j])
    while(len(q)!=0):
        now = q.popleft()
        for i in range(4): #상하좌우 탐색
            n = now[0] + dn[i]
            m = now[1] + dm[i]
            if (n<0 or m<0 or n>=N or m>=M):
                answer = people[now[0]][now[1]] +1
                flag = 1
                break
            if(maze[n][m]=='.' and visited[n][m]==0 and (fire[n][m] == 0 or people[now[0]][now[1]] +1 < fire[n][m])):
                
                visited[n][m] = 1
                people[n][m] = people[now[0]][now[1]] +1
                q.append([n, m])
        
        if (flag == 1):
            break
    if (flag == 1):
        print(answer)
    else:
        print("IMPOSSIBLE")
        
                    
        

global dn, dm, maze, fire, people, visited
dn = [1,0,-1,0]
dm = [0,1,0,-1]
N, M = map(int, input().rstrip().split(" "))
maze = []
for _ in range(N):
    maze.append(list(input()))
visited = [[0 for _ in range(M)] for _ in range(N)]
fire = [[0 for _ in range(M)] for _ in range(N)]
people = [[0 for _ in range(M)] for _ in range(N)]
FireBFS()
visited = [[0 for _ in range(M)] for _ in range(N)]
peopleBFS()
#print(fire)
#print(people)




    