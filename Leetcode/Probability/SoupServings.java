// MY FINAL INSIGHT AFTER READING THOUGH CHAT GPT ANSWERS:

// dp[0][i] = 1; It means that the probability of getting A soup empty at this point or junction has the probability of 1 as its already what we want that's why we assigned it the value of 1.

// dp[0][0] = 0.5; Cause first after this we cant pour any more and both A and B have emptied in the same pouring so in the final answer for this the probability would be contributed as half: 0.5 × (probability they empty at the same time) and both have already emptied at the same time.

// dp[i][0] = 0; As at this point there is no chance that A empties first so we assign it the probability of 0.

// All of the above 3 types are actually the leave nodes and the result for them is already known so we're kind of doing a bottom up DP 

// probability at dp[i][j] would mean that from here what is the probability that A finishes first. By now we would've already calculated the child nodes probability so we just check the result of the four operations that we can possibly do after this step and from the values of children we calculate the value of dp[i][j].

// THE QUESTIONS/ANALYSIS I DID ON CHAT GPT:

// QUESTION 1: ############################

// ## **Deep Explanation of the “Soup Servings” Problem**

// I’ll keep this beginner-proof and thorough, so we cover *both* the math and the code reasoning.
// This is going to be long, so I’ll save it into a file at the end.

// ---

// ### **1. Problem Setup**

// * You start with **n mL** of Soup A and Soup B.
// * You can serve in **4 equally likely ways** each turn:

// | Option | A Served | B Served |
// | ------ | -------- | -------- |
// | 1      | 100 mL   | 0 mL     |
// | 2      | 75 mL    | 25 mL    |
// | 3      | 50 mL    | 50 mL    |
// | 4      | 25 mL    | 75 mL    |

// * Serving **more than you have** just means emptying that soup completely.
// * You **stop** as soon as either soup is empty.
// * Return:
//   `P(A empties first) + 0.5 × P(A and B empty at same turn)`

// ---

// ### **2. Why this is Probability + DP**

// This is a **Markov process** — the probability of each next state depends only on your current `(A, B)` state.
// Dynamic programming works here because:

// * We can break the problem into subproblems: “Probability of A finishing first starting with `(i, j)` servings.”
// * Each `(i, j)` depends on **at most 4 other states**, and these states are **smaller** (less soup) → DP works.

// ---

// ### **3. State Definition**

// We define:

// ```
// dp[i][j] = Probability that starting with i servings of A and j servings of B,  
//            A finishes first + 0.5 × (both finish same turn).
// ```

// Here:

// * **1 serving = 25 mL** (this converts n mL into `ceil(n / 25)` servings).
//   Why? Because smallest removal is 25 mL → avoids large arrays.
// * So if `n=100`, `m = ceil(100 / 25) = 4` servings initially.

// ---

// ### **4. Base Cases**

// 1. **A empty, B not empty** → A is already first → probability = `1`
//    `dp[0][j] = 1  (j > 0)`
// 2. **A not empty, B empty** → B is first → probability = `0`
//    `dp[i][0] = 0  (i > 0)`
// 3. **Both empty** → they tie, so add half → probability = `0.5`
//    `dp[0][0] = 0.5`

// ---

// ### **5. Recurrence**

// At `(i, j)`, you can:

// * Serve `(4, 0)` servings → goes to `(max(0, i-4), j)`
// * Serve `(3, 1)` servings → goes to `(max(0, i-3), max(0, j-1))`
// * Serve `(2, 2)` servings → goes to `(max(0, i-2), max(0, j-2))`
// * Serve `(1, 3)` servings → goes to `(max(0, i-1), max(0, j-3))`

// Each with **probability 1/4**:

// ```
// dp[i][j] = 0.25 × (
//     dp[max(0, i-4)][j] +
//     dp[max(0, i-3)][max(0, j-1)] +
//     dp[max(0, i-2)][max(0, j-2)] +
//     dp[max(0, i-1)][max(0, j-3)]
// )
// ```

