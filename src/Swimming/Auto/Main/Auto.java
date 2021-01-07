package Swimming.Auto.Main;

import java.util.ArrayList;
import java.util.List;

public class Auto {
    public static String code;
    static List<Character> cList = new ArrayList<>();
    static List<Integer> indexList = new ArrayList<>();
    public static void autoGenerateCode(){
        //thực hiện add tất cả tất cả các ký tự từ a-->z A-->Z 0-->9
        autoGenerateChar();
        //code có trức năng sinh tự động
        //code có độ dài bằng  6 ký tự >> aaaaaa
        code = "SV";
        for (int i = 0; i < indexList.size(); i++) {
            int currenIdenx = indexList.get(i);
            code += String.valueOf(cList.get(currenIdenx));
        }
        int lastIndex = indexList.size() - 1;
        indexList.set(lastIndex, indexList.get(lastIndex) + 1);
        for (int i = indexList.size() - 1; i > 0; i--) {
            if (indexList.get(i) < cList.size()) {
                break;
            }
            indexList.set(i, 0);
            indexList.set(i - 1, indexList.get(i - 1) + 1);
        }
    }

    private static void autoGenerateChar(){
        if (cList.size() > 0) return;
        //sinh tự động mã code
        // code có 6 ký tự

        for (int i = (int)'0' ; i < (int)'9'; i++) {
            cList.add((char) i);
        }

        //lưu index tại thời điểm hiện tại
        for (int i = 0; i < 6; i++) {
            indexList.add(0);
        }
    }
}

