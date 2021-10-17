// https://codeforces.com/problemset/problem/1574/C
//
//4
//3 6 2 3
//5
//3 12
//7 9
//4 14
//1 10
//8 7
//
//2 3 3 6 ---> 
//
//2 3 3 5
//
//4 14
//6
//4 + 1 = 5
//
//
//3 12
//send 3 required 1 to defend
//= 1
//
//7 9
//add 1 to 6 to send 
//1 to add to remaining 
//= 2
//
//4 14
//select between 3 and 6
//for 3
//add 1 to 3, add 3 to get to 14
//for 6 
//send 6, add 6 to get to 14 
//so we'll take first one
//= 4
//
//1 10
//send 2, keep rest to defend
//= 0
//
//8 7
//add 2 to 6 and send, defend comfortably
//= 2


#include<bits/stdc++.h>
using namespace std;

int nh, nd, mid;
long long heroes[int(2*1e5 + 1)], dragonDefence, dragonAttack, sumOfAllPowers = 0;

// 0 if hero wins otherwise deficit
long long attackingWarResult(long long powerOfPickedHero) {
	return powerOfPickedHero - dragonDefence > 0 ? 0 : -(powerOfPickedHero - dragonDefence);
}

// 0 if heroes win otherwise deficit
long long defensiveWarResult(long long powerOfRemovedHero) {
	return sumOfAllPowers - powerOfRemovedHero - dragonAttack > 0 ? 0 : -(sumOfAllPowers - powerOfRemovedHero - dragonAttack);
}

long long solve(int left, int right) {
	if(left >= right) {
		if(heroes[left] == dragonDefence) 
			return defensiveWarResult(heroes[left]);
		
		if(left == right) {
			return min(
				min(
					attackingWarResult(heroes[max(left - 1, 0)]) + defensiveWarResult(heroes[max(left - 1, 0)]),
					attackingWarResult(heroes[left]) + defensiveWarResult(heroes[left])
				),
				attackingWarResult(heroes[min(left + 1, nh)]) + defensiveWarResult(heroes[min(left + 1, nh)])
			);
		}
		
		return min(attackingWarResult(heroes[left]) + defensiveWarResult(heroes[left]), attackingWarResult(heroes[right]) + defensiveWarResult(heroes[right]));
	}
	
	mid = left + (right - left) / 2;
	
	if(heroes[mid] == dragonDefence) 
		return defensiveWarResult(heroes[mid]);
	
	if(heroes[mid] < dragonDefence) return solve(min(mid + 1, nh), right); // Making sure left doesn't fall below 0
	
	return solve(left, max(0, mid - 1)); // Making sure right doesn't go beyond nh
}

int main() {
	scanf("%d", &nh);
	
	for(int i = 0; i < nh; i++) {
		scanf("%lld", &heroes[i]);
		sumOfAllPowers += heroes[i];
	}
	
	sort(heroes, heroes + nh);
	
	scanf("%d", &nd);
	
	while(nd--) {
		scanf("%lld %lld", &dragonDefence, &dragonAttack);
		printf("%lld\n", solve(0, nh-1));
	}
}

