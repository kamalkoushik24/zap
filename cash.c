#include <stdio.h>
#include <math.h>    //including all the required libraries
#include <cs50.h>


int main(void)
{
 float usd;
 do
 {
    usd = get_float ("Please enter the cash in usd:");  // prompting the user for change input
 }
 while(usd <= 0);

  int cents = usd*100;
  int coins = 0;
  int quart = 0;      // initializing all the variables
  int dimes = 0;
  int nicke = 0;
  int penny = 0;

  while (cents >= 25)
  {
     cents -= 25;   // calculating no.of quarters and adding to coins
     coins++ ;
     quart++ ;
  }

  while (cents >= 10)
  {
     cents -= 10;   //calculating no.of dimes and adding to coins
     coins++ ;
     dimes++ ;
  }

  while (cents >= 5)
  {
     cents -= 5;    //calculating no.of nickels and adding to coins
     coins++ ;
     nicke++ ;
  }

  while (cents >= 1)
  {
     cents -= 1;   //calculating no.of pennies and adding to coins
     coins++ ;
     penny++ ;
  }
  printf("You should be giving atleast %i coins\n", coins);
  printf("No.of quarters:%i\n", quart);
  printf("No.of dimes:%i\n", dimes);
  printf("No.of nickels:%i\n", nicke);
  printf("No.of pennies:%i\n", penny);

}
