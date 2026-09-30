import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

public class Main {

	public static void compress(Path input, Path output)
			throws IOException {

		try (
				InputStream in = Files.newInputStream(input);
				OutputStream out =
						new GZIPOutputStream(
								Files.newOutputStream(output)
						)
		) {
			byte[] buffer = new byte[8192];

			int bytesRead;

			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Path folder = Path.of("/Users/baotrihoccode/Desktop/FileIO");

		Scanner scanner = new Scanner(System.in);
		String fileInput = scanner.nextLine();
		String fileoutput = scanner.nextLine();

		Path input = folder.resolve(fileInput);
		Path output = folder.resolve(fileoutput);


		compress(input, output);
		System.out.println("Compression Completed");

		long originalSize = Files.size(input);
		long compressedSize = Files.size(output);

		System.out.println("Original: " + originalSize + " bytes");
		System.out.println("Compressed: " + compressedSize + " bytes");
	}
}