/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DanhMucSanPham;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CaterogyModify {
    
    //Hàm fillAll
    public static List<Caterogy> findAll(){
        List<Caterogy> caterogyList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
                
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Categories", "root", "");
            
            String sql = "select * from Categories";
            
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Caterogy caterogy = new Caterogy(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                caterogyList.add(caterogy);
            }
        } catch (Exception e) {
        }finally{
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return caterogyList;
    }
    
    //Hàm nhập thông tin sản phẩm
    public static void insert(Caterogy caterogy){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Categories", "root", "");
            
            String sql = "insert into categories( name) values( ?)";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, caterogy.getName());
            preparedStatement.execute();
            
            System.out.println("Nhập thành công");
        } catch (Exception e) {
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //Hàm xóa
    public static void delete(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Categories", "root", "");
            
            String sql = "delete from categories where id = ?";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Xóa thành công");
        } catch (Exception e) {
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    //lưu file
    
    public static List<Product> saveIntoFile(){
        List<Product> productList = new ArrayList<>();
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try {
            fos = new FileOutputStream("D:\\JavaSwing\\JavaSwing\\src\\DanhMucSanPham\\category.dat");
            oos = new ObjectOutputStream(oos);
            oos.writeObject(oos);
        } catch (Exception e) {
             Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
        return productList;
    }
    
    //read file
    public static List<Caterogy> readDataFromFile(){
        List<Caterogy> caterogyList = new ArrayList<>();
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            fis = new FileInputStream("D:\\JavaSwing\\JavaSwing\\src\\DanhMucSanPham\\category.dat");
            ois = new ObjectInputStream(ois);
            
            caterogyList = (List<Caterogy>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(CaterogyModify.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
        
        return caterogyList;
    }
}
