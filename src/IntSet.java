import java.util.ArrayList;
import java.util.Arrays;
/**
 * Representation of a finite set of integers.
 * 
 * @invariant getCount() >= 0
 * @invariant getCount() <= getCapacity()
 */
public class IntSet {

	/**
	 * Creates a new set with 0 elements.
	 * 
	 * @param capacity
	 *            the maximal number of elements this set can have
	 * @pre capacity >= 0
	 * @post getCount() == 0
	 * @post getCapacity() == capacity
	 */
	public IntSet(int capacity) {
		this.set = new ArrayList<Integer>();
		this.capacity = capacity;
	}
	
	private ArrayList<Integer> set;
	private int capacity;
	

	/**
	 * Test whether the set is empty.
	 * 
	 * @return getCount() == 0
	 */
	public boolean isEmpty() {
		return this.set.isEmpty();
	}

	/**
	 * Test whether a value is in the set
	 * 
	 * @return exists int v in getArray() such that v == value
	 */
	public boolean has(int value) {
		return this.set.contains(new Integer(value));
	}

	/**
	 * Adds a value to the set.
	 * 
	 * @pre getCount() < getCapacity()
	 * @post has(value)
	 * @post !this@pre.has(value) implies (getCount() == this@pre.getCount() +
	 *       1)
	 * @post this@pre.has(value) implies (getCount() == this@pre.getCount())
	 */
	public void add(int value) {
		if(this.has(value) || this.getCount() + 1 > this.getCapacity() ){
			return;
		}
		set.add(value);
	}

	/**
	 * Removes a value from the set.
	 * 
	 * @post !has(value)
	 * @post this@pre.has(value) implies (getCount() == this@pre.getCount() - 1)
	 * @post !this@pre.has(value) implies (getCount() == this@pre.getCount())
	 */
	public void remove(int value) {
                Integer integerVal = new Integer(value);
		if(this.set.contains(integerVal)){
			this.set.remove(integerVal);
		}
	}

	/**
	 * Returns the intersection of this set and another set.
	 * 
	 * @param other
	 *            the set to intersect this set with
	 * @return the intersection
	 * @pre other != null
	 * @post forall int v: (has(v) and other.has(v)) implies return.has(v)
	 * @post forall int v: return.has(v) implies (has(v) and other.has(v))
	 */
	public IntSet intersect(IntSet other) {
		if(other == null){
			return null; //Or throw an Exception but the template did not throw one so I am returning null.
		}
		ArrayList<Integer> intersect = new ArrayList<Integer>(Arrays.asList(other.getArray()));
		intersect.retainAll(this.set);
		IntSet intersectIntSet = new IntSet(intersect.size());
		for(Integer v : intersect){
			intersectIntSet.add(v);
		}
		return intersectIntSet;
	}

	/**
	 * Returns the union of this set and another set.
	 * 
	 * @param other
	 *            the set to union this set with
	 * @return the union
	 * @pre other != null
	 * @post forall int v: has(v) implies return.has(v)
	 * @post forall int v: other.has(v) implies return.has(v)
	 * @post forall int v: return.has(v) implies (has(v) or other.has(v))
	 */
	public IntSet union(IntSet other) {
		if(other == null){
			return null; //Or throw an Exception but the template did not throw one so I am returning null.
		}
		ArrayList<Integer> union = new ArrayList<Integer>(Arrays.asList(other.getArray()));
		union.addAll(this.set);
		IntSet unionIntSet = new IntSet(union.size());
		for(Integer v : union){
			unionIntSet.add(v);
		}
		return unionIntSet;
	}

	/**
	 * Returns a representation of this set as an array
	 * 
	 * @post return.length == getCount()
	 * @post forall int v in return: has(v)
	 */
	public Integer[] getArray() {
		return this.set.toArray(new Integer[this.set.size()]);
	}

	/**
	 * Returns the number of elements in the set.
	 */
	public int getCount() {
		return this.set.size();
	}

	/**
	 * Returns the maximal number of elements in the set.
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Returns a string representation of the set. The empty set is represented
	 * as {}, a singleton set as {x}, a set with more than one element like {x,
	 * y, z}.
	 */
	@Override
	public String toString() {
		return Arrays.toString(this.getArray()).replaceAll("^\\[(.*)\\]$","{$1}");
	}

}