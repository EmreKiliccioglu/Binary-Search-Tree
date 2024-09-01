package binarysearchtree;
import java.util.LinkedList;
import java.util.Queue;

class Node // Agacin dugumleri
{
    int key;
    Node left;
    Node right;
    
    public Node(int item)
    {
        this.key = item;
        this.left = null;
        this.right = null;
    }
}
public class BinarySearchTree 
{
    
    Node root;
    
    public BinarySearchTree()
    {
        root = null;
    }
    
    public void insert(int key) 
    {
        root = insertRecursive(root,key);
    }
    
    private Node insertRecursive(Node root,int key) // Agaca rekursif olarak eleman ekleme
    {
        if(root == null)
        {
            root = new Node(key);
            return root;
        }
        
        if(key < root.key)
        {
            root.left = insertRecursive(root.left,key);
        }
        else if(key > root.key)
        {
            root.right = insertRecursive(root.right,key);
        }
        return root;
    }

    public boolean search(int key)
    {
        return searchRecursive(root,key);
    }
    
    private boolean searchRecursive(Node root,int key) // Agacta rekursif olarak elaman arama
    {
        if(root == null || root.key == key)
        {
            return root != null;
        }
        
        if(key < root.key)
        {
            return searchRecursive(root.left,key);
        }
        return searchRecursive(root.right,key);
    }
    
    public void levelOrder() // Agacin dugumlerinin seviyelerine gore siralanmasi
    {
        if (root == null) 
        {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        while(!queue.isEmpty()) 
        {
            int levelSize = queue.size();  
            System.out.print("Seviye " + level + ": ");

            for (int i=0 ; i<levelSize ; i++) 
            {
                Node current = queue.poll();
                System.out.print(current.key + " ");

                if (current.left != null) 
                {
                    queue.add(current.left);
                }

                if (current.right != null) 
                {
                    queue.add(current.right);
                }
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        
        BinarySearchTree bst = new BinarySearchTree();
        
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        
        System.out.println("Seviye Sirasi ile Ikili Arama Agaci");
        bst.levelOrder();

        int keyToSearch = 80;
        if(bst.search(keyToSearch))
        {
            System.out.println("\n" + keyToSearch + " degeri bulundu.");
        }
        else
        {
            System.out.println("\n" + keyToSearch + " degeri bulunamadi.");
        }
    }
}
