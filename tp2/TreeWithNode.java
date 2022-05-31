package ProgramacionIII.tp2;

import java.util.ArrayList;


public class TreeWithNode {

	private TreeNode root;
	
	public TreeWithNode() {
		this.root = null;
	}
	
	public void add(Integer value) {
		if (this.root == null)
			this.root = new TreeNode(value);
		else
			this.add(this.root,value);
	}
	
	private void add(TreeNode actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setLeft(temp);
			} else {
				add(actual.getLeft(),value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				TreeNode temp = new TreeNode(value);
				actual.setRight(temp);
			} else {
				add(actual.getRight(),value);
			}
		}
	}
	private int getRoot(){
		return root.getValue();
	}
	
	
	public boolean hasElement(int val){
		if (this.root.getValue() != null){
			if(this.root.getValue() ==val){
				return true;
			}else{
				return hasElement(root,val);
			}
		}else {
			return false;
		}
		
	}
	private boolean hasElement(TreeNode actual,int val){
		boolean hasit = false;
		if( actual.getValue()>val){
			if (actual.getLeft() != null){
				TreeNode aux = actual.getLeft();
				if(aux.getValue()==val){
					hasit = true;
				}else {
					return hasElement(aux,val);
				}
			}	
		}else if(actual.getRight()!= null) {
			TreeNode aux = actual.getRight();
			if(aux.getValue()==val){
				hasit = true;
			}else{
				return hasElement(aux, val);
			}
		}		
		return hasit;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public int getHeigt(){
		int count = 0;
		if (this.root.getValue() == null){
			return count;
		}else{
			return getHeigt(root);
		}
	}
	private int getHeigt(TreeNode actual){
		int countL = 0;
		int countR = 0;		
		if(actual.getLeft()!= null && actual.getRight() == null){
			countL++;
			TreeNode aux = actual.getLeft();
			countL += getHeigt(aux);
		}else if( actual.getRight()!= null && actual.getLeft()==null){
			countR++;
			TreeNode aux = actual.getRight();
			countR += getHeigt(aux);
			
		}else {
			if(actual.getLeft()!=null && actual.getRight() != null){
				countL++;
				countR++;
				TreeNode aux = actual.getLeft();
				countL += getHeigt(aux);
				TreeNode auxR = actual.getRight();
				countR += getHeigt(auxR);
			}
		}
		if (countL>countR){
			return countL;
		}else return countR;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//	
	public void printPreOrder(){
		if(this.root.getValue()!= null){
			printPreOrder(this.root);
			
		}
	}
	private void printPreOrder(TreeNode actual) {
		System.out.println(actual.getValue());
		if(actual.getLeft()!=null){
			printPreOrder(actual.getLeft());
		}
		if(actual.getRight()!= null){
			printPreOrder(actual.getRight());
		}
		
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public void printPostOrder(){
		if(this.root.getValue()!= null){
			printPostOrder(this.root);
		}
	}
	private void printPostOrder(TreeNode actual) {
		if(actual.getLeft()!=null){
			printPostOrder(actual.getLeft());
		}
		if(actual.getRight()!= null){
			printPostOrder(actual.getRight());
		}
		System.out.println(actual.getValue());
		
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public void printInOrder(){
		if(this.root.getValue()!= null){
			printInOrder(this.root);
			
		}
	}
	private void printInOrder(TreeNode actual) {
		if(actual.getLeft()!=null){
			printInOrder(actual.getLeft());
		}
		System.out.println(actual.getValue());
		if(actual.getRight()!= null){
			printInOrder(actual.getRight());
		}
		
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public ArrayList<Integer> getLongestBranch(){
		if (this.root.getValue() == null){
			return null;
		}else{
			return getLongestBranch(root);
		}
	}
	private ArrayList<Integer> getLongestBranch(TreeNode actual) {
		// si es = devuelve izq
		ArrayList<Integer> longestL= new ArrayList<Integer>();
		ArrayList<Integer> longestR= new ArrayList<Integer>();
		ArrayList<Integer> longest= new ArrayList<Integer>();
		if(actual.getLeft()!=null && actual.getRight()!=null){
			longestL.add(actual.getValue());
			longestL.addAll(getLongestBranch(actual.getLeft()));
			longestR.add(actual.getValue());
			longestR.addAll(getLongestBranch(actual.getRight()));
			if(longestL.size()>= longestR.size()){
				return longestL;
			}else{
				return longestR;
			}
			
		}
		if(actual.getLeft()!=null && actual.getRight()==null){
			longestL.add(actual.getValue());
			longestL.addAll(getLongestBranch(actual.getLeft()));
			return longestL;
			
		}
		if(actual.getLeft()==null && actual.getRight()!=null){
			longestR.add(actual.getValue());
			longestR.addAll(getLongestBranch(actual.getRight()));
			return longestR;
		}
		
		;
		longest.add(actual.getValue());
		return longest;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public int getMaxValue(){
		if (root.getValue()!=null){
			return getMaxValue(root);
		}
		return -1;
	}
	private int getMaxValue(TreeNode actual) {
		if(actual.getRight()!=null){
			return getMaxValue(actual.getRight());
		}else{
			return actual.getValue();
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public int getMinValue(){
		if (root.getValue()!=null){
			return getMinValue(root);
		}
		return -1;
	}
	private int getMinValue(TreeNode actual) {
		if(actual.getLeft()!=null){
			return getMinValue(actual.getLeft());
		}else{
			return actual.getValue();
		}
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public ArrayList<Integer> frontera(){
		if (this.root.getValue() != null){
			return frontera(root);
		}
		return null;
	}
	private ArrayList<Integer> frontera(TreeNode actual) {
		ArrayList<Integer> frontera = new ArrayList<Integer>();
		if(actual.getLeft()!=null && actual.getRight()!=null){
			frontera.addAll(frontera(actual.getLeft()));
			frontera.addAll(frontera(actual.getRight()));
		}else if(actual.getLeft()!=null && actual.getRight()==null){
			frontera.addAll(frontera(actual.getLeft()));
		}else if(actual.getLeft()==null && actual.getRight()!=null){
			frontera.addAll(frontera(actual.getRight()));
		}else frontera.add(actual.getValue());
		return frontera;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public ArrayList<Integer> nodesAtLevel(int lvl){
		if(lvl <= this.getHeigt()){
			return nodesAtLevel(root,lvl,0);
		}
		return null;
		
	}
	private ArrayList<Integer> nodesAtLevel(TreeNode actual, int lvl, int lvlActual) {
		ArrayList<Integer> nodesAtLvl= new ArrayList<Integer>();
		if (lvl > lvlActual){
			lvlActual++;
			if(actual.getLeft()!=null && actual.getRight()!= null){
				nodesAtLvl.addAll(nodesAtLevel(actual.getLeft(),lvl,lvlActual));
				nodesAtLvl.addAll(nodesAtLevel(actual.getRight(),lvl,lvlActual));
			}else if(actual.getRight()!= null && actual.getLeft()== null){
				nodesAtLvl.addAll(nodesAtLevel(actual.getRight(),lvl,lvlActual));
			}else if(actual.getLeft()!= null && actual.getRight()== null){
				nodesAtLvl.addAll(nodesAtLevel(actual.getLeft(),lvl,lvlActual));
			}
		}else if (lvl == lvlActual){
			nodesAtLvl.add(actual.getValue());
		}
		
		return nodesAtLvl;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------//
	public boolean deleteLeaf(int val){
		if(root.getValue()!=null){
			if(root.getValue()!= val){
				return deleteLeaf(root,val);
			}else {
				System.out.println("es la Raiz del arbol");;
			}
		}
		return false;
	}

	private boolean deleteLeaf(TreeNode actual, int val) {
		return false;
		
		
	}
}
