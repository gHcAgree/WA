package jp.co.worksap.recruiting;

import java.util.List;
import java.util.NoSuchElementException;

public class ExamPeekableQueueImpl<E extends Comparable<E>> implements ExamPeekableQueue<E> {

    int qLength;
    int head,tail;
    Object[] qArray;

    public static final int MAXSIZE = 1024;

    public ExamPeekableQueueImpl() {
        qLength = 0;
	head = 0;
	tail = head;
	qArray = new Object[MAXSIZE];
    }

    public ExamPeekableQueueImpl(List<E> queue) {
	qArray = queue.toArray(new Object[0]);
	qLength = queue.size();
	head = 0;
	tail = head+qLength-1;
    }

    public void enqueue(E e) {
	if(e==null)
	    throw new IllegalArgumentException();
	
	//if the queue is empty, insert the new element at head
	if(qLength==0) {
	    qArray[head] = e;
	    qLength++;
	}
	else {
	    //if the queue is full, reallocate more space for the "circular" queue
	    if((tail-head+1)%qLength==0) {
		Object[] tArray = new Object[qLength*2];
		//there is a possibility that the head is ahead of the tail,
		//so we should copy them separately
		System.arraycopy(qArray,head,tArray,0,qLength-head);
		System.arraycopy(qArray,0,tArray,qLength-head,(tail+1)%qLength);
		tArray[qLength] = e;

		//reference the larger new "circular" queue
		qArray = tArray;
		qLength++;
		head = 0;
		tail = qLength-1;
	    }
	    //ordinary insert into a non-full queue
	    else {
		qArray[++tail] = e;
		qLength++;
	    }
	}
    }

    public E dequeue() {
	return null;
    }

    public E peekMedian() {
	return null;
    }

    public E peekMaximum() {
	return null;
    }

    public E peekMinimum() {
	return null;
    }

    public int size() {
	return qLength;
    }
}

