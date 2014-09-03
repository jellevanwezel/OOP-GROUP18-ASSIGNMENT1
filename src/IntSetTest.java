import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

public class IntSetTest {

	@Before
	public void generateSets() {		
		Random rnd = new Random();
		int capacity;
		
		emptyIntSet = new IntSet(10);
		intSetlist = new IntSet[10];
		capacityArray = new int[10];
		
		for (int i = 0; i < 10; i++) {
			capacity = rnd.nextInt(100);
			this.intSetlist[i] = new IntSet(capacity);
			capacityArray[i] = capacity;
			for(int j = 0; j < capacity; j++){
				this.intSetlist[i].add(rnd.nextInt(9999));
			}
		}
	}

	private IntSet emptyIntSet;
	private IntSet[] intSetlist;
	private int[] capacityArray;
	
	
	private IntSet getFilledIntSet(){
		Random rnd = new Random();
		return intSetlist[rnd.nextInt(intSetlist.length)];
	}

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
		int capacity;
		IntSet set;
		for (int i = 0; i < this.intSetlist.length; i++) {
			set = this.intSetlist[i];
			capacity = this.capacityArray[i];

			assert set.getCapacity() >= 0;
			assert set.getCount() == 0;
			assert set.getCapacity() == capacity;
		}
		//todo doe dit fixen
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
		IntSet intSet = getFilledIntSet();
		intSet.add(5);
		assert intSet.has(5);
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
		int addValue = 5;
		IntSet intSet = new IntSet(1);
		int preCount = intSet.getCount();
		assert intSet.getCount() < intSet.getCapacity();
		intSet.add(addValue);
		assert intSet.has(addValue);
		assert intSet.getCount() == preCount + 1;
		preCount = intSet.getCount();
		intSet.add(addValue);
		assert intSet.getCount() == preCount;
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
		IntSet intSet = new IntSet(1);
		int preCount = intSet.getCount();
		int addValue = 5;
		intSet.remove(addValue);
		assert intSet.getCount() == preCount;
		intSet.add(addValue);
		preCount = intSet.getCount();
		intSet.remove(addValue);
		assert intSet.getCount() == preCount - 1;
		assert !intSet.has(addValue);
	}

	@Test
	public void testIntersect() {
		IntSet intSet = this.emptyIntSet;
		
		//Empty set
		assert intSet.intersect(intSet).isEmpty();
		assert intSet.intersect(intSet).getCapacity() == intSet.getCapacity();
		assert intSet.intersect(intSet).getCount() == intSet.getCount();
		
		IntSet firstIntSet = this.getFilledIntSet();
		IntSet secondIntSet = this.getFilledIntSet();
		
		IntSet result = firstIntSet.intersect(secondIntSet);
		
		//forall int v: return.has(v) implies (has(v) and other.has(v))
		for(int v : result.getArray()){
			assert firstIntSet.has(v) && secondIntSet.has(v);
		}
		//forall int v: (has(v) and other.has(v)) implies return.has(v)
		for(int v : firstIntSet.getArray()){
			assert result.has(v) == secondIntSet.has(v);
		}
	}

	@Test
	public void testUnion() {
		IntSet intSet = this.emptyIntSet;
		
		//Empty set
		assert intSet.union(intSet).isEmpty();
		assert intSet.union(intSet).getCapacity() == intSet.getCapacity();
		assert intSet.union(intSet).getCount() == intSet.getCount();
		
		IntSet firstIntSet = this.getFilledIntSet();
		IntSet secondIntSet = this.getFilledIntSet();
		
		IntSet result = firstIntSet.union(secondIntSet);
		
		//forall int v: has(v) implies return.has(v)
		for(int v : firstIntSet.getArray()){
			assert result.has(v);
		}
		
		//forall int v: other.has(v) implies return.has(v)
		for(int v : secondIntSet.getArray()){
			assert result.has(v);
		}
		
		//forall int v: return.has(v) implies (has(v) or other.has(v))
		for(int v : result.getArray()){
			assert firstIntSet.has(v) || secondIntSet.has(v);
		}
	}

	@Test
	public void testGetArray() {
		IntSet intSet = this.getFilledIntSet();
		Integer[] result = intSet.getArray();
		
		//return.length == getCount()
		assert result.length == intSet.getCount();
		
		//forall int v in return: has(v)
		for(int v : result){
			intSet.has(v);
		}
	}

	@Test
	public void testGetCount() {
		int count = 50;
		IntSet intSet = new IntSet(count);
		addRandomInts(intSet,count);
		assert intSet.getCount() == count;
	}
	
	private void addRandomInts(IntSet intSet,int amount){
		int randomInt = 4;//Chosen by fair dice roll.
						  //Guaranteed to be random.
						  //http://xkcd.com/221/
		for(int i =0; i < amount;i++){
			intSet.add(randomInt);
		}
	}

	
	/**
	 * Returns the maximal number of elements in the set.
	 */
	@Test
	public void testGetCapacity() {
		int capicity = 50;
		IntSet intSet = new IntSet(capicity);
		assert intSet.getCapacity() == capicity;
	}

	/**
	 * Returns a string representation of the set. The empty set is represented
	 * as {}, a singleton set as {x}, a set with more than one element like {x,
	 * y, z}.
	 */
	@Test
	public void testToString() {
		IntSet intSet = this.getFilledIntSet();
		String result = intSet.toString();
		String regex = "^{((\\d*)|(\\d+(\\,\\s\\d+)+))}$"; //Machtes {}, {a}, {a, b, c ....}
		assert Pattern.matches(regex, result);		
		result.replaceAll("[^0-9]+", " ");
		for(String v : Arrays.asList(result.trim().split(" "))){
			assert intSet.has(Integer.parseInt(v));
		}
	}

}
