import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main15686_치킨배달 {
	static int N,M;
	static int[][] map = new int[51][51];
	static int[][] cHouse = new int[13][2];//row, col
	static int[][] house = new int[101][2];//row, col
	static boolean[] isExist = new boolean[13];
	static int cnt;
	static int cnt2;
	static int minDis;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		cnt = 0;
		cnt2 = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minDis = 0;
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					house[cnt2][0] = i;
					house[cnt2][1] = j;
					cnt2++;
				}
				else if(map[i][j]==2) {
					cHouse[cnt][0] = i;
					cHouse[cnt][1] = j;
					cnt++;
				}
			}
		}
		minDis = N*N*N;
		//치킨집 M개 고르기
		for(int i=0;i<cnt-M+1;i++) {
			isExist[i] = true;
			dfs(i,1);
			isExist[i] = false;
		}
		bw.write(""+minDis+"\n");
		bw.flush();
		bw.close();
	}
	static int min(int a,int b) {
		if(a<b)return a;
		return b;
	}
	static int abs(int a) {
		if(a<0)return -a;
		return a;
	}
	static int calDis(int houseNum, int cHouseNum) {
		int r1,c1,r2,c2;
		r1 = house[houseNum][0];
		c1 = house[houseNum][1];
		r2 = cHouse[cHouseNum][0];
		c2 = cHouse[cHouseNum][1];
		int dis = abs(r1-r2)+abs(c1-c2);
		return dis;
	}
	static void dfs(int cHouseNum, int depth) {
		if(depth==M) {
			int distance = 0;
			for(int c=0;c<cnt2;c++) {
				int i,j;
				int dis = N*N;
				i = house[c][0];
				j = house[c][1];
				for(int ch=0;ch<cnt;ch++) {
					if(isExist[ch]) {
						dis = min(dis,calDis(c,ch));
					}
				}
				distance+=dis;
				if(distance>=minDis)return;
			}
			if(distance<minDis)minDis=distance;
			return;
		}
		for(int i=cHouseNum+1;i<cnt;i++) {
			isExist[i] = true;
			dfs(i,depth+1);
			isExist[i] = false;
		}
	}
}
class loc{
	int r,c;
	loc(int r, int c){
		this.r = r;
		this.c = c;
	}

}
