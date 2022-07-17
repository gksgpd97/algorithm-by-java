from sys import stdin
#분할정복 기초
def func(r, c, N):
    color = arr[r][c] #0 or 1
    for i in range(r, r+N):
        for j in range(c, c+N):
            #종료 조건
            if (arr[i][j] != color):
                func(r, c, N//2)
                func(r, c+N//2, N//2)
                func(r+N//2, c, N//2)
                func(r+N//2, c+N//2, N//2)
                return #반드시 해줘야. 함수의 역할은 4분할 하는 걸로 끝
    if (color == 0):
        answer.append(0)
    else:
        answer.append(1)
    
                  
N = int(input())

global arr, answer
arr = [list(map(int, stdin.readline().split(" "))) for _ in range(N)]
answer = []
func(0, 0, N)
print(answer.count(0))
print(answer.count(1))