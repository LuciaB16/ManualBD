package bdprogra;

import Controller.CtrlActor;
import Model.Actor;
import Model.ConsultasActores;
import View.Ventana;

public class BDProgra {

    public static void main(String[] args) {
             
        Actor mod = new Actor();
        ConsultasActores modC = new ConsultasActores();
        Ventana ve = new Ventana();
        
        CtrlActor ctrl = new CtrlActor(mod,modC,ve);
        ctrl.iniciar();
        ve.setVisible(true);
        
        
    }
    
}