// ---

// ### **6. Why m0 ≈ 200**

// * The **average** A removal per step = `(4 + 3 + 2 + 1) / 4 = 2.5 servings`.
// * The **average** B removal per step = `(0 + 1 + 2 + 3) / 4 = 1.5 servings`.
// * A depletes **faster**.
// * As n increases, the probability of B finishing first gets **smaller and smaller** because the random fluctuations average out (**law of large numbers**).
// * Experiment shows: once m ≥ 200 servings (\~5000 mL), `dp[m][m]` is so close to 1 that error tolerance (10^-5) allows us to return 1 directly.

// ---

// ### **7. Optimization**

// Instead of computing `dp` for huge n:

// * If `m >= 200` → return 1 immediately.
// * Else → use DP table of size `m × m`.

// ---

// ### **8. General Pattern for Similar Problems**

// This “soup” problem is part of a category:

// * **Finite resources**
// * **Random reductions**
// * **Stop when one or both resources hit 0**
// * **Answer = probability of one event happening first**

// For these:

// 1. **Discretize** smallest action unit.
// 2. **Define state dp\[x]\[y]** = probability of desired event from that state.
// 3. **Set base cases** for termination states.
// 4. **Write recurrence** averaging over all possible moves.
// 5. **Look for asymptotic shortcuts** (large input behavior).

// QUESTION 2: #######################

// Alright, let’s go step-by-step and break these four questions down clearly.

// ---

// ## **1. Alternative to “1 serving = 25 mL”**

// When we scale `n` down to `ceil(n / 25)`, we’re reducing the size of the DP table drastically.

// **Without scaling:**

// * If `n` = 5000 mL, and we keep 1 unit = 1 mL,
//   → DP table size = 5001 × 5001 ≈ 25 million states.
//   That’s huge in memory and time.

// **With scaling (1 serving = 25 mL):**

// * `n` = 5000 mL → `m` = ceil(5000 / 25) = 200.
//   → DP table size = 201 × 201 ≈ 40k states. Much smaller.

// So the **alternative** is:

// > Use `n` directly in mL without scaling — but that means very large arrays, O(n²) states, which is infeasible for large n.

// We avoid that by **compressing the problem space** — because all operations are multiples of 25 mL, nothing changes logically by rescaling.

// ---

// ## **2. Why `dp[0][j] = 1` and `dp[i][0] = 0`**

// Think of what the state `(i, j)` means:

// * `i` servings of A left
// * `j` servings of B left

// Now:

// * `dp[0][j]` → A is **already** empty, B still has some left.
//   Game over — **A finished first**. Probability = 1 (it’s certain, no need to think about future moves because we’ve already reached the “A first” ending).

// * `dp[i][0]` → B is **already** empty, A still has some left.
//   Game over — **B finished first**. Probability of “A finishing first” is 0.

// The **intuition**:
// You don’t look at *possible moves* once a soup is empty — the outcome is fixed. This is why we instantly assign `1` or `0`.

// ---

// ## **3. Explaining `(4, 0) → (max(0, i-4), j)` like to a kid**

// Imagine:

// * You have **i cookies** of type A and **j cookies** of type B.
// * The rule says: “Take **4 cookies from A** and **0 from B**.”

// If you had **more than 4 cookies in A**, you simply remove 4:

// > `(i, j)` → `(i-4, j)`

// But what if you have **less than 4**?
// You can’t have *negative* cookies. So if you try to take 4 but only have 2, you just take those 2 and A becomes empty (`0`).
// This is where `max(0, i-4)` comes in: it stops numbers from going below zero.

// Example:

// * Start: `(3, 5)` → take `(4, 0)` → `(max(0, 3-4), 5)` = `(0, 5)`.

// It’s like saying: “Take what you can, but you can’t owe cookies.”

// ---

// ## **4. How to perform the `m ≥ 200` experiment yourself**

// Here’s the step-by-step:

