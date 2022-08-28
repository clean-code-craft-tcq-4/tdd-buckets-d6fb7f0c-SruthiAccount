package test.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChargingRangeTest {
	ChargingRange chargingRange = new ChargingRange();

	@Test
	public void checkRangesOfTwoElements() {
		ArrayList<Integer> inputData = new ArrayList<>(Arrays.asList(1, 2));
		Map<String, Integer> result = chargingRange.calculateRanges(inputData);
		assertTrue(!result.isEmpty());
		assertTrue(result.get("1 - 2") == 2);
	}

	@Test
	public void checkRangeOfTwoElementsFailed() {
		ArrayList<Integer> inputData = new ArrayList<>(Arrays.asList(3, 4));
		Map<String, Integer> result = chargingRange.calculateRanges(inputData);
		assertTrue(!result.isEmpty());
		assertTrue(result.get("1 - 2") == null);
	}

	@Test
	public void checkRangesMoreData() {
		ArrayList<Integer> inputData = new ArrayList<>(Arrays.asList(1, 9, 6, 7, 8, 9, 10));
		Map<String, Integer> result = chargingRange.calculateRanges(inputData);
		assertTrue(!result.isEmpty());
		assertTrue(result.get("6 - 10") == 6);
		assertTrue(result.get("3 - 3") == null);
	}

	@Test
	public void checkRangesMoreDataFailed() {
		ArrayList<Integer> inputData = new ArrayList<>(Arrays.asList(1, 9, 6, 7, 8, 9, 10));
		Map<String, Integer> result = chargingRange.calculateRanges(inputData);
		assertTrue(!result.isEmpty());
		assertFalse(result.get("6 - 10") == 4);
		assertFalse(result.get("1 - 1") == 2);

	}
}