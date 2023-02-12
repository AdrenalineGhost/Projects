import os
from pyxtension.streams import stream

counter = 1
maxint = []
array = {}
with open("F:\git\Projects\AdventOfCode2022\day1\input.txt","r") as file:
	lines = file.readlines()
for line in lines:
	if line == "\n":
		counter +=1
		print(f'Line {line} was equal to \\n\n')
	else:
		if array.get(counter):
			array[counter] += int(line)
		else:
			print("failed\n")
			array[counter] = int(line)
		# Part 2 =================================================================
		# if array[counter] > array[max]:
		# 	print(f'{array[counter]} was bigger then {array[max]}\n')
		# 	max = counter
maxint = sorted(array.values(),reverse=True)
while maxint.__len__() > 3:
	maxint.pop()
for item in maxint:
	print(item)
print("\nfor a total of: " + str(stream(maxint).reduce(lambda x, y: x+y)))


