package com.company;

import java.util.HashSet;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        Set<Integer> A = new HashSet<>();
        for (int i = 6; i <= 20; i++) {
            A.add(i);
        }

        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < 25; i++) {
            if (i % 2 == 0) {
                B.add(i);
            }
        }

        Set<Integer> C = new HashSet<>();
        C.add(1);
        C.add(4);
        C.add(8);
        C.add(10);
        C.add(12);
        C.add(15);
        C.add(18);
        C.add(20);

        Set<Integer> D = new HashSet<>();
        for (int i = 2; i <= 45; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                D.add(i);
            }
        }


        Set<Integer> ejercicio1 = union(B,diferenciaSimetrica(C, D));
        System.out.println("B⋂(C⨁D) = " + ejercicio1);

        Set<Integer> ejercicio2 = interseccion(union(A,C), B);
        System.out.println("(A⋂C) ⋃B = " + ejercicio2);

        Set<Integer> ejercicio3 = diferenciaBA(interseccion(B,D), C);
        System.out.println("(B⋃D) − C = " + ejercicio3);

        Set<Integer> ejercicio4 = diferenciaSimetrica(diferenciaAB(A,B), union(A,D));
        System.out.println("(A − B) ⨁ (A⋂D) = " + ejercicio4);

    }

    public static Set<Integer> union(Set<Integer> conjuntoA, Set<Integer> conjuntoB) {
        Set<Integer> resul = new HashSet<>(conjuntoA);
        resul.addAll(conjuntoB);
        return resul;
    }

    public static Set<Integer> interseccion(Set<Integer> conjuntoA, Set<Integer> conjuntoB) {
        Set<Integer> resul = new HashSet<>(conjuntoA);
        resul.retainAll(conjuntoB);
        return resul;
    }

    public static Set<Integer> diferenciaAB(Set<Integer> conjuntoA, Set<Integer> conjuntoB) {
        Set<Integer> resul = new HashSet<>(conjuntoA);
        resul.removeAll(conjuntoB);

        return resul;
    }

    public static Set<Integer> diferenciaBA(Set<Integer> conjuntoA, Set<Integer> conjuntoB) {
        Set<Integer> resul = new HashSet<>(conjuntoB);
        resul.removeAll(conjuntoA);

        return resul;
    }

    public static Set<Integer> diferenciaSimetrica(Set<Integer> conjuntoA, Set<Integer> conjuntoB) {
        Set<Integer> resul = new HashSet<>(conjuntoA);
        resul.removeAll(conjuntoB);

        Set<Integer> resul2 = new HashSet<>(conjuntoB);
        resul2.removeAll(conjuntoA);

        Set<Integer> resulfinal = new HashSet<>();
        resulfinal.addAll(resul);
        resulfinal.addAll(resul2);
        return resulfinal;
    }
}

