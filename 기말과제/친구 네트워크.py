import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

def find(name):
    if name == root[name]:
        return name
    else:                               # 경로 압축 (시간 복잡도 -> O(logN))
        root[name] = find(root[name])   # find 하면서 만난 모든 값의 부모 노드를 root로 만듦
        return root[name]               

def union(name1, name2):
    root1 = find(name1)
    root2 = find(name2)

    if root1 != root2:                              # name1과 name2의 root가 다를 경우 -> 서로 트리가 다름
        root[root2] = root1                         # 서로 다른 두 개의 트리를 합침 
        network_num[root1] += network_num[root2]    # network 수를 합침


T = int(input())        # T - testcase 수
for _ in range(T):
    F = int(input())    # F - 친구 관계의 수
    root = {}
    network_num = {}

    for _ in range(F):
        name1, name2 = input().rstrip().split()

        if name1 not in root:
            root[name1] = name1
            network_num[name1] = 1
        
        if name2 not in root:
            root[name2] = name2
            network_num[name2] = 1

        union(name1, name2)

        print(network_num[find(name1)])