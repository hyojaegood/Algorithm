import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class J2097 {
	static int[][] adj = new int[101][101];
	static int[] dist = new int[101];
	static int N,M;
	static int minValue;
	static boolean[] visit = new boolean[101];
	static int[] prevNode = new int[101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int start, end;
		int minIdx, minValue;
		minIdx = 0;
		minValue = 100001;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = 1;
		end = M;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dist[start] = 0;
		visit[start] = true;
		for(int i=1;i<=N;i++) {
			if(i!=start) {
				if(adj[1][i]>0) {
					dist[i] = adj[1][i];
					prevNode[i] = 1;
				}else {
					dist[i] = 100001;	
				}	
			}
		}
		while(!isAll()) {
			minValue =100001;
			for(int i=1;i<=N;i++) {
				if(!visit[i]) {
					if(minValue>dist[i]) {
						minIdx = i;
						minValue = dist[i];
					}
				}
			}
			visit[minIdx] = true;
			for(int i=1;i<=N;i++) {
				if(adj[minIdx][i]>0) {
					int tmp = dist[minIdx]+adj[minIdx][i];
					if(tmp<dist[i]) {
						prevNode[i] = minIdx;
						dist[i] = tmp;
					}else {
						dist[i] = dist[i];
					}
				}
			}	
		}
		String path = "";
		int idx = M;
		while(idx!=start) {
			path = idx+" "+path;
			idx = prevNode[idx];
		}
		path = start+" "+path;
		System.out.println(dist[M]);
		System.out.println(path);
	}
	public static boolean isAll() {
		for(int i=1;i<=N;i++) {
			if(!visit[i])return false;
		}
		return true;
	}
	public static int min(int a, int b) {
		if(a<b)return a;
		return b;
	}
}
