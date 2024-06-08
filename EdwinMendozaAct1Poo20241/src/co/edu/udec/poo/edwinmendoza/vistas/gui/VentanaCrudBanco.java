/* * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.vistas.gui;

import co.edu.udec.poo.edwinmendoza.Principal;
import co.edu.udec.poo.edwinmendoza.metodos.BancoMetodosController;
import dominio.Banco;
import dominio.Sucursal;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Edwin
 */
public class VentanaCrudBanco extends javax.swing.JDialog {

    public static BancoMetodosController bancoBd = new BancoMetodosController();
    Banco banco = new Banco();
    public int respuesta = 0;

    /**
     * Creates new form FormularioBanco
     */
    public VentanaCrudBanco(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        BotonAgregar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        BotonBuscar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        CampoCodigo = new javax.swing.JTextField();
        CampoSucursal = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("                                                                                 _-.:: Ventana Crud Banco ::.-_");

        BotonAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/medical-report_8506475.png"))); // NOI18N
        BotonAgregar.setText("Agregar");
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });

        BotonEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/edit_5953114.png"))); // NOI18N
        BotonEditar.setText("Editar");
        BotonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEditarActionPerformed(evt);
            }
        });

        BotonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/search_5953174.png"))); // NOI18N
        BotonBuscar.setText("Buscar");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });

        BotonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/delete_5953164.png"))); // NOI18N
        BotonEliminar.setText("Eliminar");
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        BotonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/cepillo.png"))); // NOI18N
        BotonLimpiar.setText("Limpiar");
        BotonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORMULARIO BANCO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/banco.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Banco", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Codigo Identificador");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Sucursal");

        CampoNombre.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N

        CampoCodigo.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        CampoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoCodigoKeyTyped(evt);
            }
        });

        CampoSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(Principal.sucursalBd.arraySucursales()));
        CampoSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CampoNombre)
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addComponent(CampoSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CampoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CampoSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(BotonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(BotonLimpiar)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonBuscar)
                    .addComponent(BotonEliminar)
                    .addComponent(BotonLimpiar)
                    .addComponent(BotonEditar)
                    .addComponent(BotonAgregar))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        // Recuperar los datos de la interfaz:
        String nombre = CampoNombre.getText();
        String codigoIdentificador = CampoCodigo.getText();

        //Crear Objeto
        this.respuesta = JOptionPane.showConfirmDialog(this, "seguro que desea agregar este banco", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                int codigo = Integer.valueOf(codigoIdentificador);
                banco.setCodigoIdentificador(codigoIdentificador);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "el codigo no puede tener letras");
                CampoCodigo.requestFocus();
                CampoCodigo.setSelectedTextColor(Color.red);
                CampoCodigo.selectAll();
                return;
            }
            banco.setNombre(nombre);

            try {
                if (!bancoBd.existeBanco(banco)) {
                    JOptionPane.showMessageDialog(this, "se agrego un banco al sistema");
                }
                bancoBd.crearBanco(banco);

            } catch (Exception ex) {
            }
        }

        BotonLimpiarActionPerformed(evt);
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        // TODO add your handling code here:

        String titulo = this.getTitle();
        if (titulo.indexOf("Editar") != -1) {
            CampoNombre.setEditable(false);
            CampoCodigo.setEditable(true);
        }

        //Limpiar campos
        CampoCodigo.setText("");
        CampoNombre.setText("");

    }//GEN-LAST:event_BotonLimpiarActionPerformed
    int operation = 0;
    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        // TODO add your handling code here:
        String codigo = CampoCodigo.getText();

        if (codigo.isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "El codigo se requiere para buscar un banco");
            return;
        } else {
            try {

                Banco buscar = this.bancoBd.buscarBanco(codigo);
                if (bancoBd.encontrarBanco(codigo) == null) {
                    JOptionPane.showMessageDialog(this, "El banco que busca no se encuentra");

                } else {
                    CampoCodigo.setText(buscar.getCodigoIdentificador());
                    CampoNombre.setText(buscar.getNombre());
                    String titulo = this.getTitle();
                    if (titulo.indexOf("Editar") != -1) {
                        CampoNombre.setEditable(true);
                        CampoCodigo.setEditable(false);
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        }
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void BotonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEditarActionPerformed
        // TODO add your handling code here:
        //  Recuperar campos que se editaron
        this.respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea realizar estos cambios?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            String nombre = CampoNombre.getText();
            String codigo = CampoCodigo.getText();

            //Cambiar los datos en la base de datos
            this.banco.setNombre(nombre);
            this.banco.setCodigoIdentificador(codigo);

            try {
                this.bancoBd.editarBanco(banco);
                JOptionPane.showMessageDialog(this, "Se edito el banco");
                BotonLimpiarActionPerformed(evt);
            } catch (Exception e) {

            }
        }


    }//GEN-LAST:event_BotonEditarActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        // TODO add your handling code here:
        String codigo = CampoCodigo.getText();
        int respuesta = JOptionPane.showConfirmDialog(this, "¿seguro que desea eliminar este banco?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {

            try {
                bancoBd.eliminarBanco(codigo);

                JOptionPane.showMessageDialog(this, "Se a eliminado el objeto de la base de datos");
                BotonLimpiarActionPerformed(evt);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar un banco que no existe en la base de datos");
            }
        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void CampoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCodigoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_CampoCodigoKeyTyped

    private void CampoSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoSucursalActionPerformed

    public JButton getBotonAgregar() {
        return BotonAgregar;
    }

    public JButton getBotonBuscar() {
        return BotonBuscar;
    }

    public JButton getBotonEditar() {
        return BotonEditar;
    }

    public JButton getBotonEliminar() {
        return BotonEliminar;
    }

    public JButton getBotonLimpiar() {
        return BotonLimpiar;
    }

    public JTextField getCampoCodigo() {
        return CampoCodigo;
    }

    public JTextField getCampoNombre() {
        return CampoNombre;
    }

    public JComboBox<Sucursal> getCampoSucursal() {
        return CampoSucursal;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JComboBox<Sucursal> CampoSucursal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
