def binary_search(arr, target):
    left, right = 0, len(arr)-1

    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return 1  # 존재함
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return 0  # 존재하지 않음

N = int(input())
original_list = list(map(int, input().split()))
M = int(input())
check_list = list(map(int, input().split()))

# 정렬
original_list.sort()

# 각 숫자에 대해 이진 탐색 수행
for target in check_list:
    result = binary_search(original_list, target)
    print(result)
