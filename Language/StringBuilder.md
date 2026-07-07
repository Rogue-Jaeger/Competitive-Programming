Initialization:
------------------------------------------------

Works: `StringBuilder sb = new StringBuilder("yogesh");`

Won't work: `StringBuilder sb = "yogesh";` </br>
Because AutoBoxing isn't implemented in java for StringBuilder. Go to `Language.md` for more.

Its charAt() as normal for String class.

Its deleteCharAt() and not removecharAt().

Insert at the very beginning of string builder result.insert(0, "string"); // Note here the index is the first argument not the second and generally that is the case with java as if you want to add an element in ArrayList() at a particular position you'll have to conform to the same format.

The operation new StringBuilder(str) and inserting later; is costlier than simply creating a StringBuilder and appending the chars with append as per the logic. see AddSpacesToAString.java for in depth details.
