import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def DFS(r):
    visited[r] = 1
    for node in tree[r][1:]:
        if visited[node] == 0:
            DFS(node)
            visited[r] += visited[node]

N, R, Q = map(int, input().split())
tree = [[0] for _ in range(N+1)]
visited = [0] * (N+1)
for _ in range(N-1):
    U, V = map(int, input().split())
    tree[U].append(V)
    tree[V].append(U)

DFS(R)

for _ in range(Q):
    U = int(input().rstrip())
    print(visited[U])