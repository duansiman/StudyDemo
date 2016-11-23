package com.epdc.interview;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintTwoTree {

	public static void main(String[] args) {
		Node root = new Node();
		root.value = 7;;
		init(root);
		print(root);
	}
	
	public static void print(Node root){
		
		Queue<Node> nodes = new ArrayDeque<>();
		System.out.print(root.value + ", ");
		if (root.left != null) {
			nodes.add(root.left);
		}
		if (root.right != null) {
			nodes.add(root.right);
		}
		while (!nodes.isEmpty()) {
			Node node = nodes.poll();
			System.out.print(node.value + ", ");
			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
		
	}
	
	public static void init(Node root){
		root.left = new Node();
		root.left.value = 3;
		
		root.left.left = new Node();
		root.left.left.value = 1;
		root.left.right = new Node();
		root.left.right.value = 4;
		
		root.right = new Node();
		root.right.value = 10;
		
		root.right.left = new Node();
		root.right.left.value = 8;
		root.right.right = new Node();
		root.right.right.value = 11;
	}
}

class Node {
	Node left;
	Node right;
	int value;
}
