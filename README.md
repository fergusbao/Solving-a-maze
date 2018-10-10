# Solving a maze problem

This is a Java implementation of solving a maze problem. Given a maze, we are going to find the path from start position 'S' to the mouse position 'G'. https://www.cs.bu.edu/teaching/alg/maze/

Here is the sample output of the code.

This is the original maze:

S#####
.....#
#.####
#.####
...#.G
##...#

The path is made up of these '+'s in the graph below.

S#####
++xxx#
#+####
#+####
.++#+G
##+++#

'+' is the marked positions as the part of the path.
'x' is the unmarked positions.

Here is the coordinates which constitute the path,
(0, 0)->(1, 0)->(1, 1)->(2, 1)->(3, 1)->(4, 1)->(4, 2)->(5, 2)->(5, 3)->(5, 4)->(4, 4)->(4, 5)
