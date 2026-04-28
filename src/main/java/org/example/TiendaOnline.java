package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * FASE DIRTY: CLASE CON 10 CODE SMELLS
 */
public class TiendaOnline {

    // 1. LARGE CLASS: Mezcla datos de usuario, carrito y lógica de ventas.
    public String usuarioLogueado;
    public List<String> carrito = new ArrayList<>();
    public boolean esVip = false;

    public void login(String user, String pass) {
        if (user.equals("admin") && pass.equals("1234")) {
            usuarioLogueado = user;
            System.out.println("Login correcto");
        }
    }

    // 2. DEAD CODE: Un método inútil que nadie llama.
    public void metodoQueNadieLlama() {
        System.out.println("No sirvo para nada...");
    }

    public void agregarProducto(String p) {
        carrito.add(p);
    }

    // 3. LONG METHOD: Este método es demasiado largo y hace demasiadas cosas.
    public void procesarVenta(String tipo, double precio, int cant) {
        System.out.println("Iniciando venta...");

        // 4. DUPLICATE CODE: Cálculo del IVA repetido.
        // 5. MAGIC NUMBER: El 0.21 debería ser una constante "IVA".
        double totalConIva = precio + (precio * 0.21);

        // 6. SWITCH STATEMENT: Un switch gigante (ideal para cambiar por polimorfismo).
        double precioFinal = 0;
        switch (tipo) {
            case "ELECTRONICA":
                precioFinal = totalConIva * cant;
                // 7. MAGIC NUMBER: Descuento arbitrario de 10
                if (cant > 5) precioFinal -= 10;
                break;
            case "ROPA":
                // 8. MAGIC NUMBER: 0.9 es un descuento mágico
                precioFinal = (totalConIva * cant) * 0.9;
                break;
            case "ALIMENTACION":
                // 9. DUPLICATE CODE: Repetimos la fórmula del IVA aquí
                precioFinal = (precio + (precio * 0.21)) * cant;
                break;
            default:
                precioFinal = totalConIva * cant;
                break;
        }

        // 10. INAPPROPRIATE INTIMACY: Acceso a variables de la clase directamente en la lógica
        if (esVip) {
            precioFinal = precioFinal * 0.5; // Otro Magic Number (50%)
        }

        System.out.println("Factura para: " + usuarioLogueado);
        System.out.println("Producto: " + tipo + " | Total: " + precioFinal);
        System.out.println("IVA aplicado hoy: " + (precio * 0.21)); // Más Duplicate Code
    }
}