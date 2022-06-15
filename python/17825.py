global dice, score, next, answer, horse, visited
dice = [0]
input = list(map(int, input().rstrip().split(" ")))
dice = dice + input + [0,0,0,0]
score = [0 for _ in range(37)]
next = [[0,0,0,0,0,0] for _ in range(37)]

score[1] = 2; score[2] = 4; score[3] = 6; score[4] = 8; score[5] = 10;
score[6] = 12; score[7] = 14; score[8] = 16; score[9] = 18; score[10] = 20;
score[11] = 22; score[12] = 24; score[13] = 26; score[14] = 28; score[15] = 30;
score[16] = 32; score[17] = 34; score[18] = 36; score[19] = 38; score[20] = 13;
score[21] = 16; score[22] = 19; score[23] = 25; score[24] = 26; score[25] = 27;
score[26] = 28;	score[27] = 24; score[28] = 22; score[29] = 30; score[30] = 35;
score[31] = 40;

next[0][1] = 1; next[0][2] = 2; next[0][3] = 3; next[0][4] = 4; next[0][5] = 5;

next[1][1] = 2; next[1][2] = 3; next[1][3] = 4; next[1][4] = 5; next[1][5] = 6;
next[2][1] = 3; next[2][2] = 4; next[2][3] = 5; next[2][4] = 6; next[2][5] = 7;
next[3][1] = 4; next[3][2] = 5; next[3][3] = 6; next[3][4] = 7; next[3][5] = 8;
next[4][1] = 5; next[4][2] = 6; next[4][3] = 7; next[4][4] = 8; next[4][5] = 9;
next[5][1] = 20; next[5][2] = 21; next[5][3] = 22; next[5][4] = 23; next[5][5] = 29;
next[6][1] = 7; next[6][2] = 8; next[6][3] = 9; next[6][4] = 10; next[6][5] = 11;
next[7][1] = 8; next[7][2] = 9; next[7][3] = 10; next[7][4] = 11; next[7][5] = 12;
next[8][1] = 9; next[8][2] = 10; next[8][3] = 11; next[8][4] = 12; next[8][5] = 13;
next[9][1] = 10; next[9][2] = 11; next[9][3] = 12; next[9][4] = 13; next[9][5] = 14;
next[10][1] = 28; next[10][2] = 27; next[10][3] = 23; next[10][4] = 29; next[10][5] = 30;

next[11][1] = 12; next[11][2] = 13; next[11][3] = 14; next[11][4] = 15; next[11][5] = 16;
next[12][1] = 13; next[12][2] = 14; next[12][3] = 15; next[12][4] = 16; next[12][5] = 17;
next[13][1] = 14; next[13][2] = 15; next[13][3] = 16; next[13][4] = 17; next[13][5] = 18;
next[14][1] = 15; next[14][2] = 16; next[14][3] = 17; next[14][4] = 18; next[14][5] = 19;
next[15][1] = 26; next[15][2] = 25; next[15][3] = 24; next[15][4] = 23; next[15][5] = 29;
next[16][1] = 17; next[16][2] = 18; next[16][3] = 19; next[16][4] = 31; next[16][5] = 32;
next[17][1] = 18; next[17][2] = 19; next[17][3] = 31; next[17][4] = 32; next[17][5] = 32;
next[18][1] = 19; next[18][2] = 31; next[18][3] = 32; next[18][4] = 32; next[18][5] = 32;
next[19][1] = 31; next[19][2] = 32; next[19][3] = 32; next[19][4] = 32; next[19][5] = 32;
next[20][1] = 21; next[20][2] = 22; next[20][3] = 23; next[20][4] = 29; next[20][5] = 30;

next[21][1] = 22; next[21][2] = 23; next[21][3] = 29; next[21][4] = 30; next[21][5] = 31;
next[22][1] = 23; next[22][2] = 29; next[22][3] = 30; next[22][4] = 31; next[22][5] = 32;
next[23][1] = 29; next[23][2] = 30; next[23][3] = 31; next[23][4] = 32; next[23][5] = 32;
next[24][1] = 23; next[24][2] = 29; next[24][3] = 30; next[24][4] = 31; next[24][5] = 32;
next[25][1] = 24; next[25][2] = 23; next[25][3] = 29; next[25][4] = 30; next[25][5] = 31;
next[26][1] = 25; next[26][2] = 24; next[26][3] = 23; next[26][4] = 29; next[26][5] = 30;
next[27][1] = 23; next[27][2] = 29; next[27][3] = 30; next[27][4] = 31; next[27][5] = 32;
next[28][1] = 27; next[28][2] = 23; next[28][3] = 29; next[28][4] = 30; next[28][5] = 31;
next[29][1] = 30; next[29][2] = 31; next[29][3] = 32; next[29][4] = 32; next[29][5] = 32;
next[30][1] = 31; next[30][2] = 32; next[30][3] = 32; next[30][4] = 32; next[30][5] = 32;

next[31][1] = 32; next[31][2] = 32; next[31][3] = 32; next[31][4] = 32; next[31][5] = 32;

answer = 0
horse = [0, 0, 0, 0, 0] #말의 위치
visited = [0 for _ in range(37)]

def DFS(level, nscore):
    global dice, score, next, answer, horse, visited
    if (level > 10):
        if (answer < nscore):
            answer = nscore
        return

    for i in range(1, 5):
        cur = horse[i]
        nextPos = next[cur][dice[level]] #i번 말의 다음위치
        if (cur == 32): #지금 말의 위치가 이미 도착이라면 다음 말로
            continue
        if (nextPos != 32 and visited[nextPos]): #도착지점(32)가 아닌 다음위치에 다른 말이 놓여져있다면 다음말로
            continue
        horse[i] = nextPos #말을 다음위치로 옮김
        visited[cur] = 0  #말의 원래위치였던 곳은 이제 말이 없음을 표시함

        DFS(level+1, nscore+score[horse[i]])

        horse[i] = cur
        visited[cur] = 1
        visited[nextPos] = 0

DFS(1, 0)
print(answer)