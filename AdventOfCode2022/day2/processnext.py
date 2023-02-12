from pyxtension.streams import stream

with open("input.txt","r") as file:
	lines = file.readlines()

needed = {
	"X":2,
	"Y":1,
	"Z":0
	}

pointsGiven = {
	"A":[6+2,3+1,0+3],
	"B":[6+3,3+2,0+1],
	"C":[6+1,3+3,0+2]
	}

points = 0

for line in lines:
	points = points + pointsGiven.get(line[0])[needed.get(line[2])]
print(points)
