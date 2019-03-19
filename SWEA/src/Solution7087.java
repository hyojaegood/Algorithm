import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution7087 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T,N;
		String[] str =  new String[100];
		boolean[] isExist = new boolean[26];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		int max;
		T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			max = 0;
			N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				str[i] = br.readLine();
				isExist[str[i].charAt(0)-'A'] = true;
			}
			for(int i=0;i<26;i++) {
				if(isExist[i]) {
					max++;
				}else {
					break;
				}
			}
			for(int i=0;i<26;i++) {
				isExist[i] = false;
			}
			bw.write("#"+tc+" "+max+"\n");
			bw.flush();
		}
		bw.close();
	}
}
