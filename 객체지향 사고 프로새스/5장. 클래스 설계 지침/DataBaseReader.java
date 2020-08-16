
public class DataBaseReader {
	
	private String[] db = { "Record1", "Record2", "Record3", "Record4", "Record5" };
	private boolean DBOpen = false;
	private int pos;
	
	public void open(String name) {
		DBOpen = true;
	}
	
	public void close() {
		DBOpen = false;
	}
	
	public void goToFirst() {
		pos = 0;
	}
	
	public void goToLast() {
		pos = 4;
	}
	
	public int howManyRecords() {
		int numOfRecords = 5;
		return numOfRecords;
	}
	
	public String getRecord(int key) {
		return db[key];
	}
	
	public String getNextRecord() {
		return db[pos++];
	}
}
