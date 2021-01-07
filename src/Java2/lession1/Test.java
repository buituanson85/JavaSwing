package Java2.lession1;

public class Test {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append(1);
        builder.append(2);
        builder.append(3);
        System.out.println(builder.toString());
        float sum = 0;
        try {
            sum = Calculator.divide(3, 0);
            System.out.println(sum);
        } catch (DevideByZeroException e) {
            System.out.println(e.getMessage());
        }
        System.gc();//clear hệ thống dọn rác đẩy nhanh chương trình
    }
}
