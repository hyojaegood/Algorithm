import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution5644_무선충전 {
	static int[][] BC = new int[9][4];//x,y, C, power
	static int xA,yA, xB,yB;
	static int M, bcNum;
	static int[] moveA = new int[100];
	static int[] moveB = new int[100];
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int sum;
		for(int tc=1;tc<=T;tc++) {
			sum = 0;
			xA = yA = 1;
			xB = yB = 10;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			bcNum = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<bcNum;i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][0] = Integer.parseInt(st.nextToken());
				BC[i][1] = Integer.parseInt(st.nextToken());
				BC[i][2] = Integer.parseInt(st.nextToken());
				BC[i][3] = Integer.parseInt(st.nextToken());
			}
			//이동
			for(int i=0;i<=M;i++) {
				//계산
				int useA, useB;
				int maxValue = 0;
				int powerA, powerB;
				for(int j=0;j<bcNum;j++) {
					if(check(j,xA,yA)) {
						useA = j;
					}else {
						useA = -1;
					}
					for(int k=0;k<bcNum;k++) {
						if(check(k,xB,yB)) {
							useB = k;
						}else {
							useB = -1;
						}
						if(useA==useB && useA>=0) {
							powerA = BC[useA][3]/2;
							powerB = BC[useA][3]/2;
						}else {
							if(useA>=0) {
								powerA = BC[useA][3];
							}else {
								powerA = 0;
							}
							if(useB>=0) {
								powerB = BC[useB][3];
							}else {
								powerB = 0;
							}
						}
						//System.out.printf("%d, %d\n",useA,useB);
						if(powerA+powerB>maxValue)maxValue =powerA+powerB;
					}
				}
				sum+=maxValue;
				//System.out.printf("[%d, %d], [%d, %d], %d\n",xA,yA,xB,yB,maxValue);
				if(i==M)break;
				//이동
				xA+=dx[moveA[i]];
				yA+=dy[moveA[i]];
				xB+=dx[moveB[i]];
				yB+=dy[moveB[i]];
			}
			bw.write("#"+tc+" "+sum+"\n");
			bw.flush();
		}
		bw.close();
	}
	public static boolean check(int bcNum, int x, int y) {
		int d = abs(x-BC[bcNum][0]) + abs(y-BC[bcNum][1]);
		if(d<=BC[bcNum][2])return true;
		else return false;
	}
	public static int abs(int a) {
		if(a<0)return -a;
		return a;
	}
}
