N = int(input())

arr = [list(map(int, input())) for _ in range(N)]
answer = ""

def check(r,c,N):
    global arr, answer
    for i in range(r, r+N):
        for j in range(c, c+N):
            if (arr[i][j] != arr[r][c]):
                return False
    return True
    
def recurs(r, c, N):
    global arr, answer
    #종료조건: 한 구역이 모두 같은 수로 이루어졌을 때
    if(check(r,c,N)):
        answer += str(arr[r][c])
        return
    else:
        #다르면 4분할하기전에 괄호 열어준다
        answer += '('
        recurs(r, c, N//2)
        recurs(r, c+(N//2), N//2)
        recurs(r+(N//2), c, N//2)
        recurs(r+(N//2), c+(N//2), N//2)
        #닫히는 괄호는 무조건 마지막 구역 후에 올테니까 마지막 구역 재귀 끝나고 닫아줌
        answer += ')'
    
recurs(0,0,N)
print(answer)
