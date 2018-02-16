import java.util.*;
class Node{
  Node prev, next;
  int key;
  String data;
  public Node(){}
  public Node(int key, String data){
    this.data = data;
    this.key = key;
  }
}
class DoublyLinkedList{
  Node tail, head;
  public Node insertHead(int key, String data){
    Node newNode = new Node(key, data);
    if(head == null){
      head = newNode;
      tail = newNode;
    }
    else{
      head.prev = newNode;
      newNode.next = head;
      head = newNode;
    }
    return head;
  }
  public Node insertTail(int key, String data){
    Node newNode = new Node(key, data);
    if(tail == null){
      tail = newNode;
      head = newNode;
    }
    else{
      tail.prev = newNode;
      newNode.next = tail;
      tail = newNode;
    }
    return tail;
  }
  public boolean delete(int key){
    Node temp;
    if(head == null){
      return false;
    }
    else{
      if(head == tail){
        if(head.key == tail.key){
            head = tail = null;
            return true;
        }
        else{
            return false;
        }
      }
      else if(head.key == key){
          temp = head.next;
          head = null;
          head = temp;
          return true;
      }
      else if(tail.key == key){
        temp = tail.prev;
        tail = null;
        tail = temp;
        return true;
      }
      else{
        Node currentNode, nodeToBeDeleted;
        currentNode = head;
        while(currentNode != null){
          if(currentNode.key == key){
              nodeToBeDeleted = currentNode;
              currentNode.prev.next = nodeToBeDeleted.next;
              currentNode.next.prev = nodeToBeDeleted.prev;
              return true;
          }
          currentNode = currentNode.next;
        }
      }
    }
    return false;
  }
  public void displayForward(){
    Node temp = new Node();
    temp = head;
    while(temp != null){
      System.out.println(temp.key);
      temp = temp.next;
    }
  }
  public void displayBackward(){
    Node temp = new Node();
    temp = tail;
    while(temp != null){
      System.out.println(temp.key);
      temp = temp.prev;
    }
  }
}
class Main{
  public static void main(String []args){
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    int choice = 1;
      Scanner scanner = new Scanner(System.in);
      while(choice != 0){
        System.out.println("\n(1) Insert from head \n(2) Insert from Tail \n(3) Delete an Element \n(4) Display List From head to tail \n(5) Display List from tail to head \n(0) Exit");
        System.out.println("\nEnter your Choice (1, 2...0) : ");
        choice = scanner.nextInt();
        switch(choice){
          case 1:
            System.out.println("\nEnter a key:");
            int key = scanner.nextInt();
            System.out.println("\nEnter data:");
            String data = scanner.next();
            doublyLinkedList.head = doublyLinkedList.insertHead(key, data);
          break;
          case 2:
            System.out.println("\nEnter a key:");
            key = scanner.nextInt();
            System.out.println("\nEnter data:");
            data = scanner.next();
            doublyLinkedList.tail = doublyLinkedList.insertTail(key, data);
          break;
          case 3:
            System.out.println("\nEnter key of data value to be deleted:\n");
            key = scanner.nextInt();
            if(doublyLinkedList.delete(key)){
              System.out.println("\nData deleted!");
            }
            else{
              System.out.println("\nData not fount!");
            }
          break;
          case 4:
            System.out.println("\nDisplay List from head to tail:\n");
            doublyLinkedList.displayForward();
          break;
          case 5:
            System.out.println("\nDisplay List from tail to head\n");
            doublyLinkedList.displayBackward();
          break;
        }
      }
    }
}
