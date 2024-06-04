/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.vistas.gui;

import co.edu.udec.poo.edwinmendoza.Principal;
import co.edu.udec.poo.edwinmendoza.metodos.DeCadenaADate;
import co.edu.udec.poo.edwinmendoza.metodos.OrganizacionMetodosController;
import co.edu.udec.poo.edwinmendoza.metodos.PersonaFisicaMetodosController;
import dominio.Organizacion;
import dominio.PersonaFisica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Edwin
 */
public class VentanaCrudCliente extends javax.swing.JDialog {
    public PersonaFisicaMetodosController personaBd = new PersonaFisicaMetodosController();
    public OrganizacionMetodosController organizacionBd = new OrganizacionMetodosController();
    public VentanaCrudOrganizacion organizacion = new VentanaCrudOrganizacion();
    public VentanaCrudPersonaFisica persona = new VentanaCrudPersonaFisica();
    public PersonaFisica nuevaPersona = new PersonaFisica();
    public Organizacion nuevaOrganizacion = new Organizacion();
    
    String clave;
    String nombre;
    String identificacion;
    String direccion;
    String fechaNacimiento;
    String sexo;
    String cantidad;
    String tipoOrganizacion;
    String concepto;
    
    /**
     * Creates new form CrudCliente
     */
    public VentanaCrudCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        
        this.persona.setSize(663, 539);

        this.persona.setLocation(0, 0);

