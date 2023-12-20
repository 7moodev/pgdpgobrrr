import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pist implements Iterable<Pist.PistE> {
    PistE first;
    PistE last;
    int size;

    public Pist() {
    }

    public void add(int value) {
        if (first == null) {
            first = new PistE(value);
            last = first;
            last.setIndex(size);
            size++;
            return;

        }
        if (first.next == null) {
            first.next = new PistE(value);
            first.next.prev = first;
            last = first.next;
            size++;
            return;
        } else {
            last.next = new PistE(value);
            last.next.prev = last;
            last = last.next;
            size++;
        }
    }

    public void removeLast() {
        if (size == 1) {
            last = null;
            first = null;
            size--;
        }
        if (last != null) {
            last.prev.next = null;
            last = last.prev;
            size--;
        }

    }

    //    public void removeAtIndex(int index){
//        ()
//    }
    public String toString() {
        if (first != null) {
            String sting = "";
            for (PistE temp = first; temp != null; temp = temp.next) {
                sting += temp.value + ", ";
            }
            return sting.substring(0, sting.length() - 2);
        }
        return "";
    }

    @Override
    public Iterator<PistE> iterator() {

        return new tartor(first, last);
    }

    public class tartor implements Iterator<PistE> {
        PistE first;
        PistE last;
        boolean forward;

        public tartor(PistE first, PistE last) {
            this.last = last;
            this.first = first;
            forward = false;


        }

        @Override
        public boolean hasNext() {

            //  System.out.println("First :" + first.value + "Last :" +last.value );
            return first.prev != last;

        }

        @Override
        public PistE next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (!forward) {
                PistE temp = first;
                first = first.next;
                forward = true;
                return temp;
            }
            PistE temp = last;
            last = last.prev;
            forward = false;

            return temp;
        }
    }

    public Pist reverseList() {
        Pist reversedPist = new Pist();

        if (this.first != null) {
            reversedPist.first = reverse(this.first);
        }

        return reversedPist;
    }

    private PistE reverse(PistE first) {
        if (first == null || first.next == null) {
            return first;
        }

        PistE reversedfirst = reverse(first.next);
        first.next.next = first;
        first.next = null;

        return reversedfirst;
    }


    public class PistE {
        private int index;
        PistE next;
        PistE prev;
        private int value;

        public PistE(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Pist pisto = new Pist();
        System.out.println(pisto);
        pisto.add(1);
        System.out.println(pisto);
        pisto.add(3);
        pisto.add(5);
        pisto.add(7);
        pisto.add(9);
        pisto.add(10);
        pisto.add(8);
        pisto.add(6);
        pisto.add(4);
        pisto.add(2);
        System.out.println(pisto);
//        Iterator<PistE> iti = pisto.iterator();
//        while(iti.hasNext()){
//            System.out.print(iti.next().value+"-");
//        }
//      for(PistE pi : pisto){
//              System.out.print(pi.value+"-");
//      }


        System.out.println(pisto.reverseList());

    }

}