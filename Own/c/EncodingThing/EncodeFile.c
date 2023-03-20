#include <stdio.h>
#include <string.h>
#include <stdlib.h>




int main(int argc, char *argv[]){
    char * read = malloc(20);
    char * seed = "123456";
    FILE *file;

    if (argc == 2){
        seed = argv[1];
    }

    file = fopen("file.txt", "r");
    system("cat file.txt");
    if (file == NULL){
        printf("Error");
        exit(1);
    }

    fscanf(file, "%s", read);
    printf("%s", *read);
    return 0;
}
