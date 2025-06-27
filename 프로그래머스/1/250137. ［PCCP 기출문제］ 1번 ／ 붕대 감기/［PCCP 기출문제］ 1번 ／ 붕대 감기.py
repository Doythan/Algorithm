def solution(bandage, health, attacks):
    t, x, y = bandage
    hp = health
    prev_attack_time = 0 

    for attack_time, damage in attacks:
        interval = attack_time - prev_attack_time - 1

        if interval > 0:
            # 1초씩 회복
            full_cycles = interval // t
            remainder = interval % t

            hp += full_cycles * (t * x + y)
            hp += remainder * x

            if hp > health:
                hp = health
        
        hp -= damage
        if hp <= 0:
            return -1
        
        prev_attack_time = attack_time 

    return hp