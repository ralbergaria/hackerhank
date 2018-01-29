package hackerhank.advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
	private int result = 1;
	private long m = 1000000007L;
	public int getResult() {
		return result == 0? 1 : result;
	}

	public void visitNode(TreeNode node) {
		if(node.getColor().equals(Color.RED))
			result = (int) ((result * node.getValue()) % m);
	}

	public void visitLeaf(TreeLeaf leaf) {
		if(leaf.getColor().equals(Color.RED))
			result = (int) ((result * leaf.getValue()) % m);
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

class Control {
	int parent;
	int children;
	
	public Control(int parent, int children) {
		this.parent = parent;
		this.children = children;
	}
}

public class Solution_VisitorPattern {
	
	
	
	public static Tree solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] valores = sc.nextLine().split(" ");
		String[] cores = sc.nextLine().split(" ");
		List<Control> controls = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < n - 1; i++) {
			Control control = new Control(sc.nextInt(), sc.nextInt());
			controls.add(control);
			set.add(control.parent);
		}
		
		Tree tree = new TreeNode(Integer.valueOf(valores[0]), cores[0].equals("0") ? Color.RED:Color.GREEN, 0);
		Map<Integer,Tree> map = new HashMap<Integer,Tree>();
		map.put(1, tree);			
		int i = 1;
		for (Control control : controls) {			
			Tree children = null;
			if(set.contains(control.parent)) {
				children = new TreeNode(Integer.valueOf(valores[i]), cores[i].equals("0") ? Color.RED:Color.GREEN, control.parent);
			} else {
				children = new TreeLeaf(Integer.valueOf(valores[i]), cores[i].equals("0") ? Color.RED:Color.GREEN, control.parent);
			}
			
			if (map.get(control.parent) == null) {
				
			}
			i++;
		}
		return tree;
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
