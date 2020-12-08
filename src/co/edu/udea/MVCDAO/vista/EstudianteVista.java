package co.edu.udea.MVCDAO.vista;
import co.edu.udea.MVCDAO.control.EstudianteControlador;
import co.edu.udea.MVCDAO.modelo.EstudianteDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EstudianteVista extends javax.swing.JFrame {
    private EstudianteControlador estudianteControlador = new EstudianteControlador();

    public EstudianteVista() {
        initComponents();
        initBaseDatos();
        initGender();
        this.setLocationRelativeTo(null);
        this.jPanelPrincipal.setVisible(false);
    }
    
    public void initGender()
    {
        this.jButtonMen.setVisible(false);
        this.jButtonWomen.setVisible(false);
        this.jTextPrincipal.setVisible(false);
        this.jScrollPane1.setVisible(false);
    }
    public void initBaseDatos()
    {
        estudianteControlador.updateBaseDatos();
    }
    
    public void setButtons(boolean a){
        this.jButtonAdd.setEnabled(a);
        this.jButtonDelete.setEnabled(a);
        this.jButtonExit.setEnabled(a);
        this.jButtonList.setEnabled(a);
        this.jButtonRead.setEnabled(a);
        this.jButtonUpdate.setEnabled(a);
    }
    
    public void setPanel(){
        this.jPanelPrincipal.setVisible(false);
    }
    
    public void readInicio(EstudianteDTO a){
        // L a b e l s
        Label nom = new Label("Nombres: "+a.getNombre());
        Label ape = new Label("Apellidos: "+a.getApellidos());
        Label ide = new Label("Identificacion: "+a.getIdentificacion());
        Label gen = new Label("Genero: "+a.getGenero());
        nom.setLocation(90,100);
        ape.setLocation(90,140);
        ide.setLocation(90,180);
        gen.setLocation(90,220);
        nom.setSize(600,50);
        ape.setSize(600,50);
        ide.setSize(600,50);
        gen.setSize(600,50);
        nom.alinear();
        ape.alinear();
        ide.alinear();
        gen.alinear();
        this.jPanelPrincipal.add(nom);
        this.jPanelPrincipal.add(ape);
        this.jPanelPrincipal.add(ide);
        this.jPanelPrincipal.add(gen);
        // B u t t o n
        Button readCon = new Button("Confirmar");
        readCon.setLocation(jPanelPrincipal.getWidth()/2-readCon.getWidth()/2,jPanelPrincipal.getHeight()-readCon.getHeight()*2);
        this.jPanelPrincipal.add(readCon);
        
        ActionListener boton = (ActionEvent ae) -> {
            setPanel();
            nom.setVisible(false);
            ape.setVisible(false);
            ide.setVisible(false);
            gen.setVisible(false);
            readCon.setVisible(false);
            setButtons(true);
        };
        readCon.addActionListener(boton);
        // B u t t o n s O F F
        setButtons(false);
    }
    
    public void updateInicio(EstudianteDTO est){
        // L a b e l s
        Label nom = new Label("Nombres:");
        Label ape = new Label("Apellidos:");
        Label ide = new Label("Identificacion:");
        Label gen = new Label("Genero:");
        nom.setLocation(90,100);
        ape.setLocation(90,140);
        ide.setLocation(90,180);
        gen.setLocation(90,220);
        this.jPanelPrincipal.add(nom);
        this.jPanelPrincipal.add(ape);
        this.jPanelPrincipal.add(ide);
        this.jPanelPrincipal.add(gen);
        // T e x t p a n e
        Text txtNom = new Text();
        Text txtApe = new Text();
        Text txtIde = new Text();
        txtNom.setLocation(350,110);
        txtApe.setLocation(350,150);
        txtIde.setLocation(350,190);
        txtNom.setText(est.getNombre());
        txtApe.setText(est.getApellidos());
        txtIde.setText(est.getIdentificacion());
        this.jPanelPrincipal.add(txtNom);
        this.jPanelPrincipal.add(txtApe);
        this.jPanelPrincipal.add(txtIde);
        // G E N D E R
        jButtonMen.setVisible(true);
        jButtonWomen.setVisible(true);
        // B u t t o n
        Button updateCon = new Button("Actualizar");
        updateCon.setSize(250,40);
        updateCon.setLocation(jPanelPrincipal.getWidth()/2-updateCon.getWidth()/2,jPanelPrincipal.getHeight()-updateCon.getHeight()*2);
        this.jPanelPrincipal.add(updateCon);
        
        ActionListener boton = (ActionEvent ae) -> {
            est.setNombre(txtNom.getText());
            est.setApellidos(txtApe.getText());
            est.setIdentificacion(txtIde.getText());
            if(jButtonMen.isSelected())
            {
                est.setGenero('m');
            }
            else if(jButtonWomen.isSelected())            
            {
                est.setGenero('f');
            }
            estudianteControlador.updateEstudiante(est);
            setPanel();
            nom.setVisible(false);
            ape.setVisible(false);
            ide.setVisible(false);
            gen.setVisible(false);
            updateCon.setVisible(false);
            txtNom.setText(null);
            txtApe.setText(null);
            txtIde.setText(null);
            txtNom.setVisible(false);
            txtApe.setVisible(false);
            txtIde.setVisible(false);
            jButtonMen.setVisible(false);
            jButtonWomen.setVisible(false);
            setButtons(true);
        };
        updateCon.addActionListener(boton);
        // B u t t o n s O F F
        setButtons(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanelPrincipal = new javax.swing.JPanel();
        jLabelTituloPanel = new javax.swing.JLabel();
        jButtonMen = new javax.swing.JRadioButton();
        jButtonWomen = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPrincipal = new javax.swing.JTextArea();
        jLabelTitle1 = new javax.swing.JLabel();
        jLabelTitle2 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonList = new javax.swing.JButton();
        jButtonRead = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Base de Datos - Estudiantes");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(132, 163, 184));
        jPanelPrincipal.setForeground(new java.awt.Color(0, 153, 153));
        jPanelPrincipal.setLayout(null);

        jLabelTituloPanel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTituloPanel.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTituloPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelPrincipal.add(jLabelTituloPanel);
        jLabelTituloPanel.setBounds(0, 0, 640, 74);

        jButtonMen.setBackground(new java.awt.Color(132, 163, 184));
        buttonGroup.add(jButtonMen);
        jButtonMen.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButtonMen.setText("Masculino");
        jButtonMen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelPrincipal.add(jButtonMen);
        jButtonMen.setBounds(319, 232, 131, 31);

        jButtonWomen.setBackground(new java.awt.Color(132, 163, 184));
        buttonGroup.add(jButtonWomen);
        jButtonWomen.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButtonWomen.setText("Femenino");
        jButtonWomen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelPrincipal.add(jButtonWomen);
        jButtonWomen.setBounds(456, 232, 129, 31);

        jScrollPane1.setEnabled(false);

        jTextPrincipal.setColumns(20);
        jTextPrincipal.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextPrincipal.setRows(5);
        jTextPrincipal.setEnabled(false);
        jScrollPane1.setViewportView(jTextPrincipal);

        jPanelPrincipal.add(jScrollPane1);
        jScrollPane1.setBounds(16, 86, 597, 220);

        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 640, 410));

        jLabelTitle1.setFont(new java.awt.Font("Felix Titling", 1, 48)); // NOI18N
        jLabelTitle1.setForeground(new java.awt.Color(0, 153, 153));
        jLabelTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle1.setText("estudiantes");
        jLabelTitle1.setToolTipText("");
        getContentPane().add(jLabelTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 960, 80));

        jLabelTitle2.setFont(new java.awt.Font("Felix Titling", 1, 48)); // NOI18N
        jLabelTitle2.setForeground(new java.awt.Color(0, 153, 153));
        jLabelTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle2.setText("Bienvenid@ a la base de datos");
        jLabelTitle2.setToolTipText("");
        getContentPane().add(jLabelTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 960, 80));

        jButtonAdd.setBackground(new java.awt.Color(0, 153, 153));
        jButtonAdd.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jButtonAdd.setText("Agregar ");
        jButtonAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAdd.setName(""); // NOI18N
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 230, 60));

        jButtonList.setBackground(new java.awt.Color(0, 153, 153));
        jButtonList.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jButtonList.setText("Listar");
        jButtonList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonList.setName(""); // NOI18N
        jButtonList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 230, 60));

        jButtonRead.setBackground(new java.awt.Color(0, 153, 153));
        jButtonRead.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jButtonRead.setText("Consultar");
        jButtonRead.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRead.setName(""); // NOI18N
        jButtonRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReadActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 230, 60));

        jButtonUpdate.setBackground(new java.awt.Color(0, 153, 153));
        jButtonUpdate.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jButtonUpdate.setText("Actualizar ");
        jButtonUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUpdate.setName(""); // NOI18N
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 230, 60));

        jButtonDelete.setBackground(new java.awt.Color(0, 153, 153));
        jButtonDelete.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jButtonDelete.setText("Borrar");
        jButtonDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonDelete.setName(""); // NOI18N
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 230, 60));

        jButtonExit.setBackground(new java.awt.Color(0, 153, 153));
        jButtonExit.setFont(new java.awt.Font("Felix Titling", 1, 24)); // NOI18N
        jButtonExit.setText("Salir");
        jButtonExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonExit.setName(""); // NOI18N
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 230, 60));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udea/MVCDAO/vista/img/background.jpg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 958, 626));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Boton A G R E G A R
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        this.jLabelTituloPanel.setText(" Agregar Estudiantes ");
        this.jPanelPrincipal.setVisible(true);
        // L a b e l s
        Label nom = new Label("Nombres:");
        Label ape = new Label("Apellidos:");
        Label ide = new Label("Identificacion:");
        Label gen = new Label("Genero:");
        nom.setLocation(90,100);
        ape.setLocation(90,140);
        ide.setLocation(90,180);
        gen.setLocation(90,220);
        this.jPanelPrincipal.add(nom);
        this.jPanelPrincipal.add(ape);
        this.jPanelPrincipal.add(ide);
        this.jPanelPrincipal.add(gen);
        // T e x t p a n e
        Text txtNom = new Text();
        Text txtApe = new Text();
        Text txtIde = new Text();
        txtNom.setLocation(350,110);
        txtApe.setLocation(350,150);
        txtIde.setLocation(350,190);
        this.jPanelPrincipal.add(txtNom);
        this.jPanelPrincipal.add(txtApe);
        this.jPanelPrincipal.add(txtIde);
        // G E N D E R
        jButtonMen.setVisible(true);
        jButtonWomen.setVisible(true);
        // B u t t o n
        Button AddCon = new Button("Confirmar");
        AddCon.setLocation(jPanelPrincipal.getWidth()/2-AddCon.getWidth()/2,jPanelPrincipal.getHeight()-AddCon.getHeight()*2);
        this.jPanelPrincipal.add(AddCon);
        
        ActionListener boton = (ActionEvent ae) -> {
            EstudianteDTO estudiante = new EstudianteDTO();
            estudiante.setNombre(txtNom.getText());
            estudiante.setApellidos(txtApe.getText());
            estudiante.setIdentificacion(txtIde.getText());
            if(jButtonMen.isSelected())
            {
                estudiante.setGenero('m');
            }
            else if(jButtonWomen.isSelected())
            {
                estudiante.setGenero('f');
            }
            estudianteControlador.storeEstudiante(estudiante);
            setPanel();
            nom.setVisible(false);
            ape.setVisible(false);
            ide.setVisible(false);
            gen.setVisible(false);
            AddCon.setVisible(false);
            txtNom.setText(null);
            txtApe.setText(null);
            txtIde.setText(null);
            txtNom.setVisible(false);
            txtApe.setVisible(false);
            txtIde.setVisible(false);
            jButtonMen.setVisible(false);
            jButtonWomen.setVisible(false);
            setButtons(true);
        };
        AddCon.addActionListener(boton);
        // B u t t o n s O F F
        setButtons(false);
    }//GEN-LAST:event_jButtonAddActionPerformed
    
    // Boton L I S T A R
    private void jButtonListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListActionPerformed
        this.jLabelTituloPanel.setText(" Listar Estudiantes ");
        this.jPanelPrincipal.setVisible(true);
