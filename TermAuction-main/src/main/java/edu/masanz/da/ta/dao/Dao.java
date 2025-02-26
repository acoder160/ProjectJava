package edu.masanz.da.ta.dao;

import edu.masanz.da.ta.dto.*;
import edu.masanz.da.ta.utils.Security;

import java.util.*;

import static edu.masanz.da.ta.conf.Ctes.*;
import static edu.masanz.da.ta.conf.Ini.*;

/**
 * Clase que simula la capa de acceso a datos. Cuando veamos las interfaces crearemos una interfaz para esta clase.
 * También crearemos una clase que implemente esa interfaz y que se conecte a una base de datos relacional.
 * Y una clase servicio que podrá utilizar cualquiera de las dos implementaciones, la simulada, la real u otra.
 * Por ahora, simplemente es una clase con métodos estáticos que simulan la interacción con una base de datos.
 */
public class Dao {


    //region Colecciones que simulan la base de datos
    private static Map<String, Usuario> mapaUsuarios;

    private static Map<Long, Item> mapaItems;

    private static Map<Long, List<Puja>> mapaPujas;
    //endregion

    //region Inicialización de la base de datos simulada
    public static void ini() {
        iniMapaUsuarios();
        iniMapaItems();
        iniMapaPujas();
    }

    // aqui vamos a recorer el aray publico de usuarios, voy a hacer el split por "," y crear objetos de usuario con datos obtenidos
    private static void iniMapaUsuarios() {
        mapaUsuarios = new HashMap<>();
        for (String usuarioData : USUARIOS) {
            String[] partes = usuarioData.split(",");
            Usuario usuario = new Usuario(partes[0], partes[1], partes[2], partes[3]);
            mapaUsuarios.put(partes[0], usuario);
        }
    }

    private static void iniMapaItems() {
        mapaItems = new HashMap<>();
        for (String item : ITEMS) {
            String[] partes = item.split(",");

            // variables como en el construcor de item,
            long id = Long.parseLong(partes[0]);
            String nombre = partes[1];
            String info = partes[2];
            int precioIncial = Integer.parseInt(partes[3]);
            String url = partes[4];
            String nombreUsuario = partes[5];
            int estado = Integer.parseInt(partes[6]);
            boolean historico = Boolean.parseBoolean(partes[7]);

            // se usa el parse para pasar string al tipo necesario.
            // se crean objetos item

            Item items = new Item(id, nombre, info, precioIncial, url, nombreUsuario, estado, historico);
            mapaItems.put(id, items);
        }
    }


    private static void iniMapaPujas() {
        mapaPujas = new HashMap<>();
        for (String itemPuja : PUJAS){
            String[] partes = itemPuja.split(",");

            //variables segun constructor de clase puja
            long idItem = Long.parseLong(partes[0]);
            String nombreUsuario = partes[1];
            int precio = Integer.parseInt(partes[2]);
            String instanteTiempo = partes[3];


            // este metodo se hace que si ya tenemos el id, significa que quieremos añadir la puja a la lista y si no lo tenemos pues creamos con un id nuevo
            Puja objPuja = new Puja(idItem, nombreUsuario, precio, instanteTiempo);
                if (mapaPujas.containsKey(idItem)){
                    mapaPujas.get(idItem).add(objPuja);
                }
                else{
                    mapaPujas.put(idItem, new ArrayList<>());
                }
        }
    }



    //endregion

    //region Usuarios
    public static boolean autenticar(String nombreUsuario, String password) {
//        return password.equals("1234");
        // TODO 04 autenticar
        return false;
    }

    public static boolean esAdmin(String nombreUsuario) {
//        return nombreUsuario.equalsIgnoreCase("Admin");
        // TODO 05 esAdmin
        return false;
    }

    public static List<Usuario> obtenerUsuarios() {
        // TODO 06 obtenerUsuarios
        return null;
    }

    public static boolean crearUsuario(String nombre, String password, boolean esAdmin) {
        // TODO 07 crearUsuario
        return true;
    }

    public static boolean modificarPasswordUsuario(String nombre, String password) {
        // TODO 08 modificarPasswordUsuario
        return false;
    }

    public static boolean modificarRolUsuario(String nombre, String rol) {
        // TODO 09 modificarRolUsuario
        return false;
    }

    public static boolean eliminarUsuario(String nombre) {
        // TODO 10 eliminarUsuario
        return true;
    }

    //endregion

    //region Validación de artículos
    public static List<Item> obtenerArticulosPendientes() {
        // TODO 11 obtenerArticulosPendientes
        return null;
    }

    public static boolean validarArticulo(long id, boolean valido) {
        // TODO 12 validarArticulo
        return false;
    }

    public static boolean validarTodos() {
        // TODO 13 validarTodos
        return true;
    }
    //endregion

    //region Gestión de artículos y pujas de administrador
    public static List<ItemPujas> obtenerArticulosConPujas() {
        // TODO 14 obtenerArticulosConPujas
        return null;
    }

    public static boolean resetearSubasta() {
        // TODO 15 resetearSubasta
        return true;
    }

    public static List<PujaItem> obtenerHistoricoGanadores() {
        // TODO 16 obtenerHistoricoGanadores
        return null;
    }
    //endregion

    //region Acciones por parte de usuario normal (no admin)

    public static Item obtenerArticuloPujable(long idArt) {
        // TODO 17 obtenerArticuloPujable
        return null;
    }

    public static List<Item> obtenerArticulosPujables() {
        // TODO 18 obtenerArticulosPujables
        return null;
    }

    public static boolean pujarArticulo(long idArt, String nombre, int precio) {
        // TODO 19 pujarArticulo
        return false;
    }

    public static List<PujaItem> obtenerPujasVigentesUsuario(String nombreUsuario) {
        // TODO 20 obtenerPujasVigentesUsuario
        return null;
    }

    public static boolean ofrecerArticulo(Item item) {
        // TODO 21 ofrecerArticulo
        return true;
    }

    //endregion
}
