import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) throws Exception {
		String str = "2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2";
//		String path = "src\\input00.txt";
//		try(BufferedReader br = new BufferedReader(new FileReader(path))){
//			str = br.readLine();
//		}
		List<Integer> tree = new ArrayList<Integer>();
		tree = Stream.of(str.split(" "))
					 .map(Integer::parseInt)
					 .collect(Collectors.toList());	
		int result = 0;
		for(int i = 0; true;) {
			if(tree.get(i) == 0) {
				for(int j = 0; j<tree.get(i+1);j++) {
					result += tree.get(i+2);
					tree.remove(i+2);
				}
				tree.remove(i);
				tree.remove(i);
				if(i > 1) {
					i -= 2;
					tree.set(i, tree.get(i)-1);
					continue;
				}
				if(i == 0) {
					break;
				}		
			}
			i+=2;
		}
		System.out.println("answer for (a): " + result);
	}
}
