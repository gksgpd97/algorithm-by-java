import copy

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]
changed_board = copy.deepcopy(board)
max_block = []

#게임판을 회전시키기
def rotate(changed_board):
    global N
    #가로 세로 뒤집기
    for i in range(N//2):
        for j in range(N):
            temp = changed_board[i][j]
            changed_board[i][j] = changed_board[N-i-1][j]
            changed_board[N-i-1][j] = temp
    #대각선 뒤집기
    for i in range(N):
        for j in range(i, N):
            temp = changed_board[i][j]
            changed_board[i][j] = changed_board[j][i]
            changed_board[j][i] = temp

    return changed_board
    

#좌하우상 이동하기
def move_left(changed_board, dir):
    global N
    #오른쪽으로 90도씩 회전
    for _ in range(dir):
        changed_board = rotate(changed_board)
    #왼쪽으로 수 이동
    changed_board = tilt(changed_board)
    #360도까지 회전시켜서 원래 형태로 만들기
    for _ in range(4-dir):
        changed_board = rotate(changed_board)
    
    return changed_board

#전체 이동하기
def tilt(changed_board):
    global N
    #행 한줄씩 왼쪽으로 밀기
    for i in range(N):
        changed_board[i] = tiltRow(changed_board[i])
    return changed_board

#한 행 왼쪽 이동하기
def tiltRow(row):
    n = len(row)
    done = [0]*n
    idx = 0
    for i in range(n):
        if (row[i] == 0):
            continue
        if (done[idx]==0):
            done[idx] = row[i]
        elif (done[idx] == row[i]):
            done[idx] += row[i]
            idx+=1
        else:
            idx+=1
            done[idx]=row[i]
    return done
    
#5번 왼쪽으로 미는 모든 상황 찾기
def dfs(changed_board, n):
    global N, board, max_block, visited, flag
    if (n == 5):
        max_block.append(max(map(max, changed_board)))
        return
    for i in range(4):
        now_board = copy.deepcopy(move_left(copy.deepcopy(changed_board), i))
        dfs(now_board, n+1)

dfs(changed_board, 0)
print(max(max_block))