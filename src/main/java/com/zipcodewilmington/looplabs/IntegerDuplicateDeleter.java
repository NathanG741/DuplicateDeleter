package com.zipcodewilmington.looplabs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        String str = countDuplicatesAndKeepInString(false, maxNumberOfDuplications);
        return parseStringToIntArray(str);
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String str = countDuplicatesAndKeepInString(true, exactNumberOfDuplications);
        return parseStringToIntArray(str);
    }

    private String countDuplicatesAndKeepInString(boolean isExact, int numberOfDuplications) {
        String str = "";

        for (int i = 0; i < this.array.length; i++) {
            int count = 0;
            for (int j = 0; j < this.array.length; j++) {
                if (this.array[i].equals(this.array[j])) {
                    count++;
                }
            }

            if (!isExact) {
                if (count < numberOfDuplications) {
                    str += this.array[i];
                }
            } else if (isExact) {
                if (count != numberOfDuplications) {
                    str += this.array[i];
                }
            }
        }

        return str;
    }

    private static Integer[] parseStringToIntArray(String str) {
        if (str.isEmpty()) {
            return new Integer[]{};
        } else {
            String[] strArray = str.split("");
            Integer[] intArray = new Integer[strArray.length];

            for (int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }

            return intArray;
        }
    }
}