package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeTest {

    @Test
    public void testConstructorAndGetters() {
        Range range1 = new Range(0, 10);
        assertEquals(0, range1.getLowerBound(), 0.0001);
        assertEquals(10, range1.getUpperBound(), 0.0001);

        try {
            new Range(10, 0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }

        Range range2 = new Range(5, 5);
        assertEquals(5, range2.getLowerBound(), 0.0001);
        assertEquals(5, range2.getUpperBound(), 0.0001);
    }

    public void testConstructorWithInvalidArguments() {
        try {
            new Range(10, 0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected, do nothing
        }
    }
    @Test
    public void testContains() {
        Range range = new Range(5, 15);

        assertTrue(range.contains(5));
        assertTrue(range.contains(10));
        assertTrue(range.contains(15));

        assertFalse(range.contains(4));
        assertFalse(range.contains(16));

        assertTrue(range.contains(5.0));
        assertTrue(range.contains(15.0));
    }

    @Test
    public void testEquals() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 10);
        Range range3 = new Range(5, 15);

        assertTrue(range1.equals(range2));

        assertFalse(range1.equals(range3));

        assertFalse(range1.equals("Not a Range"));
    }

    @Test
    public void testHashCode() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 10);

        assertEquals(range1.hashCode(), range2.hashCode());

        assertNotEquals(range1.hashCode(), new Range(5, 15).hashCode());
    }

    @Test
    public void testToString() {
        Range range = new Range(0, 10);
        assertEquals("Range[0.0,10.0]", range.toString());
    }

    @Test
    public void testCombine() {
        Range range1 = new Range(0, 5);
        Range range2 = new Range(3, 10);

        assertEquals(range2, Range.combine(null, range2));
        assertEquals(range2, Range.combine(range2, null));

        assertNull(Range.combine(null, null));

        assertEquals(new Range(0, 10), Range.combine(range1, range2));
    }

    @Test
    public void testExpandToInclude() {
        Range range = new Range(5, 15);

        assertEquals(new Range(5, 15), Range.expandToInclude(range, 10));
        assertEquals(new Range(1, 15), Range.expandToInclude(range, 1));
        assertEquals(new Range(5, 20), Range.expandToInclude(range, 20));
        assertEquals(new Range(10, 10), Range.expandToInclude(null, 10));
    }

    @Test
    public void testExpand() {
        Range range = new Range(0, 10);

        assertEquals(new Range(-2, 12), Range.expand(range, 0.2, 0.2));
        assertEquals(new Range(-1, 11), Range.expand(range, -0.1, -0.1));
        assertEquals(range, Range.expand(range, 0, 0));
        assertNull(Range.expand(null, 0.1, 0.1));
    }

    
    @Test
    public void testShift() {
        Range range = new Range(5, 15);

        // Test shifting a non-null range
        assertEquals(new Range(7, 17), Range.shift(range, 2));

        // Test shifting a null range
        assertNull(Range.shift(null, 5)); // Mutated line
    }


    @Test
    public void testIntersects() {
        Range range = new Range(5, 15);

        assertTrue(range.intersects(0, 10));
        assertTrue(range.intersects(10, 20));
        assertTrue(range.intersects(0, 20));
        assertTrue(range.intersects(5, 15));
        assertTrue(range.intersects(0, 5));
        assertTrue(range.intersects(15, 20));

        assertFalse(range.intersects(-10, 0));
        assertFalse(range.intersects(20, 30));
    }

    @Test
    public void testGetLength() {
        Range range = new Range(0, 10);
        assertEquals(10, range.getLength(), 0.0001);
        Range range2 = new Range(-5, 5);
        assertEquals(10, range2.getLength(), 0.0001);
        Range range3 = new Range(0, 0);
        assertEquals(0, range3.getLength(), 0.0001);
    }

    @Test
    public void testGetCentralValue() {
        Range range = new Range(0, 10);
        assertEquals(5, range.getCentralValue(), 0.0001);
        Range range2 = new Range(-5, 5);
        assertEquals(0, range2.getCentralValue(), 0.0001);
        Range range3 = new Range(0, 0);
        assertEquals(0, range3.getCentralValue(), 0.0001);
    }

    @Test
    public void testConstrain() {
        Range range = new Range(5, 15);

        assertEquals(5, range.constrain(5), 0.0001);
        assertEquals(10, range.constrain(10), 0.0001);
        assertEquals(15, range.constrain(15), 0.0001);
        assertEquals(5, range.constrain(0), 0.0001);
        assertEquals(15, range.constrain(20), 0.0001);
        assertEquals(5, range.constrain(3), 0.0001);
        assertEquals(15, range.constrain(18), 0.0001);
        assertEquals(5, range.constrain(5.0), 0.0001);
        assertEquals(15, range.constrain(15.0), 0.0001);
    }

    @Test
    public void testShiftWithNoZeroCrossing() {
        assertEquals(Double.NEGATIVE_INFINITY, Range.shiftWithNoZeroCrossing(Double.NEGATIVE_INFINITY, 5), 0.0001);
        assertEquals(Double.POSITIVE_INFINITY, Range.shiftWithNoZeroCrossing(Double.POSITIVE_INFINITY, -5), 0.0001);
    }

    @Test
    public void testClamp() {
        assertEquals(Double.NaN, Range.clamp(Double.NaN, 10, 20), 0.0001);
        assertEquals(Double.POSITIVE_INFINITY, Range.clamp(Double.POSITIVE_INFINITY, 10, 20), 0.0001);
        assertEquals(Double.NEGATIVE_INFINITY, Range.clamp(Double.NEGATIVE_INFINITY, 10, 20), 0.0001);
    }

    // Additional test cases to achieve higher coverage

    
    
    
    @Test
    public void testShiftWithNoZeroCrossingPositiveValue() {
        assertEquals(6, Range.shiftWithNoZeroCrossing(0, 5), 0.0001); // Mutated line
        assertEquals(11, Range.shiftWithNoZeroCrossing(5, 5), 0.0001); // Mutated line
        assertEquals(16, Range.shiftWithNoZeroCrossing(10, 5), 0.0001); // Mutated line
    }


    @Test
    public void testShiftWithNoZeroCrossingNegativeValue() {
        assertEquals(-5, Range.shiftWithNoZeroCrossing(0, -5), 0.0001);
        assertEquals(-10, Range.shiftWithNoZeroCrossing(-5, -5), 0.0001);
        assertEquals(-15, Range.shiftWithNoZeroCrossing(-10, -5), 0.0001);
    }

    @Test
    public void testCombineWithNullRanges() {
        // Original line
        assertNull(Range.combine(null, null));

        // Mutated line
        // This line is mutated to return a fixed range instead of processing input ranges
        Range fixedRange = new Range(0, 100); // Example of a fixed range
        assertEquals(fixedRange, Range.combine(null, null)); // This line is mutated
        Range range = new Range(0, 10);
        assertEquals(range, Range.combine(null, range));
        assertEquals(range, Range.combine(range, null));
    }

}

