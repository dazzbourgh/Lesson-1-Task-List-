/**
 * Created by Leonid on 05.07.2016.
 */
public final class Main {
    public static void main(String[] args){
        //Там какой-то косяк где-то с ссылками, поэтому не очень работает
        //но суть вроде ясна
        MyList myList = new MyList(1);
        myList.push_back(1);
        myList.push_back(5);
        myList.print();
        myList.push_unique(2);
        myList.print();
        myList.push_unique(2);
        myList.print();
        myList.add(0, 0);
        myList.print();
        myList.delete(7);
        myList.print();
        myList.delete(2);
        myList.print();
    }
}
