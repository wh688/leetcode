package newHashMap;

public class MyHashMap<k, v> {
	private int DEFAULT_LIMIT = 16;	 
	private MapEntry<k, v>[] hashTable; 
	public MyHashMap() {
		hashTable = new MapEntry[DEFAULT_LIMIT];
	} 
	public MyHashMap(int limit) {
		hashTable = new MapEntry[limit];
	}
 	public v get(k key)  { 
		if (key == null) {
			throw new IllegalArgumentException("null key not supported");
		}
		MapEntry<k, v> entry = hashTable[key.hashCode() & (hashTable.length - 1)];
		while (entry != null && !key.equals(entry.getKey()))
			entry = entry.getNext();
		return entry != null ? entry.getValue() : null;
	} 
	public void put(k key, v value) { 
		if (key == null) {
			throw new IllegalArgumentException("null key not supported");
		} 
		MapEntry<k, v> entry = hashTable[key.hashCode() & (hashTable.length - 1)]; 
		if (null != entry) {
			boolean done = false;
			while (!done) {
				if (key.equals(entry.getKey())) {
					entry.setValue(value);
					done = true;
				} else if (entry.getNext() == null) {
					entry.setNext(new MapEntry<k, v>(key, value));
					done = true;
				}
				entry = entry.getNext();
			}
		} else {
			hashTable[key.hashCode() & (hashTable.length - 1)] = new MapEntry<k, v>(key, value);
		}
	}
}
