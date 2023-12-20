import java.util.*;

public class maps<T, K> implements Iterable<T>{
    private int size;
     Set<T> Keys;
     ArrayList<K> Values;
     ArrayList<mapsE<T,K>> Elements;

    @Override
    public Iterator iterator() {
        return new MyIterator(Elements);
    }

    public maps() {
        this.size = 0;
        Keys = new HashSet<>();
        Values = new ArrayList<>();
        Elements = new ArrayList<>();


    }
    public void insert(T key, K value){
        if(key!=null){
        if (!Keys.contains(key)){
            Keys.add(key);
            Values.add(value);
            size++;
            Elements.add(new mapsE<T,K>(key, value));
        }
        Object oldValue= new Object();
        for (mapsE element : Elements){
            if (element.Key.equals(key)){
                oldValue= element.Value;
                element.Value = value;
            }
        }
        Values.set(Values.indexOf((K)oldValue), value);
    }}
    public T getKey(int value){
        for (mapsE<T,K> element : Elements){
            if(element.Value.equals(value)){
                return element.Key;
            }
        }
        return null;
    }
    public K getValue(T key){
        for (mapsE<T,K> element : Elements){
            if(element.Key==key){
                return element.Value;
            }
        }
        return null;
    }
    public boolean isEmpty(){
        return size<=0;
    }
    public void remove(T key){
        int index_to_remove=-1;
        for (mapsE<T,K> element : Elements){
            if(element.Key.equals(key)){

                Keys.remove(element.Key);
                size--;
                index_to_remove = Elements.indexOf(element);
            }
        }
        Elements.remove(index_to_remove);
        Values.remove(index_to_remove);

    }

    public int size(){
        return size;
    }
    public void clear(){
        Elements.clear();
        Keys.clear();
        Values.clear();
        size=0;
    }
    public boolean containsKey(T key){
        return Keys.contains(key);
    }
    public String toString(){
        String result ="";
        for (mapsE<T,K> element: Elements){
            result += "\n" +element.Key +" : " +element.Value;
        }
        return result;
    }

    public static class MyIterator<T> implements Iterator<T>{
        int index;
        ArrayList<T> Elements;
        public MyIterator(ArrayList<T> Elements) {
            this.Elements= Elements;
            index = 0;
        }

        @Override
        public boolean hasNext() {
           return index<Elements.size();
        }

        @Override
        public T next() {
            return Elements.get(index++);
        }
    }










    public static void main(String[] args) {

    }

}