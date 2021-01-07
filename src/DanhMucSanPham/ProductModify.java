/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DanhMucSanPham;

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

public class ProductModify {
    
    public static void insertProduct(String  nameProduct, String price, String description, int idCategory){
       Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Categories", "root", "");
            
            String sql = "insert into products( name, price, description, id_categories) values( ?, ?, ?, ?)";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameProduct);
            preparedStatement.setString(2, price);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, String.valueOf(idCategory));
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
    
    public static List<Product> findAll(){
        List<Product> productList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
                
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Categories", "root", "");
            
            String sql = "select products.*, Categories.id, Categories.name categoryName from products, Categories where Categories.id = products.id_categories";
            
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {                
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("id_categories"),
                        resultSet.getString("categoryName")
                );
                productList.add(product);
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
        
        return productList;
    }
    
    //delete product
    public static void delete(int id){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Categories", "root", "");
            
            String sql = "delete from products where id = ?";
            
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
    
    // find
    
    public  static List<Product> searchByName(String nameProduct){
        List<Product> productList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //những câu truy vấn nào có dữ liệu đưa từ msql vào thì ta dùng PreparedStatement
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Categories", "root", "");
            
            String sql = "select * from products where name like ?";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nameProduct + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {                
                Product product = new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("description"),
                        resultSet.getInt("id_categories"),
                        resultSet.getString("categoryName")
                );
                productList.add(product);
            }
        } catch (Exception e) {
        }finally{
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return productList;
    }
}
