
counter = 1
max = 1
array = {}
with open("input.txt","r") as file:
	lines = file.readlines()
for line in lines:
	if line == "\n":
		counter +=1
		print(f'Line {line} was equal to \\n\n')
	else:
		if array[counter]:
			array[counter] += int(line)
		else:
			array[counter] = int(line)
		if array[counter] > array[max]:
			print(f'{array[counter]} was bigger then {array[max]}\n')
			max = counter
print(str(max)+ " " + str(array[max]))

