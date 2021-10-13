#include<stdio.h>
using namespace std;

int t, colNumber;
char firstRow[101], secondRow[101];
bool pathExists;

int main() {
	scanf("%d", &t);
	
	while(t--) {
		scanf("%d %s %s", &colNumber, &firstRow, &secondRow);
		pathExists = true;
		while(colNumber--) {
			if(firstRow[colNumber] == '1' && secondRow[colNumber] == '1') {
				pathExists = false;
				break;
			}
		}
		printf("%s\n", pathExists ? "YES" : "NO");
	}
}
