# Coding Challenges

______________________________
**Almost Palindrome**
----------------------
A string is an almost-palindrome if, by changing only one character, you can make it a palindrome. Create a function
that returns true if a string is an almost-palindrome and false otherwise.

Examples:  
almostPalindrome("abcdcbg") ➞ true  
// Transformed to "abcdcba" by changing "g" to "a".

almostPalindrome("abccia") ➞ true  
// Transformed to "abccba" by changing "i" to "b".

almostPalindrome("abcdaaa") ➞ false  
// Can't be transformed to a palindrome in exactly 1 turn.

almostPalindrome("1234312") ➞ false

**Staircase of Recursion**
---------------------------
Write a function that returns the number of ways a person can climb n stairs, where the person may only climb 1 or 2
steps at a time.

To illustrate, if n = 4 there are 5 ways to climb:

[1, 1, 1, 1]  
[2, 1, 1]  
[1, 2, 1]  
[1, 1, 2]  
[2, 2]

<ins> Examples </ins> <br/>
waysToClimb(1) ➞ 1 <br/>
waysToClimb(2) ➞ 2 <br/>
waysToClimb(5) ➞ 8

Notes:
A staircase of height 0 should return 1.

**Heteromecic**
----------------------
A pronic number (or otherwise called as heteromecic) is a number which is a product of two consecutive integers, that
is, a number of the form n(n + 1). Create a function that determines whether a number is pronic or not.

<ins> Examples </ins> <br/>
isHeteromecic(0) ➞ true
// 0 (0 + 1) = 0 1 = 0

isHeteromecic(2) ➞ true // 1 (1 + 1) = 1 2 = 2

isHeteromecic(7) ➞ false

isHeteromecic(110) ➞ true // 10 (10 + 1) = 10 11 = 110

isHeteromecic(136) ➞ false

isHeteromecic(156) ➞ true

**New Number From Squares**
---------------------------
Given any number, we can create a new number by adding the sums of squares of digits of that number  
For example, given 203, our new number is 4 + 0 + 9 = 13. If we repeat this process, we get a sequence of numbers:

<ins> Examples </ins> <br/>
happy(203) ➞ false

happy(11) ➞ true

happy(107) ➞ true

Notes:
You can assume (and it is actually true!) that all positive whole numbers are either happy or unhappy. Any happy number
will have a 1 in its sequence, and every unhappy number will have a 4 in its sequence. The only numbers passed to your
function will be positive whole numbers.

**Median of Two Sorted Arrays**
---------------------------
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



<ins> Example 1 </ins> <br>
Input: nums1 = [1,3], nums2 = [2]  <br>
Output: 2.00000  <br>
Explanation: merged array = [1,2,3] and median is 2. <br> <br>

<ins> Example 2 </ins> <br>  
Input: nums1 = [1,2], nums2 = [3,4]  <br>
Output: 2.50000  <br>
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.  <br><br>


<ins> Constraints </ins> <br>
&nbsp; nums1.length == m  <br>
&nbsp; nums2.length == n  <br>
&nbsp; 0 <= m <= 1000  <br>
&nbsp; 0 <= n <= 1000  <br>
&nbsp; 1 <= m + n <= 2000  <br>
&nbsp; -106 <= nums1[i], nums2[i] <= 106  

**Regular Expression Matching**
---------------------------
Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element. The matching should cover the entire input string (not partial).

<ins> Example 1 </ins> <br>
Input: s = "aa", p = "a" <br>
Output: false <br>
Explanation: "a" does not match the entire string "aa". <br> <br>

<ins> Example 2 </ins> <br>
Input: s = "aa", p = "a*" <br>
Output: true <br>
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa". <br> <br>

<ins> Example 3 </ins> <br>
Input: s = "ab", p = ".*" <br>
Output: true <br>
Explanation: ".*" means "zero or more (*) of any character (.)". <br> <br>


<ins> Constraints </ins> <br>
1 <= s.length <= 20 <br>
1 <= p.length <= 30 <br>
s contains only lowercase English letters. <br>
p contains only lowercase English letters, '.', and '*'. <br>
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.

**The Longest Valid Parentheses**
---------------------------
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
parentheses substring.

<ins> Example 1 </ins> <br>
Input: s = "(()" <br>
Output: 2 <br>
Explanation: The longest valid parentheses' substring is "()". <br> <br>

<ins> Example 2 </ins> <br>
Input: s = ")()())" <br>
Output: 4 <br>
Explanation: The longest valid parentheses' substring is "()()". <br><br>

<ins> Example 3 </ins> <br>
Input: s = "" <br>
Output: 0 <br><br>


<ins> Constraints </ins> <br>
0 <= s.length <= 3 * 104 <br>
s[i] is '(', or ')'.

<!-- Add information about QueensAttack, SmallestInt, UnchangedIndex, FavoriteNum, and CanWin -->