/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Automovil.persistencia;

import Automovil.logica.Automovil;
import Automovil.logica.TipoUsuario;
import Automovil.logica.Usuario;
import Automovil.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Facundo
 */
public class ControladoraPersistencia {
    AutomovilJpaController autoJpa = new AutomovilJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    TipoUsuarioJpaController tipoJpa = new TipoUsuarioJpaController();
    public void agregarAutomovil(Automovil auto) {
        autoJpa.create(auto);
    }

    public List<Automovil> traerAutos() {
       return autoJpa.findAutomovilEntities();
    }

    public void borrarAuto(int idAuto) {
        try {
            autoJpa.destroy(idAuto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Automovil traerAuto(int idAuto) {
        return autoJpa.findAutomovil(idAuto);
    }

    public void modificarAuto(Automovil auto) {
        try {
            autoJpa.edit(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Usuario> traerUsuarios() {
        List<Usuario> lista = usuarioJpa.findUsuarioEntities();
        ArrayList<Usuario> listaUsuarios = new ArrayList(lista);
        return listaUsuarios;
    }

    public ArrayList<TipoUsuario> listarTiposUsuarios() {
        List<TipoUsuario> lista = tipoJpa.findTipoUsuarioEntities();
        ArrayList<TipoUsuario> listaTipos = new ArrayList(lista);
        return listaTipos;
    }

    public void agregarUsuario(Usuario user) {
        usuarioJpa.create(user);
    }
    
    
}
