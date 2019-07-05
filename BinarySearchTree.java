package Project2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// boolean contains( x )  --> Return true if x is present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate

/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo method.
 * 
 * @author Mark Allen Weiss
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
	/**
	 * Construct the tree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Insert into the tree; duplicates are ignored.
	 * 
	 * @param x
	 *            the item to insert.
	 */
	public void insert1(AnyType x) {
		root = insert12(x, root);
	}

	public void insert(AnyType x) {
		root = insert(x, root);
	}
//Here initial count of zero is passed to private method
	public int nodeCount() {
		return nodeCount(root, 0);
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * 
	 * @param x
	 *            the item to remove.
	 */
	public void remove(AnyType x) {
		root = remove(x, root);
	}

	/**
	 * Find the smallest item in the tree.
	 * 
	 * @return smallest item or null if empty.
	 * @throws Exception
	 */
	public AnyType findMin() throws Exception {
		if (isEmpty())
			throw new UnderflowException();
		return findMin(root).element;
	}

	/**
	 * Find the largest item in the tree.
	 * 
	 * @return the largest item of null if empty.
	 * @throws Exception
	 */
	public AnyType findMax() throws Exception {
		if (isEmpty())
			// throw new UnderflowException("Underflow" );
			throw new UnderflowException();
		return findMax(root).element;
	}

	/**
	 * Find an item in the tree.
	 * 
	 * @param x
	 *            the item to search for.
	 * @return true if not found.
	 */
	public boolean contains(AnyType x) {
		return contains(x, root);
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty() {
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * 
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree() {
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
	}

	/**
	 * Internal method to insert into a subtree.
	 * 
	 * @param x
	 *            the item to insert.
	 * @param t
	 *            the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	private BinaryNode<AnyType> insert12(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			return new BinaryNode<>(x, null, null);

		int compareResult = x.compareTo(t.element);

		if (compareResult > 0)
			t.left = insert12(x, t.left);
		else if (compareResult < 0)
			t.right = insert12(x, t.right);
		else
			; // Duplicate; do nothing
		return t;
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			return new BinaryNode<>(x, null, null);

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0)
			t.left = insert(x, t.left);
		else if (compareResult > 0)
			t.right = insert(x, t.right);
		else
			; // Duplicate; do nothing
		return t;
	}

	/**
	 * Internal method to remove from a subtree.
	 * 
	 * @param x
	 *            the item to remove.
	 * @param t
	 *            the node that roots the subtree.
	 * @return the new root of the subtree.
	 */
	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			return t; // Item not found; do nothing

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0)
			t.left = remove(x, t.left);
		else if (compareResult > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) // Two children
		{
			t.element = findMin(t.right).element;
			t.right = remove(t.element, t.right);
		} else
			t = (t.left != null) ? t.left : t.right;
		return t;
	}
// passing the root from public to private call
	public boolean isFull() {
		return isFull(root);
	}

	// is full implementation
	private boolean isFull(BinaryNode<AnyType> t)
	{
		{

            if (root!=null) {
                if ((root.left != null && root.right!= null) || (root.right== null && root.left == null))
                {
                    return true;
                }
                else if (root.left!=null)
                {
                    isFull(root.left);
                }
                else if (root.right!=null)
                {
                    isFull(root.right);
                }
                else 
                    return false;

            }
                return false;
    }
}

	// identical
	public boolean compareStructure(BinaryNode<AnyType> t,
			BinaryNode<AnyType> t1) {
		return compareStructure1(t, t1);
	}

	// private boolean compareStructure(BinaryNode<AnyType> t,
	// BinaryNode<AnyType> t1) {
	/* 1. both empty */
	private boolean compareStructure1(BinaryNode<AnyType> t,
			BinaryNode<AnyType> t1) {
		if (t == null && t1 == null)
			// boolean res = true;
			return true;

		/* 2. both non-empty -> compare them */
		if (t != null && t1 != null)
			// return (t.element == t1.element&&

			return (compareStructure(t.left, t1.left) && compareStructure(
					t.right, t1.right));

		/* 3. one empty, one not -> false */
		return false;
	}

	// equals
	public boolean equals(BinaryNode<AnyType> t, BinaryNode<AnyType> t1) {
		return equals1(t, t1);
	}

	private boolean equals1(BinaryNode<AnyType> t, BinaryNode<AnyType> t1) {
		if (t == t1) {
			return true;
		}
		if (t == null || t1 == null) {
			return false;
		}
		return t.element.equals(t1.element) && equals1(t.left, t1.left)
				&& equals1(t.right, t1.right);
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * 
	 * @param t
	 *            the node that roots the subtree.
	 * @return node containing the smallest item.
	 */
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		return findMin(t.left);
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * 
	 * @param t
	 *            the node that roots the subtree.
	 * @return node containing the largest item.
	 */
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if (t != null)
			while (t.right != null)
				t = t.right;

		return t;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * 
	 * @param x
	 *            is item to search for.
	 * @param t
	 *            the node that roots the subtree.
	 * @return node containing the matched item.
	 */
	private boolean contains(AnyType x, BinaryNode<AnyType> t) {
		if (t == null)
			return false;

		int compareResult = x.compareTo(t.element);

		if (compareResult < 0)
			return contains(x, t.left);
		else if (compareResult > 0)
			return contains(x, t.right);
		else
			return true; // Match
	}

	// count number of nodes implementation
	private int nodeCount(BinaryNode<AnyType> t, int count) {

		if (t == null) {
			return count;

		}

		count++; // Increase the count as we visited the root
		//Recursively traverse down the tree in left and right direction
		count = nodeCount(t.left, count); // Traverse left
		count = nodeCount(t.right, count); // Traverse Right

		return count;

	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * 
	 * @param t
	 *            the node that roots the subtree.
	 */
	void printTree(BinaryNode<AnyType> t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.element);
			printTree(t.right);
		}
	}

	/**
	 * Internal method to compute height of a subtree.
	 * 
	 * @param t
	 *            the node that roots the subtree.
	 */
	private int height(BinaryNode<AnyType> t) {
		if (t == null)
			return -1;
		else
			return 1 + Math.max(height(t.left), height(t.right));
	}

	public void mirror(BinaryNode<AnyType> rev) {
		printTree(rev);
		BinaryNode<AnyType> s = mirrorTree(root);
		System.out.println("mirror is");
		printTree(s);
		// System.out.println(compareStructure(rev,s));
	}

	// to get mirror of a tree

	private BinaryNode<AnyType> mirrorTree(BinaryNode<AnyType> root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		if (root != null) {
			BinaryNode<AnyType> s1 = root.left;
			root.left = root.right;
			root.right = s1;
			mirrorTree(root.right);
			mirrorTree(root.left);
		}
		return root;

	}

	// rotate right
//	public BinaryNode<AnyType> findParent(AnyType x) {
//		return findParent(x, root, null);
//	}
//
//	private BinaryNode<AnyType> findParent(AnyType x, BinaryNode<AnyType> node,
//			BinaryNode<AnyType> parent) {
//		if (node == null) {
//			return null;
//		} else if (!node.element.equals(x)) {
//			parent = findParent(x, node.left, node);
//			if (parent == null) {
//				parent = findParent(x, node.right, node);
//			}
//		}
//		return parent;
//	}

	public void rotateRight(AnyType x) {
		BinaryNode<AnyType> root1 = root;
		BinaryNode<AnyType> root1prev = null;
		while (root1.element != x && root1.element != null) {
			root1prev = root1;
			if (((Integer) root1.element > (Integer) x) && (root1.left != null)) {

				root1 = root1.left;
			}
			if (((Integer) root1.element < (Integer) x)
					&& (root1.right != null)) {

				root1 = root1.right;
			}
			if (root1.left == null && root1.right == null) {
				// System.out.println("element not found");
				throw new UnderflowException();
			}

		}
		if (root1.element == x) {
			if (root1 != null) {
				rotateRight1(root1, root1prev);
				return;
			}
		} else {
			System.out.println("element not found in tree");
			throw new UnderflowException();
		}
		return;
	}

	private void rotateRight1(BinaryNode<AnyType> root2,
			BinaryNode<AnyType> root3) {
		{
			// System.out.println(root2.element);

			BinaryNode<AnyType> temp = null;
			if (root2.element != root.element) {
				// System.out.println("hi");
				if (root2.left != null) {
					// System.out.println("hi");
					if (root2.left.right == null) {
						if ((Integer) root2.element > (Integer) root3.element)
							root3.right = root2.left;
						if ((Integer) root2.element < (Integer) root3.element)
							root3.left = root2.left;

						root2.left.right = root2;
						root2.left = null;
						// root=root2;
					} else {
						if ((Integer) root2.element > (Integer) root3.element)
							root3.right = root2.left;
						if ((Integer) root2.element < (Integer) root3.element)
							root3.left = root2.left;

						temp = root2.left.right;
						root2.left.right = root2;
						root2.left = temp;
						// root=root2;
					}
				} else
					throw new UnderflowException();
			} else {
				System.out.println("Shifting wrt root node");
				if (root2.left != null) {
					root = root2.left;
					if (root2.left.right == null) {
						root.right = root2;
						root2.left = null;

					} else {

						temp = root.right;
						root.right = root2;
						root2.left = temp;

					}
				} else
					throw new UnderflowException();

			}
		}

	}

	public void rotateLeft(AnyType x) {
		BinaryNode<AnyType> root1 = root;
		BinaryNode<AnyType> root1prev = null;
		while (root1.element != x && root1.element != null) {
			root1prev = root1;
			if (((Integer) root1.element > (Integer) x) && (root1.right != null)) {

				root1 = root1.right;
			}
			if (((Integer) root1.element < (Integer) x)
					&& (root1.left != null)) {

				root1 = root1.left;
			}
			if (root1.left == null && root1.right == null) {
				// System.out.println("element not found");
				throw new UnderflowException();
			}

		}
		if (root1.element == x) {
			if (root1 != null) {
				rotateLeft1(root1, root1prev);
				return;
			}
		} else {
			System.out.println("element not found in tree");
			throw new UnderflowException();
		}
		return;
	}

	private void rotateLeft1(BinaryNode<AnyType> root2,
			BinaryNode<AnyType> root3) {
		{
			

			BinaryNode<AnyType> temp = null;
			if (root2.element != root.element) {
				
				if (root2.left != null) {
					
					if (root2.right.left == null) {
						if ((Integer) root2.element > (Integer) root3.element)
							root3.left = root2.right;
						if ((Integer) root2.element < (Integer) root3.element)
							root3.right = root2.right;

						root2.right.left = root2;
						root2.right = null;
						
					} else {
						if ((Integer) root2.element > (Integer) root3.element)
							root3.left = root2.right;
						if ((Integer) root2.element < (Integer) root3.element)
							root3.right = root2.right;

						temp = root2.right.left;
						root2.right.left = root2;
						root2.right = temp;
						
					}
				} else
					throw new UnderflowException();
			} else {
				System.out.println("Shifting wrt root node");
				if (root2.right != null) {
					root = root2.right;
					if (root2.right.left == null) {
						root.left = root2;
						root2.right = null;

					} else {

						temp = root.left;
						root.left = root2;
						root2.right = temp;

					}
				} else
					throw new UnderflowException();

			}
		}

	}


	// print level
	public void printLevel(BinaryNode<AnyType> root) {
		printLevel1(root);
	}

	private void printLevel1(BinaryNode<AnyType> root) {
		if (root == null)
			return;

		Queue<BinaryNode> q = new LinkedList<BinaryNode>();

		// Enqueue Root and initialize height
		q.add(root);

		while (true) {

			int nodeCount = q.size();
			if (nodeCount == 0)
				break;

			while (nodeCount > 0) {
				BinaryNode node = q.peek();
				System.out.print(node.element + " ");
				q.remove();
				if (node.right != null)
					q.add(node.right);
				if (node.left != null)
					q.add(node.left);

				nodeCount--;
			}
			System.out.println();
		}
	}

	// Copy
	public void copyv(BinaryNode<AnyType> rev) {
		System.out.println("initial tree");
		printTree(rev);
		BinaryNode<AnyType> s = copy(root);
		System.out.println("copy is");
		printTree(s);
	}

	private BinaryNode<AnyType> copy(BinaryNode<AnyType> root) {
		if (root == null) {
			return null;
		}
		BinaryNode<AnyType> newNode = new BinaryNode(root.element, null, null);
		newNode.left = copy(root.left);
		newNode.right = copy(root.right);
		return newNode;
	}

	// check if mirror
	public boolean checkMirror(BinaryNode<AnyType> root1,
			BinaryNode<AnyType> root2) {
		return checkMirror1(root1, root2);
	}

	private boolean checkMirror1(BinaryNode<AnyType> root1,
			BinaryNode<AnyType> root2) {

		boolean w = false;
		boolean s = false;

		if (root1.left != null && root2.right != null)
			w = checkMirror1(root1.left, root2.right);
		if (root1.right != null && root2.left != null)
			s = checkMirror1(root1.right, root2.left);
		if ((root1.left == null) && (root2.right == null)) {
			if (root1.element.equals(root2.element))
				w = true;
		}
		if ((root1.right == null) && (root2.left == null)) {
			if (root1.element.equals(root2.element))
				s = true;
		}
		if (w == true && s == true) {
			System.out.println(root1.element + " " + root2.element);
			return true;
		} else
			return false;
	}

	// if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
	// return false;
	//
	// if (root1 == null && root2 == null)
	// return true;
	//
	//
	// if (root1.element != root2.element)
	// return false;
	// else
	// System.out.println(root1.element +" "+ root2.element);
	// return root1.element.equals(root2.element)
	// && checkMirror1(root1.left, root2.right)
	// && checkMirror1(root1.right, root2.left);
	//

	// }

	// return (checkMirror(root1.left, root2.left)&&
	// checkMirror(root1.right, root2.right) || checkMirror(root1.left,
	// root2.right)
	// && checkMirror(root1.right, root2.left));

	// return checkMirror(root1.left, root2.right)
	// && checkMirror(root1.right, root2.left);

	//
	// }

	private static class BinaryNode<AnyType> {
		// Constructors
		BinaryNode(AnyType theElement) {
			this(theElement, null, null);
		}

		BinaryNode(AnyType theElement, BinaryNode<AnyType> lt,
				BinaryNode<AnyType> rt) {
			element = theElement;
			left = lt;
			right = rt;
		}

		// public BinaryNode(AnyType i) {
		// this.element=i;
		// }

		AnyType element; // The data in the node
		BinaryNode<AnyType> left; // Left child
		BinaryNode<AnyType> right; // Right child
	}

	BinaryNode<AnyType> root;

}
