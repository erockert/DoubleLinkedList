
package doublelinkedlist;

public class DoubleLinkedList 
{

    
    Node head;
    Node tail;
    Node temp;
    
    //Node Class
    class Node
    {
        String data;
        Node prev;
        Node next;        
        
        //Node Constructor
        Node(String d)
        {
            data = d;
            prev = null;
            next = null;
        }
    }

    public void add(String str)
    {
      Node newNode = new Node(str);
       
       if(head == null)
            {
                head =  new Node(str);
                tail = head;
            }
                else
               {
                tail.next = new Node(str);
                tail = tail.next;
               }
        
    
    }
     public boolean isEmpty() {
    
    return this.head == null;
  }
    
    public void print()
    {
        temp = this.head;
        while(temp != null)
        {     
            System.out.print(temp.data +" " );
            temp = temp.next;
        }
    }
   
    //Backwards print method
    public void printBack()
    {
              
            temp = this.tail;
            while(temp != null)
            {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
    }
    
    public static void main(String[] args) 
    {
        DoubleLinkedList Llist = new DoubleLinkedList();
        
       Llist.add("fruit");
       Llist.add("orange");
       Llist.add("banana");
       
        
        Llist.print();
        System.out.println("");
        Llist.printBack();
       
       
     
        

       // Scanner scan = new Scanner(System.in);
       // System.out.print("Enter a node to search the list. If it returns true it's in the list: ");
       // String search = scan.nextLine();
        


        /* 
        System.out.print("Enter the number of nodes: ");
        int nodeNum = scan.nextInt();
        String value;

        for(int i = nodeNum; i>0; --i)
        {
            System.out.print("Enter value to node " + nodeNum + ": ");
            value = scan.nextLine();   
            list.add(value);
           // list.print();
            nodeNum --;
        } */
        
        //sort
        /*   Node newNode = new Node(str);
       
       
        if(this.isEmpty())
       {
          this.head = newNode;
       } 
        else
       {
           tail = this.head;
           
           while(newNode.data.compareTo(tail.data) < 0)          
          {
               tail = tail.next;
               
               
               newNode = tail.next;
               
               
          }
              
           tail.next = newNode;
           newNode.prev = tail;
           newNode.next = null;
       }
       
        
        int result = newNode.data.compareTo(this.head.data);
        System.out.println(result);
        if (newNode.data.compareTo(this.head.data) < 0) 
        {
            
        }*/
    }
    
}
