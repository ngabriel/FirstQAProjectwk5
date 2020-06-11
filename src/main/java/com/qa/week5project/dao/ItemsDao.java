package com.qa.week5project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.week5project.Ims;
import com.qa.week5project.dao.connections.DatabaseConnection;
import com.qa.week5project.exceptions.NotFoundException;
import com.qa.week5project.models.Customer;
import com.qa.week5project.models.Item;
import com.qa.week5project.services.CustomerService;

public class ItemsDao {
	public static final Logger LOGGER = Logger.getLogger(ItemsDao.class);
	private static DatabaseConnection databaseConnection;
	

	public ItemsDao(DatabaseConnection databaseConnection) {
		super();
		this.databaseConnection = databaseConnection;
	}

	public static void insertItem(Item item) throws SQLException {
		String sql = "insert into items(item_name, item_price) values('" + item.getName() + "', '"
				+ item.getPrice() + "');";

		databaseConnection.sendUpdate(sql);
		
	}

	public List<Item> selectItems() throws SQLException {
		String sql = "select * from items";
		ResultSet rs = databaseConnection.sendQuery(sql);
		// System.out.println(import buffer));
		List<Item> items = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt("item_id");
			String name = rs.getString("item_name");
			Double price = rs.getDouble("item_price");
			
			Item item = new Item(id, name, price);
			
			items.add(item);
		}
		if (items.size()== 0) {
			throw new NotFoundException("No Items in table");

		}

		return items;

	}

	public void editItem(int id, String newName) throws SQLException {
		String sql = "update items set item_name = ? where item_id = ? ;";
		PreparedStatement preparedStatement = databaseConnection.getPreparedStatement(sql);
		preparedStatement.setString(1, newName);
		preparedStatement.setInt(2, id);
		if (preparedStatement.executeUpdate() == 0) {
			throw new NotFoundException("No records were changed as id did not match");
		};
	}



	public void deleteItem(int id) throws SQLException {
		String sql = "delete from items where item_id = " + id + ";";
		databaseConnection.sendUpdate(sql);
		
	}

	public static List<Item> selectItems(int id) throws SQLException {
		String sql = "select * from items where item_id = " +id;
		ResultSet rs = databaseConnection.sendQuery(sql);
		
		List<Item> items = new ArrayList<>();
		while (rs.next()) {
			
			int DBid = rs.getInt("item_id");
			String name = rs.getString("item_name");
			Double price = rs.getDouble("item_price");
			
			Item item = new Item(DBid, name, price);
			
			items.add(item);
		}
		if (items.isEmpty()) {
			throw new NotFoundException("No items in table");

		}
		return items;
	}
}