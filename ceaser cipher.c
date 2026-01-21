#include <stdio.h>
#include <ctype.h>

int main() {
    char text[500], ch;
    int key;

    printf("Enter a message to be encrypted: ");
    scanf("%s", text);

    printf("Enter the encryption key: ");
    scanf("%d", &key);

    
    for (int i = 0; text[i] != '\0'; i++) {
        ch = text[i];

        if (isalnum(ch)) {
            if (islower(ch)) {
                ch = (ch - 'a' + key) % 26 + 'a';
            }
            else if (isupper(ch)) {
                ch = (ch - 'A' + key) % 26 + 'A';
            }
            else if (isdigit(ch)) {
                ch = (ch - '0' + key) % 10 + '0';
            }
        } else {
            printf("\nInvalid character found!");
            return 0;
        }

        text[i] = ch;
    }

    printf("Encrypted message: %s\n", text);

   
    printf("\nEnter decryption key: ");
    scanf("%d", &key);

    for (int i = 0; text[i] != '\0'; i++) {
        ch = text[i];

        if (isalnum(ch)) {
            if (islower(ch)) {
                ch = (ch - 'a' - key + 26) % 26 + 'a';
            }
            else if (isupper(ch)) {
                ch = (ch - 'A' - key + 26) % 26 + 'A';
            }
            else if (isdigit(ch)) {
                ch = (ch - '0' - key + 10) % 10 + '0';
            }
        }

        text[i] = ch;
    }

    printf("Decrypted message: %s\n", text);

    return 0;
}
