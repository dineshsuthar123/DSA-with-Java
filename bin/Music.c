#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

typedef struct
{
    char title[50], artist[50];
    int duration;
} Song;

void playSong(Song *song)
{
    if (!song)
        printf("No song playing.\n");
    else
    {
        printf("Playing: %s by %s (%d sec)\n", song->title, song->artist, song->duration);
        sleep(song->duration);
    }
}

void addSong(Song *songs, int *count, char *title, char *artist, int duration)
{
    strcpy(songs[*count].title, title);
    strcpy(songs[*count].artist, artist);
    songs[*count].duration = duration;
    (*count)++;
}

void displaySongs(Song *songs, int count)
{
    if (!count)
        printf("Playlist is empty.\n");
    else
        for (int i = 0; i < count; i++)
            printf("%d. %s by %s (%d sec)\n", i + 1, songs[i].title, songs[i].artist, songs[i].duration);
}

int main()
{
    Song songs[10], *currentSong = NULL;
    int songCount = 0, choice;

    while (1)
    {
        printf("\n1. Add Song\n2. Display Playlist\n3. Play Song\n4. Stop Song\n5. Exit\nChoice: ");
        scanf("%d", &choice);

        if (choice == 1)
        {
            char title[50], artist[50];
            int duration;
            printf("Title: ");
            scanf(" %[^\n]", title);
            getchar();
            printf("Artist: ");
            scanf(" %[^\n]", artist);
            getchar();
            printf("Duration (sec): ");
            scanf("%d", &duration);
            addSong(songs, &songCount, title, artist, duration);
            printf("Song added!\n");
        }
        else if (choice == 2)
            displaySongs(songs, songCount);
        else if (choice == 3)
        {
            if (!songCount)
                printf("No songs to play.\n");
            else
            {
                int songNum;
                printf("Enter song number (1-%d): ", songCount);
                scanf("%d", &songNum);
                if (songNum < 1 || songNum > songCount)
                    printf("Invalid song number.\n");
                else
                    currentSong = &songs[songNum - 1], playSong(currentSong);
            }
        }
        else if (choice == 4)
            currentSong ? printf("Stopped: %s\n", currentSong->title), currentSong = NULL : printf("No song to stop.\n");
        else if (choice == 5)
            break;
        else
            printf("Invalid choice.\n");
    }

    printf("Goodbye!\n");
    return 0;
}
