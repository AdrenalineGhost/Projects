import json

with open("input.txt","r") as file:
    names = file.readlines()

with open("jh.json","r") as file:
    data1 = json.load(file)

with open("jh2.json","r") as file:
    data2 = json.load(file)

messages = data1.get("messages")
messages2 = data2.get("messages")
mn1 = []
mn2 = []


for item in messages2:
    mn2.append(item.get("author").get("name").strip())

for item in messages:
    mn1.append(item.get("author").get("name").strip())

for name in names:
    try:
        name = name.split("#")[0]
        if name.strip() in mn1 or name.strip() in mn2:
            print(f"Name: {name.ljust(30)} found")
        else:
            print(f"Name: {name.ljust(30)} not found")
    except:
        print("ERROR IN PARSING")
