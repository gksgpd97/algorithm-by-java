
def backtracking(n):
    global N,M,arr,S,visited,answer
    if (n == M+1):
        answer.add(tuple(S[1:]))
        return

    for i in range(N):
        if (visited[i]==0):
            #print(S)
            visited[i]=1
            S[n] = arr[i]
            #print(S)
            backtracking(n+1)
            visited[i]=0

N,M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
S=[0]*(M+1)
visited=[0]*N
answer = set()
backtracking(1)
for t in sorted(answer):
    print(*t)

    