# Lagrange's Four Square Theorem. [Leetcode - Perfect Squares](https://leetcode.com/problems/perfect-squares)

## Statement

Lagrange's Four Square Theorem (1770) states that every natural number can be represented as the sum of at most four perfect squares. In other words, for any natural number n, there exist integers a, b, c, d such that:

n = a² + b² + c² + d²

## Historical Context

Joseph-Louis Lagrange proved this theorem in 1770, though earlier mathematicians like Diophantus and Bachet had made observations about sums of squares. This theorem is a special case of Waring's problem.

## Proof Sketch

The proof is complex but follows these key steps:

1. First, prove that the theorem holds for prime numbers
2. Show that if it holds for two numbers, it holds for their product
3. Use the fact that every integer can be factored into primes
4. Apply mathematical induction

A key lemma used in the proof is that if x = a₁² + a₂² + a₃² + a₄² and y = b₁² + b₂² + b₃² + b₄², then their product xy can also be represented as the sum of four squares.

## Key Properties

For any natural number n, the minimum number of squares needed to represent it has these properties:

1. The result is 1 if n is a perfect square (e.g., 1, 4, 9, 16, ...)
2. The result is 2 if n is sum of two squares (e.g., 2 = 1² + 1², 5 = 2² + 1²)
3. The result is 3 if n is sum of three squares and not fewer (e.g., 6 = 2² + 1² + 1²)
4. The result is 4 if none of the above cases apply

## Examples

### One Square

- 4 = 2²
- 9 = 3²
- 16 = 4²

### Two Squares

- 2 = 1² + 1²
- 5 = 2² + 1²
- 10 = 3² + 1²

### Three Squares

- 6 = 2² + 1² + 1²
- 11 = 3² + 1² + 1²
- 14 = 3² + 2² + 1²

### Four Squares

- 7 = 2² + 2² + 1² + 0²
- 15 = 3² + 2² + 2² + 0²
- 23 = 3² + 3² + 3² + 2²

## Interesting Facts

1. All numbers of the form 4ᵏ(8m + 7) require exactly four squares
2. The theorem implies that every natural number is a sum of at most 4 squares
3. Less than 1% of numbers need all four squares
4. The squares in the representation need not be distinct

## Applications

This theorem has applications in:

- Number Theory
- Cryptography
- Lattice-based algorithms
- Geometric problems
- Quantum Computing (quantum error correction)
- Computer Graphics (quaternion representations)