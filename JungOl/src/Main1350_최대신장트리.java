import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1350_최대신장트리 {
	//신장 트리 중 가중치의 합이 최대가 되는 합을 출력
	static int N,M;
	static int[][] map = new int[1001][1001];
	static int[] parent = new int[1001];
	static int[][] edge = new int[20000][3];//v1, v2, w
	static int edgeCnt = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int maxW;
		int v;
		int[] T = new int[1001];
		int tCnt = 0;
		
		//Kruskal
		//Prim
		//1. 정점 하나 선택해서 T에 넣음
		//2. T에 포함되지 않은 정점 중 T에 포함되는 정점과 연결되는 간선의 가중치가 가장 큰 것 선택하고 해당 정점을 T에 넣음
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if(value>map[x][y]||value>map[y][x]) {
				map[x][y] = value;
				map[y][x] = value;
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				if(map[i][j]>0) {
					edge[edgeCnt][0] = i;
					edge[edgeCnt][1] = j;
					edge[edgeCnt][2] = map[i][j];
				}
			}
		}
		make();
		//1과 연결되는 간선의 가중치가 가장 큰 정점 선택
		T[tCnt] = 1;
		tCnt++;
		maxW = 0;
		v = 0;
		for(int i=2;i<=N;i++) {
			if(map[1][i]>maxW) {
				maxW = map[1][i];
				v=i;
			}
		}
		result +=maxW;
		parent[v] = 1;
		T[tCnt] = v;
		tCnt++;
		while(tCnt<N) {
			//T에 포함되지 않은 정점 중 T에 포함되는 정점과 연결되는 간선의 가중치가 가장 큰 것 선택하고 해당 정점을 T에 넣음
			maxW = 0;
			for(int i=0;i<tCnt;i++) {
				for(int j=1;j<=N;j++) {
					if(map[T[i]][j]>maxW && find(T[i])!=find(j)) {
						maxW = map[T[i]][j];
						v = j;
					}
				}
			}
			result+=maxW;
			union(1,v);
			T[tCnt] = v;
			tCnt++;
		}
		bw.write(""+result+"\n");
		bw.flush();
		bw.close();
	}
	public static void make() {
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
	}
	public static void union(int x, int y) {
		int parentX, parentY;
		parentX = find(x);
		parentY = find(y);
		for(int i=1;i<=N;i++) {
			if(parent[i]==parentY) {
				parent[i] = parentX;
			}
		}
	}
	public static int find(int x) {
		if(parent[x] ==x) {
			return x;
		}else {
			return parent[x]=find(parent[x]);
		}
	}
}
