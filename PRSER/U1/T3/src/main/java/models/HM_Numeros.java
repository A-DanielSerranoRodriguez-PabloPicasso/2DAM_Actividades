package models;

import java.io.BufferedReader;
import java.io.IOException;

public class HM_Numeros {
	protected static int hacerMedia(int[] nums) throws IOException {
		int numbers = nums.length;
		String[] results = new String[nums.length + 4];
		results[0] = "java";
		results[1] = "-cp";
		results[2] = "./bin";
		results[3] = "models.HM_Numeros";

		for(int i = 0; i < numbers; i++) {
			results[i+4] = Integer.toString(nums[i]);
		}

		ProcessBuilder pb = new ProcessBuilder(results);
		Process p = pb.start();
		BufferedReader br = new BufferedReader(p.inputReader());
		return Integer.parseInt(br.readLine());
	}

	public static void main(String[] args) {
		int num = 0, total = args.length;
		for (int i = 0; i < total; i++) {
			num += Integer.parseInt(args[i]);
		}
		System.out.println(num / total);
	}
}
