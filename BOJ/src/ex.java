import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ex {

	public static int[] dy = {-1,-1,-1, 0, 0, 1, 1, 1}, dx = {-1, 0, 1,-1, 1,-1, 0, 1};
	public static Deque<Tree> treeList = new ArrayDeque<>();
	public static int[][] ground, A;
	public static int N,M,K;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = toInteger(input[0]);
		M = toInteger(input[1]);
		K = toInteger(input[2]);
		
		ground = new int[N+1][N+1];
		A = new int[N+1][N+1];
		
		for(int[] arr : ground)
			Arrays.fill(arr, 5);
		
		for(int i=1 ; i<=N ; i++) {
			input = br.readLine().split(" ");
			for(int j=1 ; j<=N ; j++) {
				A[i][j] = toInteger(input[j-1]);
			}
		}
		
		Tree[] arr = new Tree[M];
		for(int i=0 ; i<M ; i++) {
			input = br.readLine().split(" ");
			arr[i] = new Tree(toInteger(input[0]),toInteger(input[1]),toInteger(input[2]));
		}
		
		Arrays.sort(arr);
	
		after_K_year(arr);
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
	}
	
	public static void after_K_year(Tree[] inputTree) {		
		Deque<Tree> deadTree = new ArrayDeque<>();
		Deque<Tree> spreadTree = new ArrayDeque<>();
				
		for(Tree t : inputTree)
			treeList.addLast(t);
		
		for(int i=0 ; i<K ; i++) {			
			spring(deadTree, spreadTree);
			summer(deadTree);
			fall(spreadTree);
			winter();
		}
		 
		System.out.println(treeList.size());
	}
	
	public static void spring(Deque<Tree> deadTree, Deque<Tree> spreadTree) {
		int size = treeList.size();
		
		while(size > 0) {
			size--;
			Tree t = treeList.removeFirst();
			
			if(ground[t.y][t.x] < t.age) {
				deadTree.push(t);
				continue;
			}				
			
			ground[t.y][t.x] -= t.age;
			t.age += 1;
			treeList.addLast(t);
			
			if(t.age%5 == 0)
				spreadTree.push(t);
		}
	}
	
	public static void summer(Deque<Tree> deadTree) {
		while(!deadTree.isEmpty()) {
			Tree t = deadTree.pop();
			ground[t.y][t.x] += t.age/2;
		}					
	}
	
	public static void fall(Deque<Tree> spreadTree) {
		while(!spreadTree.isEmpty()) {
			Tree t = spreadTree.pop();
			spread(t);
		}
	}
	
	public static void winter() {		
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=N ; j++) {
				ground[i][j] += A[i][j];
			}
		}				
	}
	
	public static void spread(Tree t) {		
		for(int i=0 ; i<8 ; i++) {
			int ny = t.y + dy[i];
			int nx = t.x + dx[i];
			
			if(ny>N || nx>N || ny<1 || nx<1)
				continue;
			
			treeList.addFirst(new Tree(ny,nx,1));
		}
	}
	
	public static int toInteger(String str) {
		return Integer.parseInt(str);
	}

}

class Tree implements Comparable<Tree>{
	int y, x, age;
	
	public Tree(int y, int x, int age) {
		// TODO Auto-generated constructor stub
		this.y = y;
		this.x = x;
		this.age = age;
	}

	@Override
	public int compareTo(Tree t) {
		// TODO Auto-generated method stub
		if(this.age > t.age)		return  1;
		else if(this.age < t.age)	return -1;
		else						return  0;
	}	
}
