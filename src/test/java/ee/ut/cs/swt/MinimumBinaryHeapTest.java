package ee.ut.cs.swt;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinimumBinaryHeapTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	private MinimumBinaryHeap heap;
	private List<Integer> result;

	@Before
	public void setUp() {
		heap = new MinimumBinaryHeap();
		result = new ArrayList<>();
		result.add(10);
		result.add(5);
		result.add(4);
		result.add(8);
		result.add(12);
	}

	@Test
	public void minHeapifyTest() {
		heap.minHeapify(result);
		assertEquals(4, heap.getArray().get(0), 0);
		// In min binary heap, smaller elements should have smaller indexes, so 5 should be on index 1
		// and 8 should be on index 2..
		assertEquals(5, heap.getArray().get(1), 0);
		assertEquals(8, heap.getArray().get(2), 0);
		// Added 2 more asserts to check the rest of the elements
		assertEquals(10, heap.getArray().get(3), 0);
		assertEquals(12, heap.getArray().get(4), 0);
	}

	@Test
	public void extractMinTest() {
		heap.add(7);
		heap.add(1);
		heap.add(6);
		int min = heap.exractMin();
		assertEquals(1, min);
	}

	@Test
	public void swapTest() {
		heap.add(5);
		heap.add(8);
		heap.add(13);
		heap.swap(1, 2);
		assertEquals(5, heap.getArray().get(0), 0);
		assertEquals(13, heap.getArray().get(1), 0);
		assertEquals(8, heap.getArray().get(2), 0);
	}

	@Test
	public void addTest() {
		heap.add(10);
		heap.add(5);
		heap.add(4);
		heap.add(8);
		heap.add(12);
		assertEquals(4, heap.getArray().get(0), 0);
		assertEquals(8, heap.getArray().get(1), 0);
		assertEquals(5, heap.getArray().get(2), 0);
	}

	@Test
	public void removeTest() {
		heap.add(5);
		heap.add(3);
		heap.add(2);
		boolean b1 = heap.remove(3);

		assertEquals(true, b1);
	}

	@Test
	public void isEmptyTest() {
		heap = new MinimumBinaryHeap();
		assertEquals(true, heap.isEmpty());
	}



	@Test
	public void removeNonExistElementTest() {
		heap.add(5);
		heap.add(3);
		heap.add(2);
		boolean b1 = heap.remove(8);

		assertEquals(false, b1);
	}

	@Test
	public void parentTest() {
		//Testing parent
		heap.add(8);
		heap.add(5);
		heap.add(6);
		//Array after bubbleUp how to be [5,8,6]
		//We got 5,6,8
		//incorrect line 60: int parent = (pos)/2;
		//Correct line: int parent = (pos - 1)/2;
		assertEquals(6, heap.getArray().get(2),0);
	}

	@Test
	public void extractMin1Test() {
		heap.add(7);
		heap.add(1);
		heap.add(6);
		heap.add(13);
		heap.add(18);
		heap.add(22);
		heap.add(-1);
		heap.add(66);
		int min = heap.exractMin();
		assertEquals(-1, min);
	}

	@Test
	public void removeElementTest() {
		heap.add(4);
		heap.add(6);
		heap.add(10);
		heap.add(7);
		heap.add(8);
		heap.add(9);
		boolean b1 = heap.remove(6);
		assertEquals(7,heap.getArray().get(1),0);
		assertEquals(true, b1);

	}

	@Test
	public void extractMin2Test() {
		heap.add(7);
		heap.add(3);
		heap.exractMin();
		heap.add(3);
		assertEquals(3,heap.getArray().get(0),0);

		heap.add(9);
		heap.add(1);
		ArrayList<Integer> expected = new ArrayList<>();
		expected.add(3);
		expected.add(9);
		expected.add(7);
		heap.exractMin();
		assertNotEquals(expected, heap.getArray());

		heap.bubbleDown(7);
		ArrayList<Integer> expected2 = new ArrayList<>();
		expected2.add(3);
		expected2.add(7);
		expected2.add(9);

		assertEquals(expected2,heap.getArray());
	}

	@Test
	public void isNonEmptyTest() {
		heap.add(5);
		assertEquals(false, heap.isEmpty());

	}

}
