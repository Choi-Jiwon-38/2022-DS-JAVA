# https://www.acmicpc.net/problem/2605

import sys
input = sys.stdin.readline

line = []

numOfStudent = int(input())
numOfSwap = list(map(int, input().split()))

for i in range(numOfStudent):
    line.append(i + 1) # 학생이 줄을 선다
    move = numOfSwap[i]
    
    if move == 0: # 학생이 0번 번호를 받은 경우 -> 자리에 그대로
        pass
    else:
        num = i
        for j in range(move): # 학생이 move번 번호를 받으면 -> move번 앞 element와 swap
            line[i - 1], line[i] = line[i], line[i - 1]
            i -= 1

answer = ""

for l in line:
    answer += str(l) + " "

print(answer)