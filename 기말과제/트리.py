import sys
input = sys.stdin.readline

N = int(input())
parent = list(map(int, input().split()))
rm_node = int(input())

def remove_node(rm): #dfs
    parent[rm] = 20213091
    for i in range(N):
        if parent[i] == rm:
            remove_node(i)

remove_node(rm_node)

leaf = 0
for node in range(N):
    if node not in parent and parent[node] != 20213091:
        leaf += 1

print(leaf)