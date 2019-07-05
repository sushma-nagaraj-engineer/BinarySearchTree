package Project2;



public class BinarySearchTreeDriver {
	// Test program
	public static void main(String[] args) throws Exception {
		BinarySearchTree<Integer> t = new BinarySearchTree<>();

		System.out.println("Checking the functionality of each method)");
//Creating a test tree using in order traversal
		t.insert(20);
		t.insert(10);
		t.insert(40);
		t.insert(50);
		t.insert(45);
		t.insert(100);
//		t.insert(55);
//		t.insert(150);
		
		System.out.println("The inorder printing of tree is");
		t.printTree();

		System.out.println("The number of nodes in given tree is "
				+ t.nodeCount());
		System.out.println("Is the tree full? " + t.isFull());
		BinarySearchTree<Integer> t1 = new BinarySearchTree<>();
		t1.insert(20);
		t1.insert(10);
		t1.insert(40);
		t1.insert(50);
		t1.insert(45);
		// t1.insert(7);
		System.out.println("The new second tree is");
		t1.printTree();
		System.out.println("Are the above two tree structures identical? "
				+ t.compareStructure(t.root, t1.root));
		System.out
				.println("Are the above two trees identical with respect to structure and data? "
						+ t.equals(t.root, t1.root));
		BinarySearchTree<Integer> rev = new BinarySearchTree<>();
		rev.insert(100);
		rev.insert(50);
		rev.insert(150);
		rev.insert(40);
		rev.insert(45);
		rev.insert(15);
		rev.insert(200);
		System.out.println("tree check rev");
		t.printTree(rev.root);
		// rev.insert(5);
		// rev.insert(7);

		System.out.println("The original tree and its mirror is as follows:");
		rev.mirror(rev.root);

		System.out
				.println("the elements of the tree at different levels is as follows");
		t.printLevel(rev.root);
		System.out.println("The copy of the tree is as below");
		rev.copyv(rev.root);
		System.out.println(" wrt mirror");
		BinarySearchTree<Integer> reva = new BinarySearchTree<>();
		// reva.insert(100);
		// reva.insert(50);
		// reva.insert(150);
		// reva.insert(40);
		// reva.insert(45);
		reva.insert(50);
		reva.insert(25);
		reva.insert(10);
		reva.insert(30);
		// reva.insert(30);
		reva.insert(60);
		// reva.insert(55);
		// reva.insert(90);

		System.out.println("reva is");
		reva.printTree(reva.root);

		BinarySearchTree<Integer> revcheck = new BinarySearchTree<>();
		// BinaryNode<Integer>revcheck.root=100;

		revcheck.insert1(100);
		revcheck.insert1(50);
		revcheck.insert1(150);
		revcheck.insert1(40);
		revcheck.insert1(45);
		// revcheck.insert1(50);
		// revcheck.insert1(25);
		// revcheck.insert1(10);
		// revcheck.insert1(30);
		// revcheck.insert1(30);
		// revcheck.insert1(60);
		// revcheck.insert1(55);
		// revcheck.insert1(90);
		// revcheck.insert1(150);

		System.out.println();
		revcheck.printTree(revcheck.root);

		System.out.println("is it a mirror tree?"
				+ t.checkMirror(reva.root, revcheck.root));

		// reva.rotateLeft(50);
		System.out.println("Output of Rotate Left");
		reva.printTree(reva.root);
		System.out.println();
		System.out.println("Output of Rotate Right");
		reva.rotateRight(25);
		reva.printTree(reva.root);

	}
}
