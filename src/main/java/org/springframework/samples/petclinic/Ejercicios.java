package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.samples.petclinic.owner.Owner;

public class Ejercicios {

	public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
		// 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
		String sql = "SELECT * FROM owners";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("first_name");
			String lastname = rs.getString("Last_name");
			String adress = rs.getString("address");
			String city = rs.getString("city");
			String telephone = rs.getString("telephone");

			//
			System.out.println("Id:" + id);

			System.out.println("name:" + name);

			System.out.println("apelido" + lastname);
			System.out.println("adress:" + adress);
			System.out.println("cidade" + city);
			System.out.println("telephone:" + telephone);
			System.out.println("__________________");
		}

	}

	public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
		// 2. Insertarnos a nosotros como nuevo propietario de una mascota
		statement = connection.createStatement();
		String sql = "INSERT INTO owners (first_name, last_Name,address,city,telephone)"
				+ "VALUES ('Joao','Vasco','diracao','cidade','99999')";
		int row = statement.executeUpdate(sql);

	}

	public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
		// 3. Modificar nuestra ciudad por Sevilla
		// int numeroDeFilasModificadas = -1;
		// String sqlupdate = "UPDATE owners SET cidade=? WHERE id=?";
		statement = connection.createStatement();
		String sqlUpdate = "UPDATE owners " + "SET city = 'Sevilla' " + "WHERE first_name ='Joao'";

		int numeroDeFilasModificadas = statement.executeUpdate(sqlUpdate);

		System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

	}

	public static void ejercicio4(Connection connection) throws SQLException {
		// 4. Crear una variable de tipo String y buscar todos los Owner que coincidan
		// en nombre o apellido.

		// SELECT *
		// FROM suppliers
		// WHERE (state = 'California' AND supplier_id <> 900)
		// OR (supplier_id = 100);
		String sql = "SELECT * FROM owners WHERE first_name =? OR last_name=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, "Joao");
		ps.setString(2, "Black");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			// Retrieve by column name
			int id = rs.getInt("id");
			String name = rs.getString("first_name");
			String lastname = rs.getString("last_name");
			String morada = rs.getString("address");
			String city = rs.getString("city");
			String telefone = rs.getString("telephone");

			// Display values
			System.out.println("id: " + id);
			System.out.println("first_name: " + name);
			System.out.println("last_name: " + lastname);
			System.out.println("morada" + morada);
			System.out.println("cidade" + city);
			System.out.println("telefone" + telefone);
		}
	}

	public static void ejercicio5(Connection connection) throws SQLException {
		// 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y
		// teléfono (todas de tipo
		// String), un nuevo owner
		String SQL_INSERT = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?,?,?,?,?)";
		
		   PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);

	            preparedStatement.setString(1, "antonio");
	            preparedStatement.setString(2, "con");
	            preparedStatement.setString(3, "expo");
	            preparedStatement.setString(4, "lisboa");
	            preparedStatement.setString(5, "920349699");
	            int numeroDeFilasModificadas = -1;       

	            int row = preparedStatement.executeUpdate();
		System.out.println("Se han modificado " + row + " rows.");
		   

	}

	public static void reto(Connection connection,Owner owner) throws SQLException {
		
	
	String SQL_INSERTowner = "INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES (?,?,?,?,?)";
		int numeroDeFilasModificadas = -1;
		   PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERTowner);

	            preparedStatement.setString(1, owner.getFirstName());
	            preparedStatement.setString(2, owner.getLastName());
	            preparedStatement.setString(3, owner.getAddress());
	            preparedStatement.setString(4, owner.getCity());
	            preparedStatement.setString(5, owner.getTelephone());
	           

	            numeroDeFilasModificadas = preparedStatement.executeUpdate();
		System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

	}

}
