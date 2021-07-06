import java.util.ArrayList;
import java.util.Scanner;

public class TowerOfHanoi {
	
	public static int count = 0;
	public static ArrayList<String> arraylist = new ArrayList<>();

	public static void hanoi(int n, int start, int end, int via) {
		
		if(n == 1) {								// 이동할 원반의 수가 1개
			count++;
			arraylist.add(start + " " + end);		// 시작 -> 목표
		} else {
			hanoi(n-1, start, via, end);			// 원판 수 n-1개, 시작 -> 중간 -> 끝
			arraylist.add(start + " " + end);		// 시작 -> 끝
			count++;
			hanoi(n-1, via, end, start);			// 원판 수 n-1개, 중간 -> 끝 -> 시작
		}
	}
													// 제일 큰 원반을 제외한 나머지 원반은 중간을 거쳐야 한다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		hanoi(number, 1, 3, 2);
		
		System.out.println(count);
		for(String str : arraylist) {				// for-each문, arraylist를 끝까지 다 훑는다
			System.out.println(str);
		}
	}

}
