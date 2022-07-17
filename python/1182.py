N, S = map(int, input().split())
list = list(map(int, input().split()))
answer = 0

def backtracking(n, sum):
    global N, S, list, answer
    if (n == N):
        if (sum == S):
            answer+=1
        return
    
    backtracking(n+1, sum)
    backtracking(n+1, sum+list[n])
    
"""틀린이유 (-3,-2,7) (-3,7,-2)를 다른 경우로 카운팅
N, S = map(int, input().split())
list = list(map(int, input().split()))
visited = [0 for _ in range(N)]
tmp = []
answer = 0

def backtracking(n):
    global N, S, list, visited, tmp, answer
    if(n == N):
        return    
    if(sum(tmp) == S):
        print(tmp)
        answer+=1
    
    for i in range(N):
        if (visited[i] == 0):
            visited[i] = 1
            tmp.append(list[i])
            backtracking(n+1)
            visited[i] = 0
            tmp.pop()
"""

backtracking(0, 0)
print(answer-1 if S==0 else answer)

