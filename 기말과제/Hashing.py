# https://www.acmicpc.net/problem/15829
import sys
input = sys.stdin.readline

answer = 0
L = int(input())
string = input()

for i in range(L):
    answer += ((ord(string[i]) - 96) * (31 ** i))
answer %= 1234567891

print(answer)