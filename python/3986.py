N = int(input())
answer = 0
for _ in range(N):
    str = list(input().rstrip())
    stack = []
    idx = 0
    while (idx != len(str)):
        if (len(stack) == 0):
            stack.append(str[idx])
            idx+=1
        else:
            top = stack.pop()
            if (str[idx]==top):
                idx+=1
            else:
                stack.append(top)
                stack.append(str[idx])
                idx+=1
        #print("stack:",stack)
    if (len(stack)==0):
        answer+=1
        #print(str,"add")
print(answer)