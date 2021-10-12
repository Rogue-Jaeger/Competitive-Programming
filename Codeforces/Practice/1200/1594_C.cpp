// https://codeforces.com/problemset/problem/1594/C

#include<iostream>
#include<cmath>
using namespace std;


	int t, n;
	char c;
	char s[int(3*1e5+10)];

int main() {
	
	scanf("%d", &t);
	
	newTestCase: while(t--) {
		scanf("%d %c %s", &n, &c, &s);
		
		for(int i = 0; i < n; i++) {
			if(s[i] != c) break;
			if(i == (n-1)) {
				printf("0\n");
				goto newTestCase;
			};
		}
		
		for(int i = floor(n/2); i < n; i++) {
			if(s[i] == c) {
				printf("1\n%d\n", i+1);
				break;
			}
			if(i == (n-1)) printf("2\n%d %d\n", n-1, n);
		}
	}
}
