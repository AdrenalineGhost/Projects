ranges = [range(1), range(1)]
count = 0

with open("input.txt","r") as file:
    lines = file.readlines()

for line in lines:
    line = line.split(",")
    ranges[0] = range(int((line[0].split("-"))[0]) , (int((line[0].split("-"))[1])+1))
    ranges[1] = range(int((line[1].split("-"))[0]) , (int((line[1].split("-"))[1])+1))

    for rang in range(1):
        check = [True , True]
        for index in ranges[rang]:
            if index not in ranges[~(rang)]:
                check[rang] = False
    print(line)
    if check[0] is True or check[1] is False:
        count += 1
        print("true\n")
    else:
        print("false\n")

print(count)
