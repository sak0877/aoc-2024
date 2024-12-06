import java.io.*;
import java.util.*;

class Main {

	public static boolean isSafe(ArrayList<Integer> levels) {
		boolean increasing = levels.get(0) < levels.get(1);
		for (int i = 0; i < levels.size() - 1; i++) {
			int current = levels.get(i);
			int next = levels.get(i + 1);
			int difference = Math.abs(current - next);
			if ((difference > 3) || (increasing && current > next) ||
				(!increasing && current < next) || (current == next)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkSafetyWithDampener(ArrayList<Integer> levels) {
		if (isSafe(levels)) return true;
		for (int i = 0; i < levels.size(); i++) {
			ArrayList<Integer> levelsCopy = new ArrayList<>(levels);
			levelsCopy.remove(i);
			if (isSafe(levelsCopy)) {
				return true;
			}
		}
		return false;
	}

	public static void main (String[] args) {
		int safeCount = 0;
		try {
			Scanner scanner = new Scanner(new File("1.in"));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] levelArr = line.split(" ");
				ArrayList<Integer> levels = new ArrayList<>();
				for (int i = 0; i < levelArr.length; i++) {
					levels.add(Integer.parseInt(levelArr[i]));
				}
				if (checkSafetyWithDampener(levels)) {
					safeCount++;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		System.out.println(safeCount);
	}
}