// 1. **Write the DP function** exactly as in the editorial, with `m = ceil(n / 25)`.

//    * Base cases: `dp[0][0] = 0.5`, `dp[0][j] = 1`, `dp[i][0] = 0`.
//    * Recurrence: average over the 4 moves.

// 2. **Loop over increasing m**:

//    ```python
//    for m in range(1, 500):
//        ans = dp[m][m]
//        if ans > 1 - 1e-5:
//            print(m, ans)
//            break
//    ```

//    This will print the smallest m where the answer is > `1 - 10^-5`.

// 3. **Convert servings back to mL**:
//    `m servings × 25 mL = threshold volume`.

// 4. You’ll see that around `m = 200` (≈ 5000 mL), the probability is so close to 1 that further simulation doesn’t change the answer in the problem’s tolerance.

// You can also **plot** m vs dp\[m]\[m] to see how it approaches 1 as m increases — it’s like a curve that levels off.

// QUESTION 3: #######################

// Alright — I get why these two points are tricky.
// Let’s go step-by-step and tie them together so you’re not just “taking it on faith” when we say `dp[0][j] = 1`.

// ---

// ## **1. Why `dp[0][j] = 1` is mathematically correct**

// Think of probability here **not** as “we guess” but as a **fraction of outcomes that meet our condition**.

// Our condition is:

// > “A empties before B” OR “A and B empty at the same time (count half).”

// ---

// ### Imagine the game as a probability tree:

// * **Each path** in the tree is one sequence of random servings until the game ends.
// * **The leaves** (endpoints) are the final outcomes:

//   * A finished first
//   * B finished first
//   * Both finished together

// Now, the state `(0, j)` means:

// * A is already empty.
// * B still has `j > 0` servings.

// At this point:

// * The “path” has already ended — you are **already at a leaf** of the probability tree.
// * This leaf **always** counts as “A finished first” (probability = 1 for the condition being true).
// * There is **zero uncertainty left** — no more branching. It’s like flipping a coin, but you’ve already seen the side — the probability of it being heads is 1 if you’ve already looked and it is heads.

// ---

// **Key:**
// We are **not** assigning this from “our own selves” — we’re **measuring the fraction of future outcomes** where A finishes first.
// If A is already finished, the fraction is 100% of possible futures → probability = 1.

// Similarly, `(i, 0)` is a leaf where B already finished first → fraction of A-first outcomes = 0% → probability = 0.

// ---

// **Analogy:**
// Say you want the probability of rain tomorrow.

// * At 9 AM tomorrow, you wake up and see it’s raining.
// * The probability of rain tomorrow is now 1 — **not because you decided it, but because the event has already occurred**.

// In `(0, j)`, the event “A empties first” has already occurred.

// ---

// ## **2. Tree structure → Recurrence relation**

// Let’s expand the DP into a **tree picture** so you see exactly where:

// ```
// dp[i][j] = 0.25 × (
//     dp[max(0, i-4)][j] +
//     dp[max(0, i-3)][max(0, j-1)] +
//     dp[max(0, i-2)][max(0, j-2)] +
//     dp[max(0, i-1)][max(0, j-3)]
// )
// ```

// ---

// ### Level 0 (Root):

// You start with `(i, j)` servings.

// ---

// ### Level 1:

// From `(i, j)` you can choose any of the 4 serving patterns **equally likely** (probability 1/4 each):

// 1. `(i-4, j)`
// 2. `(i-3, j-1)`
// 3. `(i-2, j-2)`
// 4. `(i-1, j-3)`

// ---

// ### Level 2:

// From each of those new states, you again have 4 possible serving patterns.
// So each branch from level 1 splits into 4 children (16 total).

// ---

// ### Going deeper:

// Eventually, some branch will hit a state `(0, j)` or `(i, 0)` or `(0, 0)` — **these are terminal leaves** (base cases).

// ---

// ### How the recurrence ties in:

