package Controller;

import Model.Actor;
import Model.ConsultasActores;
import View.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlActor implements ActionListener {
    
   private Actor cAct;
   private ConsultasActores cConAct;
   private Ventana ve;

    public CtrlActor(Actor cAct, ConsultasActores cConAct, Ventana ve) {
        this.cAct = cAct;
        this.cConAct = cConAct;
        this.ve = ve;
                
        this.ve.bGuardar.addActionListener(this);
        this.ve.bModificar.addActionListener(this);
        this.ve.bEliminar.addActionListener(this);
        this.ve.bLimpiar.addActionListener(this);
        this.ve.bBuscar.addActionListener(this);
    }
    
    
    public void iniciar(){
        ve.setTitle("Actores");
        ve.setLocationRelativeTo(null);

    }
    
    
   @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == ve.bGuardar){
            cAct.setId(Integer.parseInt(ve.txtId.getText()));
            cAct.setNombre(ve.txtNombre.getText());
            cAct.setApellido(ve.txtApellido.getText());
            cAct.setEdad(Integer.parseInt(ve.txtEdad.getText()));
            
            
            if(cConAct.guardar(cAct)){
                JOptionPane.showMessageDialog(null,"Registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al guardar");
                limpiar();
            }
        }
        
        
        if(e.getSource() == ve.bModificar){
            cAct.setId(Integer.parseInt(ve.txtId.getText()));
            cAct.setNombre(ve.txtNombre.getText());
            cAct.setApellido(ve.txtApellido.getText());
            cAct.setEdad(Integer.parseInt(ve.txtEdad.getText()));
            
            
            if(cConAct.modificar(cAct)){
                JOptionPane.showMessageDialog(null,"Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al modificar");
                limpiar();
            }
        }
        
        
        
        if(e.getSource() == ve.bEliminar){
            cAct.setId(Integer.parseInt(ve.txtId.getText()));
                     
            
            if(cConAct.eliminar(cAct)){
                JOptionPane.showMessageDialog(null,"Registro eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar");
                limpiar();
            }
        }
        
        
        if(e.getSource() == ve.bBuscar){
            cAct.setId(Integer.parseInt(ve.txtId.getText()));
           
            
            if(cConAct.buscar(cAct)){
                
                ve.txtId.setText(String.valueOf(cAct.getId()));
                ve.txtNombre.setText(cAct.getNombre());
                ve.txtApellido.setText(cAct.getApellido());
                ve.txtEdad.setText(String.valueOf(cAct.getEdad()));
                
                
            }else{
                JOptionPane.showMessageDialog(null,"No se encontró el registro");
                limpiar();
            }
        }
        
        if(e.getSource() == ve.bLimpiar){
            limpiar();
        }
       }    
    
      
    
    public void limpiar(){
        ve.txtId.setText(null);
        ve.txtNombre.setText(null);
        ve.txtApellido.setText(null);
        ve.txtEdad.setText(null);
    }
   
   
   
    
}
