#include <stdio.h>
#include <cs50.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

bool key_validity(string x); //prototyping the function of key validity

int main(int argc, string argv[]) //main function
{
    if (argc != 2 || !key_validity(argv[1])) //if arguments not equal to 2 then exit the program or if the given key doesn't satisfy
    {
        printf("Usage: ./caeser key\n");
        return 1;
    }
    int key = atoi(argv[1]); //changing acscii to integers
    string s = get_string("plaintext:  ");
    int len = strlen(s);
    printf("ciphertext: ");

    for (int i = 0; i < len; i++) //loop for extracting letters
    {

        if (s[i] >= 'a' && s[i] <= 'z')
        {
            printf("%c", (((s[i] - 'a') + key) % 26) + 'a'); // print out lowercase with key
        } // if it it between uppercase A and C
        else if (s[i] >= 'A' && s[i] <= 'Z')
        {
            printf("%c", (((s[i] - 'A') + key) % 26) + 'A'); // print out uppercase with key
        }
        else
        {
            printf("%c", s[i]); //if it is a special character, then we print it as it is
        }
    }

    printf("\n"); //printing a new line after ciphering the text
}




bool key_validity(string x)
{
    int l = strlen(x);
    for (int i = 0; i < l; i++)

        if (!isdigit(x[i]))
        {
            return false;
        }
    return true;

}
