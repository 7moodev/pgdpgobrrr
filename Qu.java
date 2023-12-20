import java.util.Iterator;

public class Qu implements Iterable<Qu.QueueE> {

    QueueE first;
    QueueE last;
    private int size;


    public void clear(){
        first= null;
        last=null;
        size=0;
    }

    public Qu() {
        first = null;
    }
    public void enq(int value){
        if(first ==null ){
            first = new QueueE(value);
            first.next = null;
            last = first;
            size++;
            return;
        }
            QueueE temp = new QueueE(value);
            last.next = temp;
            last =temp;
            size++;
    }
    public int deq(){
        if(first==null){
            return Integer.MAX_VALUE+1;
        }
        if(first!=last) {
            int value = 0;
            QueueE tempQ = null;
            for (QueueE temp = first; temp != null; temp = temp.next) {
                if (temp.value > value) {
                    value = temp.value;
                    tempQ = temp;
                }
            }
            for (QueueE temp = first; temp != null; temp = temp.next) {
                if (temp.next == tempQ) {
                    temp.next = tempQ.next;
                    break;
                }
                if(tempQ==first){
                    first=temp.next;
                }
            }
            size--;
            if (tempQ != null) {
                return tempQ.value;
            }
        }
        else{
                int toreturn = first.value;
                first=null;
                last=null;
                size--;
                return toreturn;
        }

        return Integer.MAX_VALUE;
    }
    public int size(){
        return size;
    }

    public String toString(){
        if(first!=null){
        String result = "";
        for(QueueE temp =first; temp!=null;  temp=temp.next){

            result+=temp.value +"-";
        }
        return result;}
        else{
            return "";
        }
    }

    @Override
    public Iterator<QueueE> iterator() {
        return new tartor(first, last);
    }
    public class tartor implements Iterator<QueueE>{
        QueueE first;
      //  QueueE last;
        public tartor(QueueE first, QueueE last) {
            this.first = first;
            //this.last = last;
        }

        @Override
        public boolean hasNext() {
            return first!=null;
        }

        @Override
        public QueueE next() {

            QueueE theG = null;
            int greatest = Integer.MAX_VALUE+1;
            if(first!=null){
            for(QueueE temp = first; temp!=null; temp=temp.next){
                if(temp.value > greatest){
                    theG = temp;
                    greatest = temp.value;
                }
            }
            for (QueueE temp = first; temp!=null; temp=temp.next){
                if(temp.next == theG){
                    temp.next = theG.next;
                    break;
                }
                if(theG == first){
                    first=first.next;
                    break;
                }
            }


            return theG;
            }
            else{
                return null;
            }
        }
    }

    public static class QueueE{
        int value;
        QueueE next;

        public QueueE(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Qu ququ = new Qu();
        ququ.enq(13);
        ququ.enq(3);
        ququ.enq(444);
        ququ.enq(6);
        ququ.enq(32);
//        System.out.println(ququ);
//        System.out.println( ququ.size);
//        System.out.println(ququ.deq());
        //ququ.clear();
        //System.out.println(ququ + "heey");
        Iterator<QueueE> iti =  ququ.iterator();
        System.out.println(iti.next().value);
        for(QueueE qu : ququ){
            System.out.print(qu.value + "--");
        }





    }
}
