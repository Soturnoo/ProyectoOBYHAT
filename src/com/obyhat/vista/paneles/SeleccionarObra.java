package com.obyhat.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.obyhat.controlador.BotonesSelecionarObra;

public class SeleccionarObra extends JFrame {

	private DefaultTableModel modeloTabla;
    private String [][] datos = {};
    private String [] column = {"Nombre","Cantidad"};
    private JTable tablaObras;
    
    private JScrollPane scrollPane;
	private JPanel contentPane,panelSur;
	
	private JButton btnSeleccionar;

	private BotonesSelecionarObra BO = new BotonesSelecionarObra(this);
	private PanelAsignar PA;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarObra frame = new SeleccionarObra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeleccionarObra() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Seleccionar material");
		setSize(650, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
			modeloTabla = new DefaultTableModel(null,column);
	        
	        scrollPane = new JScrollPane();
	        tablaObras= new JTable();
	        tablaObras.getTableHeader().setFont(new Font ("Acme", 1,15));// Encabezado de tablaObras.
	        tablaObras.setModel(modeloTabla);
	        scrollPane.setViewportView(tablaObras);
	        contentPane.add(scrollPane, BorderLayout.CENTER);
			
			panelSur = new JPanel();
			panelSur.setPreferredSize(new Dimension(0, 50));
			contentPane.add(panelSur, BorderLayout.SOUTH);
			
			btnSeleccionar = new JButton("Seleccionar");
			btnSeleccionar.addActionListener(BO);
			panelSur.add(btnSeleccionar);
			
		
			BO.obtenerMateriales();
	}
	
	public void limpiarTabla() {
	    	
		for (int i = 0; i < tablaObras.getRowCount(); i++) {
	            
			this.modeloTabla.removeRow(i);
			i-=1;
		}
	}
	    
	public final void insertarTabla(Object data[]){
	    	
		this.modeloTabla.addRow(data);
	}

	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}

	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}

	public JTable getTablaObras() {
		return tablaObras;
	}

	public void setTablaObras(JTable tablaObras) {
		this.tablaObras = tablaObras;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	
}