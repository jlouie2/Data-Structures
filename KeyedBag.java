package jlouie_hw_4_keyedbag;

/**
 *
 * @author Jocelyn Louie
 *
 * A bag that stores a string entry with a unique numeric key
 */
public class KeyedBag {

    private int[] key;
    private String[] data;
    private int items;

    public KeyedBag() {
        key = new int[10];
        data = new String[10];
        items = 0;
    }

    /**
     * @param entry 
     * A string entry, like a name
     * @param keyNum
     * A unique numeric entry that corresponds with the string
     * entry
     * @precondition
     * items<10 and keyNum not in bag already @return true if the
     * values were inserted and false if the values were not inserted
     */
    public boolean insert(String entry, int keyNum) {
        //full
        if (items == 10) {
            increaseCapacity((2 * items) + 1);
            data[items] = entry;
            key[items] = keyNum;
            items++;
            return true;
        } else if ((items < 10) && (inBag(keyNum) == false)) {
            data[items] = entry;
            key[items] = keyNum;
            items++;
            return true;
        }
        return false;
    }

    /**
     * @param newCapacity
     * the new increased numeric value of the capacity of the
     * arrays
     * @precondition
     * data.length<newCapacity
     */
    public void increaseCapacity(int newCapacity) {
        String[] newData;
        int[] newKey;
        if (data.length < newCapacity) {
            newData = new String[newCapacity];
            System.arraycopy(data, 0, newData, 0, items);

            newKey = new int[newCapacity];
            System.arraycopy(key, 0, newKey, 0, items);
        }
    }

    /**
     * @param keyNum
     * integer value that is used to retrieve string entry that
     * corresponds with it
     * @precondition
     * items>0
     * @return
     * returns true if the value is in the bag and false if the value is
     * not in the bag
    *
     */
    public boolean inBag(int keyNum) {
        if (items > 0) {
            for (int i = 0; i < items; i++) {
                if (key[i] == keyNum) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param keyNum
     * integer value that is used to retrieve string entry that
     * corresponds with it
     * @precondition
     * items>0
     * @return
     * returns true if the value was removed from the bag and false if
     * the value was not removed from the bag
    *
     */
    public boolean remove(int keyNum) {
        if (items > 0) {
            for (int i = 0; i < items; i++) {
                if (key[i] == keyNum) {
                    items--;
                    data[i] = data[items];
                    key[i] = key[items];
                    i = items;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param keyNum integer value that is used to retrieve string entry that
     * corresponds with it
     * @precondition
     * items>0
     * @return 
     * returns the string entry of the corresponding key or null if
     * value is not in bag
    *
     */
    public String retrieve(int keyNum) {
        if (items > 0) {
            for (int i = 0; i < items; i++) {
                if (key[i] == keyNum) return data[i];
            }
        }
        return null;
    }

}//end of KeyedBag class
