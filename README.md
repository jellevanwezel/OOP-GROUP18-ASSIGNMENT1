1.1 Assignment 1: Intset 1
? 1.1 Assignment 1: Intset
The purpose of this assignment is to use test-first-design to implement a class for representing
sets of integers.
Remember: a set is a collection of elements (in our case integer values) in which each
element appears at most once. A set has the following operations:
• Union: C is the union of sets A and B if C contains all elements of A and B together
and no other elements.
Notation: C = A ? B.
• Intersection: C is the intersection of A and B if C contains only those elements that
are present in A and in B
Notation: C = A n B.
• Difference: C is the difference of A and B if C contains only those elements that are
present in A but not in B.
Notation: C = A \ B.
Note that C = A \ B is different from C = B \ A.
• Symmetric difference: C is the symmetric difference of A and B if C contains only
those elements that are present in A or in B but not in both. Notation: C = A ? B.
A B A B
Union A ? B Intersection A n B
A B A B
Difference A \ B Symmetric difference A ? B
Figuur 1.1: Operations on sets
• Make a new eclipse project with the given file IntSet.java as first source file.
• Use the method as described in the lectures for using Junit to test each of the given
operations carefully and completely. Take care of also testing the constructor itself.
Always first write the test(s) and then implement the corresponding code in such a way
that the test will succeed. At least the following parts need to be tested completely:
– Creating a new empty set
– Checking if a set is empty2
– Adding and removing elements from the set (including removing non-existing
elements, adding the same element twice, etc)
– Checking if an element is part of the set (with method has)
– Returning the number of elements in a set using getCount
– Creating new sets by using one or more of the above operations.
– Returning an array representation using getArray (and also test that this method
will not influence the content of the set itself)
– Returning a String-representation of the set using toString (and, again, test that
this method will not influence the content of the set itself)