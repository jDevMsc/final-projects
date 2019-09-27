package java.dao;

import entitiy.Flower;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class FlowerDAO extends AbstractDAO {

    private static FlowerDAO instance;

    private FlowerDAO() {
    }

    public static FlowerDAO getInstance() {
        if (instance == null) {
            instance = new FlowerDAO();
        }
        return instance;
    }
    public void addFlower(Flower flower) {

    }

    public List<Flower> getAll() {
        Connection connection = null;
        Statement statement = null;
        List<Flower> flowers = new ArrayList<Flower>();

        try {
            connection = getConnection();
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT f.id, fl.mark, f.price, " +
                    " f.ice_level, f.length_steak " +
                    "FROM flowers_exists f INNER JOIN flowers fl ON f.mark_id = fl.id WHERE f.bunch_id iS NULL ");

            while (rs.next()) {
                int id = rs.getInt(1);
                String mark = rs.getString(2);
                double price = rs.getDouble(3);
                Flower flower = new Flower();
                flower.setId(id);
                flower.setName(mark);
                flower.setPrice(price);
                flowers.add(flower);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && statement != null) {
                    connection.close();
                    statement.close();
                }
            } catch (SQLException  e) {
                e.printStackTrace();
            }
        }
        return flowers;
    }

    public void removeFlower(Flower flower) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("DELETE FROM flowers_exists WHERE id = ?");
            statement.setInt(1, flower.getId());
            int result = statement.executeUpdate();
            //проверка
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