        dinamicContent.removeAll();
        dinamicContent.add(this.persona, BorderLayout.CENTER);
        dinamicContent.revalidate();
        dinamicContent.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        esPersonaFisica = new javax.swing.JRadioButton();
        esOrganizacion = new javax.swing.JRadioButton();
        labelTipoCliente = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CampoSucursal = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BotonAgregar = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        BotonEditar = new javax.swing.JButton();
        BotonBuscar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        dinamicContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        buttonGroup1.add(esPersonaFisica);
        esPersonaFisica.setSelected(true);
        esPersonaFisica.setText("Persona Fisica");
        esPersonaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esPersonaFisicaActionPerformed(evt);
            }
        });

        buttonGroup1.add(esOrganizacion);
        esOrganizacion.setText("Organizacion");
        esOrganizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esOrganizacionActionPerformed(evt);
            }
        });

        labelTipoCliente.setBackground(new java.awt.Color(0, 102, 204));
        labelTipoCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTipoCliente.setText("Tipo de cliente");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Sucursal");

        CampoSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/atencion-al-cliente.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );

        BotonAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/medical-report_8506475.png"))); // NOI18N
        BotonAgregar.setText("Agregar");
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
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

        BotonEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BotonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/edit_5953114.png"))); // NOI18N
        BotonEditar.setText("Editar");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTipoCliente)
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(BotonLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(esPersonaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(esOrganizacion)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(BotonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CampoSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BotonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BotonAgregar)
                                .addGap(165, 165, 165)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(esOrganizacion)
                    .addComponent(esPersonaFisica))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CampoSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAgregar)
                    .addComponent(BotonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonEliminar)
                    .addComponent(BotonEditar))
                .addGap(5, 5, 5)
                .addComponent(BotonLimpiar)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout dinamicContentLayout = new javax.swing.GroupLayout(dinamicContent);
        dinamicContent.setLayout(dinamicContentLayout);
        dinamicContentLayout.setHorizontalGroup(
            dinamicContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        dinamicContentLayout.setVerticalGroup(
            dinamicContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dinamicContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dinamicContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void esPersonaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esPersonaFisicaActionPerformed
        // TODO add your handling code here:
        
        this.persona.setSize(663, 539);

        this.persona.setLocation(0, 0);

        dinamicContent.removeAll();
        dinamicContent.add(this.persona, BorderLayout.CENTER);
        dinamicContent.revalidate();
        dinamicContent.repaint();
        
    }//GEN-LAST:event_esPersonaFisicaActionPerformed

    private void esOrganizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esOrganizacionActionPerformed
        // TODO add your handling code here:
        
        this.organizacion.setSize(663, 539);

        this.organizacion.setLocation(0, 0);

        dinamicContent.removeAll();
        dinamicContent.add(this.organizacion, BorderLayout.CENTER);
        dinamicContent.revalidate();
        dinamicContent.repaint();
    }//GEN-LAST:event_esOrganizacionActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        // TODO add your handling code here:
        String respuesta = seleccion();
        switch (respuesta) {
            case "Persona Fisica":
                clave = String.valueOf(persona.getCampoClave().getPassword());
                nombre = persona.getCampoNombre().getText();
                identificacion = persona.getCampoCodigo().getText();
                direccion = persona.getCampoDireccion().getText();
                fechaNacimiento = persona.getCampoFechaNacimiento().getDateFormatString();
                sexo = (String)persona.getCampoSexo().getSelectedItem();
                
                try {
                int verificar = Integer.valueOf(identificacion);
                this.nuevaPersona.setIdentificacion(identificacion);
                    if (fechaNacimiento == null) {
                        JOptionPane.showMessageDialog(this, "Es obligatorio ingresar la fecha");
                    }
                this.nuevaPersona.setFechaNacimiento(DeCadenaADate.convertir(fechaNacimiento));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "ingrese los datos de manera correcta");
                    return;
                }
        
                this.nuevaPersona.setNombre(nombre);
                this.nuevaPersona.setClave(clave);
                this.nuevaPersona.setDireccion(direccion);
                this.nuevaPersona.setSaldo(0);
                
                this.nuevaPersona.setSexo(sexo);
                //--
        
                //--
                Principal.personaBd.crearPersonaFisica(this.nuevaPersona);
                JOptionPane.showMessageDialog(this, "se agrego un cliente al sistema");
                BotonLimpiarActionPerformed(evt);
                break;
                
            case "Organizacion":
                 clave = String.valueOf(organizacion.getCampoClave().getPassword());
                 nombre = organizacion.getCampoNombre().getText();
                 identificacion = organizacion.getCampoCodigo().getText();
                 direccion = organizacion.getCampoDireccion().getText();
                 cantidad = organizacion.getCantidadDeEmpleados().getText();
                 tipoOrganizacion = organizacion.getCampoTipoOrganizacion().getText();
                 concepto = organizacion.getCampoConcepto().getText();
                 
                
                try {
                int verificar = Integer.valueOf(identificacion);
                this.nuevaOrganizacion.setIdentificacion(identificacion);
                    
                
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "ingrese los datos de manera correcta");
                    return;
                }
        
                this.nuevaOrganizacion.setNombre(nombre);
                this.nuevaOrganizacion.setClave(clave);
                this.nuevaOrganizacion.setDireccion(direccion);
                this.nuevaOrganizacion.setSaldo(0);
                this.nuevaOrganizacion.setCantidadEmpleados(cantidad);
                this.nuevaOrganizacion.setTipoOrganizacion(tipoOrganizacion);
                this.nuevaOrganizacion.setConcepto(concepto);
                
                //--
        
                //--
                Principal.organizacionBd.crearOrganizacion(this.nuevaOrganizacion);
                JOptionPane.showMessageDialog(this, "se agrego un cliente al sistema");
                BotonLimpiarActionPerformed(evt);
                break;
            default:
                throw new AssertionError();
        }
        
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        // TODO add your handling code here:
        String respuesta = seleccion();
        persona.getCampoClave().setText("");
        persona.getCampoNombre().setText("");
        persona.getCampoCodigo().setText("");
        persona.getCampoDireccion().setText("");
        switch (respuesta) {
            case "Persona Fisica":
                
                break;
                
            case "Organizacion":  
                organizacion.getCantidadDeEmpleados().setText("");
                organizacion.getCampoConcepto().setText("");
                organizacion.getCampoTipoOrganizacion().setText("");  
            default:
                throw new AssertionError();
        }
        
        
        
        
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        // TODO add your handling code here:
        String codigo = persona.getCampoCodigo().getText();
        String titulo = this.getTitle();
        String respuesta = seleccion();            
        switch (respuesta) {
            case "Persona Fisica":
                
                if (codigo.isEmpty() == true) {
                    JOptionPane.showMessageDialog(this, "El codigo se requiere para buscar un banco");
                    return;
                }else {try {
                       nuevaPersona = Principal.personaBd.buscarPersonaFisica(codigo);
                       if (Principal.personaBd.traerPersonaFisica(codigo) == null) {
                        JOptionPane.showMessageDialog(this, "El cliente no se encuentra en la base de datos");
                    }else{
                        Date fecha = nuevaPersona.getFechaNacimiento();
                        persona.getCampoClave().setText(nuevaPersona.getClave());
                        persona.getCampoNombre().setText(nuevaPersona.getNombre());
                        persona.getCampoCodigo().setText(nuevaPersona.getIdentificacion());
                        persona.getCampoDireccion().setText(nuevaPersona.getDireccion());
                        persona.getCampoFechaNacimiento().setDate(fecha);
                        persona.getCampoSexo().setToolTipText(nuevaPersona.getSexo());
                       
                       }
                       if (titulo.indexOf("Editar") != -1) {
                        persona.getCampoNombre().setEditable(true);
                        persona.getCampoCodigo().setEditable(false);
                        persona.getCampoClave().setEditable(true);
                        persona.getCampoDireccion().setEditable(true);
                        persona.getCampoSexo().setEditable(true);       
                    }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
}
               
                break;
                
            case "Organizacion":
                if (codigo.isEmpty() == true) {
                    JOptionPane.showMessageDialog(this, "El codigo se requiere para buscar un banco");
                    return;
                }else {try {
                       nuevaOrganizacion = Principal.organizacionBd.buscarOrganizacion(codigo);
                       if (Principal.organizacionBd.traerOrganizacion(codigo) == null) {
                        JOptionPane.showMessageDialog(this, "El cliente no se encuentra en la base de datos");
                    }else{
                        
                        organizacion.getCampoClave().setText(nuevaOrganizacion.getClave());
                        organizacion.getCampoNombre().setText(nuevaOrganizacion.getNombre());
                        organizacion.getCampoCodigo().setText(nuevaOrganizacion.getIdentificacion());
                        organizacion.getCampoDireccion().setText(nuevaOrganizacion.getDireccion());
                        organizacion.getCantidadDeEmpleados().setText(nuevaOrganizacion.getCantidadEmpleados());
                        organizacion.getCampoTipoOrganizacion().setText(nuevaOrganizacion.getTipoOrganizacion());
                        organizacion.getCampoConcepto().setText(nuevaOrganizacion.getConcepto());
            
                       }
                       if (titulo.indexOf("Editar") != -1) {
                        organizacion.getCampoNombre().setEditable(true);
                        organizacion.getCampoCodigo().setEditable(false);
                        organizacion.getCampoClave().setEditable(true);
                        organizacion.getCampoConcepto().setEditable(true);
                        organizacion.getCampoDireccion().setEditable(true);
                        organizacion.getCampoTipoOrganizacion().setEditable(true);
                    }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
}
            
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
        // TODO add your handling code here:
        String codigo = persona.getCampoCodigo().getText();
        String codigo1 = organizacion.getCampoCodigo().getText();
        String titulo = this.getTitle();
        String respuesta = seleccion();   
        int decision = JOptionPane.showConfirmDialog(this, "seguro que desea eliminar este cliente", "Advertencia", JOptionPane.YES_NO_OPTION);
        
        switch (respuesta) {
            case "Persona Fisica":
                
                if (decision == JOptionPane.YES_OPTION) {
            try {
                Principal.personaBd.eliminarPersonaFisica(codigo);
                JOptionPane.showMessageDialog(this, "Se a eliminado el objeto de la base de datos");
                BotonLimpiarActionPerformed(evt);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar un cliente que no existe en la base de datos");
            }
            
        }
               
                break;
                
            case "Organizacion":
                if (decision == JOptionPane.YES_OPTION) {
            try {
                Principal.organizacionBd.eliminarOrganizacion(codigo1);
                JOptionPane.showMessageDialog(this, "Se a eliminado el objeto de la base de datos");
                BotonLimpiarActionPerformed(evt);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se puede eliminar un cliente que no existe en la base de datos");
            }
            
        }
            
                break;
            default:
                throw new AssertionError();
        }
    }//GEN-LAST:event_BotonEliminarActionPerformed

    public String seleccion(){
        ButtonModel seleccionBoton = buttonGroup1.getSelection();
        
        AbstractButton decision = null;
        for (Enumeration<AbstractButton> botones = buttonGroup1.getElements(); botones.hasMoreElements();) {
            AbstractButton boton = botones.nextElement();
            if (boton.getModel() == seleccionBoton) {
                decision = boton;
                break;
            }
        }
        
        if (decision != null){
            return decision.getText();
        }
         return "";  
    }
    
    public JButton getBotonAgregar() {
        return BotonAgregar;
    }

    public void setBotonAgregar(JButton BotonAgregar) {
        this.BotonAgregar = BotonAgregar;
    }

    public JButton getBotonBuscar() {
        return BotonBuscar;
    }

    public void setBotonBuscar(JButton BotonBuscar) {
        this.BotonBuscar = BotonBuscar;
    }

    public JButton getBotonEditar() {
        return BotonEditar;
    }

    public void setBotonEditar(JButton BotonEditar) {
        this.BotonEditar = BotonEditar;
    }

    public JButton getBotonEliminar() {
        return BotonEliminar;
    }

    public void setBotonEliminar(JButton BotonEliminar) {
        this.BotonEliminar = BotonEliminar;
    }

    public JButton getBotonLimpiar() {
        return BotonLimpiar;
    }

    public void setBotonLimpiar(JButton BotonLimpiar) {
        this.BotonLimpiar = BotonLimpiar;
    }

    public VentanaCrudOrganizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(VentanaCrudOrganizacion organizacion) {
        this.organizacion = organizacion;
    }

    public VentanaCrudPersonaFisica getPersona() {
        return persona;
    }

    public void setPersona(VentanaCrudPersonaFisica persona) {
        this.persona = persona;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JButton BotonEditar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JComboBox<String> CampoSucursal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel dinamicContent;
    private javax.swing.JRadioButton esOrganizacion;
    private javax.swing.JRadioButton esPersonaFisica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelTipoCliente;
    // End of variables declaration//GEN-END:variables
}
