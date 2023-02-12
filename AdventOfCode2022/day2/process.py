from pyxtension.streams import stream

with open("input.txt","r") as file:
	lines = file.readlines()

pointsper = {
	"X" : 1,
	"Y" : 2,
	"Z" : 3
	}

opp = {
	"A" : ["Z","X","Y"],
	"B" : ["X","Y","Z"],
	"C" : ["Y","Z","X"]
	}

points = 0;

stream(lines).filter(lambda x: x).map(lambda x: x.split(" ")).toList()

for line in lines:
	points = points + (opp.get(line[0]).index(line[2]) *3) + pointsper.get(line[2])

print(points)
