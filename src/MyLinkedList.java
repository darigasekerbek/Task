

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
       if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
       }
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
        int index = indexOf(item);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
       checkIndex(index);
       Node<T> node;
       if (size == 1){
           node = next;
           next = null;
           previous = null;
       }
       else if (index == 0){
           node = next;
           next = node.a;
       }
       else if (index == size -1 ){
           node = previous;
           previous = getNode(index-1);
           previous.a= null;
       }
       else {
           Node<T> prevNode = getNode(index - 1);
           node = prevNode.a;
           prevNode.a = node.a;
       }
       size--;
       return node.data;
    }

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
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
    public void returnList(){
      Node<T> list2 = next;
      while (list2!=null){
          System.out.print(list2.data + " ");
          list2 = list2.a;
      }
      System.out.println();
    }
}
