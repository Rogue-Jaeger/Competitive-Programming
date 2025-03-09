This algorithm is not described in Cormen and the competetive programming book.

This algorithm is runs on odd length palindromes only. So to make every palindrome odd we just add a special character like # before and after every character in the string. i.e.

String : 'abcd'
TransformedString : '#a#b#c#d#'

I basically optimises the case where if an index i already lies in another palindrome (big palindrome) then it forms a palindrome of atleast the length of its mirror index found previously in the big palindrome. 