// The probability of winning from `(i, j)` is:

// 1. **Look at all possible next moves.**

// 2. **Take the probability from each resulting state.**
//    For example:

//    * If you go from `(i, j)` to `(i-4, j)` → the probability from there is `dp[max(0, i-4)][j]`.
//    * Same for other moves.

// 3. **Average them**, because each move has equal chance (0.25 each).

// ---

// ### Why `max(0, ...)`:

// When a branch tries to take more than is left, you set it to zero (no negatives). That branch might end immediately if it reaches a base case.

// ---

// **Example with small numbers:**
// Say `(i, j) = (2, 1)` (2 servings A, 1 serving B):

// * First move options:

//   1. `(max(0, 2-4), 1)` = `(0, 1)` → terminal leaf → probability = 1
//   2. `(max(0, 2-3), max(0, 1-1))` = `(0, 0)` → terminal leaf → probability = 0.5
//   3. `(max(0, 2-2), max(0, 1-2))` = `(0, 0)` → terminal leaf → probability = 0.5
//   4. `(max(0, 2-1), max(0, 1-3))` = `(1, 0)` → terminal leaf → probability = 0

// So:

// ```
// dp[2][1] = 0.25 × (1 + 0.5 + 0.5 + 0)
//          = 0.25 × (2)
//          = 0.5
// ```

// → meaning starting with `(2, 1)` you have 50% chance A finishes first.

// QUESTION 4: ########################

// In the **soup servings** problem,

// `dp[i][j]` = probability that **Soup A empties first + 0.5 × (probability they empty at the same time)**, given `i` servings of A and `j` servings of B left.

// ---

// When **`dp[0][0]`** happens, it means:

// * Soup A is **empty**
// * Soup B is also **empty**
// * And both got empty **at exactly the same serving step**

// ---

// Here’s why `dp[0][0] = 0.5`:

// 1. **By definition of the problem**
//    The problem states:

//    * If A empties first → probability = `1`
//    * If B empties first → probability = `0`
//    * If **both empty at the same time**, we count **half** toward the probability (since it’s “half A’s win” and “half B’s win”).

// 2. **When we land on `(0,0)`**
//    We already know *both soups are empty*, so we are in the “both at same time” scenario.
//    This means the result of this *entire branch* is fixed — no more serving happens, no randomness remains.
//    So the probability that “A finishes first (or ties and gets half credit)” is exactly **0.5**.

// 3. **Why it’s not from our own wish**
//    It’s not that we arbitrarily chose 0.5 — it’s baked into the *rules* of the problem.
//    The DP is computing **expected probabilities** from all possible future moves, but when we hit a terminal case (like `(0,0)`), there *is no* future — we just apply the outcome value directly.

// 4. **Think of it like a game tree**

//    * Any path that ends at `(0,0)` has the same value: `0.5`.
//    * That `0.5` is then averaged back up the tree when we compute earlier states.
//    * It’s just like a chess game — when you reach checkmate, you don’t keep playing, you assign the score immediately.

class Solution {
    public double soupServings(int n) {
        if (n > 5000) return 1;
        int pouringsCount = Math.min(201, ((n + 25 - 1) / 25) + 1); // This is ceil function
        double[][] dp = new double[pouringsCount][pouringsCount];
        for (int i = 0; i < pouringsCount; i++) {
            dp[i][0] = 0;
            dp[0][i] = 1;
        }
        dp[0][0] = 0.5;

        for (int i = 1; i < pouringsCount; i++) {
            for (int j = 1; j < pouringsCount; j++) {
                dp[i][j] = 0.25 * (
                    dp[Math.max(0, i - 4)][j]
                    + dp[Math.max(0, i - 3)][j - 1]
                    + dp[Math.max(0, i - 2)][Math.max(0, j - 2)]
                    + dp[i - 1][Math.max(0, j - 3)]
                );
            }
        }

        return dp[pouringsCount - 1][pouringsCount - 1];
    }
}
