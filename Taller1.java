package com.company;

import javax.swing.*;
import java.util.HashSet;
import java.util.stream.Collectors;
import static java.util.stream.Stream.concat;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

    public static void main(String[] args) {

        HashSet conjunto2 = new HashSet();
        HashSet conjunto1 = new HashSet();

        do {

            int entrada1 = 0;
            try {
                entrada1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el conjunto 1 de numeros, cuando desee" +
                        " terminar de digitar numeros al conjunto presione en 'cancelar' \n Conjunto 1: " + conjunto1));
            }catch (NumberFormatException ex) {
                break;
            }
            conjunto1.add(entrada1);

        } while (true);

        do {

            int entrada = 0;
            try {
                entrada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el conjunto 2 de numeros, cuando desee" +
                        " terminar de digitar numeros al conjunto presione en 'cancelar' \n Conjunto 1: " + conjunto1 +
                        "\n Conjunto 2: " + conjunto2));
            }catch (NumberFormatException ex) {
                break;
            }
            conjunto2.add(entrada);

        } while (true);

        String conjuntoPantalla = "Los conjuntos que ingresaste son los siguientes\n Conjunto 1: " + conjunto1 +
                "\n Conjunto 2: " + conjunto2;
        showMessageDialog(null, conjuntoPantalla);

        String[] opciones = {"Union", "Interseccion", "Diferencia", "Diferencia Simetrica"};
        int opcion = JOptionPane.showOptionDialog(
                null //componente
                , "¿Que operacion deseas hacer?" // Mensaje
                , "Cuadro de pregunta" // Titulo en la barra del cuadro
                , JOptionPane.DEFAULT_OPTION // Tipo de opciones
                , JOptionPane.INFORMATION_MESSAGE // Tipo de mensaje (icono)
                , null // Icono (ninguno)
                , opciones // Opciones personalizadas
                , null // Opcion por defecto
        );

        switch (opciones[opcion]) {
            case "Union":
                HashSet Union = new HashSet();
                Union.add(concat(conjunto1.stream(), conjunto2.stream()).collect(Collectors.toSet()));
                showMessageDialog(null, "Has escogido "+opciones[opcion] + "\n " +opciones[opcion]+ Union);
                break;
            case "Interseccion":
                HashSet intersection = new HashSet<>(conjunto1);
                intersection.retainAll(conjunto2);
                showMessageDialog(null, "Has escogido "+opciones[opcion] + "\n " +opciones[opcion]+ intersection);
                break;
            case "Diferencia":
                HashSet result = new HashSet<>(conjunto1);
                result.removeAll(conjunto2);

                HashSet result2 = new HashSet<>(conjunto2);
                result2.removeAll(conjunto1);

                showMessageDialog(null, "Has escogido "+opciones[opcion] + "\n"+
                        " Conjunto 1 - Conjunto 2 = " + result + "\n"+
                        " Conjunto 2 - Conjunto 1 = " + result2);
                break;
            case "Diferencia Simetrica":
                HashSet DiferenciaSimetrica = new HashSet();

                HashSet resultS = new HashSet<>(conjunto1);
                resultS.removeAll(conjunto2);

                HashSet resultS2 = new HashSet<>(conjunto2);
                resultS2.removeAll(conjunto1);

                DiferenciaSimetrica.add(concat(resultS.stream(), resultS2.stream()).collect(Collectors.toSet()));

                showMessageDialog(null, "Has escogido "+opciones[opcion] + "\n" +
                        "La " +opciones[opcion]+ " entre Conjunto 1 y Conjunto 2 es: " + DiferenciaSimetrica);

                break;
        }
    }
}
