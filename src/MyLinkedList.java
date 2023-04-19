

import java.util.Comparator;

public class MyLinkedList<T> implements MyList<T> {
   private int size;
   private Node<T> next;
   private Node<T> previous;
   public MyLinkedList(){
       this.size=0;
       this.next = null;
       this.previous=null;
   }
   //Node class for storing the data and the link to the next node
   private static class Node<T>{
       T data;
       Node<T> a;

       public Node(T data){
           this.data = data;
           this.a = null;
       }
   }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)!=-1;
    }
    //add item to the end of list
    @Override
    public void add(Object item) {
    add(item,size);
    }
// add item at a specified index
    @Override
    public void add(Object item, int index) {
       if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
       }
    Node<T> newNode = (Node<T>) new Node<>(item);
    if(size ==0 ){
        // List is empty, so this is the first node
        next =newNode;
        previous = newNode;}
    else if (index == 0) {
        //add at the beginning of list
        newNode.a = next;
        next = newNode;}
    else if(index == size){
        //add at the end of list
        previous.a = newNode;
        previous = newNode;
    }
    else {
        // add in middle of list
        Node<T> node =getNode(index - 1);
        newNode.a = node.a;
        node.a = newNode;
      }
    size++;
   }
// Returns the node at a specified index
    private Node<T> getNode(int index) {
       Node<T> node = next;
       for(int i = 0; i<index; i++){
           node = node.a;
       }
       return node;
    }
    //remove item from list
    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }
//Removes the item at a specified index and returns it
    @Override
    public T remove(int index) {
       checkIndex(index);
       Node<T> node;
       if (size == 1){
           //Remove the only node in the list
           node = next;
           next = null;
           previous = null;
       }
       else if (index == 0){
           // Remove the first node in the list
           node = next;
           next = node.a;
       }
       else if (index == size -1 ){
           // Remove the last node in the list
           node = previous;
           previous = getNode(index-1);
           previous.a= null;
       }
       else { //Remove the middle node in the list
           Node<T> prevNode = getNode(index - 1);
           node = prevNode.a;
           prevNode.a = node.a;
       }
       size--;
       return node.data;
    }
// clear list
    @Override
    public void clear() {
    next = null;
    previous = null;
    size = 0;
    }

    @Override
    public T get(int index) {
       checkIndex(index);
       Node<T> node = getNode(index);
       return node.data;

    }
// returns index of the 1 element in list, or -1 if list does not contain the elements.
    @Override
    public int indexOf(Object o) {
       Node <T> node = next;
       for(int n = 0; n<size; n++){
           if(node.data.equals(o)){
               return n;
           }
           node = node.a;
       }
        return -1;
    }
//returns the index of last occurrence in list, or -1 if the list doesn't contain the element
    @Override
    public int lastIndexOf(Object o) {
       int lastIndex = -1;
       Node<T> node = next;
       for(int i = 0; i<size; i++){
           if(node.data.equals(o)){
               lastIndex = i;
           }
           node = node.a;
       }
        return lastIndex;
    }

// sorts list according to the order specified by the comparator
    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size <= 1) {
            return;
        }
        Node<T> unsorted = next.a;
        next.a = null;
        while (unsorted != null) {
            Node<T> node = unsorted;
            unsorted = unsorted.a;
            if (comparator.compare(node.data, next.data) < 0) {
                node.a = next;
                next = node;
            } else {
                Node<T> curr = next;
                while (curr.a != null && comparator.compare(node.data, next.data) < 0) {
                    curr = curr.a;
                }
                node.a = curr.a;
                curr.a = node;
            }
        }
    }
    // checks whether the given index is withing the bounds of the list
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    // print element of the list
    public void returnList(){
      Node<T> list2 = next;
      while (list2!=null){
          System.out.print(list2.data + " ");
          list2 = list2.a;
      }
      System.out.println();
    }
}
