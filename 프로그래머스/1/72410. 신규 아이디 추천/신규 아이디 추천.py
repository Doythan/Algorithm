def solution(new_id):
    # 소문자로 
    new_id = new_id.lower() 
    
    # 허용되지 않은 문자 제거
    allowed = 'abcdefghijklmnopqrstuvwxyz0123456789-_.'
    new_id_filtered = ''
    for c in new_id:
        if c in allowed:
            new_id_filtered += c
    new_id = new_id_filtered
    
    # 마침표 연속 제거
    new_id_compact = ''
    prev = ''
    for c in new_id:
        if c == '.' and prev =='.':
            continue
        new_id_compact += c
        prev = c
    new_id = new_id_compact

    # 처음, 끝 마침표 제거
    if new_id and new_id[0] == '.':
        new_id = new_id[1:]
    if new_id and new_id[-1] == '.':
        new_id = new_id[:-1]
    
    # 빈 문자열이면 'a'
    if new_id == '':
        new_id = 'a'

    # 15자 이상이면 자르고 끝 마침표 제거
    if len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id[-1] == '.':
            new_id = new_id[:-1]

    # 길이 2 이하일 경우, 마지막 문자 반복
    while len(new_id) < 3:
        new_id += new_id[-1]

    return new_id

