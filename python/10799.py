str = list(input())
stack = []
answer = 0
laser_flag = 0
for idx, s in enumerate(str):
    if (len(stack)==0):
        stack.append(s)
    else:
        if (s == ')'):
            top = stack.pop()
            if (str[idx-1]=='('):
                #레이저일 때
                answer += len(stack)    
            else:
                #쇠막대의 오른쪽 끝일 때
                answer += 1
        elif (s == '('):
            stack.append(s)

print(answer)