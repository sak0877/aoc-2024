# Sum of minimums
def part1(list1: list[int], list2: list[int]) -> int:
    distances = []
    while list1 != [] and list2 != []:
        l1_sm = min(list1)
        list1.remove(l1_sm)
        l2_sm = min(list2)
        list2.remove(l2_sm)
        if l1_sm > l2_sm:
            distances.append(l1_sm - l2_sm)
        else:
            distances.append(l2_sm - l1_sm)
    return sum(distances)

# Similarity score
def part2(list1: list[int], list2: list[int]) -> int:
    score = 0
    print(list1)
    for val in list1:
        score += val * list2.count(val)
    return score

def main() -> None:
    inp = open('1.in').readlines()
    values = [num.split() for num in inp]
    list1 = [int(lst[0]) for lst in values]
    l1_copy = list1.copy()
    list2 = [int(lst[1]) for lst in values]
    l2_copy = list2.copy()
    print(part1(list1, list2))
    print(part2(l1_copy, l2_copy))

main()
