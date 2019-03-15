import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution6781 {
	static char[][] deck = new char[2][9];
	static int setCnt;
	static boolean[] done = new boolean[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		String input;
		char[] tmp = new char[9];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			setCnt = 0;
			input = br.readLine();
			tmp = input.toCharArray();
			deck[0] = tmp;
			input = br.readLine();
			tmp = input.toCharArray();
			deck[1] = tmp;
			sort1();
			sort2();
			for(int i=0;i<7;i++) {
				if(!done[i]) {
					if(checkIdentical(i)) {
						
					}else {
						
					}
				}
			}
			if(setCnt ==3) {
				bw.write("#"+tc+" Win\n");
				bw.flush();
			}else {
				bw.write("#"+tc+" Continue\n");
				bw.flush();				
			}
		}
		bw.close();
	}
	public static boolean checkIdentical(int idx) {
		int cnt = 0;
		for(int i=idx;i<9 && i<idx+3;i++) {
			if(deck[1][idx]==deck[1][idx]) {
				if(deck[0][idx] == deck[0][i]) {
					cnt++;
					if(cnt==3)break;
				}
			}
		}
		if(cnt!=3) {
			return false;
		}
		done[idx] = done[idx+1] = done[idx+2] = true;
		return true;
	}
	public static void checkSequence(int idx, int cnt) {
		
	}
	public static void sort1() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9-i-1;j++) {
				if(deck[1][j]<deck[1][j+1]) {
					swap(j,j+1);
				}
			}
		}
	}
	public static void sort2() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9-i-1;j++) {
				if(deck[1][j]==deck[1][j+1]) {
					if(deck[0][j]>deck[0][j+1]) {
						swap(j,j+1);
					}	
				}
			}
		}
	}
	public static void swap(int i, int j) {
		char tmp1, tmp2;
		tmp1 = deck[0][i];
		tmp2 = deck[1][i];
		deck[0][i] = deck[0][j];
		deck[1][i] = deck[1][j];
		deck[0][j] = tmp1;
		deck[1][j] = tmp2;
	}

}
