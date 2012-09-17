package jp.co.worksap.recruiting;

import java.util.List;
import java.util.NoSuchElementException;

public class ExamPeekableQueueImpl<E extends Comparable<E>> implements ExamPeekableQueue<E> {

    MyList<E> queue;

    public ExamPeekableQueueImpl() {
	queue = new MyList<E>();
    }

    public ExamPeekableQueueImpl(MyList<E> queue) {
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
	return queue.remove();
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
	    Node tmp = new Node<E>(e);
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

