import sys
import heapq
input = sys.stdin.readline

N = int(input()) # 도시의 개수 == 노드의 개수
M = int(input()) # 버스의 개수 == 간선의 개수

city = [[] for _ in range(N + 1)] # 각 도시에 연결되어 있는 도시의 정보가 담김 (도착 도시, 비용)

for i in range(M):
    start_city, end_city, cost = map(int, input().split())
    city[start_city].append((end_city, cost))

distance = [1000000000] * (N + 1) # <- 질문할 거 왜 100001은 안되는데 10억은 되는거지..???

def dijkstra(start):
    hq = []
    heapq.heappush(hq, (0, start)) # 출발지 <-> 출발지의 비용은 0
    while hq:
        cost, nowCity = heapq.heappop(hq)

        if distance[nowCity] >= cost:
            for i in city[nowCity]: # i[0] <- end_city / i[1] <- cost
                new_cost = cost + i[1]
                if new_cost < distance[i[0]]:
                    distance[i[0]] = new_cost
                    heapq.heappush(hq, (new_cost, i[0]))

start, end = map(int, input().split())

distance[start] = 0

dijkstra(start)

print(distance[end])