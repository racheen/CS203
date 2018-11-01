/*Tumulak, Rachel
 *CS203
 *2CSA
 *Lab Exercise 8 
 */
public class SLL<T>{
   private SLLNode<T> head, tail;
   public String toString(){
       SLLNode<T> p;
       String s = "";
       for (p = head; p != null; p = p.next)
           s = s + p.info.toString() + " ";
       return s;
   }
   public void addToHead(T el){
       head = new SLLNode<T>(el, head);
       if(tail == null)
           tail = head;
   }
   public T deleteFromHead(){
       if (isEmpty()) return null;
       T el = head.info;
       if (head == tail)
           head = tail = null;
       else{
           tail = head.next;
       }
       return el;
   }
   public void addToTail(T el){
       if (isEmpty()) head = tail = new SLLNode<T>(el, null);
       else{
           tail.next = new SLLNode<T>(el, null);
           tail = tail.next;
       }
   }
   public boolean isEmpty(){
       if (head == null) return true;
       else return false;
   }
   public T deleteFromTail(){
       if (isEmpty()) return null;
       T el = tail.info;
       if (head == tail)
           head = tail = null;
       else{
           SLLNode<T> p;
           for (p=head; p.next != tail; p = p.next);
           tail = p;
           tail.next = null;
       }
       return el;
   }
   public T find(T info){
       SLLNode<T> p = head;
       while(p != null && p.info != info)
           p = p.next;
       return (T)p;
   }
   public void insertAsc(T info){
       SLLNode<T> p = head;
       if (isEmpty()) addToHead(info);
       else{
           if(((Comparable)tail.info).compareTo(info) <= -1){//tail is less than info
               addToTail(info);
           }
           else if(((Comparable)head.info).compareTo(info) >= 1){
               addToHead(info);
           }
           else{
               while(((Comparable)p.info).compareTo(info) <= -1)//while p is less than the info
                   p = p.next;
               if (((Comparable)p.info).compareTo(info) <= -1)//p is less than info
                   addBefore(info, p.next);
               else
                   addBefore(info, p);
           }
       }
   }
   public void addBefore(T el, SLLNode<T> n){
      if (isEmpty() || n.info == head.info)
          addToHead(el);
      else {
      SLLNode<T> p = null;
      SLLNode<T> c = head;
      while (c != null && c.info != n.info) {
          p = c;
          c = c.next;
      }
      if (c != null)
          p.next = new SLLNode(el, n);
      else
          addToTail(el);
      }
  }
   
   public SLL mergeWithoutDups(SLL slist2){
        SLL<T> slist = new SLL<T>();
        SLLNode<T> p1 = this.head;
        SLLNode<T> p2 = slist2.head;
        
        while(this.isEmpty() == false || slist2.isEmpty()==false){
            if(((Comparable)slist2.head.info).compareTo((Comparable)this.head.info) <= 0){
            //if((Integer)slist2.head.info >= (Integer)this.head.info){
                slist.addToTail((T)this.deleteFromHead());
            }
            else{
                slist.addToTail((T)slist2.deleteFromHead());
            }
        }
        if(this.isEmpty()){
            while(slist2.isEmpty() == false){
                slist.addToTail((T)slist2.deleteFromHead());
            }
        }
        if(slist2.isEmpty()){
            while(this.isEmpty() == false){
                slist.addToTail((T)this.deleteFromHead());
            }
        }
        return slist;
   }
   
}

