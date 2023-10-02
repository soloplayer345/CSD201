/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xSource, int xPrice, int xType) {
        //You should insert here statements to complete this function
        //xPrice is the key of the tree.
        if (xSource.charAt(0) == 'B') {
            return;
        }
        Node x = new Node(new Watermelon(xSource, xPrice, xType));
        if (root == null) { //this.isEmpty()
            root = x;
            return;
        }
        Node f, p;
        p = root;
        f = null;
        while (p != null) {
            if (x.info.price == p.info.price) {// key trung
                System.out.println(" The key " + x.info.price + " already exists, no insertion");
                return;
            }
            f = p;
            if (x.info.price < p.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.info.price < f.info.price) {
            f.left = x;
        } else {
            f.right = x;
        }
    }//end insert

    //f2
    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.type < 5) {
            fvisit(p, f);
        }

        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }
    //

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        //void f2() – Perform pre-order traversal from the root but display to file f2.txt
        //nodes with type<5 only.

        preOrder2(root, f);

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    int count(Node p, RandomAccessFile f) throws Exception {
        int i = 0;
        if (p == null) {
            return i++;
        }
//        fvisit(p, f);
        count(p.left, f);
        count(p.right, f);
        return i++;
    }

    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        //void f3() – Suppose p is the 3rd node when performing the pre-order traversal of the tree.
        //Delete the node p  by copying. 
        System.out.println(count(root, f));
        if (count(root, f) != 3) {
            count(root, f);
        }
        //------------------------------------------------------------------------------------

        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //void f4() - rightmost node.
        Node b;
        b = root;
        while (b.right != null) {
            b = b.right;
        }

        //------------------------------------------------------------------------------------
        f.writeBytes(b.info + "\r\n");
        f.close();
    }
//=============================================================

    void printLeaf(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        printLeaf(p.left, f);
        if (p.right == null && p.left == null) {
            fvisit(p, f);
        }
        printLeaf(p.right, f);
    }

    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        //void f5() - Leaf nodes
        Node b;
        b = root;
        printLeaf(b, f);

        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//=============================================================

    void printInternal(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.right != null || p.left != null) {
            fvisit(p, f);
        }
        printInternal(p.left, f);
        printInternal(p.right, f);
    }

    void f6() throws Exception {
        clear();
        loadData(21);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        //void f6() - Internal nodes
        Node b;
        b = root;
        printInternal(b, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//=============================================================

    int height(Node p) throws Exception {
        int l, r;
        if (p == null) {
            return 0;
        }
        l = height(p.left) + 1;
        r = height(p.right) + 1;
        return l > r ? l : r;
    }

    void f7() throws Exception {
        clear();
        loadData(25);
        String fname = "f7.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //------------------------------------------------------------------------------------
        //void f7() - height of the tree
        Node b;
        b = root;
        //
        f.writeBytes(height(b) + "\r\n");
        f.close();
    }
//=============================================================

    void leafheight(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        printLeaf(p.left, f);
        if (p.right == null && p.left == null) {
            p.info.type += height(p);
            fvisit(p, f);
        }
        printLeaf(p.right, f);
    }

    void f8() throws Exception {
        clear();
        loadData(29);
        String fname = "f8.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        //void f8() - tim nut la, cong type voi chieu cao cua cay
        leafheight(root, f);
        //
        f.writeBytes("\r\n");
        f.close();
    }
//=============================================================
}
