package ProgramacionIII.tp2;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list= new int []{3,2,5,4,6,1,12,9,7,10,15};
		//int[] list= new int []{15,22,7,19,6,8,2,30,31,32,1};
		TreeWithNode arb = new TreeWithNode();
		for (int i : list) {
			arb.add(i);
		}
		//System.out.println(arb.hasElement(4));
		//System.out.println(arb.hasElement(6));
		System.out.println(arb.hasElement(1));
		System.out.println("the heigt is:"+arb.getHeigt());
		//arb.printPreOrder();
		//arb.printPostOrder();
		//arb.printInOrder();
		System.out.println("the longest bramch is:"+arb.getLongestBranch());
		System.out.println("the max value is: "+arb.getMaxValue());
		System.out.println("the min value is: "+arb.getMinValue());
		System.out.println("the last nodes are: "+arb.frontera());
		System.out.println("the nodes at lvl are: "+arb.nodesAtLevel(0));
	}

}
