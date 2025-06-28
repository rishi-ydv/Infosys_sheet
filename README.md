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

## ✅ Easy Problem 3: Minimum Initial Oil to Avoid Disturbance

---

### 📝 Problem Statement

You're given a queue of `N` people where:

- 🔁 `A[i] = 1` → The person wants to **sell** 1 litre of oil
- 🔁 `A[i] = -1` → The person wants to **buy** 1 litre of oil

You have an oil tank with a capacity of `C` litres. People are served **in order**. A **disturbance** occurs when:

- ❌ Someone wants to **buy**, but the tank is **empty**
- ❌ Someone wants to **sell**, but the tank is **already full**

To **minimize the total number of disturbances**, you are allowed to fill the tank initially with `X` litres of oil.

🎯 Your goal is to find the **minimum value of `X`** such that **disturbances are minimized**.

---

### 📥 Sample Inputs & Outputs

#### ✅ Case 1
<pre>
Input:
3
3
-1 1 1

Output:
1
</pre>

#### ✅ Case 2
<pre>
Input:
3
2
-1 -1 1

Output:
2
</pre>

#### ✅ Case 3
<pre>
Input:
4
3
1 1 1 1

Output:
0
</pre>

---

### 🧠 Approach & Explanation

💡 The problem is solved using a **greedy simulation** strategy with **prefix minimum tracking**.

Here's how:

