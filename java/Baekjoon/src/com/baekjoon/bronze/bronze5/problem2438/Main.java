package com.baekjoon.bronze.bronze5.problem2438;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 별 찍기 - 1
// https://www.acmicpc.net/problem/2438
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String star = new String(new char[i]).replace("\0", "*");
			bw.write(star + "\n");
			bw.flush();
		}
		bw.close();

		// 숫자로 출력하기
//		int cnt = 1;
//		for (int i = 1; i <= n; i++) {
//			StringBuilder sb = new StringBuilder();
//			for (int j = 0; j < i; j++) {
//				sb.append(String.format("%3d", cnt++));
//			}
//			bw.write(sb + "\n");
//			bw.flush();
//		}
//		bw.close();
	}
}
