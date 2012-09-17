package jp.co.worksap.recruiting;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExamPeekableQueueImpl<E extends Comparable<E>> implements ExamPeekableQueue<E> {

    List<E> queue;

    public ExamPeekableQueueImpl() {
	queue = new ArrayList<E>();
    }

    public ExamPeekableQueueImpl(List<E> queue) {
	this.queue = queue;
    }

    public void enqueue(E e) {
	if(e==null)
	    throw new IllegalArgumentException();
	queue.add(e);
    }

    public E dequeue() {
	if(queue.isEmpty())
	    throw new NoSuchElementException();
	E e = queue.get(0);
	queue.remove(0);
	return e;
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
        return queue.size();
    }
}

