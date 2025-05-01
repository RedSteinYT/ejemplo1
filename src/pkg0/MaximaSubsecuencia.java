/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg0;

import java.util.*;
import java.io.*;

/**
 *
 * @author Luis Alejandro Castro Contreras
 */
public class MaximaSubsecuencia {

    public static int sumaMaximaSubsecuencia(int[] arr) throws UnsupportedEncodingException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        
        if (arr == null || arr.length == 0) {
            return 0;
        }

        boolean todosNegativos = true;
        for (int num : arr) {
            if (num >= 0) {
                todosNegativos = false;
                break;
            }
        }
        if (todosNegativos) {
            return 0;
        }

        int maxActual = arr[0];
        int maxGlobal = arr[0];
        int bajo = 0;
        int alto = 0;
        int inicioTemp = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxActual + arr[i]) {
                maxActual = arr[i];
                inicioTemp = i;
            } else {
                maxActual += arr[i];
            }

            if (maxActual > maxGlobal) {
                maxGlobal = maxActual;
                bajo = inicioTemp;
                alto = i;
            }
        }

        out.println("La suma máxima va de: (" + (bajo + 1) + ", " + (alto + 1) + ")");

        return maxGlobal;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);

        Scanner scanner = new Scanner(System.in);

        out.print("¿Deseas usar el arreglo por defecto? (s/n): ");
        out.flush();
        String opcion = scanner.nextLine().trim().toLowerCase();

        int[] ejemplo;

        if (opcion.equals("s")) {
            ejemplo = new int[]{-2, 11, -4, 13, -5, 9, -3, 2, -8, 4};
        } else {
            out.print("¿Cuántos valores deseas ingresar?: ");
            out.flush();
            int n = scanner.nextInt();
            ejemplo = new int[n];
            
            for (int i = 0; i < n; i++) {
                System.out.print("Valor #" + (i + 1) + ": ");
                ejemplo[i] = scanner.nextInt();
            }
        }

        out.println("Suma máxima: " + sumaMaximaSubsecuencia(ejemplo));
    }
}
