// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    boolean hadPeekElment;
    Integer peekElement;
    Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.hadPeekElment = false;
        this.peekElement = null;   
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(hadPeekElment) {
            return this.peekElement;
        } else {
            var value = this.next();
            this.hadPeekElment = true;
            this.peekElement = value;
            return value;
        }
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(this.hadPeekElment) {
           this.hadPeekElment = !this.hadPeekElment;
           return this.peekElement;  
        }
        return this.iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    return hadPeekElment || this.iterator.hasNext();
	}
}