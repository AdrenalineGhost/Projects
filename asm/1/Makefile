all: object exe 
object:
	nasm write.asm -o main.o -f win
exe: 
	gcc main.o -o main  
# run:
# 	./main &> a.txt
# fail:
# 	@echo $? &> b.txt
