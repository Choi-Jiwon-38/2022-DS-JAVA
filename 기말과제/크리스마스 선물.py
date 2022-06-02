import heapq
import sys
input = sys.stdin.readline

present = []

n = int(input())

for _ in range(n):
    a = list(map(int, (input().split())))
    
    if a[0] == 0:
        if len(present) != 0:
            print(100000 - heapq.heappop(present))
        else:
            print(-1)
    else: # a[0] != 0:
        for i in range(a[0]):
            heapq.heappush(present, 100000 - a[i + 1])