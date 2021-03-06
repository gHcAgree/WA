package jp.co.worksap.recruiting;

import java.util.Stack;
import java.util.NoSuchElementException;

public class ExamPeekableQueueImpl<E extends Comparable<E>> implements ExamPeekableQueue<E> {

    MyList<E> queue;
    Stack<E> maxStk;
    Stack<E> minStk;
    Stack<E> medianStk;

    public ExamPeekableQueueImpl() {
	queue = new MyList<E>();
	maxStk = new Stack<E>();
	minStk = new Stack<E>();
	medianStk = new Stack<E>();
    }

    public ExamPeekableQueueImpl(MyList<E> queue) {
	this.queue = queue;
    }

    public void enqueue(E e) {
	if(e==null)
	    throw new IllegalArgumentException();
	queue.add(e);

	if(!maxStk.empty()) {
	    E max = maxStk.peek();
	    if(max.compareTo(e)<0)
	        maxStk.push(e);
	}
	else maxStk.push(e);

	if(!minStk.empty()) {
	    E min = minStk.peek();
	    if(min.compareTo(e)>0)
	        minStk.push(e);
	}
	else minStk.push(e);

	if(!medianStk.empty()) {
	    E median = medianStk.peek();
	    //if the enqueued element is largger, the median may be larger
	    if(median.compareTo(e)>=0) {
		//if there are even number of elements in the queue after enqueue,
		//we select the larger one
		if(queue.size()%2==0) {
		    medianStk.pop();
		    medianStk.push(e);
		}
	    }
	    //if the enqueued element is smaller, the median may be smaller
	    if(median.compareTo(e)<0) {
		//if there are odd number of elements in the queue after enqueue,
		//we select the smaller one
		if(queue.size()%2==1) {
		    medianStk.pop();
		    medianStk.push(e);
		}
	    }
	}
	else medianStk.push(e);
    }

    public E dequeue() {
	if(queue.isEmpty())
	    throw new NoSuchElementException();

	E e = queue.remove();
	E max = maxStk.peek();
	E min = minStk.peek();
	E median = medianStk.peek();

	if(max.equals(e))
	    maxStk.pop();
	if(min.equals(e))
	    minStk.pop();
        if(median.equals(e))
	    medianStk.pop();
	return e;
    }

    public E peekMedian() {
	if(!medianStk.empty())
	    return medianStk.peek();
	else
	    throw new NoSuchElementException();
    }

    public E peekMaximum() {
	if(!maxStk.empty())
	    return maxStk.peek();
	else
	    throw new NoSuchElementException();
    }

    public E peekMinimum() {
	if(!minStk.empty())
	    return minStk.peek();
	else
	    throw new NoSuchElementException();
    }

    public int size() {
        return queue.size();
    }
}


class Node<E> {
    public E datum;
    public Node<E> next;

    public Node(E d) {
	datum = d;
	next = null;
    }

    public void setDatum(E d) {
	datum = d;
    }

    public E getDatum() {
	return datum;
    }

    public void setNext(Node<E> n) {
	next = n;
    }

    public Node<E> getNext() {
	return next;
    }
}

class MyList<E> {
    public Node<E> head;
    public Node<E> tail;
    public int size;

    public MyList() {
	head = null;
	tail = null;
	size = 0;
    }

    public MyList(MyList<E> list) {
	if(list==null||list.head==null)
	   throw new IllegalArgumentException();
	Node<E> tmp1;
	for(tmp1=list.head;tmp1!=null;tmp1=tmp1.next)
	    this.add(tmp1.datum);
    }

    public void add(E e) {
	if(head==null) {
	    head = new Node<E>(e);
	    tail = head;
	}
	else {
	    Node<E> tmp = new Node<E>(e);
	    tail.next = tmp;
	    tail = tmp;
	}

	size++;
    }

    public E remove() {
	if(head==null)
	    throw new NoSuchElementException();

	if(head==tail) {
	    E e = head.datum;
	    head = null;
	    tail = head;
	    return e;
	}

        size--;

	Node<E> tmp = head;
	head = head.next;
	tmp.next = null;
	return tmp.datum;
    }

    public boolean isEmpty() {
	return size==0;
    }

    public int size() {
	return size;
    }
}

