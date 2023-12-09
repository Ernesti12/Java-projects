package BinarySearchTree;

/*
 List Operations:
 1. addFront()
 2. addLast()
 3. insertItemAt()
 4. removeFront()
 5. removeLast()
 6. removeItemAt()
 7. isEmpty()
 8. getPosition()
 9. isFound()
*/

public class SLinkedList{
    SNode head;
    SNode tail;
    int count;

    //constructor
    public SLinkedList(){
        head = tail = null;
        count = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFront(Object item){
        SNode node = new SNode(item);
        if(isEmpty())
            head = tail = node;
        else{
            node.setNext(head);
            head = node;
        }
        count++;
    }

    public void addLast(Object item){
        SNode node = new SNode(item);
        if(isEmpty())
            tail = head = node;
        else{
            tail.setNext(node);
            tail = node;
        }
        count++;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for(SNode p = head; p != null; p = p.getNext())
            sb.append(p.getItem() + " ");
        sb.append("}");
        return sb.toString();
    }

    public void removeFront(){
        if(!isEmpty())
        {
            SNode p = head;
            head = head.getNext();
            p.setNext(null);
            count--;
        }
    }

    public void removeLast(){
        if(!isEmpty()){
            if(count == 1) tail = head = null;
            else{
                SNode prev = head;
                SNode p = head.getNext();
                while(p.getNext() != null){
                    p = p.getNext();
                    prev = prev.getNext();
                }
                prev.setNext(null);
                tail = prev;
            }
            count--;
        }
    }

    public int getPosition(Object item){
        int pos = 0;
        int cnt = 0;//location
        for(SNode p = head; p != null; p=p.getNext()){
            cnt++;
            if(p.getItem().equals(item)){
                pos = cnt; break;
            }
        }
        return pos;
    }

    public void removeItemAt(int location){
        if(location >= 1 && location <= count){
            if(location == 1) {tail = head = null; count--;}//removeFront();
            else if (location == count) removeLast();
            else{
                SNode prev = head;
                SNode p = head.getNext();
                int cnt = 1;
                while(++cnt != location && p != null){
                    prev = prev.getNext();
                    p = p.getNext();
                }
                prev.setNext(p.getNext());
                //disconnect p
                p.setNext(null);
            }
            count--;
        }
    }
    //insertItemAt

    public boolean isFound(Object item){
        boolean found = false;
        for(SNode p = head; p != null; p = p.getNext())
            if(p.getItem().equals(item))
            {
                found = true; break;
            }
        return found;
    }

    public Object getFirstElement(){
        return isEmpty()?null:head.getItem();
    }

    public Object getLastElement(){
        return isEmpty()?null: tail.getItem();
    }
    public static void main(String [] args){
        SLinkedList list  = new SLinkedList();
        list.addFront(5);
        list.addFront(6);
        list.addFront(1);
        list.addFront(2);
        System.out.println("list contains:" + list);
        list.removeLast();
        list.removeLast();
        //list.removeLast();
        // list.removeLast();
        list.removeLast();
        list.addFront(4);
        list.addFront(5);
        list.addFront(6);
        list.addFront(10);
        list.addFront(15);
        System.out.println("list contains:" + list);
        System.out.println("Item 100 is at location:" + list.getPosition(100));
        list.removeItemAt(5);
        System.out.println("list contains:" + list);
    }
}
