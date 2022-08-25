package com.algo.java.prim;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class primTest2 {

	static class Node {
		public int vertex;
		public int weight;
		Node next;

		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[V]; // 각 정점별 인접리스트

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 무향 처리
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}

		// 프림 알라고림에 필요한 자료구조
		int[] minEdge = new int[V]; // 각 정점이 신장트리에 포함된 정점과의 간선 비용 중 최소 비용
		boolean[] visited = new boolean[V]; // 신장트리 포함 여부

		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 관리하기 위해 큰 값 세팅

		// 1. 임의의 시작점 처리, 0번 정점을 신장트리 구성의 시작점으로
		minEdge[0] = 0;

		int result = 0; // 최소 신장 트리 비용 누적

		for (int c = 0; c < V; c++) { // v개 정점 처리하면 끝

			// step1. 신장트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}

			// step2. 신장트리에 추가
			visited[minVertex] = true;
			result += min;

			// step3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소비용과 비교해서 갱신
			// 신장트리에 새롬게 추가되는 정점의 모든 인접정점 들여다보며 처리
			for (Node temp = adjList[minVertex]; temp != null; temp = temp.next) {
				if (!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
				}
			}
		}
		
		System.out.println(result);

	}
}

/**
 * 
 * <test data>
 * 
 * 정점의 개수
 * 
 * 정점에 대한 정보
 * 
 * 5 0 5 10 8 7 5 0 5 3 6 10 5 0 1 3 8 3 1 0 1 7 6 3 1 0
 * 
 * output==>10
 * 
 * 7 0 32 31 0 0 60 51 32 0 21 0 0 0 0 31 21 0 0 46 0 25 0 0 0 0 34 18 0 0 0 46
 * 34 0 40 51 60 0 0 18 40 0 0 51 0 25 0 51 0 0
 * 
 * output==>175
 * 
 */