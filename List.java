import java.io.*;

class Node{
	private Node link;
	private int info;
	
	// Creating a Node
	public Node()
	{
		link = null;
		info = 0;
	}
	
	public Node(int data)
	{
		link = null;
		info = data;
	}
	
	public Node(int data, Node n){
		link = n;
		info = data;
		
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}
}


public class List {
    private Node head;
    
	public List() {
	 head = null;	
	}
    
	public void addNode (int data){
		if (head == null){
			head = new Node();
			head.setInfo(data);
			head.setLink(null);
		}
		else{
			Node temp = new Node();
			temp.setInfo(data);
			temp.setLink(null);
			Node current = head;
			while(current.getLink()!=null){
				current = current.getLink();
			}
			current.setLink(temp);
			current=current.getLink();
		}
	}
	public int getLength(){
		int count=0;
		if (head == null){
			System.out.println("Empty List");
		return count;
		}
		else{
		count = 0;	
		Node current = head;
		while(current != null){
			current=current.getLink();
			count += 1;
		}
		return count;
		}	
	}
	public void deleteNode(int data){
		if(head == null){
			System.out.println("Linked List is Empty\n");
			}
		else if (head.getInfo() == data){
			if (head.getLink()==null){
				head = null;
			  	}
			else{
				Node current = head;
				//Node trailCurrent = head;
				head=head.getLink();
				current = null;
				//trailCurrent = null;			
				}
			}
		else{
			Node current = head;
			Node trailCurrent = head;
			current= current.getLink();
			while(current != null && current.getInfo()!=data){
				current = current.getLink();
				trailCurrent=trailCurrent.getLink();
				}
			if (current == null){
				System.out.println("No required element");
			}
			else{
				trailCurrent.setLink(current.getLink());
				current = null;
			}
		}
	}	
		public void printList(){
			Node temp = head;
			while (temp != null){
				System.out.println(temp.getInfo());
				temp = temp.getLink();
			}
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List l = new List();
        while (true){
        	System.out.println("Enter Your Choice:");
        	System.out.println("1. addNode");
        	System.out.println("2. deleteNode");
        	System.out.println("3. Exit");
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	//int i = Integer.parseInt(br.readline());
        	int option;
        	try {
        		option = Integer.parseInt(br.readLine());
        		
        		switch(option)
        		{
        		case 1:
        		{
        			System.out.println("Enter the value to be added");
        			int i = Integer.parseInt(br.readLine());
        			
        			l.addNode(i);
        			
        			break;
        		}
        		case 2:
        		{
        			System.out.println("delete the required element from the list");
        			int d = Integer.parseInt(br.readLine());
        			l.deleteNode(d);
        			break;
        			
        		}
        		case 3:System.exit(0);
        		default: 
        			{
        				System.out.println("Enter number between 1 and 3");
        				System.out.println(l.getLength());
        				l.printList();
        			}
        		
        	}
        	}catch (NumberFormatException | IOException e){
        		System.out.println("Provide valid integer number");
        	}
        }
	}

}
