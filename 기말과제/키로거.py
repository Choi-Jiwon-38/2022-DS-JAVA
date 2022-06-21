import sys
from collections import deque

input = sys.stdin.readline

testcase = int(input())                     # 테스트 케이스 개수  

for _ in range(testcase):
    
    cursor_left = deque()
    cursor_right = deque()
    
    keyloger = input().rstrip()             # 강산이가 입력한 문자열
    
    for key in keyloger:
        if key == '<':
            if len(cursor_left) > 0:
                tmp = cursor_left.pop()
                cursor_right.append(tmp)
        elif key == '>':
            if len(cursor_right) > 0:
                tmp = cursor_right.pop()
                cursor_left.append(tmp)
        elif key == '-':
            if len(cursor_left) > 0:
                cursor_left.pop()
        else:
            cursor_left.append(key)

    print(''.join(cursor_left) + ''.join(reversed(cursor_right)))