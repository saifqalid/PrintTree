import java.util.Scanner;
 
/* Class HeapSort */


public class HeapSort 
{    
    private static int N;
    static int flag = 0;
    /* Sort Function */
    public static void sort(int arr[])
    {       
    	BST bt=new BST();
        heapify(arr);    
        for (int i = N; i > 0; i--)
        {
            swap(arr,1, i);
            N = N-1;
            maxheap(arr, 1);
            bt.setRoot(createTreeNode(arr,1));
            BTreePrinter.printNode(bt.getRoot());
        }
    }     
    /* Function to build a heap */   
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i > 0; i--)
        	maxheap(arr, i);        
    }
    /* Function to swap largest element in heap */        
    public static void maxheap(int arr[], int i)
    { 
    	
    	BST bt=new BST();
    	bt.setRoot(createTreeNode(arr,1));
        BTreePrinter.printNode(bt.getRoot());
        int left = 2*i ;	
        int right = 2*i+1 ;
        int max = i;
        if (left <= N && arr[left] < arr[i])
            max = left;
        if (right <= N && arr[right] < arr[max])        
            max = right;
        /*if(max==i){
        System.out.println("------------------max==i("+max+"=="+i+")---------------------");
        bt.setRoot(createTreeNode(arr,1));
        BTreePrinter.printNode(bt.getRoot());
        }*/
        
        if (max != i)
        {
        	swap(arr, i, max);
        	/*System.out.println("------------------max!=i("+max+"!="+i+")---------------------");
            bt.setRoot(createTreeNode(arr,1));
            BTreePrinter.printNode(bt.getRoot());
            */    
            maxheap(arr, max);
        }
        
    }   
    
    public static BSTNode createTreeNode(int input[], int index){
        if(index<=input.length){
            Integer value = input[index];
            if(value!=null){
                BSTNode t = new BSTNode(value);
                if(index*2<=N){
                	t.left = createTreeNode(input, index*2);
                }
                if((index*2+1)<=N){
                	t.right = createTreeNode(input, index*2+1);
                }
                
                return t;
            }
        }
        return null;
    }
    
    
    public static void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    
    
    public static void main(String[] args) 
    {
    	char ch;
    	do{
    		
        Scanner scan = new Scanner( System.in );        
        int n, i; 
       
        BST bst = new BST();
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();    
        int arr[] = new int[ n+1 ];
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 1; i <=n; i++){
            arr[i] = scan.nextInt();
            
        }
        /* Call method sort */
        sort(arr);
        /* Print sorted Array */
        System.out.println("\nElements after sorting ");        
        for (i = 1; i <=n; i++)
            System.out.print(arr[i]+" ");            
        System.out.println("\nDo you want to continue (Type y or n) \n");
        ch = scan.next().charAt(0);                        
    } while (ch == 'Y'|| ch == 'y');            
    }    
}