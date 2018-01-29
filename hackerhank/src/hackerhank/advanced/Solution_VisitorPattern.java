package hackerhank.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis
{
	public abstract int getResult();
	public abstract void visitNode(TreeNode node);
	public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	private int result = 0;
	public int getResult() {      	
		return result;
	}

	public void visitNode(TreeNode node) {}

	public void visitLeaf(TreeLeaf leaf) {
		result += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {
	private long result = 1;
	private final int M = 1000000007;

	public int getResult() {
	    return (int) result;
	}

	public void visitNode(TreeNode node) {
	    if(node.getColor().equals(Color.RED)) {
	        result = (result * node.getValue()) % M;
	    }
	}

	public void visitLeaf(TreeLeaf leaf) {
	    if(leaf.getColor().equals(Color.RED)) {
	        result = (result * leaf.getValue()) % M;
	    }
	}
}


class FancyVisitor extends TreeVis {
	private int sumNonLeaf = 0;
	private int sumLeaf = 0;

	public int getResult() {
		return Math.abs(sumNonLeaf - sumLeaf);
	}

	public void visitNode(TreeNode node) {
		if(node.getDepth()%2 == 0)
			sumNonLeaf += node.getValue(); 
	}

	public void visitLeaf(TreeLeaf leaf) {
		if(leaf.getColor().equals(Color.GREEN))
			sumLeaf += leaf.getValue();
	}
}

public class Solution_VisitorPattern {
	static String[] valores;
	static String[] cores;
	static Map<Integer, HashSet<Integer>> map;
	static int n;
	static boolean[] created;
	
	public static Tree solve() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		valores = sc.nextLine().split(" ");
		cores = sc.nextLine().split(" ");

//		sc.nextLine(); //clean the cache
		map = new HashMap<Integer, HashSet<Integer>>();
		for(int i = 0; i < n - 1; i++) {
			int parent = sc.nextInt()-1;
			int children = sc.nextInt()-1;
			
			if (map.get(parent) == null){
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(children);
				map.put(parent, set);
			} else {
				map.get(parent).add(children);
			}
			
			if (map.get(children) == null){
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(parent);
				map.put(children, set);
			} else {
				map.get(children).add(parent);
			}
			
		}
		
		return getTree(0);
	}

	private static Tree getTree(int i) {
		if(map.get(i).isEmpty())
			return new TreeLeaf(Integer.valueOf(valores[i]), cores[i].equals("0")? Color.RED:Color.GREEN, 0);
		else{
			created = new boolean[n];
			return buildTree(i, 0);
		}
	}

	private static Tree buildTree(int pos, int depth) {
		created[pos] = true;
		List<Tree> childs = new ArrayList<Tree>();
		for (Integer e : map.get(pos)) {
			if(!created[e]) {
				childs.add(buildTree(e, depth + 1));
			}			
		}
		
		if (childs.isEmpty()){
			return new TreeLeaf(Integer.valueOf(valores[pos]), cores[pos].equals("0")? Color.RED:Color.GREEN, depth);
		}
		
		TreeNode node = new TreeNode(Integer.valueOf(valores[pos]), cores[pos].equals("0")? Color.RED:Color.GREEN, depth);
		for(Tree child : childs){
			node.addChild(child);
		}
		
		return node;
		
	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);

	}

}
