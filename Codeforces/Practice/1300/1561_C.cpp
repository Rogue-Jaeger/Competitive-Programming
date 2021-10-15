//2
//3 10 15 8
//2 12 11
//
//13 > cave1required
//13 + cave1members > cave2required
//13 + cave1members + cave2members > cave3required

#include<bits/stdc++.h>
using namespace std;

int t, numberOfCaves, powerOfSingleMonster, ans, sum, numberOfMonsters[int(1e5 + 1)], maxPowerRequired[int(1e5 + 1)], sortedOrderOfCavesByMaxPow[int(1e5 + 1)];

bool cmp(int x, int y) { 
	return maxPowerRequired[x] < maxPowerRequired[y];
}

int main() {
	scanf("%d", &t);
	
	while(t--) {
		scanf("%d", &numberOfCaves);
		ans = sum = 0;
		
		for(int i = 0; i < numberOfCaves; i++) {
			scanf("%d", &numberOfMonsters[i]);
			sortedOrderOfCavesByMaxPow[i] = i;
			maxPowerRequired[i] = 0;
			
			for(int j = 0; j < numberOfMonsters[i]; j++) 
				scanf("%d", &powerOfSingleMonster),
				maxPowerRequired[i] = max(maxPowerRequired[i], powerOfSingleMonster - j + 1);
			
		}
		
		sort(sortedOrderOfCavesByMaxPow, sortedOrderOfCavesByMaxPow + numberOfCaves, cmp);
		
		for(int i = 0; i < numberOfCaves; i++) {
			ans = max(maxPowerRequired[sortedOrderOfCavesByMaxPow[i]] - sum, ans);
			sum += numberOfMonsters[sortedOrderOfCavesByMaxPow[i]];
		}
		
		printf("%d\n", ans);
	}
}






