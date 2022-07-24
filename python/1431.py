N = int(input())
strs = [input() for _ in range(N)]
after = []
for str in strs:
    sum_n = 0
    for s in str:
        if (s>='0' and s<='9'):
            sum_n += int(s)
    after.append((len(str), sum_n, str))

after.sort(key = lambda x:(x[0], x[1], x[2]))
for t in after:
    print(t[2])