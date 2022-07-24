
N = int(input())

dic = {}

for _ in range(N):
    n = int(input())
    if (n not in dic):
        dic[n] = 1
    else:
        dic[n] += 1
        
dic = sorted(dic.items(), key=lambda x:(-x[1], x[0]))
print(dic[0][0])