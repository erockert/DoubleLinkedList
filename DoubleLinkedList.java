
package doublelinkedlist;

import java.util.*;
public class DoubleLinkedList 
{

    
    Node head;
    Node current;
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

    public void add(String data)
    {
       Node newNode = new Node(data);
       
       
        if(this.isEmpty())
       {
          this.head = newNode;
       } 
        else
       {
           current = this.head;
           
           while(newNode.data.compareTo(current.data) < 0)           // while(current.next != null)
          {
               current = current.next;
               
               
               newNode = current.next;
               
               
          }
              
           current.next = newNode;
           newNode.prev = current;
           newNode.next = null;
       }
       
        
        int result = newNode.data.compareTo(this.head.data);
        System.out.println(result);
        if (newNode.data.compareTo(this.head.data) < 0) 
        {
            
        }
    }
    
  
    public boolean isEmpty()   
    {
        return this.head == null;
    }
    
    public void print()
    {
        current = this.head;
        while(current != null)
        {     
            System.out.print(current.data + "--");
            current = current.next;
        }
        System.out.print(">NULL");
    }
   
    //Backwards print method
    public void printBack()
    {
        temp = null;
        current = this.head;
        
        while(current != null)
        {     
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if(temp != null)
        {
            head = temp.prev;
        }
    }
    
    public void delete(int nodeNum)
    {
        int i = 1;
        current = head;
        
        if(nodeNum == 1)
        {
            head = current.next;
            current.next = null;
            current.prev = null;
        }
        else
        {
            while(i != nodeNum)
            {
                current = current.next;
                
                i++;  
            }
            if(current.next == null)
            {
                current.prev.next = null;
                current.prev = null;
            }
            else
            {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }
    
    public static void main(String[] args) 
    {
        DoubleLinkedList list = new DoubleLinkedList();
        
        list.add("apple");
        list.add("orange");
        list.add("banana");
        list.add("kiwi");
        list.add("grape");
        
        int deleteVal = 4;
        
        System.out.println("The List is: ");
        list.print();
        
        System.out.println("\n-------------------------------------------");
        
        System.out.println("The Backwards List is: ");
        list.printBack();
        list.print();
        
        System.out.println("\n-------------------------------------------");
       
        list.printBack();
        
        System.out.println("Now to delete node " + deleteVal + " from the list...");
       
        
        list.delete(deleteVal);
        System.out.println("The New List is: ");
        list.print();
        System.out.println("\n-------------------------------------------");
       

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
    }
    
}
