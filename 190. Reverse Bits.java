public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }
        return result;
    }
}

//Optimization
//We can divide an int into 4 bytes, and reverse each byte then combine into an int. For each byte, we can use cache to improve performance.
public class Solution {
    // cache
	private final Map<Byte, Integer> cache = new HashMap<Byte, Integer>();//map can always check dublicate to make efficiency
	public int reverseBits(int n) {
		byte[] bytes = new byte[4];
		for (int i = 0; i < 4; i++) // convert int into 4 bytes
			bytes[i] = (byte)((n >>> 8*i) & 0xFF);
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += reverseByte(bytes[i]); // reverse per byte
			if (i < 3)
				result <<= 8;
		}
		return result;
	}

	private int reverseByte(byte b) {
		Integer value = cache.get(b); // first look up from cache
		if (value != null)
			return value;
		value = 0;
		// reverse by bit
		for (int i = 0; i < 8; i++) {
			value += ((b >>> i) & 1);
			if (i < 7)
				value <<= 1;
		}
		cache.put(b, value);
		return value;
	}
}