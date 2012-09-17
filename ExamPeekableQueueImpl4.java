package jp.co.worksap.recruiting;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Deque;
import java.util.NoSuchElementException;

public class ExamPeekableQueueImpl<E extends Comparable<E>> implements ExamPeekableQueue<E> {
    
    ArrayDeque<E> aqueue;

    public ExamPeekableQueueImpl() {
	aqueue = new ArrayDeque<E>();
    }

    public ExamPeekableQueueImpl(Deque<E> queue) {
	this.aqueue = (ArrayDeque<E>)queue;
    }

    public void enqueue(E e) {
	if(e==null)
	    throw new IllegalArgumentException();
	aqueue.add(e);
    }

    public E dequeue() {
	if(aqueue.isEmpty())
	    throw new NoSuchElementException();
	return aqueue.removeFirst();
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
        return aqueue.size();
    }
}


