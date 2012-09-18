package jp.co.worksap.recruiting;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
	ArrayList<Long> list = new ArrayList<Long>();
        ExamPeekableQueueImpl<Long> queue = new ExamPeekableQueueImpl<Long>(); 

	try {
	    BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
	    String s;
	    
	    while((s=reader.readLine())!=null) {
		list.add(Long.parseLong(s));
            }
		
	    long stime = System.nanoTime();
	    for(int i=0;i<10000;i++)
		queue.enqueue(list.get(i));
	    long etime = System.nanoTime();
	    System.out.printf("Enqueue Time Consumption: %,d\n",(etime-stime));

	    stime = System.nanoTime();
	    for(int i=0;i<5000;i++)
		queue.dequeue();
	    etime = System.nanoTime();
	    System.out.printf("Dequeue Time Consumption: %,d\n",(etime-stime));
	    	    
	    Long max = queue.peekMaximum();
	    Long min = queue.peekMinimum();
	    //Long median = queue.peekMedian();
	    int size = queue.size();
	    System.out.println("Size   "+size);
	    System.out.println("Max    "+max);
	    System.out.println("Min    "+min);
	    //System.out.println("Median "+median);
	}catch(IOException e) {
		e.printStackTrace();
	}
    }
}
