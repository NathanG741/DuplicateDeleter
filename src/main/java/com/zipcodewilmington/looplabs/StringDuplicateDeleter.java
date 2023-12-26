package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    public StringDuplicateDeleter(String[] stringArray) {
        super(stringArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        return countDuplicatesAndKeepInString(false, maxNumberOfDuplications);
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return countDuplicatesAndKeepInString(true, exactNumberOfDuplications);
    }

    private String[] countDuplicatesAndKeepInString(boolean isExact, int numberOfDuplications) {
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
                    str += this.array[i] + "/";
                }
            } else if (isExact) {
                if (count != numberOfDuplications) {
                    str += this.array[i] + "/";
                }
            }
        }

        if (str.isEmpty()) {
            return new String[]{};
        } else {
            return str.split("/");
        }
    }

}