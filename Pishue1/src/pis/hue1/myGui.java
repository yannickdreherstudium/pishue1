package pis.hue1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class myGui extends javax.swing.JFrame {

	private javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
	
	private javax.swing.JTextArea jArea1 = new javax.swing.JTextArea();
	 
    private javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    private javax.swing.JButton jButton1 = new javax.swing.JButton();
    private javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    private javax.swing.JTextField jTextField1 = new javax.swing.JTextField();
 
    public myGui() {
 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
        jPanel1.setLayout( new java.awt.FlowLayout() );
 
        jLabel1.setText ( "Klartext" );
        jPanel1.add ( jLabel1 );
        
//        jArea1.setSize(500, 500);
        jLabel1.add(jArea1);
        
        
        jButton1.setText ( "2. einjButton" );
 
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
 
        jPanel1.add ( jButton1 ) ;
 
        jTextField1.setText ( "3. ein jTextField" ) ;
        jPanel1.add ( jTextField1 ) ;
 
        jLabel2.setText ( "4. wieder ein jLabel usw." ) ;
        jPanel1.add ( jLabel2 ) ;
 
        this.getContentPane().add ( jPanel1 ) ;
 
        pack();
    }
 
    /**
     * Die Listener-Methode des JButton.
     * Wird von der oben implementierte ActionListener-Klasse aufgerufen.
     */
    private void jButton1ActionPerformed( java.awt.event.ActionEvent evt ) {
        
    }
 

    public static void main(String args[]) {
        new myGui().setVisible ( true );
    }
	

	
}
