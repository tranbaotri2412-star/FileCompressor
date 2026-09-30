import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {

	public static void main(String[] args) throws IOException {

		Path path = Path.of("firstFile.txt");
		String content = Files.readString(path);
		System.out.println(content);
		Path des = Path.of("backup.txt");
//		Files.copy(path, des);

		String contDes = Files.readString(des);
		System.out.println(contDes);
	}
}