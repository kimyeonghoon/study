package Classroom;

public class Student {

	int id;
	String name;
	int subnum;
	Test[] test;
	
	Student(int i, String n, int s) {
		id = i;
		name = n;
		subnum = s;
		test = new Test[s];
		for (int j = 0; j < s; j++) {
			test[j] = new Test();
		}
	}
	
	String getName() {
		return id + ":" + name;
	}
	
	int getGrade() {
		int sum = 0;
		for(int i = 0; i <subnum; i++) {
			sum += test[i].point;
		}
		return sum;
	}
	
	int getGrade(int a) {
		int base = 100 * subnum / a;
		int rank = getGrade() / base + 1;
		return (rank > a) ? a : rank;
	}
	
	void printScore() {
		System.out.println(getName());
		for(int i = 0; i <subnum; i++) {
			System.out.print(test[i].getPoint() + " ");
		}
		System.out.println();
		System.out.println("총점 : " + getGrade());
		int rank = 5;
		System.out.println(rank + "단계 평가 " + getGrade(rank));
		System.out.println();
	}
}
