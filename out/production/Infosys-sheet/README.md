# Infosys Sheet – Coding Preparation

### 👨‍💻 Author: Rishi Yadav

Final Year Student at DIT University
📚 Preparing for Campus Placements
🏢 Target Company: Infosys
🎯 This sheet contains 14 curated coding problems (5 Easy, 5 Medium, 4 Hard) tailored to help students crack Infosys campus placements. These problems are chosen to reflect the patterns and logic often asked by Infosys in their hiring process.

---

## ✅ Easy Problem 1: Array Update and Range Sum Queries

### 📝 Problem Statement

You're given an array `A` of `n` integers and `q` queries.

Each query is one of the following types:

* **Type 1 (Update):** `1 l r`
  Replace `A[i] = (i - l + 1) * A[l]` for all `i` in the range `[l, r]`.

* **Type 2 (Sum):** `2 l r`
  Return the sum of elements from `A[l]` to `A[r]`.

You need to return the **sum of answers to all Type 2 queries**, modulo `10^9 + 7`.

---

### 📥 Sample Input 1

```
7
1 4 5 1 6 7 8
5
1 1 6
1 1 5
2 5 5
2 3 4
2 3 3
```

### 📤 Sample Output 1

```
60
```

---

### 🧠 Approach & Explanation

To solve this problem efficiently:

* We iterate through the list of queries.
* For **Type 1 queries**, we perform a linear update within the specified range based on the formula.
* For **Type 2 queries**, we compute the range sum directly using a loop.
* We maintain a cumulative `totalSum` to store results of all Type 2 queries modulo `10^9 + 7`.

### 🧩 Pattern Used

* **Brute Force with Simulation**: Since each query is executed as described, this is a direct simulation of the problem statement.
* **Prefix Sum Optimization**: Could be considered for range sums if performance becomes a concern.

---

### ⏱ Time and Space Complexity

**Time Complexity:**

| Operation    | Complexity   |
| ------------ | ------------ |
| Type 1 Query | O(r - l + 1) |
| Type 2 Query | O(r - l + 1) |
| Total Worst  | O(q × n)     |

In the worst case, this can reach `O(10^10)` operations, which is acceptable here as per sample size.

**Space Complexity:**

| Component | Space |
| --------- | ----- |
| Array A   | O(n)  |
| Queries   | O(q)  |

---

## ✅ Easy Problem 2: Maximum Sum of Good Subarray

### 📝 Problem Statement

Given an array `A` of `N` integers and a number `k`, find the **maximum sum of any subarray** that contains **at most **\`\`** distinct elements**. An **empty subarray** is valid and has a sum of 0.

---

### 📥 Sample Input 1

```
11
2
1 2 2 3 2 3 5 1 2 1 1
```

### 📤 Sample Output 1

```
12
```

---

### 🧠 Approach & Explanation

* We use the **Sliding Window** technique to find the maximum sum of a valid subarray.
* A **HashMap** is used to track the frequency of elements in the current window.
* We **expand the window to the right** while the number of distinct elements is ≤ `k`.
* If the count exceeds `k`, we **shrink from the left** until it's valid again.
* We track the **current sum** and update the maximum sum whenever valid.
* To avoid negative sums, we **reset the window** (like Kadane’s Algorithm) when `currSum < 0`.

### 🧩 Pattern Used

* **Sliding Window with Two Pointers**
* **HashMap for Frequency Count**
* **Kadane’s Reset Strategy**: Restart the sum if it drops below 0

---

### ⏱ Time and Space Complexity

**Time Complexity:** `O(N)`
Each element is processed at most twice (once by right, once by left pointer).

**Space Complexity:** `O(K)`
For storing up to `k` distinct elements in HashMap.

---

### 📄 NOTE

To view all 14 questions (**5 Easy**, **5 Medium**, **4 Hard**) from the Infosys preparation sheet, please check the [`assets/`](./assets/) folder of this repository where the full **PDF sheet** is stored:

📂 Path: [`assets/Infosys_Sheet.pdf`](./assets/Infosys_Sheet.pdf)
