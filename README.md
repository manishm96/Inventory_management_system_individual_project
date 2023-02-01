# individual-project-manishm96
# CMPE 202 Individual Project

## Name: Manish Mapakshi
## SJSU ID: 015926729

## Problem Statement
Design and implement a Java application which maintains an internal, static database. There is a limit on the number of items that can be added to the cart based on the category it comes under. Based on the categories, Essentials are restricted to a maximum of 3, Luxury to 4 and Miscellaneous to 6. The application validates if the requested quantity for each item is allowed or not. If the cart is valid, then this application adds prices and displays the total amount by using card details. The output will be saved in a “.csv” file. If the cart does not get validated, then the error message with the items whose quantity has to be changed to successfully proceed with billing will be updated on “.TXT” file.
## Design Patterns 

2 Design patterns, namely Chain of responsibility and Builder patterns are used in this project. Chain of responsibility is a behavioral design pattern and Builder is a creational design pattern.

### Chain of Responsibility 

In object oriented design, the chain-of-responsibility pattern is a behavioral design pattern consisting of a source of command objects and a series of processing objects. Each processing object contains logic that defines the types of command objects that it can handle; the rest are passed to the next processing object in the chain. A mechanism also exists for adding new processing objects to the end of this chain. Chain of responsibility pattern is used to achieve loose coupling in software design where a request from the client is passed to a chain of objects to process them. Later, the object in the chain will decide themselves who will be processing the request and whether the request is required to be sent to the next object in the chain or not.

### Builder 

Builder pattern aims to “Separate the construction of a complex object from its representation so that the same construction process can create different representations.” It is used to construct a complex object step by step and the final step will return the object. The process of constructing an object should be generic so that it can be used to create different representations of the same object.


## Instructions

Requirements: 
IDE: Eclipse IDE
Maven

* Open the repository gopinathsjsu/individual-project-manishm96 and clone the repository or download a zip file of the project.
* Open the project in Eclipse IDE.
* Java SE 18 should be installed to run this project if the project isn't running.
* Open Billing.java file and add  dataset.csv document that you want to use in the cdv reader.
* There are two types of datasets in my project. One is "Dataset - Sheet1.csv" which contains items as its first column and category as its second column. For this dataset, you can use "Input1 - Sheet1.csv" as the input file. Second type is "Inventory.csv" which consists of categories in the first column and items in the second column. For this to run, you'll have to swap the values of entrees[1] and entrees[0] in line 136 and 137 of "Billing.java" file to entrees[0] and entrees[1], compile it and run it and provide "input.csv" or "input1.csv" to proceed.
* If you want to continue with the existing dataset that is already given by me, run the Billing.java file and    give the input file name in the console.
* You can see the output of updated cart with output in “Output.txt” file.
* If the number of  permissive items for a particular category exceeds, then you can see the items whose quantity needs to be changed in “Error.txt”.




