import java.util.Scanner;

public class StringMaxDP {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();

        String []s = new String[line];

        for(int i=0;i<line;i++) {
            String single = sc.next();
            s[i] = single;
        }

        int flag = 0;
        int count = 0;
        String pattern = sc.next();
        String tmp = "";

        int maxSize = 0;
        for(int i=0;i<line;i++) {
            if(s[i].length() > maxSize) {
                maxSize = s[i].length();
            }
        }
        int start = 0;
        for(int i=0;i<pattern.length();i++) {
            tmp = pattern.substring(start, i+1);
            for(int j=0;j<line;j++) {
                if(s[j].equals(tmp)) {
                    flag = 1;
                    count++;
                    break;
                }
            }

            if(tmp.length() >= maxSize) {
                start++;
                i = start-1;
            }
            if(flag == 1) {
                flag = 0;
                start++;
                i = start-1;
            }
        }

        System.out.println(count);

    }
}