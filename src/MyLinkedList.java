

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

    @Override
    public void add(Object item) {
    add(item,size);
    }

    @Override
    public void add(Object item, int index) {
    checkIndex(index);
    Node<T> newNode = (Node<T>) new Node<>(item);
    if(size ==0 ){
        next =newNode;
        previous = newNode;}
    else if (index == 0) {
        newNode.a = next;
        next = newNode;}
    else if(index == size){
        previous.a = newNode;
        previous = newNode;
    }
    else {
        Node<T> node =getNode(index - 1);
        newNode.a = node.a;
        node.a = newNode;
      }
    size++;
   }

    private Node<T> getNode(int index) {
       Node<T> node = next;
       for(int i = 0; i<index; i++){
           node = node.a;
       }
       return node;
    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort(Comparator comparator) {

    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
