import sys
sys.setrecursionlimit(10**6)

def DFS(v, pref):
    if (visited[v]):
        return False #사이클 발생
    visited[v] = 1
    for node in tree[v][1:]:
        if (node != pref):
            if DFS(node, v) == False: #사이클 발생해서 돌아왔다면
                return False
    return True

input = sys.stdin.readline
case = 0
while True:    
    case+=1
    n, m = map(int, input().split())
    if (n ==0 and m == 0):
        break
    tree = [[0] for _ in range(n+1)]
    visited = [0 for _ in range(n+1)]
    cnt = 0
    for _ in range(m):
        v1, v2 = map(int, input().split())
        tree[v1].append(v2)
        tree[v2].append(v1)
    for i in range(1, n+1):
        if visited[i] == 1:
            continue
        if DFS(i, 0):
            cnt+=1
    if cnt==0:
        print('Case {}: No trees.'.format(case))
    elif cnt == 1:
        print('Case {}: There is one tree.'.format(case))
    else:
        print('Case {}: A forest of {} trees.'.format(case, cnt))

        