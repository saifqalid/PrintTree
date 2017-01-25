import java.util.ArrayList;

public class BST {


	ArrayList<Integer> list=new ArrayList<>();
    private BSTNode root;

    static ArrayList<Integer> result = new ArrayList<>();
    
    /* Constructor */
    public BST()
    {
        setRoot(null);
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return getRoot() == null;
    }
    /* Functions to insert data */
    public void insert(int data)
    {
        setRoot(insert(getRoot(), data));
        
    }
    /* Function to insert data recursively */
	private BSTNode insert(BSTNode node, int data)
    {
   	
        if (node == null)
            node = new BSTNode(data);
        else
        {
       	 if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
       
        return node;
    }
    /* Functions to delete data */
    public void delete(int k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry "+ k +" is not present");
        else
        {
            setRoot(delete(getRoot(), k));
            System.out.println(k+ " deleted from the tree");
        }
    }
    public ArrayList<Integer> preorder()
    {
   	 ArrayList<Integer> tt=null;
        tt=preorder(getRoot());
		return tt;
    }
    public ArrayList<Integer> preorder(BSTNode root)
    {
   	 ArrayList<Integer> aL=new ArrayList<>();
        extractValues(root);
        aL=result;
        
        return aL;
    }

    private static void extractValues(BSTNode root2) {
	    
	    if (root2== null)    return;
	    
	  result.add(root2.getData());
 	  extractValues(root2.getLeft());
	  extractValues(root2.getRight());
    }

    private BSTNode delete(BSTNode root, int k)
    {
        BSTNode p, p2, n;
        if (root.getData() == k)
        {
            BSTNode lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            	 
            }
        }
        if (k < root.getData())
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            n = delete(root.getRight(), k);
            root.setRight(n);             
        }
        return root;
    }
    
    /* Functions to search for an element */
    public boolean search(int val)
    {
        return search(getRoot(), val);
    }
    /* Function to search for an element recursively */
    private boolean search(BSTNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
	public BSTNode getRoot() {
		return root;
	}
	public void setRoot(BSTNode root) {
		this.root = root;
	}
         
     }