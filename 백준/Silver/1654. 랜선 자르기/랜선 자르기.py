def count_lans(lans ,length):
    return sum(lan // length for lan in lans)

def binary_search(lans, N):
    left, right = 1, max(lans)
    result = 0

    while left <= right:
        mid = (left + right) // 2
        if count_lans(lans, mid) >= N:
            result = mid
            left = mid + 1
        else:
            right = mid - 1
    return result


K, N = map(int, input().split())
lans = [int(input()) for _ in range(K)]

print(binary_search(lans, N))
