package Java2.lession1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Exception là lỗi sinh ra quá trình phát truyển dự án.
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        try {
            //int z = 5/0; ví dụ về ArrayIndexOutOfBoundsException
            for (int i = 0; i <= arr.length; i++){
                System.out.format("Nhập phần tử arr[%d]: ", i);
                arr[i] = Integer.parseInt(sc.nextLine());
            }
        }catch (ArrayIndexOutOfBoundsException e){ //chỉ khi gặp lỗi ArrayIndexOutOfBoundsException mới bỏ qua
            // được gọi vào khi chương trình gặp lỗi(exception)
            System.out.println(e.getMessage());
//            e.printStackTrace();  //code lỗi vân in code tiếp theo
        }finally {
            // được gọi khi chương trình có lỗi hoặc không có lỗi đều chạy vào
            System.out.println("Finish 1");
        }

        try {
            for (int i = 0; i <= arr.length; i++){
                System.out.println(arr[i]);
            }
        }catch (ArithmeticException ex){
//            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } catch (Exception e){// để Exception mọi lỗi gặp phải sẽ bỏ qua
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Finish 2");
            //được dùng tùy vào trường hợp vd:
        }

        try {
            //one connection (mở kết nối database)
                //giả sử mở kết nối thành công
            //query (viết truy vấn đến database)
            //--> nhưng đến query gặp lỗi

        }catch (Exception e){
            // chương trình nhảy xuống catch --> ko close conection đc
            //  -->nếu nhiều one connection mở kết nối đến database ko đóng được do gặp lỗi
            // --> chương trình chậm hệ thống làm hiệu năng hệ thống thấp do đó người ta quy định ra finally
        }finally {
            //để close connection (đóng database) ở finally dù thành công hay thất bại đều đóng được kết nối
            //những cái cần giải phóng tài nguyên người ta để ở finally vd: kết nối với database, dwload dữ liệu trên mạng
            // ,đọc ghi file,đọc ghi API từ ứng đụng khác vào hệ thống ...
        }
    }
}
