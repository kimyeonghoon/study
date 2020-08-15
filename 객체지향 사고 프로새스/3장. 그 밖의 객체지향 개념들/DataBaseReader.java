
public class DataBaseReader {
	
	String dbName;
	int startPosition;
	
	// 이름만 초기화
	public DataBaseReader(String name) {
		dbName = name;
		startPosition = 0;
	}
	
	// 이름과 위치를 초기화
	public DataBaseReader(String name, int pos) {
		dbName = name;
		startPosition = pos;
	}

	public static void main(String[] args) {
		
		// 이름만
		DataBaseReader d = new DataBaseReader("김영훈");
		System.out.println(d.dbName + ", " + d.startPosition);
		
		// 이름 위치
		DataBaseReader dp = new DataBaseReader("영훈김", 50);
		System.out.println(dp.dbName + ", " + dp.startPosition);
	}

}

