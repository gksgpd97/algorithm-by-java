from collections import deque

def backtracking(n):
    global k, S, visited, arr
    if (n == 7):
        print(*S[1:])
        return

    for i in range(k):
        if (visited[i] == 0 and S[n-1] < arr[i]):
            #print(i, S)
            visited[i] = 1
            S[n] = arr[i]
            backtracking(n+1)
            visited[i] = 0

while(True):
    arr = deque(map(int, input().split()))
    #print(arr)
    if (arr[0] == 0):
        break
    k = arr.popleft()
    visited = [0]*k
    S = [0]*7
    backtracking(1)
    print()

    