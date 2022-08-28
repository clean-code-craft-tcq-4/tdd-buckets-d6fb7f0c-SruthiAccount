package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

import main.java.ChargingRange;

public class ChargingRangeTest {
	ChargingRange chargingRange = new ChargingRange();

	@Test
	public void checkRangesOfTwoElements() {
		ArrayList<Integer> inputData = new ArrayList<>(Arrays.asList(1, 2));
		Map<String, Integer> result = chargingRange.calculateRanges(inputData);
		assertTrue(result.get("1 - 2") == 2);
	}

	@Test
	public void checkRangeOfTwoElementsFailed() {
		ArrayList<Integer> inputData = new ArrayList<>(Arrays.asList(3, 4));
		Map<String, Integer> result = chargingRange.calculateRanges(inputData);
		assertTrue(result.get("5 - 6") == null);
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
		ArrayList<Integer> inputData = new ArrayList<>(Arrays.asList(1, 9, 6, 7, 8, 9, 10,11));
		Map<String, Integer> result = chargingRange.calculateRanges(inputData);
		assertFalse(result.get("7 - 10") == 4);
		assertFalse(result.get("1 - 1") == 2);

	}
}