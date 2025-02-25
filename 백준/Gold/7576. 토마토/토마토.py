from collections import deque

M, N = map(int, input().split())  # 가로 칸 수, 세로 칸 수 입력 
matrix = [list(map(int, input().split())) for _ in range(N)]  # 2차원 리스트 입력

queue = deque()

# 방향벡터 _ 상, 하, 좌, 우 이동
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 익은 토마토 queue에 넣기 
for i in range(N):
    for j in range(M):
        if matrix[i][j] == 1:
            queue.append((i, j))

# BFS 실행
def bfs():
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위 체크 & 익지 않은 토마토라면 익히기
            if 0 <= nx < N and 0 <= ny < M and matrix[nx][ny] == 0:
                matrix[nx][ny] = matrix[x][y] + 1  # 날짜 증가
                queue.append((nx, ny))

bfs()

# 모든 토마토가 익는 데 걸리는 날짜 찾기
result = 0
for row in matrix:
    if 0 in row:
        print(-1)
        exit()
    result = max(result, max(row))

print(result - 1)