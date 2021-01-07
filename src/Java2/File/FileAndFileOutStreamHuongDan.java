package Java2.File;

public class FileAndFileOutStreamHuongDan {
    /*Phần 1 cách tạo file
        File file = new File("son.txt");
         if (file.exists()){
            System.out.println("file tồn tại");
        }else {
            try {
                file.createNewFile();  lệnh tạo file mới
            }catch (IOException ex){
                Logger.getLogger(FileAndFileOutStream.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("file not found");
        }
        Phần 2 cách ghi dữ liệu vào file

        1.  FileOutputStream fileOutputStream = null; khởi tạo hàm mở file
        2.  fileOutputStream = new FileOutputStream("test.txt"); try cash
        3.  finally if (fileInputStream != null)  fileInputStream.close();  try cash
        4.  Scanner sc = new Scanner(System.in); Nhập từ bàn phím lưu vào file
        5.  for ( ; ; ){
                System.out.println("Insert line into file");
                String line = sc.nextLine() + "\n";  // "\n" ký tự xuống dòng
                byte[] b = line.getBytes();
                fileOutputStream.write(b);              try cash
                System.out.println("Continue Y/N");
                String choose = sc.nextLine();
                if (choose.equalsIgnoreCase("N")){
                    break;
                }
            }

          II. cách ghi thêm dữ liệu vào file dữ liệu cũ ko mất
          fileOutputStream = new FileOutputStream("test.txt", true)  để false dữ liệu sẽ ghi mới
    */
}
