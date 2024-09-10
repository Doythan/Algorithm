# 델타 탐색을 할 때는 무조건 dxy 를 만들고 시작하자.
# dx = [1, 0, 0]
# dy = [0, -1, 1]
dxy = [[1, 0], [0, -1], [0, 1]]

def search_leader(x, y):
    # 1. import copy, copy.deepcopy() => 코스트가 꽤 큼 , 가급적 사용X
    # 원본을 훼손하지 않고, 방문체크를 할 수 있는 변수
    visited = [[0] * BLOCK_SIZE for _ in range(BLOCK_SIZE)]

    visited[x][y] = 1  # 시작지점을 방문체크 함

    # x 좌표는 행, y 좌표는 열
    # 마지막 행(99)에 도착할 때까지 델타 탐색을 진행한다.
    while x != BLOCK_SIZE - 1:
        # 3방향으 탐색해야한다.
        # x는 현재좌표, nx 는 현재 델타만큼 이동한 후의 좌표  (y도 동일)
        # for i in range(3):  # [0, 1, 2]
        #     nx = x + dx[i]
        #     ny = y + dy[i]
        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            # if nx >= 0 and nx < BLOCK_SIZE and ny >= 0 and ny < BLOCK_SIZE:
            #     # 범위 안에 있는 경우에만 통과
            #     print("123")

            # 이동하려는 좌표가 범위를 벗어난 경우
            if nx < 0 or nx >= BLOCK_SIZE or ny < 0 or ny >= BLOCK_SIZE: continue

            # 사다리가 아닌 경우
            if not data[nx][ny]: continue

            # 이미 방문한 경우
            if visited[nx][ny]: continue

            # 이 지점에 도착한 친구들은
            # 1. 범위를 만족하고, 사다리이고, 방문하지 않았다.

            # 현재 좌표를 방문한 것으로 처리한다.
            visited[x][y] = 1

            # 현재 좌표를 이동하려고 한 좌표로 바꾼다.
            x, y = nx, ny

    # 제대로 도착했을 경우
    if data[x][y] == 2:
        return True

    # 제대로 도착하지 못했을 경우
    return False


for _ in range(1, 11):
    # 첫 번째 줄에 테스트케이스 몇 번인지를 알려준다.
    tc = int(input())
    BLOCK_SIZE = 100
    # 100 * 100 2차원 리스트 입력 받는다.
    # int => 형변환 함수다.
    # map => 첫 번쩌 파라미터에 있는 함수를 , 2번째 파라미터에 있는 리스트의 각각의 요소에 함수를 적용한다.
    data = [list(map(int, input().split())) for _ in range(BLOCK_SIZE)]
    # ['1', '0', '0', ... ]

    # 모든 시작점에서 출발해본다.
    # 그리고 도착지점(2)에 제대로 도착했다면, 그 시작점을 반환하면 된다.
    # 100 * 100 이니까 시작점은 0 ~ 100 까지 모두 다 해봐야겠죠
    result = -1
    for j in range(BLOCK_SIZE):
        # 밑에는 길을 찾아가는 로직을 작성할겁니다.
        # 사다리는 1이다. 0은 갈 수 없는 곳이다.
        """
        early return 
        조건을 걸고 바로 리턴 시키는 겁니다. 
        """
        if data[0][j] == 0:
            continue
        # 여기에 도달한 친구들은 첫 번째 줄에서의 사다리이다.
        # 0, j에서 시작했을 때, 목적지에 도달하는 지 확인하는 함수
        # 이 함수는 True / False 를 반환을 합니다.
        if search_leader(0, j):
            # 제대로 도달한 친구는 아래 if 문 코드를 돌린다.
            # 제대로 도달했을 때의 시작점은 j 이기 때문에, 최종 결과에 저장한다.
            result = j
            break  # if문을 탈출하는 게 아니고, 제일 가깝게 있는 for/while 문을 탈출하는 거다.

    print(f"#{tc} {result}")