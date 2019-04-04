import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main12100_2048Easy {
	static int[][] map = new int[21][21];
	static int N;
	static int maxValue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[][] saveMap = new int[21][21];
		maxValue = 0;
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(maxValue<map[i][j])maxValue=map[i][j];
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<N;j++)saveMap[j] = map[j].clone();
			move(i,0);
			for(int j=0;j<N;j++)map[j] = saveMap[j].clone();
		}
		System.out.println(maxValue);
	}
	public static void crush(int dir) {
		if(dir == 0) {
			for(int i=0;i<N-1;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==map[i+1][j]) {
						map[i][j] *= 2;
						map[i+1][j] = 0;
						if(maxValue<map[i][j])maxValue=map[i][j];
					}
				}
			}
		}else if(dir==1) {
			for(int i=N-1;i>=1;i--) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==map[i-1][j]) {
						map[i][j] *= 2;
						map[i-1][j] = 0;
						if(maxValue<map[i][j])maxValue=map[i][j];
					}
				}
			}
		}else if(dir==2) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-1;j++) {
					if(map[i][j]==map[i][j+1]) {
						map[i][j] *= 2;
						map[i][j+1] = 0;
						if(maxValue<map[i][j])maxValue=map[i][j];
					}
				}
			}
		}else {
			for(int i=0;i<N;i++) {
				for(int j=N-1;j>=1;j--) {
					if(map[i][j]==map[i][j-1]) {
						map[i][j] *= 2;
						map[i][j-1] = 0;
						if(maxValue<map[i][j])maxValue=map[i][j];
					}
				}
			}
		}
	}
	public static void move(int dir, int depth) {
		int[][] saveMap = new int[21][21];
		if(depth==5) {
			return;
		}else {
			//이동
//			System.out.println(dir);
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.printf("%d",map[i][j]);
//				}System.out.println();
//			}
//			System.out.println("VVVVVVVVVVVVV");
			push(dir);
			crush(dir);
			push(dir);
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.printf("%d",map[i][j]);
//				}System.out.println();
//			}System.out.println("-------------");
			for(int i=0;i<4;i++) {
				for(int j=0;j<N;j++) {
					saveMap[j] = map[j].clone();
				}
				move(i,depth+1);
				for(int j=0;j<N;j++) {
					map[j] = saveMap[j].clone();
				}
			}
		}
	}
	public static void push(int dir) {
		int target;
		if(dir==0) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]!=0) {
						target = -1;
						for(int k=i-1;k>=0;k--) {
							if(map[k][j]==0) {
								target = k;
							}
						}
						if(target>=0) {
							map[target][j] = map[i][j];	
							map[i][j] = 0;
						}
					}
				}
			}
		}else if(dir==1) {
			for(int i=N-1;i>=0;i--) {
				for(int j=0;j<N;j++) {
					if(map[i][j]!=0) {
						target = -1;
						for(int k=i+1;k<N;k++) {
							if(map[k][j]==0) {
								target = k;
							}
						}
						if(target>=0) {
							map[target][j] = map[i][j];	
							map[i][j] = 0;
						}
					}
				}
			}
		}else if(dir==2) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[j][i]!=0) {
						target = -1;
						for(int k=i-1;k>=0;k--) {
							if(map[j][k]==0) {
								target = k;
							}
						}
						if(target>=0) {
							map[j][target] = map[j][i];
							map[j][i] = 0;
						}
					}
				}
			}
		}else {
			for(int i=N;i>=0;i--) {
				for(int j=0;j<N;j++) {
					if(map[j][i]!=0) {
						target = -1;
						for(int k=i+1;k<N;k++) {
							if(map[j][k]==0) {
								target = k;
							}
						}
						if(target>=0) {
							map[j][target] = map[j][i];
							map[j][i] = 0;
						}
					}
				}
			}
		}
	}

}
