from collections import deque

s = input()

num = ''
nums = deque()
ops = deque()
for c in s:
    if (c >= '0' and c <= '9'):
       num += c
    else:
        nums.append(int(num))
        num = ''
        ops.append(c)
nums.append(int(num))

answer = nums.popleft()
tmp = 0
while (nums):
    op = ops.popleft()
    if (op == '+'):
        answer += nums.popleft()
    elif (op == '-'):
        while (True):
            tmp += nums.popleft()
            if (ops):
                tmpOp = ops[0]
                if (tmpOp == '+'):
                    ops.popleft()
                elif (tmpOp == '-'):
                    answer -= tmp
                    tmp = 0
                    break
            else:
                answer -= tmp
                break

print(answer)