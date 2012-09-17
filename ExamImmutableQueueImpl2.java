package jp.co.worksap.recruiting;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExamImmutableQueueImpl<E> implements ExamImmutableQueue<E> {
    private MyList<E> queue;

    public ExamImmutableQueueImpl() {
	queue = new MyList<E>();
    }

    private ExamImmutableQueueImpl(MyList<E> queue) {
	this.queue = queue;
    }

    public ExamImmutableQueue<E> enqueue(E e) {
	if(e==null)
	    throw new IllegalArgumentException();
	MyList<E> clone = new MyList(queue);
        clone.add(e);

	return new ExamImmutableQueueImpl<E>(clone);
    }

    public ExamImmutableQueue<E> dequeue() {
    }

    public E peek() {
    }
    
    public int size() {
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

    public MyList() {
	head = null;
	tail = null;
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
    }

    public void remove() {
	if(head==null)
	    return;

	if(head==tail) {
	    head = null;
	    tail = head;
	    return;
	}

	Node<E> tmp = head;
	head = head.next;
	tmp.next = null;
    }
}
