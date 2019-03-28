import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2477_차량정비소 {
	static int[] a = new int[10];
	static int[] b = new int[10];
	static int[][] aState = new int[10][2];//시간, 고객 번호
	static int[][] bState = new int[10][2];//시간, 고객 번호
	static int[][] customer = new int[1001][3];//도착시간, 접수창구번호, 정비창구번호
	static int N, M, K, A, B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int time;
		StringTokenizer st;
		
		Queue<Integer> waitQ1 = new LinkedList<Integer>();
		Queue<Integer> exitQ1 = new LinkedList<Integer>();
		Queue<Integer> exitQ2 = new LinkedList<Integer>();
		for(int tc=1;tc<=T;tc++) {
			waitQ1.clear();
			exitQ1.clear();
			exitQ2.clear();
			time = 0;
			st = new StringTokenizer(br.readLine());
			int result = 0;
			int customerNum;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=M;i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=K;i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
			}
			while(true) {
				//접수 창구 체크
				for(int i=1;i<=K;i++) {
					if(customer[i][0]==time) {
						waitQ1.add(i);
					}
				}
				if(!waitQ1.isEmpty()) {
					for(int i=1;i<=N;i++) {
						if(aState[i][0]==0) {
							customerNum = waitQ1.poll();
							aState[i][0] = a[i];
							aState[i][1] = customerNum;
							customer[customerNum][1] = i;
						}
						if(waitQ1.isEmpty())break;
					}
				}
				//정비 창구 체크
				if(!exitQ1.isEmpty()) {
					for(int i=1;i<=M;i++) {
						if(bState[i][0]==0) {
							customerNum = exitQ1.poll();
							bState[i][0] = b[i];
							bState[i][1] = customerNum;
							customer[customerNum][2] = i;
						}
						if(exitQ1.isEmpty())break;
					}
				}
				if(exitQ2.size()==K)break;
//				System.out.printf("time: %d\n",time);
//				System.out.print("접수 대기: ");
//				System.out.println(waitQ1);
//				System.out.println("접수 창구");
//				for(int i=1;i<=N;i++) {
//					System.out.printf("%d\t",i);
//				}System.out.println();
//				for(int i=1;i<=N;i++) {
//					if(aState[i][0]!=0) {
//						System.out.printf("%d\t",aState[i][1]);
//					}else {
//						System.out.printf("%d\t",0);	
//					}
//				}System.out.println();
//				System.out.print("정비 대기: ");
//				System.out.println(exitQ1);
//
//				System.out.println("정비 창구");
//				for(int i=1;i<=N;i++) {
//					System.out.printf("%d\t",i);
//				}System.out.println();
//				for(int i=1;i<=N;i++) {
//					if(bState[i][0]!=0) {
//						System.out.printf("%d\t",bState[i][1]);
//					}else {
//						System.out.printf("%d\t",0);	
//					}
//				}System.out.println();
//				System.out.println("------------------");
				for(int i=1;i<=N;i++) {
					if(aState[i][0]!=0) {
						if(aState[i][0]==1) {
							exitQ1.add(aState[i][1]);
						}
						aState[i][0]--;
					}
				}
				for(int i=1;i<=M;i++) {
					if(bState[i][0]!=0) {
						if(bState[i][0]==1) {
							exitQ2.add(bState[i][1]);
						}
						bState[i][0]--;
					}
				}
				time++;
			}
			boolean check = false;
			for(int i=1;i<=K;i++) {
				if(customer[i][1]==A&&customer[i][2]==B) {
					check = true;
					result+=i;
				}
			}
			if(!check)result=-1;
			bw.write("#"+tc+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}

}
