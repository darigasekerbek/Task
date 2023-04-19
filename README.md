# Task 2
MyArrayList:

MyArrayList implements the MyList interface. The class uses generics to generate an array of type T and has several methods to work with this array like adding,removing and etc.
The class initializes the array with a size of 5, and as elements are added, the size of the array increases by doubling its size.
Also its includes a checkIndex method that ensures that the given index is within the bounds of the array.

The MyArrayList class implements the following methods:
 size()
 contains(Object o)
 add(Object item)
 add(Object item, int index)
 remove(Object item)
 remove(int index)
 clear()
 get(int index)
 indexOf(Object o)
 lastIndexOf(Object o)
 sort(Comparator comparator)
 
And also includes a method returnList() that prints the items in the array in the order they appear.

MyLinkedList:
MyLinkedList also implements the MyList interface. This class is a linked list implementation, where each element of the list is stored in a node 
that contains a reference to the next node in the list.The class has a private static nested class called Node that defines the structure of a node. 
The Node class has a generic data field data, which stores the element of the list, and a reference field a, which points to the next node in the list.
The MyLinkedList class has instance fields size, next, and previous. size keeps track of the number of elements in the list, while next and previous
are references to the first and last nodes in the list, respectively. If the list is empty, both next and previous are null.

The class implements the methods of the MyList interface: 
size() 
contains(Object o)
add(Object item)
add(Object item, int index)
remove(Object item)
remove(int index)
clear()
get(int index)
indexOf(Object o)
lastIndexOf(Object o)
and sort(Comparator comparator)

And also includes a method returnList() that prints the items in the array in the order they appear.


# There is also an explanation in the form of comments in the code itself.
