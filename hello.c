#include <stdio.h>
#include <cs50.h>

/* Starting the Main part of the Function*/
int main(void)
{
    string name = get_string("What is your name?\n") ;
    printf("Hello ,%s\n", name);
}