public class MyArrayList <T> implements MyList{
    private T[] arr;
    private int size;
    public MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    public void increase(){
        T[] newArr = (T[]) new Object[arr.length * 2];
        for(int i=0; i<arr.length;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i<size;i++){
            if(o.equals(arr[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Object item) {
        if (size == arr.length)
            increase();
        arr[size++] = (T) item;
    }

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

    @Override
    public Object remove(int index) {
        checkIndex(index);
        for (int i = index +1 ; i<size; i++){
            arr[i-1] = arr[i];
    }
        size--;
        return null;
    }

    @Override
    public void clear() {
     for (int i=0; i<size; i++){
         arr[i] = null;
     }
     size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i=0; i<size; i++){
            if (o.equals(arr[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i=size-1; i >=0;i--){
            if (o.equals(arr[i]))
                return i;
        }
        return -1;
    }

    @Override
    public void sort() {

    }
    public void checkIndex (int index){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
    }
}
