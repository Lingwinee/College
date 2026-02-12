#include <stdio.h>

int main() {
    int n;
    printf("Enter number of vertices: ");
    scanf("%d", &n);

    int adj[n][n];
    printf("Enter adjacency matrix:\n");
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &adj[i][j]);

    int edgeCount = 0;
    int totalAppearances = 0;

    printf("\nEdges:\n");
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (adj[i][j] == 1) {
                printf("(%d, %d)\n", i + 1, j + 1);
                edgeCount++;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (adj[i][j] == 1) {
                totalAppearances++;
            }
        }
    }

    printf("\nNumber of unique edges = %d\n", edgeCount);
    printf("Total appearances in adjacency matrix = %d\n", totalAppearances);

    return 0;
}
