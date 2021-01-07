package JavaII.Assignment4;

import java.io.File;

public class FileOperation {
    String spaces = " ";

    public  void dirTree(String path){
        File file = new File(path);
        //Kiểm tra file có tồn tại hay ko
        if (!file.exists()){
            System.out.println("File not exists");
            return;
        }
        //kiểm tra xem file có phải là foder hay ko nếu có sẽ  in ra foder đó nếu ko kết thúc luôn
        // tmp biến đẩy lùi foder con vào một dấu cách
        if (file.isDirectory()){
            File[] listFile = file.listFiles();
            for (File f : file.listFiles()){
                if (f.isDirectory()){
                    System.out.println(spaces + "+ " + f.getName());
                    spaces += " ";
                    //do vẫn tiếp tục là file nên dequy tiếp
                    dirTree(f.getAbsolutePath());
                   spaces = spaces.substring(0, spaces.length() - 1);
                }else {
                    System.out.println(spaces + "-" + f.getName());
                }
            }
        }else {
            System.out.println(spaces + "-" + file.getName());
        }

    }
    //kiểm tra xóa file
        public boolean deleteFolder(String path){
        File file = new File(path);
        if (!file.exists()){
            return false;
        }
        if (file.isDirectory()){
            File[] listFiles= file.listFiles();
            for (File f : listFiles){
                deleteFolder(f.getAbsolutePath());
            }
        }
        return file.delete();
    }

}
