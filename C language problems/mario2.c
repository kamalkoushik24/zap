#include <stdio.h>
#include <cs50.h>
int main(void) {
int n,r,c;
do {
  n = get_int("Please enter the height of the pyramid (from 1 to 8):");
   }
while(n<1 || n>8);

//Prompting the user for 


 for (r = 0;r < n; r++) //This is for initializing the row of hashes
 {
   for (int b = 0; b < n-r-1; b++)
   {
     printf(" "); //Printing the spaces for the right aligned pyramid
   }
   for (c = 0; c <= r; c++)
   {
     printf("#"); //Printing the first set of Hashes
   }
    printf("  "); //For every row the spaces are equal 2, Printing those
   for (c = 0; c <=r; c++)
   {
     printf("#"); //Printing the Second set of Hashes
   }
  printf("\n"); //Printing a new line for the new row
 }
 }
