# Refactoring hands-on

Repository with source code of examples used in the refactoring hands-on taught by Rodrigo Martins Pagliares at UNIFAL-MG.

## 01 - refactoring-hands-on

First version of the example to be evolved during the hands-on. Although fully functional, this version has a very poor object oriented design.

### UML Class Diagram:

<p align="center">
    <img src="UML_Diagrams/01/Class_Diagram.png" alt="UML Class diagram">
</p>

### UML Sequence Diagram:
<p align="center">
    <img src="UML_Diagrams/01/Sequence_Diagram.png" alt="UML Sequence diagram">
</p>


## 02 - refactoring-hands-on

Second version of the example. This version builds upon the first version by applying the refactoring Extract Method (creation of the method quantiaDe(Locacao umaLocacao) from the method conta()).


## 03 - refactoring-hands-on

Third version of the example. This version builds upon the second version by applying the refactorings Move Method and Rename Method (Moving the method quantiaDe(Locacao umaLocacao)from the class Cliente to the class Locacao. After moving, we rename the method to lerPreco).

### UML Class Diagram:

<p align="center">
    <img src="UML_Diagrams/03/Class_Diagram.png" alt="UML Class diagram">
</p>

## 04 - refactoring-hands-on

Fourth version of the example. In this example, we apply the refactoring Replace Temp with Query to the previous version of the code. This is a type of refactoring that is not alwasy feasible due performance issues, since it demands calling a method each time it is needed instead of calling it once and storing the result in a temp variable. For simple methods like the one used in this example,  performance is not an issue, but for some complex and time consuming methods, the reafactoring Replace Temp with Query would probably not be recommended.
