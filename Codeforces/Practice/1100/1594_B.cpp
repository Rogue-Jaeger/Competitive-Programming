// https://codeforces.com/problemset/problem/1594/

// showing just the powers of any n to get guaranteed increasing pattern
// This is the order of powers in which the array will be sorted 
//
// Now we have to reverse engineer the pattern what will be the combination of powers for a given index k in the array
// We can see that to get the combination of powers for a given index k, we can just divide k by 2 until there is no remainder
// the powers of 2 that we get upon division are the combination of powers to make that indexed number
// 0
// 1
// 0 1
// 2
// 2 0
// 2 1
// 2 1 0
// 3 
// 3 0
// 3 1
// 3 1 0
// 3 2 
// 3 2 0 
// 3 2 1
// 3 2 1 0


#include<iostream>
using namespace std;

int t, n, k, result, power;
const int modulo = 1e9 + 7;

int main() {
	scanf("%d", &t);
	
	while(t--) {
		scanf("%d %d", &n, &k);
		result = 0; power = 1;
		
		while(k) {
			result = (k&1) ? (result + power ) % modulo : result;
			k>>=1;
			power = 1ll * power * n % modulo;
		}
		
		printf("%d\n", result);
	}
}



