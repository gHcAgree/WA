package jp.co.worksap.recruiting;

import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
	int a[] = {7,1,3,3,5,1,2,4,3};
        ExamPeekableQueueImpl<Integer> queue = new ExamPeekableQueueImpl<Integer>(); 
	for(int i=0;i<a.length;i++)
	    queue.enqueue(a[i]);
	
        //for(int i=0;i<5;i++)
	    //queue.dequeue();

	int max = queue.peekMaximum();
	int min = queue.peekMinimum();
	int median = queue.peekMedian();
	
	System.out.println("Max: "+max);
	System.out.println("Min: "+min);
	System.out.println("Median: "+median);
    }
}
