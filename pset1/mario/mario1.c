#include <stdio.h>
#include <cs50.h>
int main(void)
{
    int n, r, c;
    do
    {
        n = get_int("Please enter the height of the pyramid (from 1 to 8):");
    }
    while (n < 1 || n > 8); //prompting the user to give a number from 1 to 8

    for (r = 0; r < n; r++) //initializing the row of hashes
    {
        for (int b = 0; b < n - r - 1; b++)
        {
            printf(" "); //printing the spaces for the right aligned pyramid
        }
        for (c = 0; c <= r; c++)
        {
            printf("#"); //print the hashes for the pyramid
        }
        printf("\n"); //coming to the next row
    }
}
