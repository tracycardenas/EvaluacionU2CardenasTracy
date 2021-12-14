package ec.edu.ups.EvaluacionU2Cardenas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.EvaluacionU2Cardenas.business.LibroONRemote;
import ec.edu.ups.EvaluacionU2Cardenas.model.Libro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaLibro extends JFrame {

	private JPanel contentPane;
	private JTextField Jnombre;
	private JTextField JTextAutor;
	private JTextField JTextNumpag;
	private JTextField JTextPrecio;
	private LibroONRemote liRemote;
	private JTextField JCodigoLibroBuscar;
	JButton btnactualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLibro frame = new VentanaLibro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void conectar() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "demopp59");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "demopp59");  
              
            final Context context = new InitialContext(jndiProperties);  
              
           
            final String lookupName2 = "ejb:/EvaluacionU2Cardenas/LibroON!ec.edu.ups.EvaluacionU2Cardenas.business.LibroONRemote";
            this.liRemote = (LibroONRemote) context.lookup(lookupName2);
            
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
	public void crearLibro() {
		Libro p = new Libro();
		p.setNombre(Jnombre.getText());
		p.setAutor(JTextAutor.getText());
		p.setNumPag(Integer.parseInt(JTextNumpag.getText()));
		p.setPrecio(Double.parseDouble(JTextPrecio.getText()));
		
		try {
			liRemote.insertarLibro(p);
			JOptionPane.showMessageDialog(null, "LIBRO INGRESADO CON ÉXITO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void cargarLibro() {
		Libro p = liRemote.buscarP(Integer.parseInt(JCodigoLibroBuscar.getText()));
		
		if (p==null) {
			JOptionPane.showMessageDialog(null, "Libro no Registrado");
			
		} else {
			Jnombre.setText(p.getNombre());
			JTextAutor.setText(p.getAutor());
			JTextNumpag.setText(p.getNumPag()+"");
			JTextPrecio.setText(p.getPrecio()+"");
			
			
			
			
		}
		
	}
	
	private void actualizarLibro() {
		Libro p = new Libro();
		p.setCodigo(Integer.parseInt(JCodigoLibroBuscar.getText()));
		p.setNombre(Jnombre.getText());
		p.setAutor(JTextAutor.getText());
		p.setNumPag(Integer.parseInt(JTextNumpag.getText()));
		p.setPrecio(Double.parseDouble(JTextPrecio.getText()));
		liRemote.actualizar(p);
		JOptionPane.showMessageDialog(null, "LIBRO ACTUALIZADO CORRECTAMENTE");
		
	}

	/**
	 * Create the frame.
	 */
	public VentanaLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(139, 144, 85, 15);
		contentPane.add(lblNewLabel);
		
		JLabel JAutor = new JLabel("Autor:");
		JAutor.setFont(new Font("Tahoma", Font.BOLD, 12));
		JAutor.setBounds(149, 186, 85, 15);
		contentPane.add(JAutor);
		
		JLabel JNumpag = new JLabel("Numero de paginas:");
		JNumpag.setFont(new Font("Tahoma", Font.BOLD, 12));
		JNumpag.setBounds(61, 226, 143, 16);
		contentPane.add(JNumpag);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(139, 272, 65, 15);
		contentPane.add(lblNewLabel_3);
		
		Jnombre = new JTextField();
		Jnombre.setBounds(217, 143, 96, 19);
		contentPane.add(Jnombre);
		Jnombre.setColumns(10);
		
		JTextAutor = new JTextField();
		JTextAutor.setBounds(217, 182, 96, 19);
		contentPane.add(JTextAutor);
		JTextAutor.setColumns(10);
		
		JTextNumpag = new JTextField();
		JTextNumpag.setBounds(217, 226, 96, 19);
		contentPane.add(JTextNumpag);
		JTextNumpag.setColumns(10);
		
		JTextPrecio = new JTextField();
		JTextPrecio.setBounds(217, 271, 96, 19);
		contentPane.add(JTextPrecio);
		JTextPrecio.setColumns(10);
		
		JButton btnNewButton = new JButton("Insertar Libro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectar();
					crearLibro();
					JCodigoLibroBuscar.setText("");
					Jnombre.setText("");
					JTextAutor.setText("");
					JTextNumpag.setText("");
					JTextPrecio.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton.setBounds(215, 321, 131, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("LIBRERIA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(185, 26, 110, 21);
		contentPane.add(lblNewLabel_1);
		
		JCodigoLibroBuscar = new JTextField();
		JCodigoLibroBuscar.setBounds(165, 78, 96, 19);
		contentPane.add(JCodigoLibroBuscar);
		JCodigoLibroBuscar.setColumns(10);
		
		JLabel Ingresa = new JLabel("Ingresar codigo:");
		Ingresa.setBounds(49, 81, 131, 13);
		contentPane.add(Ingresa);
		
		JButton bntbuscarLibro = new JButton("Buscar");
		bntbuscarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectar();
					cargarLibro();
					btnactualizar.setEnabled(true);
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		bntbuscarLibro.setBounds(294, 77, 85, 21);
		contentPane.add(bntbuscarLibro);
		
		btnactualizar = new JButton("Actualizar");
		btnactualizar.setEnabled(false);
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conectar();
					actualizarLibro();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnactualizar.setBounds(61, 321, 119, 20);
		contentPane.add(btnactualizar);
	}
}
