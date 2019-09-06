package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.samples.petclinic.owner.Owner;

public class JDBCApplication {

	public static void main(String[] args) {
		

		Owner owner = new Owner();
		owner.setFirstName("Jonas");
		owner.setLastName("Jonas");
		owner.setAddress("chelas");
		owner.setCity("Lisboa");
		owner.setTelephone("92333444");
		
		
		SpringApplication.run(PetClinicApplication.class, args);
			System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		PreparedStatement ps=null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic", "root", "");
			if (connection != null) {
				System.out.println("Conexión establecida");
			}

			statement = connection.createStatement();
			//String sql = "SELECT * FROM vets";
			//String sql1 = "SELECT * FROM vets WHERE id=?";
			//ResultSet rs = statement.executeQuery(sql);
			//ps=connection.prepareStatement(sql1);
//			ps.setInt(1,3 );
//			
//			ResultSet rs = ps.executeQuery();
//			
//			
//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("first_name");
//				String lastname = rs.getString("Last_name");
//
//				System.out.println("Id:" + id);
//				System.out.println("name:" + name);
//				System.out.println("apelido" + lastname);
//
//			}

			// TODO: hacer aqui los ejercicios del taller en la usando la Class Ejercicios
			System.out.println("\n\n===== EJERCICIO 1 =====");
			Ejercicios.ejercicio1(connection, statement);
			System.out.println("\n\n===== EJERCICIO 2 =====");
			Ejercicios.ejercicio2(connection, statement);
			System.out.println("\n\n===== EJERCICIO 3 =====");
			Ejercicios.ejercicio3(connection, statement);
			System.out.println("\n\n===== EJERCICIO 4 =====");
			Ejercicios.ejercicio4(connection);
			System.out.println("\n\n===== EJERCICIO 5 ===== ");
			Ejercicios.ejercicio5(connection);
			System.out.println(" \n\n===== RETO =====");
			 Ejercicios.reto(connection, owner);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if (statement != null)
					connection.close();
			} catch (SQLException se) {

			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
