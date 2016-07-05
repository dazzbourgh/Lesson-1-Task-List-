/**
 * Created by Leonid on 05.07.2016.
 */
public class MyList {
    private int value;
    private int size;
    private MyList next;

    //В конце решил запретить создавать пустой список, чтобы не было проблем с пустым первым элементом
    private MyList(){
        value = 0;
        size = 0;
        next = null;
    }

    public MyList(int pValue){
        value = pValue;
        size = 1;
        next = null;
    }

    public void add(int pValue, int index){
        if(checkSize(index + 1) || index < 0){
            System.out.println("Error: out of boundaries");
            return;
        }
        else{
            MyList iter = this;
            int indexIter = 0;
            while(indexIter != index){
                iter = iter.next;
                indexIter++;
            }
            MyList newElement = new MyList(pValue);
            if(getValue(0) == iter.value) {
                newElement.next = this;
                int temp = newElement.value;
                newElement.value = this.value;
                this.value = temp;
            }
            else{
                MyList iter2 = this;
                while(iter2.next != this){
                    iter2 = iter2.next;
                }
                iter2.next = newElement;
            }
            size++;
        }
    }

    public void add(Integer pValue, int index){
    }

    public void push_back(int pValue){
        MyList iter = this;
        while(iter.next != null){
            iter = iter.next;
        }
        MyList newElement = new MyList(pValue);
        iter.next = newElement;
        size++;
    }

    public int getValue(int index){
        if(checkSize(index + 1) || index < 0){
            System.out.println("Error: out of boundaries");
        }
        else{
            MyList iter = this;
            int indexIter = 0;
            while(indexIter != index){
                iter = iter.next;
                indexIter++;
            }
            return iter.value;
        }
        return 0;
    }

    public void push_unique(int pValue){
        if(checkUnique(pValue))
            push_back(pValue);
        else
            System.out.println("Error: list already contains that element");
    }

    public int getSize(){
        return size;
    }

    public boolean checkSize(int pValue){
        if(pValue > size - 1)
            return true;
        else
            return false;
    }
    public boolean checkUnique(int pValue){
        if(size != 0){
            MyList iter = this;
            while(iter != null){
                if(iter.value == pValue)
                    return false;
                iter = iter.next;
            }
        }
        return true;
    }

    public void delete(int pIndex){
        if(checkSize(pIndex)){
            MyList iter = this;
            int index = 0;
            while(iter.next != null){
                if(index == pIndex){
                    iter.next = iter.next.next;
                    return;
                    //А дальше пусть garbage collector разбирается
                }
                index++;
                iter = iter.next;
            }
            size--;
        }
        else
            System.out.println("Error: out of boundaries");
    }

    public void print(){
        MyList iter = this;
        while(iter.next != null){
           System.out.println(iter.value);
            iter = iter.next;
        }
        System.out.println("---------");
    }
}
