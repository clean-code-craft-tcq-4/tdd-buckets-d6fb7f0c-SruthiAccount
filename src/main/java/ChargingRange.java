package main.java;

import java.util.*;

public class ChargingRange {

	public Map<String, Integer> calculateRanges(ArrayList<Integer> chargingData) {
		Collections.sort(chargingData);
		Map<String, Integer> csvFormatOutput = new HashMap<>();
		int prevElement = chargingData.get(0);
		int curIndex = 0;
		for (int j = 1; j < chargingData.size(); j++) {
			if ((chargingData.get(j) != prevElement) && (prevElement + 1 != chargingData.get(j))) {
				String key = chargingData.get(curIndex) + " - " + prevElement;
				csvFormatOutput.put(key, j - curIndex);
				curIndex = j;
			}
			if (j == chargingData.size() - 1) {
				String key = chargingData.get(curIndex) + " - " + chargingData.get(j);
				csvFormatOutput.put(key, j - curIndex + 1);
			}
			prevElement = chargingData.get(j);
		}
		System.out.println("Range, Readings");
		for (Map.Entry<String, Integer> entry : csvFormatOutput.entrySet())
			System.out.println(entry.getKey() + ", " + entry.getValue());
		return csvFormatOutput;
	}

}