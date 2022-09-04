import sys
sys.setrecursionlimit(10**6)

global graph, visited, check, isBinary

def DFS(v):
    #print(v)
    global graph, visited, check, isBinary
    visited[v] = 1
    for i in graph[v][1:]:
        if (not visited[i]):
            check[i] = (check[v] + 1) % 2
            DFS(i)
        else:
            if (check[v] == check[i]):
                isBinary = False
                
#입력받기
input = sys.stdin.readline
K = int(input()) #노드 수

for _ in range(K):
    V, E = map(int, input().split())
    graph = [[0] for _ in range(V+1)]
    visited = [0]*(V+1)
    check = [0]*(V+1)
    isBinary = True
    #print(graph, visited, check)
    for _ in range(E): 
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    #print(graph)
    for i in range(1, V):
        if (isBinary):
            DFS(i)
        else:
            break

    if (isBinary):
        print("YES")
    else:
        print("NO")
    