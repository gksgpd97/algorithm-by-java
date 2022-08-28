import sys
K, L = map(int, input().split())

dic = {}
rank = 1
for _ in range(L):
    s = sys.stdin.readline().rstrip()
    if (s in dic):
        del dic[s]
    dic[s] = rank
    rank += 1

for i, (k, v) in enumerate(dic.items()):
    if (i == K):
        break
    print(k)