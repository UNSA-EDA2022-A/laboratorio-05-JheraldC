package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

	public boolean existenDuplicados(String str) {
		MyStack<Character> stack = new LinkedListStack<>();
		// Colocar codigo aqui
		for (int i = 0; i < str.length(); i++) { //Bucle para recorrer los caracteres del String
			char ch = str.charAt(i); //Guardo el caracter en una variable tipo char
			if (ch == ')') { //Verifico si se cierra el corchete
				stack.pop(); //Si es cerrado, elimino el ultimo elemento agregado
				int contElem = 0; //Inicio un contador de los elementos
				while (stack.top() != '(') { //Bucle para recorrer los caracteres hasta encontrar el corchete abierto
					contElem++; //Si no lo encuentra, suma al contador
					stack.pop(); //Elimina de la pila el ultimo elemento agregado, encontro su corchete 
				}
				if (contElem < 1) { //Si el contador es menor a 1, significa que encontro un corchete duplicado
					return true;  //Retorna verdadero
				}
			} else //Si no cierra, es abierto
				stack.push(ch); //Entonces se agrega a la pila
		}
		return false; //Si no es menor a 1, entonces no se encontraron corchetes duplicados
	}
}
