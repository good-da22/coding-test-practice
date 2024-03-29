package com.baekjoon.silver.silver5.problem17478;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 17478번, 재귀함수가 뭔가요?
// https://www.acmicpc.net/problem/17478
public class Main {

	static int N;

	static void recursive(int m) {

		if (m < 1) {
			return;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N - m; i++) {
			sb.append("____");
		}

		StringBuilder sb1 = new StringBuilder(sb + "\"재귀함수가 뭔가요?\"\n")
				.append(sb + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
				.append(sb + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
				.append(sb + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

		System.out.print("" + sb1);

		recursive(m - 1);

		if (m == 1) {
			StringBuilder sb5 = new StringBuilder(sb + "____\"재귀함수가 뭔가요?\"\n")
					.append(sb + "____\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
					.append(sb + "____라고 답변하였지.\n");

			System.out.print("" + sb5);
		}

		StringBuilder sb8 = new StringBuilder(sb + "라고 답변하였지.\n");

		System.out.print(sb8);

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		System.out.println(sb + "");
		recursive(N);
	}
}
