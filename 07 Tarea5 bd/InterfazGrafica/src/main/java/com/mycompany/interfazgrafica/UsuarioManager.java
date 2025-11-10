package com.mycompany.interfazgrafica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private static final String ARCHIVO = "usuarios.txt";

    // Carga usuarios desde archivo (si no existe, devuelve lista vacía)
    public static List<Usuario> cargarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        File f = new File(ARCHIVO);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Usuario u = Usuario.fromString(linea);
                if (u != null) lista.add(u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Guarda la lista completa en el archivo (sobrescribe)
    public static void guardarUsuarios(List<Usuario> usuarios) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Usuario u : usuarios) {
                bw.write(u.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos de conveniencia de instancia (opcional)
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioManager() {}

    public void agregar(Usuario u) {
        usuarios.add(u);
    }

    public List<Usuario> listar() {
        return usuarios;
    }
}
