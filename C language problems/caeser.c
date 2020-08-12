#include <stdio.h>
#include <cs50.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

bool key_validity(string x);

int main(int argc, string argv[])
{
  if (argc != 2 || key_validity(argv[1]))
  {
     printf("Usage: ./caeser key\n");
     return 1;
  }
  int key = atoi(argv[1]);
  string plaintext = get_string("plaintext: ");
  int len = strlen(plaintext);

  for (int i = 0; i < len; i++)
  {
    char c = plaintext[i];
    if (isalpha(c))
    {
      char n = 'A';
      if (islower(c))
         n = 'a';
         printf("%c\n", ((c - n - key) % 26) + n);
    }
    else
    {
      printf("%c", c);
    }
  }
  printf("\n");
}

bool key_validity(string x)
{
  int l = strlen(x);
  for (int i = 0; i < l; i++)
  {
   if (!isdigit(x[i]))
   {
     return false;
   }
   else
   {
     return true;
   }
  }
}
