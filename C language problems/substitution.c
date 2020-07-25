#include <stdio.h>
#include <ctype.h>
#include <cs50.h>
#include <string.h>
#include <stdlib.h>

bool key_validity(string key);

int main(int argc, string argv[])
{
	if (argc != 2)
	{
		printf("Usage: ./substitution key\n");
	}
    
    string s = get_string("plaintext:  ")
	string key = argv[1];
	string alpha = abcdefghijklmnopqrstuvwxyz;


	
}

bool key_validity(string key)
