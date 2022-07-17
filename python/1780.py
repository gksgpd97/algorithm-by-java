#68852KB
N = int(input())
arr = [list(map(int, input().split(" "))) for _ in range(N)]
answer = [0,0,0]

#분할정복 기초
def recursive(r,c,N):
    global answer, arr
    number = arr[r][c]
    for i in range(r, r+N):
        for j in range(c, c+N):
            if (number != arr[i][j]):
                recursive(r,c,N//3)
                recursive(r,c+(N//3),N//3)
                recursive(r,c+(2*(N//3)),N//3)
                recursive(r+(N//3),c,N//3)
                recursive(r+(N//3),c+(N//3),N//3)
                recursive(r+(N//3),c+(2*(N//3)),N//3)
                recursive(r+(2*(N//3)),c,N//3)
                recursive(r+(2*(N//3)),c+(N//3),N//3)
                recursive(r+(2*(N//3)),c+(2*(N//3)),N//3)
                return

    if (arr[r][c] == -1):
        answer[0]+=1
    elif(arr[r][c] == 0):
        answer[1]+=1
    else:
        answer[2]+=1

recursive(0, 0, N)
print(answer[0])
print(answer[1])
print(answer[2])

""" 367388KB
from sys import stdin

def check(r,c,N):
    global arr
    for i in range(r, r+N):
        for j in range(c, c+N):
            if(arr[r][c] != arr[i][j]):
                return False
    return True

#분할정복 기초
def recursive(r,c,N):
    global arr, answer
    #종료조건
    if (check(r,c,N)): 
        answer[int(arr[r][c])+1]+=1
        return
    for i in range(3):
        for j in range(3):
            recursive(r+(i*(N//3)), c+(j*(N//3)), N//3)
    
global arr, answer

N = int(input())
arr = [list(stdin.readline().split()) for _ in range(N)]
answer = [0,0,0]
recursive(0, 0, N)
print(answer[0])
print(answer[1])
print(answer[2])
"""