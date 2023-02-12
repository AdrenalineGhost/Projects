total = 0
list = list()

with open("F:\git\Projects\AdventOfCode2022\day3\input.txt","r") as file:
    lines = file.readlines()

for line in lines:
    length = int((line.__len__()-1)/2)
    try:
        A = line[:length]
        B = line[length:-1]
        for char in A:
            if char in B:
                list.append(char)
                break
    except:
        print(f'failed with line {line} with length {length}')

print(list)
for char in list:
    if char.islower():
        total += abs('a')-abs(char)+1
    elif char.isupper():
        total += abs('A')-abs(char)+1

print(total)

