// https://codeforces.com/problemset/problem/989/B

#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, p;
	string s;
	
	cin >> n >> p >> s;
	
	bool is_p_period = true;
	
	for (int i = 0 ; i < (n-p); i++) {
		if (s[i] == '.' && s[i+p] == '.') {
			s[i] = '1';
			s[i+p] = '0';
			is_p_period = false;
			break; // optimization for time
		} else if (s[i] == '.') {
			s[i] = s[i+p] - '0' ? '0' : '1';
			is_p_period = false;
			break; // optimization for time
		} else if (s[i+p] == '.') {
			s[i+p] = s[i] - '0' ? '0' : '1';
			is_p_period = false;
			break; // optimization for time
		} else if (s[i] != s[i+p] ) {
			is_p_period = false;
			break; // optimization for time
		}
	}
	
	if(is_p_period) {
		cout << "No" << endl;
	} else {
		for (int i = 0; i < s.size(); i++) {
			if(s[i] == '.') s[i] = '1';
		}
		cout << s << endl;
	}
	
	return 0;
} 
