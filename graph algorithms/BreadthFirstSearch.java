

//BFS impl
//Applications: Connected graph or not,bipartite graph or not
//for bipartite check levels if two vertex have edges in the same level than it is not bipartite
package GraphAssignment;
import java.util.Scanner;

 class BFSTraversing {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.createGraph();
	}
}

class Graph {

	private char a;
	private char vertices[];//list of vertices
	private int vertexCheckForDFS[];//check if its been discovered or found connected
	private int edges[][];//Adjacency matrix
	private char c;
	private char d;
	private int flag;
	private int max;
	private int temp1, temp2;

	class Node {
		private char value;//it can be char ,or some class defining vertex value
		private char parent;//do it source has nil or Null or 0 or '0'
		private char color;//do it initially white,then color-gray those whose neighbours have not been 
		//discovered and black whose who have been deque from the queue and has no undiscovered neighbours 
		private int distance;//distance from source node
		public Node(char value, int distance) {
			this.value = value;
			this.distance = distance;
		}

		public char getValue() {
			return value;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}
	}
	//Initialize the distance of all nodes with infinity if needed
	private Node BFSQueue[];//used queue for BFS
	private Node bfsArray[];//used array to hold after deque of the vertex holding the vertex char and distance 
	private int bfstemp;
	private int qtemp=0;
	private static int MAXIMUM = 100;//The Value can be changed according to number of nodes in a graph
	private int neighbourDepth;

	void createGraph() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Number of Vertices");
		max = sc.nextInt();
		vertices = new char[max];
		vertexCheckForDFS=new int[max];
		for (int i = 0; i < vertexCheckForDFS.length; i++) {
			vertexCheckForDFS[i]=0;
		}
		edges = new int[max][max];
		BFSQueue = new Node[max];
		bfsArray = new Node[max];
		System.out.println("Enter The Vertices");

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				edges[i][j] = 0;
			}
		}
		insert(sc);
		System.out.println("The Adjacency Matrix is");
		display();
		System.out.println("\n\nThe Adjacency List is");
		displayList();
		System.out.println("\n\nBFS Search Path With The Distance To Their Corresponding Source Vertex  is");
		bfsDisplay();
	}

	private void insert(Scanner sc) {
		flag = 0;
		System.out.println("Insert the Vertices -> ");
		for (int i = 0; i < max; i++) {
			vertices[i] = sc.next().charAt(0);
		}

		while (flag == 0) {
			System.out.println("\nEnter The edge -> ");
			c = sc.next().charAt(0);
			d = sc.next().charAt(0);
			for (int m = 0; m < max; m++) {
				if (d == vertices[m]) {
					temp2 = m;
				} else if (c == vertices[m]) {
					temp1 = m;
				}
			}

			edges[temp1][temp2] = 1;
			edges[temp2][temp1] = 1;
			System.out.println("If You Want to insert more edges: Enter Y or y");
			a = sc.next().charAt(0);
			if (!(a == 'Y'||a=='y')) {
				flag = 1;
			}
		}

	}

	private void display() {
		for (int i = 0; i < max; i++) {
			System.out.println();
			for (int j = 0; j < max; j++) {
				System.out.print(edges[i][j] + "\t");
			}
		}
	}

	private void displayList() {
		System.out.println("");
		for (int i = 0; i < max; i++) {
			System.out.println("");
			System.out.print(vertices[i]);
			for (int j = 0; j < max; j++) {
				if ((edges[i][j] == 1)) {
					System.out.print("->" + vertices[j]);
				}
			}
		}
	}

	private void bfsDisplay() {
		enqueue(vertices[0],0);//vertex at index 0 goes into the queue
		vertexCheckForDFS[0]=1;//checking the connectedness of the vertex
		bfsSearch(0);
		printBfsSequence();
	}

	private void bfsSearch(int distance) {
		char vChar = '0';
		while (!queueIsEmpty()) {
			vChar=BFSQueue[0].getValue();
			discoverNeighbours(distance+1, vChar);
			deque(0);
		}
	}

	
	private void printBfsSequence() {
		System.out.println();
		for (int i = 0; i < bfstemp; i++) {
			System.out.print(bfsArray[i].getValue() + "("
					+ bfsArray[i].getDistance() + ")");
		}
	}


	private void discoverNeighbours(int depth, char ch) {
		int temp = 0;
		for (int i = 0; i < max; i++) {
			if (vertices[i] == ch) {
				temp = i;
				break;
			}
		}
		for (int i = 0; i < max; i++) {
			if (edges[temp][i] == 1&&vertexCheckForDFS[i]==0/*checking for if already traversed*/) {
				vertexCheckForDFS[i]=1;//Setting connectedness
				enqueue(vertices[i],depth);
			}
		}

	}


	private boolean queueIsEmpty() {
		return qtemp <= 0;
	}

	private void enqueue(char ch,int depth) {
				BFSQueue[qtemp] = new Node(ch, depth);
				qtemp++;
	}

	private void deque(int minIndex) {
		if (bfstemp < max && minIndex < qtemp) {
			bfsArray[bfstemp] = BFSQueue[minIndex];
			if(bfsArray[bfstemp].getDistance()>=MAXIMUM)
			{
				bfsArray[bfstemp].setDistance(neighbourDepth);
			}
			bfstemp = bfstemp + 1;
			for (int i = minIndex; i < max - 1; i++) {
				BFSQueue[i] = BFSQueue[i + 1];
			}
			qtemp = qtemp - 1;
			
		}
	}
}
