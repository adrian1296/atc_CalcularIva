
package calculadoraiva;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraIva extends JFrame implements ActionListener {
    
    private JLabel lblIva;
    private JLabel lblCantidad;
    private JButton boton;
    private JTextField caja;
    private JTextField cajaB;
     private JTextField cajaIva;  
     
     private JComboBox iva;
     private String selectIva;
     
    public CalculadoraIva(){
        super();
        configurarVentana();
        crearComponentes();
    }
    
    private void  configurarVentana(){
        this.setTitle("Calculadora Iva");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
     private void crearComponentes(){
        lblCantidad = new JLabel();
        lblCantidad.setText("CANTIDAD");
        lblCantidad.setBounds(60, 50, 100, 40);
        lblCantidad.setForeground(Color.black);
        this.add(lblCantidad);
        
        lblIva = new JLabel();
        lblIva.setText("IVA");
        lblIva.setBounds(60, 130, 100, 40);
        lblIva.setForeground(Color.black);
        this.add(lblIva);
        
        caja = new JTextField();
        caja.setBounds(50, 90, 100, 30);
        this.add(caja);
        
        /*cajaB = new JTextField();
        cajaB.setBounds(50, 250, 100, 30);
        this.add(cajaB);*/
        
        /*cajaIva = new JTextField();
        cajaIva.setBounds(50, 160, 100, 30);
        this.add(cajaIva);*/
        
        boton = new JButton();
        boton.setText("CALCULAR");
        boton.setBounds(50, 200, 100, 20);
        boton.addActionListener(this);
        this.add(boton);
        
        String[] ivaList = new String[]{"IVA","16","10","8"};
        JComboBox<String> iva = new JComboBox<>(ivaList);
        iva.setBounds(50, 170, 100, 25);
        iva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                selectIva = iva.getItemAt(iva.getSelectedIndex());
                System.out.println("el valor del iva es: "+selectIva);
            }
        });
        this.add(iva);
     }
     
     @Override
     public void actionPerformed(ActionEvent e){
         Double valor1 = Double.parseDouble(caja.getText());
         Double valorIva = Double.parseDouble(selectIva);
         Double iva = (valor1*valorIva)/100;
         Double suma  =  valor1 + iva;
         JOptionPane.showMessageDialog(this,"Resultado:  "+suma);
     }
  
    public static void main(String[] args) {
       CalculadoraIva ventana = new CalculadoraIva();
        ventana.setVisible(true);
    }
    
}
