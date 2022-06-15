from sys import stdin
left = list(stdin.readline().strip()) #strip 안하면 개행남음
M = int(input())
right = []
for _ in range(M):
    command = stdin.readline()
    if command[0] == 'P':
        left.append(command[2])
    elif command[0] == 'L': 
        if left:
            right.append(left.pop())
    elif command[0] == 'D': 
        if right:
            left.append(right.pop())
    else:
        if left:
            left.pop()
            
print(''.join(left + right[::-1]))