1. Initialize `currentOil = 0` and `minOil = 0`.
2. Traverse the array from left to right:
  - If a person **buys** (`-1`), subtract 1 from `currentOil`.
  - If a person **sells** (`1`), add 1 to `currentOil` (only if it's less than capacity `C`).
3. Track how low the `currentOil` dips using `minOil = min(minOil, currentOil)`.
4. The **minimum initial oil X** needed is `abs(minOil)`, so the tank never goes negative.

🔥 Selling oil is **only restricted** by tank capacity — so we only care about **underflows**, not overflows.

---

### 🧩 Patterns Used

- 📍 **Greedy Simulation**
- 🧮 **Prefix Minimum Tracking**
- 🚫 Ignore overflow disturbances (they can't be avoided by initial oil)

---

### ⏱ Time and Space Complexity

<table>
  <thead>
    <tr>
      <th>Aspect</th>
      <th>Complexity</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>🕒 Time Complexity</td>
      <td><code>O(N)</code> – Single pass through the list</td>
    </tr>
    <tr>
      <td>💾 Space Complexity</td>
      <td><code>O(1)</code> – Constant auxiliary variables</td>
    </tr>
  </tbody>
</table>

---

📌 This is a classic **real-world greedy strategy problem**, simulating a queue with constraints.

Feel free to explore edge cases like:
- All buyers at the beginning
- All sellers when the tank is full

---
# ✅ Easy Problem 4: Minimum Moves to Reduce Soldiers to 1

---

## 📝 Problem Statement

You're given an army of `N` soldiers and your task is to reduce the number to exactly `1` using the **minimum number of moves**.

### 🧾 Allowed Moves:
- ➖ **Subtract 1 soldier** → `N → N - 1`
- 🌓 **Remove half of the soldiers** (rounded down) → `N → floor(N / 2)`
- ⚖️ **Remove two-thirds of the soldiers** (rounded down) → `N → floor(N / 3)`

Each move must leave an **integer** number of soldiers.

🎯 **Your goal** is to determine the **minimum number of moves** required to reach 1 soldier.

---

## 📥 Input Format
```txt
An integer N — the number of soldiers.
Constraints: 1 ≤ N ≤ 10^9
```

## 📤 Output Format
```txt
Print the minimum number of moves required to reduce the army to 1 soldier.
```

---

## 📊 Sample Test Cases

### ✅ Case 1
<pre>
Input: 5
Output: 3
</pre>

**🧾 Explanation:**
```
5 → 4 (subtract 1)
4 → 2 (half)
2 → 1 (half)
```

### ✅ Case 2
<pre>
Input: 1
Output: 0
</pre>

**🧾 Explanation:**
```
Already at 1, so no moves required.
```

### ✅ Case 3
<pre>
Input: 6
Output: 2
</pre>

**🧾 Explanation:**
```
6 → 3 (half)
3 → 1 (half)
```

---

## 🧠 Approach & Explanation

💡 This problem is solved using **Recursive Dynamic Programming with Memoization** for large inputs, and **BFS** for smaller inputs.

### 🧩 Key Insight:
At each step, we have 3 choices. We need to find the path that leads to 1 with the minimum number of moves.

### 🚶 Strategy:

#### Method 1: BFS Approach (For smaller N ≤ 100,000)
1. **Initialize** a queue with the starting number `N`
2. **Use BFS** to explore all possible next states level by level
3. **Track visited states** to avoid cycles
4. **Return** the number of levels when we reach 1

#### Method 2: Recursive DP with Memoization (For large N)
1. **Base case**: If `N = 1`, return 0 moves
2. **For each N**, try all three operations:
  - Subtract 1 → `minMoves(N - 1) + 1`
  - Divide by 2 → `minMoves(N / 2) + 1`
  - Divide by 3 → `minMoves(N / 3) + 1`
3. **Return** the minimum of all three options
4. **Use memoization** to cache results and avoid recalculation

---

## 🧩 Patterns Used

- 🧮 **Dynamic Programming with Memoization**
- 📊 **Breadth-First Search (BFS)**
- 🔄 **State Space Search**
- 🎯 **Optimization Problem**

### 🔄 Transition Relations:
- **Subtract 1** → `minMoves(N - 1) + 1`
- **Divide by 2** → `minMoves(N / 2) + 1`
- **Divide by 3** → `minMoves(N / 3) + 1`

---

## ⏱ Time and Space Complexity

<table>
  <thead>
    <tr>
      <th>Metric</th>
      <th>BFS Approach</th>
      <th>Recursive DP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>🕒 <strong>Time Complexity</strong></td>
      <td><code>O(N)</code></td>
      <td><code>O(log N)</code> average</td>
    </tr>
    <tr>
      <td>💾 <strong>Space Complexity</strong></td>
      <td><code>O(N)</code></td>
      <td><code>O(log N)</code></td>
    </tr>
  </tbody>
</table>

### 📈 Why Recursive DP is Better for Large N:
- **Logarithmic depth**: Division operations reduce the problem size quickly
- **Memoization**: Avoids recalculating the same subproblems
- **Memory efficient**: Only stores results for visited states

---

## 📌 Important Notes

### 🤔 Understanding the Third Operation:
Even though the problem says **"Remove two-thirds of the soldiers"**, it means you're left with **one-third**, so:
```
N → floor(N / 3)
```
This is why the operation for "remove two-thirds" is treated as `N / 3` in the logic.

### 🎯 Algorithm Choice:
- **For N ≤ 100,000**: Use BFS for guaranteed optimal solution
- **For N > 100,000**: Use Recursive DP with memoization for efficiency

---

## 🔍 Step-by-Step Trace Examples

### Example 1: N = 5
```
Step 0: N = 5, moves = 0
Step 1: Try operations on 5
  - 5-1 = 4 → Check minMoves(4)
  - 5/2 = 2 → Check minMoves(2)  
  - 5/3 = 1 → Found! Return 1
Best path: 5 → 4 → 2 → 1 (3 moves)
```

### Example 2: N = 6
```
Step 0: N = 6, moves = 0
Step 1: Try operations on 6
  - 6-1 = 5 → Check minMoves(5)
  - 6/2 = 3 → Check minMoves(3)
  - 6/3 = 2 → Check minMoves(2)
Best path: 6 → 3 → 1 (2 moves)
```

---

## 📚 Related Problems for Practice

<table>
  <thead>
    <tr>
      <th>Problem</th>
      <th>Platform</th>
      <th>Tags</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Minimum Steps to One</td>
      <td>Coding Ninjas</td>
      <td>DP, Memoization</td>
    </tr>
    <tr>
      <td>Reduce to One</td>
      <td>CSES</td>
      <td>DP</td>
    </tr>
    <tr>
      <td>Integer Replacement</td>
      <td>LeetCode</td>
      <td>DP, Recursion</td>
    </tr>
    <tr>
      <td>Minimum Steps to 1</td>
      <td>GeeksForGeeks</td>
      <td>DP</td>
    </tr>
  </tbody>
</table>

---

## 🚀 Optimization Tips

1. **Use memoization** to avoid redundant calculations
2. **Choose the right approach** based on input size
3. **Handle edge cases** (N = 1) explicitly
4. **Consider iterative DP** for very memory-constrained environments

---

## 🧪 Additional Test Cases

```
Test Cases:
minMoves(1)   → Output: 0
minMoves(2)   → Output: 1
minMoves(3)   → Output: 1
minMoves(9)   → Output: 2 (9→3→1)
minMoves(27)  → Output: 3 (27→9→3→1)
```

---

📌 This problem beautifully demonstrates the power of **dynamic programming** and the importance of choosing the right algorithm based on input constraints!


---

# ✅ Easy Problem 5: Minimum Time to Invade All Enemies ⛨️

---

## 📝 Problem Statement

General Ali has initiated an invasion on an `N x M` battlefield represented by a grid `Q`. Your task is to calculate the **minimum number of seconds** it takes to invade **all enemy (`E`) cells**, starting from already-invaded (`A`) cells. If not all enemies can be invaded, return `-1`.

### 📼 Cell Types:

* ✨ `'A'`: Already invaded cell
* ❌ `'E'`: Enemy cell
* ⬛ `'*'`: Blocked cell (cannot be visited)

### ⏳ Invasion Rules:

Every second, all `'A'` cells **spread to adjacent `'E'` cells** (up, down, left, right).

---

## 📥 Input Format

```txt
An integer N: Number of rows in the grid.
An integer M: Number of columns in the grid.
Next N lines: Each contains a string of M characters representing each row of the grid.
```

## 📤 Output Format

```txt
An integer representing the minimum seconds required to invade all 'E' cells, or -1 if impossible.
```

---

## 📊 Sample Test Cases

### ✅ Case 1

<pre>
Input:
2
2
AE
EE

Output:
2
</pre>

**📓 Explanation:**

```
t = 0:
AE
EE

t = 1:
AA
AE

t = 2:
AA
AA
```

---

### ✅ Case 2

<pre>
Input:
3
2
AE
*E
EE

Output:
4
</pre>

**📓 Explanation:**

```
t = 0:
AE
*E
EE

t = 1:
AA
*E
EE

t = 2:
AA
*E
AE

t = 3:
AA
*E
AA
```

---

### ❌ Case 3

<pre>
Input:
3
2
AE
**
EE

Output:
-1
</pre>

**📓 Explanation:**

```
t = 0:
AE
**
EE

t = 1:
AA
**
EE

t = 2:
AA
**
AA
(Cannot cross '**')
```

---

## 🧐 Approach & Explanation

### 🔎 Pattern Used: **Multi-Source Breadth-First Search (BFS)**

This problem is a classic example of a **flood fill** or **rot propagation** problem, similar to "Rotting Oranges" on LeetCode.

---

## 🔀 Step-by-Step Strategy

1. **Queue Initialization**: Add all `'A'` cells (already invaded) to a BFS queue.
2. **Count `'E'` Cells**: Count the total number of enemy cells we need to invade.
3. **BFS Execution**:

  * For each second, process all cells in the queue.
  * For each cell, invade its up/down/left/right neighbor if it's an `'E'`.
  * Add newly invaded cells to the queue.
4. **Track Time**: Increase time only if at least one invasion happened in the current second.
5. **Final Condition**:

  * If all `'E'` cells are turned to `'A'`, return total time.
  * If some `'E'` remain, return `-1`.

---

## ⏱ Time and Space Complexity

<table>
  <thead>
    <tr>
      <th>Aspect</th>
      <th>Complexity</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>🕒 Time Complexity</td>
      <td><code>O(N * M)</code> – Every cell is visited at most once</td>
    </tr>
    <tr>
      <td>📀 Space Complexity</td>
      <td><code>O(N * M)</code> – BFS queue can hold all cells</td>
    </tr>
  </tbody>
</table>

---

## 🥇 Why It's Optimal

* **BFS guarantees shortest path** to reach all `'E'` cells.
* **Efficient** even for maximum constraints (1000 x 1000 grid).
* **Avoids cycles** and **over-processing** using a visited marker (turning `'E'` → `'A'`).

---

## 📈 Real-World Analogy & Related Problems

| Problem           | Platform      | Tags              |
| ----------------- | ------------- | ----------------- |
| Rotting Oranges   | LeetCode #994 | BFS, Grid, Spread |
| Zombie Infection  | InterviewBit  | Multi-source BFS  |
| Fire in Forest    | GeeksForGeeks | Graph/BFS         |
| Spread of Disease | Coding Ninjas | Simulation, Queue |

---

## 💡 Bonus Tips

* Use `directions[][] = {{-1,0},{1,0},{0,-1},{0,1}}` to simplify neighbor traversal
* Always check grid boundaries during traversal
* Use `char[][]` or `String[]` to read grid in Java

---

📌 This problem is a great exercise for mastering **grid-based BFS**, used in many **game, simulation, and AI models**.

---


### 📄 NOTE

To view all 14 questions (**5 Easy**, **5 Medium**, **4 Hard**) from the Infosys preparation sheet, please check the [`assets/`](./assets/) folder of this repository where the full **PDF sheet** is stored:

📂 Path: [`assets/Infosys_Sheet.pdf`](./assets/Infosys_Sheet.pdf)
