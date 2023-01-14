#include <stdio.h>

const int DIM = 10;

void lees_matrix(int matrix[][DIM],int aantal_rij, int aantal_kol);

void print_matrix(int matrix[][DIM],int aantal_rij, int aantal_kol);
// \/\/\/ these are still wrong \/\/\/
void transponeer(int matrix[][DIM],int dim);

void vermenigvuldig_matrix(int product[][DIM], int matrix1[][DIM], int matrix2[][DIM], int dim);

int main(int argc, char **argv)
{

	int matrix[DIM][DIM];
	int matrix2[DIM][DIM];
	int product[DIM][DIM];
	lees_matrix(matrix,2,2);
	printf("lees tweede matrix\n");
	lees_matrix(matrix2,2,2);

	printf("matrix 1\n");
	print_matrix(matrix,2,2);
	printf("matrix 1 getransponeerd\n");
	transponeer(matrix,2);
	print_matrix(matrix,2,2);
	printf("matrix 2 \n");
	print_matrix(matrix2,2,2);
	printf("produkt \n");
	vermenigvuldig_matrix(product,matrix,matrix2,2);
	print_matrix(product,2,2);

	return 0;

}


void lees_matrix(int matrix[ ][DIM], int aant_rij, int aant_kol) {
     for (int i=0; i<aant_rij; i++) {
          for (int j=0 ; j<aant_kol ; j++) {
               printf("matrix[%d,%d] = ", i, j);
               scanf ("%d" , &matrix[i][j] );
          }
     }
}


void print_matrix(int matrix[][DIM],int aantal_rij, int aantal_kol){
	for (int i = 0; i < aantal_rij; i++){
		for(int j = 0; j < aantal_kol; j++)
		{
			printf("%d\t\t",matrix[i][j]);
		}
		printf("\n");
	}
	printf("\n\n");
}

void transponeer(int matrix[][DIM],int dim)
{

	int newmatrix[dim][dim] ;
	int *p = matrix[dim*dim];

	for (int i = 0; i < dim; i++)
	{
		for (int j = 0; j < dim; j++){
			newmatrix[i][j] = *p;
			p--;
		}
	}

	for (int i = 0; i < dim; i++){
		for(int j = 0; j < dim; j++){
			matrix[i][j] = newmatrix[i][j];
		}
	}

}

void vermenigvuldig_matrix(int product[][DIM], int matrix1[][DIM], int matrix2[][DIM],int dim) {
     for (int i=0 ; i<dim ; i++) {
          for (int j=0 ; j<dim ; j++) {
               int som = 0;
               for (int k=0 ; k<dim ; k++) {
                    som = som + matrix1[i][k] * matrix2[k][j];
               }
               product[i][j] = som;
          }
     }
}















