import sys

input = sys.stdin.readline
sys.setrecursionlimit(100000)

M, N, K = map(int, input().split())
area = [[0] * N for _ in range(M)]

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())

    for x in range(x1, x2):
        for y in range(y1, y2):
            area[y][x] = 1

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]




currCount = 0
countArr = []

def dfs(x, y):
    if 0 <= x < N and 0 <= y < M:
        global currCount
        if area[y][x] == 0:
            area[y][x] = 1  # 현재 노드 방문 처리
            currCount += 1
            for i in range(4):
                next_y = y + dy[i]
                next_x = x + dx[i]

                dfs(next_x, next_y)


for i in range(M):
    for j in range(N):
        if area[i][j] == 0:
            dfs(j, i)

            countArr.append(currCount)
            currCount = 0

countArr.sort()

answer = ""
for i in countArr:
    answer += str(i)
    answer += " "

print(len(countArr))
print(answer)