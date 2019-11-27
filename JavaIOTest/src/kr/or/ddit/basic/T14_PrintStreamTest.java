package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 
 * 프린터기능 제공 보조스트림
 *
 */
public class T14_PrintStreamTest {

	public static void main(String[] args) throws IOException {
		FileOutputStream fout = new FileOutputStream("d:/D_Other/print.txt");
		FileOutputStream fout2 = new FileOutputStream("d:/D_Other/print2.txt");
		
		PrintStream out = new PrintStream(System.out);
		
		out.print("안녕하세요. PrintStream 입니다.\n");
		out.print("안녕하세요. PrintStream 입니다2.\n");
		out.print("안녕하세요. PrintStream 입니다3.\n");
		
		out.close();
	
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fout,"UTF-8"));
		writer.print("안녕하세요. PrintWriter 입니다. \r \n");
		writer.print("안녕하세요. PrintWriter 입니다2.");
		writer.print("안녕하세요. PrintWriter 입니다3.");
	}
}
