package org.example.Validaciones;

import org.example.Utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioMembresiaValidacionTest {
    UsuarioMembresiaValidacion usuarioMembresiaValidacion;
    @BeforeEach
    public void configurarPrueba(){
        System.out.println("Configuraciones Iniciales");
        this.usuarioMembresiaValidacion = new UsuarioMembresiaValidacion();
    }
    @Test
    public void validarFallaTope(){

        double tope = 300000;
        Exception respuesta = Assertions.assertThrows(Exception.class, ()->
                this.usuarioMembresiaValidacion.validarTopePago(tope));
        Assertions.assertEquals(Mensaje.TOPE_MEMBRESIA.getMensaje(), respuesta.getMessage());
    }
    @Test
    public void validarTopeCorrecto(){
        double tope = 90000;
        boolean respuesta = Assertions.assertDoesNotThrow(()->this.usuarioMembresiaValidacion.validarTopePago(tope));
        Assertions.assertTrue(respuesta);
    }
    @Test
    public void validarPagoMensualCorrecto(){
        double costoMensual = 80000;
        boolean respuesta = Assertions.assertDoesNotThrow(()->this.usuarioMembresiaValidacion.validarTopePago(costoMensual));
        Assertions.assertTrue(respuesta);
    }

}