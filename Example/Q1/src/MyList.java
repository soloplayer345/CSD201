/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//==================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    //---------------------------------------------------
    void addLast(String xName, int xSalary, int xAbility) {
        //You should write here appropriate statements to complete this function.
        //..........................
        //..........................
        if (xName.charAt(0) == 'A') return;
    Node q = new Node(new Worker(xName, xSalary, xAbility));
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    //===================================================================
    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void insertPos(Worker data, int position) {
        Node newNode = new Node(data);

        if (position == 1) { // Insert at the beginning
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = head;
            int count = 1;

            while (count < position - 1 && previous.next != null) {
                previous = previous.next;
                count++;
            }

            if (count == position - 1 && previous != null) {
                newNode.next = previous.next;
                previous.next = newNode;
            } else {
            }
        }
    }

    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Worker x, y;
        x = new Worker("X", 1, 2);
        y = new Worker("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        //..........................
        //..........................
        insertPos(x, 1);
        insertPos(y, 5);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        //..........................
        //..........................
        Node curr = head;
        while (curr != null){
            if (curr.info.salary > 8) {
                curr.info.ability = 100;
                break;
            }
            curr = curr.next;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        //..........................
        //..........................
        for (Node i = head; i!= null; i = i.next)
            for (Node j = i.next; j!=null; j=j.next){
                if (i.info.salary < j.info.salary){
                    Worker tmp = i.info;
                    i.info = j.info;
                    j.info = tmp;
                }
            }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
//==================================================================
    void deleteNodeAtPosition(int position) {
        if (head == null) {
            return;
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        int currentPosition = 0;

        while (current != null) {
            if (currentPosition == position) {
                previous.next = current.next;
                return;
            }

            previous = current;
            current = current.next;
            currentPosition++;
        }

        System.out.println("Invalid position");
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
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        //..........................
        //..........................
        for (Node i = head; i!= null; i = i.next)
            for (Node j = i.next; j!=null; j=j.next){
                if (i.info.salary < j.info.salary){
                    Worker tmp = i.info;
                    i.info = j.info;
                    j.info = tmp;
                }
            }
        deleteNodeAtPosition(0);
        deleteNodeAtPosition(1);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
//==================================================================
    void f6() throws Exception {
        clear();
        loadData(21);
        String fname = "f6.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        int deleteSalary = 11;  //find and delete the node having salary=10
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        //..........................
        //..........................
        
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
