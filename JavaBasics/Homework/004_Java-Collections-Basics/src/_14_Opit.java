import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _14_Opit {

	public static List<File> res = new ArrayList<File>();

	public static void main(String[] args) throws IOException {

		File dit = new File("D:/Opit/");
		int level = 4;
		BFS(dit, level);

	}

	public static void BFS(File dir, int level) throws IOException {
		if (level == 0) {
			//System.out.println(dir.pathSeparator);
			return;
		}

		if (dir.isDirectory()) {
			
			String[] subDirsList = dir.list();
			System.out.println(dir.getAbsolutePath());
			
			for (String direct : subDirsList) {
				//System.out.println(direct);
				File newDir = new File(dir, direct);
				BFS(newDir, level - 1);
			}
		}	
	}

}
