package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import Menu.Menu;
import login.acceso;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class acceso {

	private JFrame acc;
	private JTextField usu;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acceso window = new acceso();
					window.acc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public acceso() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		acc = new JFrame();
		acc.getContentPane().setBackground(new Color(255, 255, 255));
		acc.setBounds(100, 100, 450, 300);
		acc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		acc.getContentPane().setLayout(null);
		
		JLabel usuario = new JLabel("Usuario");
		usuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usuario.setBounds(79, 91, 45, 13);
		acc.getContentPane().add(usuario);
		
		JButton ingresar = new JButton("Ingresar");
		ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				  String us = (usu.getText());  
			      		     
			      String pas = pass.getText();
			      
			        try {
			          Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/construction","root" ,"");
			          Statement comando=conexion.createStatement();
			          ResultSet registro = comando.executeQuery("SELECT activo FROM usuarios WHERE usuario='"+us+"' AND pass='"+pas+"'");
			          if (registro.next()==true) {
			        	  
			        	  acceso ac = new acceso();
							ac.acc.setVisible(false);
			        	    Menu m = new Menu();
			        	    m.setVisible(true);		                 
			             
			             
			          } else {
			            ingresar.setText("Error en digitación");
			          }
			          conexion.close();
			        } catch(SQLException ex){
			          
			        }
			
			}
		});
		ingresar.setBounds(181, 194, 85, 21);
		acc.getContentPane().add(ingresar);
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(79, 142, 100, 13);
		acc.getContentPane().add(lblNewLabel);
		
		usu = new JTextField();
		usu.setBounds(196, 89, 96, 19);
		acc.getContentPane().add(usu);
		usu.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(196, 140, 96, 19);
		acc.getContentPane().add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema gestión construcción");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(116, 26, 267, 26);
		acc.getContentPane().add(lblNewLabel_1);
	}
}
