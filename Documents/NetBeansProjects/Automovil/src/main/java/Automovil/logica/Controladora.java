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

public int queTipoEs(int idUsuario) {
    List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
    for (Usuario user : listaUsuarios) {
        if (user.getIdUsuario() == idUsuario) {
            TipoUsuario tipoUsuario = user.getTipoUsuario();
            if (tipoUsuario != null) {
                return tipoUsuario.getIdTipoUsuario();
            } else {
                return 0;
            }
        }
    }
    return 0;
}/*
    public int queTipoEs(int idUsuario){
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        for(Usuario user : listaUsuarios){
            if(user.getIdUsuario() == (idUsuario)){
                return (user.getTipoUsuario()).getIdTipoUsuario();
                
            }
        }
        return 0;
    }*/

    public String validarUsuario(String usuario, String password) {
        String mensaje="";
        List<Usuario> listarUsuarios = controlPersis.traerUsuarios();
        for(Usuario usu : listarUsuarios){
            if (usu.getNickname().equals (usuario)) {
                if (usu.getPassword().equals (password)){
                    int rango = queTipoEs(usu.getIdUsuario());
                    Principal princ = new Principal();
                    princ.setVisible(true);
                    princ.setLocationRelativeTo(null);
                    princ.activarBotones(rango);
                    System.out.println("Rango"+ rango);
                                
                        
                    
   
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
    public ArrayList<TipoUsuario> listarTipoUsuario(){

        return controlPersis.listarTiposUsuarios();

    }
        public void abrirPrincipal(){
            Principal princ = new Principal();
            princ.setVisible(true);
            princ.setLocationRelativeTo(null);
        }

    public void agregarUsuario(String nombre, String password, String nombreTipoUsuario) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        List<TipoUsuario> listarTipoUsuarios = controlPersis.listarTiposUsuarios();
        for(TipoUsuario tipoUsu : listarTipoUsuarios){
            if (tipoUsu.getNombre().equals (nombreTipoUsuario)) {
                tipoUsuario = tipoUsu;
                break;
            }

        
        }
        Usuario user = new Usuario();
        user.setNickname(nombre);
        user.setPassword(password);
        user.setTipoUsuario(tipoUsuario);
        controlPersis.agregarUsuario(user);
        }

        

        //controlPersis.agregarUsuario(nombre, password, nombreTipoUsuario)
    }
    




    

