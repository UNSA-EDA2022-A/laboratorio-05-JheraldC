package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

	public boolean esBalanceado(String s) {
		MyStack<Character> stack = new LinkedListStack<>();
		// Colocar codigo aqui
		for (int i = 0; i < s.length(); i++) { //Bucle para recorrer los caracteres del String
			char ch = s.charAt(i); //Guardo el caracter en una variable tipo char
			if (ch == '(' || ch == '[' || ch == '{') //Verifico si se abre el corchete
				stack.push(ch); //En caso si, lo agrego a la lista
			else { //En caso no, significa que cierra corchetes
				if (stack.top() == '(' && ch == ')' || stack.top() == '[' && ch == ']'
						|| stack.top() == '{' && ch == '}') //Verifico si el caracter que cierra es correcto con el top de la lista
					stack.pop(); //Si lo es, significa que esta anidado correctamente
				else //En caso contrario
					return false; //Retorna falso
			}
		}
		return stack.isEmpty(); //Si esta vacio, es balanceado
	}
}
