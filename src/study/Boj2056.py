import copy
import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
graph = [[] for _ in range(N+1)]
indegree = [0] * (N + 1)
time = [0] * (N + 1)

for i in range(1, N + 1):
    data = list(map(int, input().split()))
    time[i] = data[0]
    indegree[i] = data[1]
    for j in data[2:]:
        graph[j].append(i)


def topology_sort():
    result = copy.deepcopy(time)
    q = deque()
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)
    while q:
        now = q.popleft()
        for i in graph[now]:
            result[i] = max(result[i], result[now] + time[i])
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
    return max(result)
print(topology_sort())