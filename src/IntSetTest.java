import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class IntSetTest {

	@Before
	public void generateSets() {
		Random rnd = new Random(100);

		this.emptyIntSet = new IntSet(0);
		int capacity;
		for (int i = 0; i < 10; i++) {
			capacity = rnd.nextInt();
			this.intSetlist[i] = new IntSet(capacity);
			capacityArray[i] = capacity;
		}

	}

	private IntSet emptyIntSet;
	private final IntSet[] intSetlist = new IntSet[10];
	private final int[] capacityArray = new int[10];

	/**
	 * Creates a new set with 0 elements.
	 * 
	 * @param capacity
	 *            the maximal number of elements this set can have
	 * @pre capacity >= 0
	 * @post getCount() == 0
	 * @post getCapacity() == capacity
	 */
	@Test
	public void testIntSet() {
		for (int i = 0; i < this.intSetlist.length; i++) {
			IntSet set = this.intSetlist[i];
			int capacity = this.capacityArray[i];

			assert set.getCapacity() >= 0;
			assert set.getCount() == 0;
			assert set.getCapacity() == capacity;
		}
	}

	/**
	 * Test whether the set is empty.
	 * 
	 * @return getCount() == 0
	 */
	@Test
	public void testIsEmpty() {
		assert this.emptyIntSet.isEmpty();
		assert this.emptyIntSet.getCount() == 0;
	}

	/**
	 * Test whether a value is in the set
	 * 
	 * @return exists int v in getArray() such that v == value
	 */
	@Test
	public void testHas() {
		throw new UnsupportedOperationException("not yet implemented");
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
	@Test
	public void testAdd() {
		throw new UnsupportedOperationException("not yet implemented");
	}

	/**
	 * Removes a value from the set.
	 * 
	 * @post !has(value)
	 * @post this@pre.has(value) implies (getCount() == this@pre.getCount() - 1)
	 * @post !this@pre.has(value) implies (getCount() == this@pre.getCount())
	 */
	@Test
	public void testRemove() {
		throw new UnsupportedOperationException("not yet implemented");
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
	@Test
	public void testIntersect() {
		throw new UnsupportedOperationException("not yet implemented");
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
	@Test
	public void testUnion() {
		throw new UnsupportedOperationException("not yet implemented");
	}

	/**
	 * Returns a representation of this set as an array
	 * 
	 * @post return.length == getCount()
	 * @post forall int v in return: has(v)
	 */
	@Test
	public void testGetArray() {
		throw new UnsupportedOperationException("not yet implemented");
	}

	/**
	 * Returns the number of elements in the set.
	 */
	@Test
	public void testGetCount() {
		throw new UnsupportedOperationException("not yet implemented");
	}

	/**
	 * Returns the maximal number of elements in the set.
	 */
	@Test
	public void testGetCapacity() {
		throw new UnsupportedOperationException("not yet implemented");
	}

	/**
	 * Returns a string representation of the set. The empty set is represented
	 * as {}, a singleton set as {x}, a set with more than one element like {x,
	 * y, z}.
	 */
	@Test
	public void testToString() {
		throw new UnsupportedOperationException("not yet implemented");
	}

}
