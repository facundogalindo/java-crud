/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automovil.logica;

import Automovil.igu.Principal;
import Automovil.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Facundo
 */
public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    public void agregarAutomovil(String modelo, String marca, String motor, String color, String patente, int cantPuertas) {
        Automovil auto = new Automovil();
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(cantPuertas);
        
        controlPersis.agregarAutomovil(auto);
    }



    public List<Automovil> traerAutos() {
        return controlPersis.traerAutos();
    }

    public void borrarAuto(int idAuto) {
        controlPersis.borrarAuto(idAuto);
        
    }
    public Automovil traerAuto(int idAuto) {
        return controlPersis.traerAuto(idAuto);
    }

    public void modificarAuto(Automovil auto, String modelo, String marca, String motor, String color, String patente, int cantPuertas) {
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setMotor(motor);
        auto.setCantPuertas(cantPuertas);
        controlPersis.modificarAuto(auto);
    }

    public String validarUsuario(String usuario, String password) {
        String mensaje="";
        List<Usuario> listarUsuarios = controlPersis.traerUsuarios();
        for(Usuario usu : listarUsuarios){
            if (usu.getNickname().equals (usuario)) {
                if (usu.getPassword().equals (password)){
                    Principal princ = new Principal();
                    princ.setVisible(true);
                    princ.setLocationRelativeTo(null);
                }
                else{
                    mensaje = "pass incorrecta";
                    
                }
            }
            else{
                        mensaje = "Usuario no encontrado"    ;
            }
                
            }
            return mensaje;
        
        }
        /*public String validarUsuario(String usuario, String password){
            String mensaje = "";
            ArrayList<Usuario> listaUsuarios = controlPersis.traerUsuarios();
            for (Usuario u : listaUsuarios){
                if (u.getNickname().equals(usuario)){
                    if (u.getPassword().equals(password)){
                        mensaje ="asda";
                        
                        
                    }
                }

            }
            return mensaje;
        }*/
    }



    

