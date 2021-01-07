package JavaII.JavaIIS1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String flag;
        Scanner sc = new Scanner(System.in);
        String exp = " ";
        String str;
        while (true){
            System.out.println("Enter expression");
            exp = sc.nextLine();

            Pattern pattern = Pattern.compile(exp);

            System.out.println("Enter String to seach");
            str = sc.nextLine();

            Matcher matcher = pattern.matcher(str);
            boolean found = false;

            while (matcher.find()){
                found = true;
                System.out.println("found: " + matcher.group());
            }

            if (!found){
                System.out.println("Not found");
            }

            System.out.println("Continue ?.");
            String rs = sc.nextLine();
            if (rs.equalsIgnoreCase("N")){
                break;
            }
            str.matches(" ");
        }
        System.out.println("bye...bye");

    }
}
