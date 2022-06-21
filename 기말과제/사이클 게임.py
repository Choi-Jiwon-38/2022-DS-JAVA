import sys
sys.setrecursionlimit(10000000)
input = sys.stdin.readline

n, m = map(int, input().split())

root = [0] * 500000

for i in range(n):
    root[i] = i

def find(num):
    if num == root[num]:
        return num
    else:
        root[num] = find(root[num])
        return root[num]

def union(num1, num2):
    root1 = find(num1)
    root2 = find(num2)

    if root1 != root2:
        root[root2] = root1
    else: # root1 == root2
        return 'cycle'

answer = 0

for i in range(m):
    num1, num2 = map(int, input().split())

    if union(num1, num2) == 'cycle':
        answer = i + 1
        break

print(answer)