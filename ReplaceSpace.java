public class NiuKeTwo {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("   ");
        char[] strChar = str.toString().toCharArray();
        int []a = new int[strChar.length];
        int j = 0;

        for(int i=0;i<a.length;i++) {
            a[i] = -1;
        }

        for(int i=0;i<strChar.length;i++) {
            if(strChar[i] == ' ') {
                a[j] = i;
                j++;
            }

        }

        int dis = 2;
        int mul = 1;
        for(int i=0;i<a.length;i++) {
            if(a[i] != -1) {
                if(i == 0) {
                    str.deleteCharAt(a[i]);
                    str.insert(a[i],"%20");
                } else {
                    a[i] += dis * mul;
                    mul++;
                    str.deleteCharAt(a[i]);
                    str.insert(a[i],"%20");
                }
            }

        }

        System.out.println(str);

    }
}
