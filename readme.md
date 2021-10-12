1. Declaring variables outside main function saved 15ms of runtime on Codeforces.
2. Its 1e9+7 not 10e9+7, As e means "Times 10 to the" here its donating (1*10)^9 + 7.
3. ll or LL makes an integer literal of type long long which can be used inside large (integer, integer) multiplications where there are chances of overflow. There won't be any need for this if we multiply long long with integer as the result will be casted to long long automatically. A good example is at: https://github.com/Rogue-Jaeger/Competitive-Programming/blob/0279c47be37eee931616ed49385af8e409c03dd1/Codeforces/Practice/1100/1594_B.cpp.
