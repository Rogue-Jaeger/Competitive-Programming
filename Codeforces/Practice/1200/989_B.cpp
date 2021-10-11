// https://codeforces.com/problemset/problem/989/B

#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, p;
	string s;
	
	cin >> n >> p >> s;
	
	int i = 0;
	//The 2 for loops can be merged somehow to reduce solution size
	for (; i < (n-p); i++) {
		if(s[i] == s[i+p] && s[i] != '.') { // No need to check for && s[i+p] != '.' as it is similar to s[i]  
			continue;
		} else break;
	}
	
	if(i == (n-p)) {
		cout << "No" << endl;
	} else {
		if (s[i+p] == '.' && s[i] == '.') {
			s[i] = '1';
			s[i+p] = '0';
			++i;
		} else if (s[i] == '.') {
			s[i] = s[i+p] == '0' ? '1' : '0';
			++i;
		} else if (s[i+p] == '.') {
			s[i+p] = s[i] == '0' ? '1' : '0';
			++i;
		}
		for (; i < n; i++) {
			if(s[i] == '.') s[i] = '1';
		}
		cout << s << endl;
	}
	
	return 0;
} 

