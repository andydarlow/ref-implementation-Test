Mars Rover Reference Implementation
===================

This is my implementation to demonstrate some of the ideas I'm looking for..

**The Problem**

A Mars Rover has been developed to map out the landscape. It's a small robot which can move on a grid, controlled by simple commands.
In this example, it will move on a 5x5 grid with a simple co-ordinate system - 0,0 is the bottom left, 4,4 is the top right. We can control the Rover by sending it a string consisting of commands, such as the following: RFLFFRF: R means rotate right 90 degrees, L rotate left 90 degrees, and F means move forward one square in the direction the Rover is currently facing. The Rover starts at 0,0 facing North ("up" the grid).
We need a program which will accept strings of commands at the command line, and return the grid position of the Rover after those commands.

**To Run**

mvn clean install exec:java

** Review Notes**

1. Should be using SOLID principles. For example, dependency inversion (part of SOLID) for IO ideally. I've used Google Guice for this (via dependency injection). This allows keep IO separate from the model. the use of Command Object separates  
2. Test should be there
3. Ideally a build tool is used (mvn/ant/gradles/etc)
4. Should be packaged into model and IO parts
5. Really good candidates won't have any switch statements in their code for managing direction. RobotOrientation is one way to do this (in the reference implementation)