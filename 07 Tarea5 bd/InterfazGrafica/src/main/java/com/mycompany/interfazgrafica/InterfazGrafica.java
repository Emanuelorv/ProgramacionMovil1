package com.mycompany.interfazgrafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InterfazGrafica extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private List<Usuario> usuarios;

    public InterfazGrafica() {
        super("Gestión de Usuarios");

        usuarios = UsuarioManager.cargarUsuarios();

        modelo = new DefaultTableModel(new Object[]{"Nombre", "Correo"}, 0) {
            // evitar edición directa en la tabla
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cargarTabla();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        btnAgregar.addActionListener(e -> agregarUsuario());
        btnEditar.addActionListener(e -> editarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(tabla), BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);

        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{u.getNombre(), u.getCorreo()});
        }
    }

    private void agregarUsuario() {
        JTextField campoNombre = new JTextField();
        JTextField campoCorreo = new JTextField();
        Object[] campos = {
            "Nombre:", campoNombre,
            "Correo:", campoCorreo
        };

        int opcion = JOptionPane.showConfirmDialog(this, campos, "Agregar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            Usuario nuevo = new Usuario(campoNombre.getText(), campoCorreo.getText());
            usuarios.add(nuevo);
            UsuarioManager.guardarUsuarios(usuarios);
            cargarTabla();
        }
    }

    private void editarUsuario() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar.");
            return;
        }

        // Si hay RowSorter, convertir índice a modelo (más robusto)
        int filaModelo = tabla.convertRowIndexToModel(filaSeleccionada);
        Usuario u = usuarios.get(filaModelo);

        JTextField campoNombre = new JTextField(u.getNombre());
        JTextField campoCorreo = new JTextField(u.getCorreo());
        Object[] campos = {
            "Nombre:", campoNombre,
            "Correo:", campoCorreo
        };

        int opcion = JOptionPane.showConfirmDialog(this, campos, "Editar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            u.setNombre(campoNombre.getText());
            u.setCorreo(campoCorreo.getText());
            UsuarioManager.guardarUsuarios(usuarios);
            cargarTabla();
        }
    }

    private void eliminarUsuario() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar.");
            return;
        }

        int filaModelo = tabla.convertRowIndexToModel(filaSeleccionada);
        Usuario u = usuarios.get(filaModelo);

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Eliminar usuario?\n\nNombre: " + u.getNombre() + "\nCorreo: " + u.getCorreo(),
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            usuarios.remove(filaModelo);
            UsuarioManager.guardarUsuarios(usuarios);
            cargarTabla();
            JOptionPane.showMessageDialog(this, "Usuario eliminado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazGrafica());
    }
}