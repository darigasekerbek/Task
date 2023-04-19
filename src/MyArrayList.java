import java.util.Comparator;

// constructor which init arr capacity of 5, size of 0
public class MyArrayList <T> implements MyList{
    private T[] arr;
    private int size;
    public MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    // method which increase the size by doubling
    public void increase(){
        T[] newArr = (T[]) new Object[arr.length * 2];
        for(int i=0; i<arr.length;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    // return the size of array
    @Override
    public int size() {
        return size;
    }
    //checks if array contains the given object and returns true if it does, and false otherwise
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i<size;i++){
            if(o.equals(arr[i])){
                return true;
            }
        }
        return false;
    }
    // adds an item to the end of array, if necessary its increase size of array
    @Override
    public void add(Object item) {
        if (size == arr.length)
            increase();
        arr[size++] = (T) item;
    }
    // adds an item at a certain index in arr, move all items to the right of the index by 1 position
    @Override
    public void add(Object item, int index) {
    if(index < 0 && index >= size){
        throw new IndexOutOfBoundsException(index + size);}
    else {
      if (size == arr.length)
        increase();
      for (int i = size - 1; i>=index; i--){
          arr[i+1] = arr[i];
      }
      arr[index] = (T) item;
      size++;
    }
    }
    // Removes the 1 element of the given obj from arr, moving all items to the right of the obj to the left by 1 position
    //return true if the obj was found and removed
    @Override
    public boolean remove(Object item) {
        for (int index = 0; index <size;index++){
            if(item.equals(arr[index])){
                remove(index);
                return true;
            }
        }
        return false;
    }
// removes the item at the specified index, move all items to the right of the index to the left by 1 position
    // return the removed item
    @Override
    public Object remove(int index) {
        checkIndex(index);
        for (int i = index +1 ; i<size; i++){
            arr[i-1] = arr[i];
    }
        size--;
        return null;
    }
//clear array by setting all items to null and resetting the size to 0
    @Override
    public void clear() {
     for (int i=0; i<size; i++){
         arr[i] = null;
     }
     size = 0;
    }

    // return the item at the certain index
    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
// return index of the first element of the given obj, or -1 if it isn't found
    @Override
    public int indexOf(Object o) {
        for (int i=0; i<size; i++){
            if (o.equals(arr[i]))
                return i;
        }
        return -1;
    }
// finds the index of the last element of the given obj in array
    @Override
    public int lastIndexOf(Object o) {
        for (int i=size-1; i >=0;i--){
            if (o.equals(arr[i]))
                return i;
        }
        return -1;
    }

//sorts array using comparator
    @Override
    public void sort(Comparator comparator) {
        //Loop through array until no more swaps are needed
     boolean swapped;
     do {
         swapped = false;
         //Compare adjacent  elements and swap them they are not in correct order
         for(int i=0; i<size - 1; i++){
             if (comparator.compare(arr[i], arr[i+1])>0){
                 T temp = arr[i];
                 arr[i] = arr[i+1];
                 arr[i+1] = temp;
                 swapped = true;

             }
         }
     } while (swapped);
    }
// checkd if given index is valid for array
    public void checkIndex (int index){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
    }
    // print all elements in the array
    public void returnList(){
        for (int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
