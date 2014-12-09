package newHashMap;

public class MapEntry<k, v> {
	 
    private MapEntry<k, v> next;
    private final k key;
    private v value;
 
    public MapEntry(k key, v value) {
        this.key = key;
        this.setValue(value);
    }
 
    public k getKey() {
        return key;
    }
 
    public void setValue(v value) {
        this.value = value;
    }
 
    public v getValue() {
        return value;
    }
 
    public void setNext(MapEntry<k, v> next) {
        this.next = next;
    }
 
    public MapEntry<k, v> getNext() {
        return next;
    }
}

