package net.acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_12865 {
	public static int n, capacity;
	public static int[] volume, need;
	public static int[][] cache;
	
	public static int pack(int capacity, int item) {
		if (item == n) {
			return 0;
		}
		
		int ret = cache[capacity][item];
		if (ret != 0) {
			return ret;
		}
		
		ret = pack(capacity, item + 1);
		cache[capacity][item] = ret;
		
		if (capacity >= volume[item]) {
			ret = Math.max(ret, pack(capacity - volume[item], item + 1) + need[item]);
			cache[capacity][item] = ret;
		}
		
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
//		String input = "4 7\r\n" + 
//				"6 13\r\n" + 
//				"4 8\r\n" + 
//				"3 6\r\n" + 
//				"5 12";
//		BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line[] = br.readLine().split(" ");
		n = Integer.valueOf(line[0]);
		capacity = Integer.valueOf(line[1]);
		
		volume = new int[100];
		need = new int[1000];
		
		for (int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			volume[i] = Integer.valueOf(line[0]);
			need[i] = Integer.valueOf(line[1]);
		}
		
		cache = new int[100001][100];
		int min = pack(capacity, 0);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(min + "\n");
		
		br.close();
		bw.close();
		
	}
}