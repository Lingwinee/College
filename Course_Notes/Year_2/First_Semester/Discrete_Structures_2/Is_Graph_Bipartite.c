#include <stdio.h>

int checkValid(int edges[][2], int, int*);
void assignGroup(int, int, int, int edges[][2], int group[], int*);

int main() {
    int n, e;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter number of edges: ");
    scanf("%d", &e);

    int edges[e][2];
    int group[n];
    int isBipartite = 0;

    printf("Enter the edges (ex: u v):\n");
    for (int i = 0; i < e; i++)
        scanf("%d %d", &edges[i][0], &edges[i][1]);

    assignGroup(0, n, e, edges, group, &isBipartite);

    if (isBipartite)
        printf("The graph IS bipartite.\n");
    else
        printf("The graph is NOT bipartite.\n");

    return 0;
}

int checkValid(int edges[][2], int e, int group[]) {
    for (int i = 0; i < e; i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        if (group[u] == group[v])
            return 0;
    }
    return 1;
}

void assignGroup(int vertex, int n, int e, int edges[][2], int group[], int *isBipartite) {
    if (*isBipartite) return;
    if (vertex == n) {
        if (checkValid(edges, e, group)) {
            *isBipartite = 1;
        }
        return;
    }

    group[vertex] = 0;
    assignGroup(vertex + 1, n, e, edges, group, isBipartite);

    group[vertex] = 1;
    assignGroup(vertex + 1, n, e, edges, group, isBipartite);
}