//        TextArea text = new TextArea();
//        this.jPanelPrincipal.add(text);
        this.jScrollPane1.setVisible(true);
        this.jScrollPane1.setLocation(25,100);
       
        this.jTextPrincipal.setVisible(true);
        this.jTextPrincipal.setLocation(25,100);
        this.jTextPrincipal.setSize(590,200);
        String lista = "";
        for(int i = 0; i < estudianteControlador.listEstudiantes().size(); i++)
        {
            EstudianteDTO x = estudianteControlador.listEstudiantes().get(i);
            lista = lista + "\n" + x.toString();
        } 
        this.jTextPrincipal.setText(lista);
        
        Button listCon = new Button("Confirmar");
        listCon.setLocation(jPanelPrincipal.getWidth()/2-listCon.getWidth()/2,jPanelPrincipal.getHeight()-listCon.getHeight()*2);
        this.jPanelPrincipal.add(listCon);
        
        ActionListener boton = (ActionEvent ae) -> {
            setPanel();
            this.jScrollPane1.setVisible(false);
            this.jTextPrincipal.setText(null);
            this.jTextPrincipal.setVisible(false);
            listCon.setVisible(false);
            setButtons(true);
        };
        listCon.addActionListener(boton);
        setButtons(false);
    }//GEN-LAST:event_jButtonListActionPerformed

    // Boton C O N S U L T A R
    private void jButtonReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReadActionPerformed
        this.jLabelTituloPanel.setText(" Consultar Estudiantes ");
        this.jPanelPrincipal.setVisible(true);
        // L a b e l
        Label consultar = new Label("Identificacion:");
        consultar.setLocation(90,100);
        this.jPanelPrincipal.add(consultar);
        // T e x t p a n e
        Text txtIde = new Text();
        txtIde.setLocation(360,100);
        this.jPanelPrincipal.add(txtIde);
        // B u t t o n
        Button con = new Button("Consultar");
        con.setLocation(jPanelPrincipal.getWidth()/2-con.getWidth()/2,jPanelPrincipal.getHeight()-con.getHeight()*2);
        this.jPanelPrincipal.add(con);
        
        // Accion B U T T O N
        ActionListener boton = (ActionEvent ae) -> {
            EstudianteDTO a = estudianteControlador.searchEstudiante(txtIde.getText());
            if(a != null)
            {
                txtIde.setText(null);
                txtIde.setVisible(false);
                con.setVisible(false);
                consultar.setVisible(false);
                readInicio(a);
            }else
            {
                setPanel();
                txtIde.setText(null);
                consultar.setVisible(false);
                txtIde.setVisible(false);
                con.setVisible(false);
                setButtons(true);
            }     
        };
        con.addActionListener(boton);
        setButtons(false);
    }//GEN-LAST:event_jButtonReadActionPerformed
    
    // Boton A C T U A L I Z A R 
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        this.jLabelTituloPanel.setText(" Actualizar Estudiantes ");
        this.jPanelPrincipal.setVisible(true);
        // L a b e l
        Label consultar = new Label("Identificacion:");
        consultar.setLocation(90,100);
        this.jPanelPrincipal.add(consultar);
        // T e x t p a n e
        Text txtIde = new Text();
        txtIde.setLocation(360,100);
        this.jPanelPrincipal.add(txtIde);
        // B u t t o n
        Button con = new Button("Siguiente");
        con.setLocation(jPanelPrincipal.getWidth()/2-con.getWidth()/2,jPanelPrincipal.getHeight()-con.getHeight()*2);
        this.jPanelPrincipal.add(con);
        
        ActionListener boton = (ActionEvent ae) -> {
            EstudianteDTO est = estudianteControlador.searchEstudiante(txtIde.getText());
            if(est != null)
            {
                txtIde.setText(null);
                consultar.setVisible(false);
                txtIde.setVisible(false);
                con.setVisible(false);
                updateInicio(est);
            }else
            {
                setPanel();
                txtIde.setText(null);
                consultar.setVisible(false);
                txtIde.setVisible(false);
                con.setVisible(false);
                setButtons(true);
            }
        };
        con.addActionListener(boton);
        setButtons(false);
    }//GEN-LAST:event_jButtonUpdateActionPerformed
    
    // Boton B O R R A R
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        this.jLabelTituloPanel.setText(" Borrar Estudiantes ");
        this.jPanelPrincipal.setVisible(true);
        // L a b e l
        Label consultar = new Label("Identificacion:");
        consultar.setLocation(90,100);
        this.jPanelPrincipal.add(consultar);
        // T e x t p a n e
        Text txtIde = new Text();
        txtIde.setLocation(360,100);
        this.jPanelPrincipal.add(txtIde);
        // B u t t o n
        Button con = new Button("Borrar");
        con.setLocation(jPanelPrincipal.getWidth()/2-con.getWidth()/2,jPanelPrincipal.getHeight()-con.getHeight()*2);
        this.jPanelPrincipal.add(con);
        
        ActionListener boton = (ActionEvent ae) -> {
            estudianteControlador.deleteEstudiante(txtIde.getText());
            setPanel();
            txtIde.setText(null);
            consultar.setVisible(false);
            txtIde.setVisible(false);
            con.setVisible(false);
            setButtons(true);
        };
        con.addActionListener(boton);
        setButtons(false);
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    // Botono S A L I R
    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new EstudianteVista().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonList;
    private javax.swing.JRadioButton jButtonMen;
    private javax.swing.JButton jButtonRead;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JRadioButton jButtonWomen;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JLabel jLabelTitle2;
    private javax.swing.JLabel jLabelTituloPanel;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextPrincipal;
    // End of variables declaration//GEN-END:variables
}

class Label extends JLabel
{
    public Label(String a)
    {
        setText(a);
        setSize(220,50);
        setFont(new Font("Tahoma",Font.BOLD,30));
        setHorizontalAlignment(RIGHT);
        setVisible(true);
    }
    public void alinear()
    {
        setHorizontalAlignment(LEFT);
    }
}

class Button extends JButton
{
    public Button(String a)
    {
        setText(a);
        setSize(200,40);
        setBackground(Color.CYAN);
        setFont(new Font("Felix Titling",Font.BOLD,24));
        setVisible(true);
    }
}

class Text extends JTextPane
{
    public Text()
    {
        setText(null);
        setSize(220,30);
        setFont(new Font("Consolas",Font.BOLD,16));
        setVisible(true);
    }
}

class TextArea extends JTextArea
{
    public TextArea()
    {
        setLocation(25,100);
        setSize(590,200);
        setFont(new Font("Tahoma",Font.PLAIN,20));
        setVisible(true);
        setEnabled(false);
    }
}

class Scroll extends JScrollPane
{
    public Scroll(TextArea a)
    {
        add(a);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
}
