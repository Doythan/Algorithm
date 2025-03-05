N = int(input()) # 계단의 개수 입력
stairs = [int(input()) for _ in range(N)]  # 계단 점수 입력

# DP 테이블 생성(최대 N개까지 필요)
dp = [0] * N

# 예외 처리 (계단이 1개 또는 2개일 경우)
if N == 1:
    print(stairs[0])
    exit()
elif N == 2:
    print(stairs[0] + stairs[1])
    exit()

# 초기 DP 값 설정
dp[0] = stairs[0]
dp[1] = stairs[0] + stairs[1]
dp[2] = max(stairs[0] + stairs[2], stairs[1] + stairs[2])

# DP 점화식 적용(Bottom-Up 방식)
for i in range(3, N):
    dp[i] = max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i])

print(dp[N-1])