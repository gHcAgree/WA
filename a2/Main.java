package jp.co.worksap.recruiting;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	MyList<Long> list = new MyList<Long>();

	try {
	    BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
	    String s;
	    
	    while((s=reader.readLine())!=null) {
			list.add(Long.parseLong(s));
        }
	    ExamPeekableQueue<Long> queue = new ExamPeekableQueueImpl<Long>(list);
		
	    long stime = System.nanoTime();
	    for(int i=0;i<100000;i++)
		queue.enqueue(999999999L);
	    long etime = System.nanoTime();
	    System.out.printf("Enqueue Time Consumption: %,d\n",(etime-stime));

	    stime = System.nanoTime();
	    for(int i=0;i<100000;i++)
		queue.dequeue();
	    etime = System.nanoTime();
	    System.out.printf("Dequeue Time Consumption: %,d\n",(etime-stime));
	    	    
	    int size = queue.size();
	    System.out.println("Size "+size);

	}catch(IOException e) {
		e.printStackTrace();
	}
    }
}
