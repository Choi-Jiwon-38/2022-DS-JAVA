import sys
input = sys.stdin.readline

n = int(input())
parents = [map(int, input().split())]
d = int(input())
parents[d] = -2

def find(u):
    if parents[u] == -1:    # root인 경우
            return False    # 지우려는 subtree의 자식이 아님
    elif parents[u] == -2:
        return True
    else:
        return find(parents[u])        


for u in range(n):
    if find(u):             # True의 경우 1 반환, 아닌 경우 0 반환
        parents[u] = -2     # 지워지는 노드의 subtree를 전부 2로 변경해주는 기능 수행


internals = set(parents)

cnt = 0
for u in range(n):
    if parents[u] != 2 and u not in internals:
        cnt += 1