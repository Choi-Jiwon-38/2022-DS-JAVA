import sys
from collections import deque
input = sys.stdin.readline

n, w, L = map(int, input().split())
truck = list(map(int, input().split()))

bridge = deque([0] * w)
time = 0

while len(truck) > 0:
    bridge.popleft()
    if sum(bridge) + truck[0] <= L:
        bridge.append(truck[0])
        del truck[0]
    else:
        bridge.append(0)
    time += 1
time += w

print(time)
