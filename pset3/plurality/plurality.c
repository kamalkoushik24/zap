#include <cs50.h>
#include <stdio.h>
#include <string.h>
#define MAX 9               // Max number of candidates
typedef struct              // Candidates have name and vote count
{
    string name;
    int votes;
}
candidate;
candidate candidates[MAX];      // Array of candidates
int candidate_count;             // Number of candidates
bool vote(string name);          // Function prototypes
void print_winner(void);
int get_index(string name);
int main(int argc, string argv[])
{
    if (argc < 2)                   // Check for invalid usage
    {
        printf("Usage: plurality [candidate ...]\n");
        return 1;
    }
// Populate array of candidates
    candidate_count = argc - 1;     //Candidadte count = no of CLAs - 1
    if (candidate_count > MAX)
    {
        printf("Maximum number of candidates is %i\n", MAX);
        return 2;
    }
    for (int i = 0; i < candidate_count; i++)
    {
        candidates[i].name = argv[i + 1];
        candidates[i].votes = 0;
    }
    int voter_count = get_int("Number of voters: ");
    // Loop over all voters
    for (int i = 0; i < voter_count; i++)
    {
        string name = get_string("Voter %i: ", i + 1);
        // Check for invalid vote
        if (vote(name) == 0)
        {
            printf("Invalid vote.\n");
        }
    }
    // Display winner of election
    print_winner();
}
// Update vote totals given a new vote
int get_index(string name)
{
    for (int i = 0; i < candidate_count; i++)

        if (strcmp(candidates[i].name, name) == 0)
        {
            return i;
        }
    return -1;
}

bool vote(string name)
{
    int candidate_index = get_index(name);
    if (candidate_index != -1)
    {
        candidates[candidate_index].votes++;
        return true;
    }
    return false;

}

int get_max(void)
{
    int max_votes = candidates[0].votes;
    for (int i = 0; i < candidate_count; i++)
        if (candidates[i].votes > max_votes)
        {
            candidates[i].votes = max_votes;
        }

    return max_votes;
}

// Print the winner (or winners) of the election
void print_winner(void)
{
    int max_votes = get_max();
    for (int i = 0; i < candidate_count; i++) // TODO
        if (candidates[i].votes == max_votes)
        {
            printf("%s\n", candidates[i].name);
        }
    return;
}
