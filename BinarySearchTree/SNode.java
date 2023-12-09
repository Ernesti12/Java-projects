package BinarySearchTree;

public class SNode{
    private Object item;
    private SNode next;

    //constructors
    public SNode(Object item, SNode next){
        this.item = item;
        this.next = next;
    }

    public SNode(Object item){
        this(item,null);
    }

    public SNode(){
        this(null, null);
    }

    //setters
    public void setItem(Object item){
        this.item = item;
    }

    public void setNext(SNode next){
        this.next = next;
    }
    //getters

    public Object getItem(){return item;}
    public SNode getNext(){return next;}

}
