#include<bits/stdc++.h>
using namespace std;

int main() {
	long long t, ir, ans;
	string powers[63], str;

	cin >> t;
	
	for(int i = 0; i < 63; i++) {
		long long r = 1LL << i;
		powers[i] = to_string(r);
	}
	
	while (t--) {
		cin >> str;
		ans = 1e9;
		
		for(int i = 0; i < 63; i++) {
			ir = 0; // will run on powers
			
			for(char c: str) {
				if(ir < (long long)powers[i].length() && powers[i][ir] == c) ++ir;
			}
			
			ans = min(ans, (long long)(powers[i].size() + str.length() - 2*ir));
		}
		
		cout << ans << endl;
	}
}
