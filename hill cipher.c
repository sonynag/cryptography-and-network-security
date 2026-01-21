#include <stdio.h>
#include <string.h>

int main() {
    
    int key[3][3] = {
        {6, 24, 1},
        {13, 16, 10},
        {20, 17, 15}
    };

   
    int invKey[3][3] = {
        {8, 5, 10},
        {21, 8, 21},
        {21, 12, 8}
    };

    int pt[3], ct[3], dt[3]; 
    char msg[4];
    int i, j, t;

    printf("Enter 3-letter plaintext (CAPITAL letters only): ");
    scanf("%3s", msg);

    
    for(i = 0; i < 3; i++) {
        pt[i] = msg[i] - 'A';
    }

  
    for(i = 0; i < 3; i++) {
        t = 0;
        for(j = 0; j < 3; j++) {
            t += key[i][j] * pt[j]; 
        }
        ct[i] = t % 26; 
    }

    printf("\nEncrypted text: ");
    for(i = 0; i < 3; i++) {
        printf("%c", ct[i] + 'A');
    }

 
    for(i = 0; i < 3; i++) {
        t = 0;
        for(j = 0; j < 3; j++) {
            t += invKey[i][j] * ct[j]; 
        }
        dt[i] = t % 26;
    }

    printf("\nDecrypted text: ");
    for(i = 0; i < 3; i++) {
        printf("%c", dt[i] + 'A');
    }

    return 0;
}
;