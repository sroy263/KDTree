/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KD_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author roy
 */

class Node{
    int data[];
    Node left,right;
    Node(int k){
        data=new int[k];
        left=right=null;
    }
    
     static Node node_Creation(int data[]){
        Node temp=new Node(2);
        System.arraycopy(data, 0, temp.data, 0, 2);
        temp.left=temp.right=null;
        return temp;
    }   
}


public class KD_Tree {
    
    static Node createKDTree(Node root,int data[],int depth){
        if(root==null){
            return Node.node_Creation(data);
        }
        
        int currentDepth_temp=depth %2;
        
        if(data[currentDepth_temp ] < root.data[currentDepth_temp] ){
            // go to the left side of the tree:
            root.left=createKDTree(root.left, data, depth+1);
        }
        else{
            // go to the right side of the tree
            root.right=createKDTree(root.right, data, depth+1);
        }
        
        return root;
    }
    
    static Node insertInKDTree(Node root,int data[]){
        if(root==null){
            return Node.node_Creation(data);
        }
        else{
            Node temp=root;
            Node newNode=Node.node_Creation(data);
            int depth=0;
            while(true){
                
                int cd=depth%2;
                if(data[cd]<temp.data[cd]){
                    // go to left
                    if(temp.left==null){
                        temp.left=newNode;
                        break;
                    }
                    else{
                        temp=temp.left;
                        depth+=1;
                    }
                }
                else{
                    //go to right
                    if(temp.right==null){
                        temp.right=newNode;
                        break;
                    }
                    else{
                        temp=temp.right;
                        depth+=1;
                    }
                }
            }
        }
        return root;
    }
    
    static void rangeSearch(Node root,int x1,int y1,int x2,int y2)
    {
        Queue <Node> arr=new LinkedList<>();
        arr.add(root);
        while(!arr.isEmpty()){
            Node temp=arr.poll();
            
            System.out.print(temp.data[0]+","+temp.data[1]+"  ");
            if(temp.data[0]>= x1 && temp.data[0]<=x2 && temp.data[1]>=y1 && temp.data[1]<=y2){
                System.out.println("Point is in the Range");
            }
            else{
                System.out.println("Point is Not in the range ");
            }
            
            if(temp.left!=null){
                arr.add(temp.left);
            }
            if(temp.right!=null){
                arr.add(temp.right);
            }
        }
        
        
    }
    static void inorderOfTree(Node root){
        if(root.left!=null){
            inorderOfTree(root.left);
        }
        System.out.println("("+root.data[0]+","+root.data[1]+")");
        
        if(root.right!=null){
            inorderOfTree(root.right);
        }
    }
    
    public static void main(String[] args) {
        int data[][]={{20,30},{40,50},{5,15},{25,35},{45,67}};
        Node root=null;
        for(int i=0;i<data.length;i++){
          root= createKDTree(root, data[i], 0);
        }
        
        System.out.println("Enter range to search:");
        int a,b;
        Scanner scan=new Scanner(System.in);
        a=scan.nextInt();
        b=scan.nextInt();
        int arr[]={a,b};
        root=insertInKDTree(root, arr);
        System.out.println("inorder traversal");
        inorderOfTree(root);
        System.out.println("---------------------------------------------------");
        rangeSearch(root,10, 10, 50, 100);
    }
}
