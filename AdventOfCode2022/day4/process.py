ranges = [0,0]
count = 0

with open("input.txt","r") as file:
    lines = file.readlines()

for line in lines:
    line = line.split(",")
    ranges[0] = range(int((line[0].split("-"))[0]) , (int((line[0].split("-"))[1].strip())+1))
    ranges[1] = range(int((line[1].split("-"))[0]) , (int((line[1].split("-"))[1].strip())+1))

    check = [True , True]
    for rang in (0,1):
        for index in ranges[rang]:
            if index not in ranges[0 if rang else 1]:
                check[rang] = False
    print(line)
    print(f"--> {ranges[0]}\t{ranges[1]}") 
    print(f"--> {check[0]}\t\t{check[1]}")
    if check[0] is True or check[1] is True:
        count += 1
        print("true\n")
    else:
        print("false\n")

print(count)
