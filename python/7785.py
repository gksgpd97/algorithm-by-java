n = int(input())

dic = {}

for _ in range(n):
    name, log = input().rstrip().split()
    if (name not in dic):
        dic[name] = log
    else:
        del dic[name]

dic = sorted(dic.items(), reverse = True)
for k, v in dic:
    print(k)