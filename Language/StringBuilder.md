Initialization:
------------------------------------------------

Works: `StringBuilder sb = new StringBuilder("yogesh");`

Won't work: `StringBuilder sb = "yogesh";` </br>
Because AutoBoxing isn't implemented in java for StringBuilder. Go to `Language.md` for more.


Its char At as normal for string class

Its deleteCharAt and not removecharAt

Insert at the very beginning of string builder result.insert(0, "string"); // Note here the index is the first argument not the second.

The operation new StringBuilder(s) and inserting later; is costlier than simply creating a StringBuilder and appending the chars with append as per the logic. see AddSpacesToAString.java for in depth details.
