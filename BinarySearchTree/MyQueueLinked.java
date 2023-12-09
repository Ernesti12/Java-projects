package BinarySearchTree;

public class MyQueueLinked extends SLinkedList{


    public void enqueue(Object item){
        addLast(item);
    }

    public Object dequeue(){
        Object item = null;
        if(!isEmpty())
        {
            item = getFirstElement();
            removeFront();
        }
        return item;
    }

    public boolean isEmpty(){
        //empty if count is zero
        return count == 0;
    }

    public void clear(){
        //keep on dequeueing, while queue is not empty
        //set count to zero
        while(!isEmpty())
            dequeue();
    }

    public Object qFront(){
        return getFirstElement();
    }

    //public String toString(){}

    public static void main(String [] args){
        //Test your methods
    }//end of main
}//end of class
