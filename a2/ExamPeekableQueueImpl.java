package jp.co.worksap.recruiting;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class ExamPeekableQueueImpl<E extends Comparable<E>> implements ExamPeekableQueue<E> {

    //ArrayDeque, a linear collection that supports element insertion and removal at both ends
    ArrayDeque<E> queue;
    ArrayDeque<E> maxQue;
    ArrayDeque<E> minQue;

    public ExamPeekableQueueImpl() {
	queue = new ArrayDeque<E>();
	maxQue = new ArrayDeque<E>();
	minQue = new ArrayDeque<E>();
    }

    public void enqueue(E e) {
	if(e==null)
	    throw new IllegalArgumentException();
	queue.add(e);

	if(maxQue.isEmpty())
	    maxQue.add(e);
	else {
	    //if there are elements "smaller" than e at the tail, remove them all
	    //and then add e to the tail;
	    //else just add e to the tail;
	    //this is to ensure that the maxQue is ordered "descendingly" with
	    //the maximum element at the head
	    while(!maxQue.isEmpty() && maxQue.peekLast().compareTo(e)<0)
	        maxQue.removeLast();
	    maxQue.add(e);
	}

	if(minQue.isEmpty())
	    minQue.add(e);
	else {
	    //if there are elements "larger" than e at the tail, remove them all
	    //and then add e to the tail;
	    //else just add e to the tail;
	    //this is to ensure that the minQue is ordered "ascendingly" with
	    //the minimum element at the head
	    while(!minQue.isEmpty() && minQue.peekLast().compareTo(e)>0)
		minQue.removeLast();
	    minQue.add(e);
	}
    }

    public E dequeue() {
	if(queue.isEmpty())
	    throw new NoSuchElementException();

	E e = queue.remove();

	//if the current maximum/minimum at the head of the maxQue/minQue is removed
	//the second largest/smallest element(right after the maximum/minimum)
	// in the maxQue/minQue will take the place
	if(!maxQue.isEmpty() && maxQue.peek().equals(e))
	    maxQue.remove();
	if(!minQue.isEmpty() && minQue.peek().equals(e))
	    minQue.remove();
	return e;
    }

    public E peekMedian() {
	if(queue.isEmpty())
	    throw new NoSuchElementException();
	//find the (size()/2+1)th smallest element
	//convert the ArrayDeque to Array to facilitate the following operations
	Object[] array = queue.toArray();
	return selectKth(array, 0, array.length-1, array.length/2+1);
    }

    public E peekMaximum() {
	if(maxQue.isEmpty())
	    throw new NoSuchElementException();
	return maxQue.peek();
    }

    public E peekMinimum() {
	if(minQue.isEmpty())
	    throw new NoSuchElementException();
	return minQue.peek();
    }

    public int size() {
        return queue.size();
    }

    ////////////////////////////////////
    // addtional methods
    ////////////////////////////////////
    
    public E selectKth(Object[] array,int left,int right,int k) {
	if(k>right+1||k<=0)
	    throw new NoSuchElementException();

	if(left>=right)
	    return (E)array[left];

	int partIndex = partition(array,left,right);
	if(partIndex+1==k) 
	    return (E)array[partIndex];
	else if(partIndex+1>k) 
	    return selectKth(array, left, partIndex-1, k);
	else
            return selectKth(array, partIndex+1, right, k-partIndex-1);
    }

    public int partition(Object[] array,int left,int right) {
	E pivot = (E)array[left];
	while(left<right) {
	    while(left<right && ((E)array[right]).compareTo(pivot)>=0) 
		right--;
	    array[left] = array[right];
	    while(left<right && ((E)array[left]).compareTo(pivot)<=0)
		left++;
	    array[right] = array[left];    
	}
	array[left] = pivot;

	return left;
    }
}


