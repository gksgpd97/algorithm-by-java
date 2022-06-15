N = int(input())
L = list(map(int, input().rstrip().split(" ")))
L.reverse()

stack = []
answer = [0 for _ in range(N+1)]

for idx, l in enumerate(L):
    if (len(stack)==0):
        stack.append([idx, l])
        s_min = l
    else:
        while (len(stack) != 0):
            pidx, pl = stack.pop()
            if (l < pl):
                stack.append([pidx, pl])
                break
            else:
                answer[N-pidx] = N-idx
        stack.append([idx, l])

print(" ".join(map(str, answer[1:])))
                
                
                