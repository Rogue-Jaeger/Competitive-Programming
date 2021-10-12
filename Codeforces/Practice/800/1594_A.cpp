// https://codeforces.com/problemset/problem/1594/A

// To find a single truthy value do addition of all boolean values.
// To find a single falsy value do multiplication of all boolean values.

#include<iostream>
using namespace std;

int main() {
	long long int input, testCase;
	
	scanf("%lld", &testCase);
	
	while(testCase--) {
		scanf("%lld", &input);
		printf("%lld %lld\n", -input+1, input);
	}
}
