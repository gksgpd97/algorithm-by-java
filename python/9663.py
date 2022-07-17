N = int(input())
board = [[0 for _ in range(N)] for _ in range(N)]
vcol = [0 for _ in range(N)]
vldiagonal = [0 for _ in range(N*2-1)]
vrdiagonal = [0 for _ in range(N*2-1)]

answer = 0
def backtracking(row): #행에 체스 하나만을 두고 어떤 열에 둘 수 있는지 찾는다
    global N, board, vcol, vldiagonal, vrdiagonal, answer
    if (row == N):
        answer += 1
        return
    for col in range(N):
        if (vcol[col] or vldiagonal[row+col] or vrdiagonal[row-col+N-1]):
            continue
        vcol[col] = 1
        vldiagonal[row+col] = 1
        vrdiagonal[row-col+N-1] = 1
        backtracking(row+1)
        vcol[col] = 0
        vldiagonal[row+col] = 0
        vrdiagonal[row-col+N-1] = 0
        
backtracking(0)
print(answer)
