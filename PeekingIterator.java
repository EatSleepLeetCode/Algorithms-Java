import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> 
{
    Iterator<Integer> itr;
    Integer next;
    boolean noElemLeft = false;
    
	public PeekingIterator(Iterator<Integer> iterator) 
    {
	    this.itr = iterator;
        this.advanceItr();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() 
    {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() 
    {
	    if (noElemLeft)
        {
            return null;
        }
        else
        {
            Integer cache = next;
            this.advanceItr();           //update next
            return cache;               //return cached valued of next
        }
	}

	@Override
	public boolean hasNext() 
    {
	    return !noElemLeft;
	}
    
    public void advanceItr()
    {
        if (this.itr.hasNext())
        {
            next = itr.next();
        }
        else
        {
            noElemLeft = true;
        }
    }
}