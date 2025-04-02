# MyArrayList & MyLinkedList - Custom Java Collection Implementations
## 🔹 Overview
This project provides custom implementations of dynamic array (MyArrayList) and linked list (MyLinkedList), following the MyList interface. Both classes are generic, ensuring type safety and flexibility.

### Key Features:
✔ Dynamic resizing for MyArrayList (doubles in size when needed).
✔ Node-based structure for MyLinkedList (doubly linked list).
✔ Full CRUD operations (Add, Remove, Get, Search, Sort, etc.).
✔ Custom iterator methods for seamless iteration.

## 🛠 MyArrayList: Dynamic Array Implementation
MyArrayList<T> is a resizable array-based implementation that dynamically grows as elements are added. The initial capacity is 5, and when exceeded, the size doubles automatically.

### Core Functionalities:
Efficient element addition & removal.

Index-based operations with boundary checks.

Implements sorting via custom Comparator.

Includes a returnList() method to print elements sequentially.

📌 Example Constructor & Initialization:

public MyArrayList() {
    array = (T[]) new Object[DEFAULT_CAPACITY]; // Initial capacity = 5
    size = 0;
}

## 🔗 MyLinkedList: Doubly Linked List Implementation
MyLinkedList<T> follows a doubly linked list structure with a private static nested Node class. Each node contains:

data (stored element).

next (reference to the next node).

previous (reference to the previous node).

📌 Example Node Structure:

private static class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
### Core Functionalities:
✔ Efficient insertions/removals in O(1).<br>
✔ Index-based retrieval (get(index)).<br>
✔ Supports custom sorting with Comparator.<br>
✔ returnList() method for ordered traversal.<br>


### 🚀 Example Usage
Using MyArrayList <br>

MyArrayList<Integer> list = new MyArrayList<>();<br>
list.add(10);<br>
list.add(20);<br>
list.add(30);<br>
System.out.println(list.get(1)); // Output: 20 <br>

Using MyLinkedList<br>

MyLinkedList<String> linkedList = new MyLinkedList<>();<br>
linkedList.add("Alice");<br>
linkedList.add("Bob");<br>
linkedList.remove("Alice");<br>
System.out.println(linkedList.get(0)); // Output: Bob<br>

# 📜 Conclusion
This project demonstrates the implementation of custom Java collections with an emphasis on performance, scalability, and flexibility.

For further improvements or contributions, feel free to submit a pull request or open an issue on GitHub. 🚀

## 📧 Contact
**Author: Dariga Sekerbek**

**GitHub: @darigasekerbek**

**Email: darigasekerbek2@gmail.com**
