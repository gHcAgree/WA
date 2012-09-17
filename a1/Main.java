package jp.co.worksap.recruiting;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
	List<Long> list = new ArrayList<Long>();

    ExamImmutableQueue<Long> queue1 = new ExamImmutableQueueImpl<Long>();
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
	    String s;
	    
	    while((s=reader.readLine())!=null) {
			list.add(Long.parseLong(s));
        }
	    ExamImmutableQueue<Long> queue = new ExamImmutableQueueImpl<Long>(list);
		
	    long stime = System.nanoTime();
	    for(int i=0;i<1000;i++)
			queue1 = queue.enqueue(999999999L);
	    long etime = System.nanoTime();
	    System.out.printf("Enqueue Time Consumption: %,d\n",(etime-stime));
		
		stime = System.nanoTime();
	    for(int i=0;i<1000;i++)
			queue1 = queue.dequeue();
	    etime = System.nanoTime();
	    System.out.printf("Dequeue Time Consumption: %,d\n",(etime-stime));
		
	    Long l = queue.peek();
	    System.out.println("Peek "+l);
		
		int size = queue.size();
	    System.out.println("Size "+size);
		
	}catch(IOException e) {
		e.printStackTrace();
	}
    }
}
