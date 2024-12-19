def get_input(filename: str, dimen: int = 1) -> list[str]:
    input_list = []
    with open(filename) as fp:
        for line in fp:
            if dimen == 1:
                input_list.append(line.strip())
            else:
                input_list.append([char for char in line.strip()])
    return input_list

def print_input(input_list: list[str]) -> None:
    for string in input_list: print(string)
