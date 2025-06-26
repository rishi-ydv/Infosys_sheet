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
- **Type 1 (Update):** `1 l r`  
  Replace `A[i] = (i - l + 1) * A[l]` for all `i` in the range `[l, r]`.

- **Type 2 (Sum):** `2 l r`  
  Return the sum of elements from `A[l]` to `A[r]`.

You need to return the **sum of answers to all Type 2 queries**, modulo `10^9 + 7`.

---

### 📥 Sample Input 1
<pre>
7
1 4 5 1 6 7 8
5
1 1 6
1 1 5
2 5 5
2 3 4
2 3 3
</pre>

### 📤 Sample Output 1
<pre>60</pre>


<pre>⏱ Time Complexity
Operation	Complexity
Type 1 Query	O(r - l + 1)
Type 2 Query	O(r - l + 1)
Total (Worst Case)	O(q × n)

📝 In the worst case, if each query affects the whole array (n = 10^5 and q = 10^5), it becomes O(n × q) = 10^10 operations (not efficient for tight time limits, but acceptable here as per sample cases).

📦 Space Complexity
Component	Space
Array A	O(n)
Queries	O(q)
Total	O(n + q)</pre>

### 📄 NOTE

To view all 14 questions (**5 Easy**, **5 Medium**, **4 Hard**) from the Infosys preparation sheet, please check the [`assets/`](./assets/) folder of this repository where the full **PDF sheet** is stored:

📂 Path: [`assets/Infosys_Sheet.pdf`](./assets/Infosys_Sheet.pdf)
