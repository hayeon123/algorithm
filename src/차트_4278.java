import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class 차트_4278 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> inputs = new ArrayList<>();
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			if(input==null|| input.isEmpty()) {
				break;
			}
			inputs.add(input);
		}
		for (int j = 0; j < inputs.size(); j++) {
			String st = inputs.get(j);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < st.length(); i++) {
				switch (st.charAt(i)) {
				case 'W':
					sb.append('Q');
					break;
				case 'E':
					sb.append('W');
					break;
				case 'R':
					sb.append('E');
					break;
				case 'T':
					sb.append('R');
					break;
				case 'Y':
					sb.append('T');
					break;
				case 'U':
					sb.append('Y');
					break;
				case 'I':
					sb.append('U');
					break;
				case 'O':
					sb.append('I');
					break;
				case 'P':
					sb.append('O');
					break;
				case '[':
					sb.append('P');
					break;
				case ']':
					sb.append('[');
					break;
				case '\\':
					sb.append(']');
					break;
				case 'S':
					sb.append('A');
					break;
				case 'D':
					sb.append('S');
					break;
				case 'F':
					sb.append('D');
					break;
				case 'G':
					sb.append('F');
					break;
				case 'H':
					sb.append('G');
					break;
				case 'J':
					sb.append('H');
					break;
				case 'K':
					sb.append('J');
					break;
				case 'L':
					sb.append('K');
					break;
				case ';':
					sb.append('L');
					break;
				case '\'':
					sb.append(';');
					break;
				case 'X':
					sb.append('Z');
					break;
				case 'C':
					sb.append('X');
					break;
				case 'V':
					sb.append('C');
					break;
				case 'B':
					sb.append('V');
					break;
				case 'N':
					sb.append('B');
					break;
				case 'M':
					sb.append('N');
					break;
				case ',':
					sb.append('M');
					break;
				case '.':
					sb.append(',');
					break;
				case '/':
					sb.append('.');
					break;
				case ' ':
					sb.append(' ');
					break;
				case '1':
					sb.append('`');
					break;
				case '2':
					sb.append('1');
					break;
				case '3':
					sb.append('2');
					break;
				case '4':
					sb.append('3');
					break;
				case '5':
					sb.append('4');
					break;
				case '6':
					sb.append('5');
					break;
				case '7':
					sb.append('6');
					break;
				case '8':
					sb.append('7');
					break;
				case '9':
					sb.append('8');
					break;
				case '0':
					sb.append('9');
					break;
				case '-':
					sb.append('0');
					break;
				case '=':
					sb.append('-');
					break;
				default:
					break;
				}
			}
			System.out.println(sb.toString());
		}
		
	}

}
