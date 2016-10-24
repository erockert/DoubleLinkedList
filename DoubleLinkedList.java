
package doublelinkedlist;

public class DoubleLinkedList 
{

    //making a node head
    Node head;
    //making a node tail
    Node tail;
    //making a temp node
    Node temp;
    
    //Node Class
    class Node
    {
        //making my string data
        String data;
        //making my node Prev
        Node prev;
        //Making my node next.
        Node next;        
        
        //Node Constructor
        Node(String d)
        {
            //setting data to d
            data = d;
            //setting previous to nulll
            prev = null;
            //setting next to null
            next = null;
        }
        //Making a get method for getString
        public String getString()
        {
            return this.data;
        }
        //Making a get method for Get previous
        public Node getPrev()
        {
            return this.prev;
        }
       //Making a get method for GetNExt
        public Node getNext()
        {
            return this.next;
        }
        //Set method for setString
        public void setString(String newString)
        {
            this.data = newString;
        }
        //Set previous method 
        public void setPrev(Node newPrev)
        {
            this.prev = newPrev;
        }
        //Set method for setNExt
        public void setNext(Node newNext)
        {
            this.next = newNext;
        }
    }
       public String searchString(String str)
    {
        //setting temp node to head
        Node temp = this.head;
        //while temp doesnt queal null
     while(temp != null)   
     {
         //if head getString == str
         if(head.getString()==str)
         {
             //return the head
             return head.getString();
         }
         //else if tail getString == str
         else if(tail.getString()==str)
         {
             //return the tail
             return tail.getString();
         }
         
         else if(temp.getString()!=null&& temp.getString()==str)
         {
             return temp.getString();
         }
         //setting the temp to the next of temp
         temp =temp.getNext();
     }
         return "No String exists with that name";
    }
       
       //Add method
        public void add(String str)
    {
      //making a new new for my add method 
      Node newNode = new Node(str);
      
       //If list is empty
       if(isEmpty())
            {
                //head equals the new Node
                this.head = newNode;
            }
            else
               {
                this.temp = head;
                //while temp doesnt equal null
                while(temp != null)
                {
                    //if temp equals head and temp.getString is less than 0
                    if(temp == head && temp.getString().compareTo(str) > 0)
                    {
                        //setting new node to head
                        newNode.setNext(this.head);
                        //set head to new node
                        this.head = newNode;
                        temp.setPrev(newNode);
                        break;
                    }
                    else if(temp != null && temp.getString().compareTo(str)>0)
                    {
                        //setting temp to the previous of temp       
                        temp = temp.getPrev();
                       //setting the node to previous, setting temp to Next.
                        newNode.setPrev(temp.getNext());
                        //setting temp to next, then setting next to prev
                        temp.getNext().setPrev(newNode);
                        //setting temp to next of the Node
                        temp.setNext(newNode);
                        //setting new node prev to temp
                        newNode.setPrev(temp);
                        break;
                    }
                    else if(temp.getNext() == null)
                    {
                        temp.setNext(newNode);
                        newNode.setPrev(temp);
                        this.tail = newNode;
                        break;
                    }
                  temp = temp.getNext(); 
                }
               }
    }
     public boolean isEmpty() {
    //is empty method
    return this.head == null;
  }
    
    public void print()
    {
        //setting the temp to head
        temp = this.head;
       //while temp doesnt equal null
        while(temp != null)
        {     
            System.out.print(temp.data +" " );
            // setting the temp to the next string
            temp = temp.next;
        }
    }
   
    //Backwards print method
    public void printBack()
    {
              //Setting the temp node to tail
            temp = this.tail;
            //While the tail does not equal null
            while(temp != null)
            {
                System.out.print(temp.data + " ");
                //setting temp to prev
                temp = temp.prev;
            }
    }
    public boolean deleteNode(String str)
    {
        temp = this.head;
        while(temp != null)
        {
            if(head.getString() == str)
            {
                //The next of head 
                head = head.next;
                //setting whats before head to null
                head.prev = null;
                return true;
            }
            else if(tail.getString() == str)
            {
                //setting the tail to prev
                tail = tail.prev;
                //Setting the next of tail to null
                tail.next = null;
                //Return if it is true
                return true;
            }    
            else if(temp.getNext() != null && temp.getNext().getString() == str)
            {
                //setting temp to next, then setting temp to next.getNExt
                temp.setNext(temp.getNext().getNext());
                //setting get next to Prev(temp)
                temp.getNext().setPrev(temp);
                //return true
                return true;
            }
            temp = temp.getNext();
       }
        return false;
    }
    public void deleteList()
    {
        //setting the head to null
        this.head = null;
        //setting the tail to null
        this.tail = null;
    }
    
    public static void main(String[] args) 
    {
        DoubleLinkedList Llist = new DoubleLinkedList();
        //adding fruit the the list
       Llist.add("fruit");
       //adding orange to the list
       Llist.add("orange");
       //adding banana to the list
       Llist.add("banana");
       Llist.add("purple");
       
       System.out.println("Printing the list forward:");
       Llist.print();
        System.out.println("\n"+"\nSearching for a node in the list");
       Llist.searchString("orange");
       System.out.println("Found "+Llist.searchString("orange")+" in the List" + "\n");
       System.out.println("Printing the list backwards");
       Llist.printBack();
       
       System.out.println("\n"+"\n"+"Deleting a node from the list");
       Llist.deleteNode("orange");
       Llist.printBack();
       System.out.println();
       System.out.println("\n"+"Checking if the list is empty");
       Llist.print();
       System.out.println(Llist.isEmpty());
       
       Llist.deleteNode("fruit");
       System.out.println("\n"+"Deleting another node from the list");
       Llist.printBack();
       System.out.println();
       System.out.println("\n"+"Adding a node to the list");
       Llist.add("apple");
       Llist.printBack();
       System.out.println("\n"+"\n"+"Finally printing the list out again backwards");
       Llist.print();
       System.out.println();
    }
    
}
