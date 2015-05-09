import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


class Main {
	
	static HashMap<Character, Character> mapa = new HashMap<Character, Character>();
	
	/*
	 *  Tenta criar um mapa de tradução baseado na linha dada
	 *  Se conseguir, retorna true indicando que o mapa está pronto
	 */
	public static boolean criaMapa(String linha){
		// limpa do mapa as tentativas anteriores
		mapa.clear();
		
		Scanner sc = new Scanner(linha);
		
		// atual sempre vai guardar a próxima palavra a ser lida
		String atual;
		
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}
		
		
		// "the"
		if(atual.length() == 3){
			mapa.put(atual.charAt(0), 't');
			mapa.put(atual.charAt(1), 'h');
			mapa.put(atual.charAt(2), 'e');
		}
		else{
			sc.close();
			return false;
		}
		
		
		// "quick"
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}
		
		if(atual.length() == 5){
			mapa.put(atual.charAt(0), 'q');
			mapa.put(atual.charAt(1), 'u');
			mapa.put(atual.charAt(2), 'i');
			mapa.put(atual.charAt(3), 'c');
			mapa.put(atual.charAt(4), 'k');
		}
		else{
			sc.close();
			return false;
		}
		
		// "brown"
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}

		if(atual.length() == 5){
			mapa.put(atual.charAt(0), 'b');
			mapa.put(atual.charAt(1), 'r');
			mapa.put(atual.charAt(2), 'o');
			mapa.put(atual.charAt(3), 'w');
			mapa.put(atual.charAt(4), 'n');
		}
		else{
			sc.close();
			return false;
		}

		// "fox"
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}

		if(atual.length() == 3){
			mapa.put(atual.charAt(0), 'f');
			mapa.put(atual.charAt(2), 'x');
			
			// se ele der dois mapeamentos para a mesma letra, retorna falso
			if(!mapa.containsKey(atual.charAt(1)) || mapa.get(atual.charAt(1))!='o'){
				sc.close();
				return false;
			}
			
		}
		else{
			sc.close();
			return false;
		}
		
		// "jumps"
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}

		if(atual.length() == 5){
			mapa.put(atual.charAt(0), 'j');
			mapa.put(atual.charAt(1), 'u');
			mapa.put(atual.charAt(2), 'm');
			mapa.put(atual.charAt(3), 'p');
			mapa.put(atual.charAt(4), 's');
		}
		else{
			sc.close();
			return false;
		}

		// "over"
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}

		if(atual.length() == 4){
			mapa.put(atual.charAt(1), 'v');
			mapa.put(atual.charAt(2), 'e');
			
			// se ele der dois mapeamentos para a mesma letra, retorna falso
			if(!mapa.containsKey(atual.charAt(0)) || mapa.get(atual.charAt(0))!='o'){
				sc.close();
				return false;
			}

			if(!mapa.containsKey(atual.charAt(3)) || mapa.get(atual.charAt(3))!='r'){
				sc.close();
				return false;
			}

		}
		else{
			sc.close();
			return false;
		}		
		
		
		
		// "the"
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}

		if(atual.length() == 3){
			// se ele der dois mapeamentos para a mesma letra, retorna falso
			if(!mapa.containsKey(atual.charAt(0)) || mapa.get(atual.charAt(0))!='t'){
				sc.close();
				return false;
			}

			if(!mapa.containsKey(atual.charAt(1)) || mapa.get(atual.charAt(1))!='h'){
				sc.close();
				return false;
			}

			if(!mapa.containsKey(atual.charAt(2)) || mapa.get(atual.charAt(2))!='e'){
				sc.close();
				return false;
			}
		}
		else{
			sc.close();
			return false;
		}		
		
		
		// "lazy"
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}

		if(atual.length() == 4){
			mapa.put(atual.charAt(0), 'l');
			mapa.put(atual.charAt(1), 'a');
			mapa.put(atual.charAt(2), 'z');
			mapa.put(atual.charAt(3), 'y');
		}
		else{
			sc.close();
			return false;
		}
		
		// "dog"
		if(sc.hasNext())
			atual = sc.next();
		else{
			sc.close();
			return false;
		}

		if(atual.length() == 3){
			mapa.put(atual.charAt(0), 'd');
			mapa.put(atual.charAt(2), 'g');

			// se ele der dois mapeamentos para a mesma letra, retorna falso
			if(!mapa.containsKey(atual.charAt(1)) || mapa.get(atual.charAt(1))!='o'){
				sc.close();
				return false;
			}
			

		}
		else{
			sc.close();
			return false;
		}		
		
		// se ainda há palavras na linha lida, ela não corresponde ao enunciado
		if(sc.hasNext()){
			sc.close();
			return false;
		}		
		
		// se chegou até aqui, o mapa foi criado corretamente
		sc.close();
		return true;

	}
	
	static Collection<String> resposta = new LinkedList<String>();
	
	public static boolean traduzir(String linha){
		
		char[] trad = new char[linha.length()];
		
		for(int i = 0; i < linha.length(); i++){
			
			// se o caracter atual for um espaço em branco
			if(linha.charAt(i) == ' '){
				trad[i] = ' ';
				continue;
			}
			
			if(!mapa.containsKey(linha.charAt(i)))
				return false;
			
			trad[i] = mapa.get(linha.charAt(i));
		}
		
		resposta.add(String.valueOf(trad));
		return true;
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		// para testes no eclipse
		Scanner sc = new Scanner(new FileInputStream("entrada.txt"));
		
		// Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		Collection<String> set = new LinkedList<String>();
		String atual;
		sc.nextLine();
		sc.nextLine();
		
		// loop dos casos de input
		for(int i = 0; i<casos; i++){
			
			// limpa o set do caso anterior
			set.clear();
			
			// captura todas as linhas do caso i
			while(sc.hasNext()){
				atual = sc.nextLine();
				
				// se encontrar uma linha em branco, encerre a captura deste caso
				if(atual.length() == 0)
					break;
				
				set.add(atual);
			}
			
			boolean mapa_criado = false;
			Iterator<String> it = set.iterator();
			
			// tenta encontrar a linha que criará o mapa
			while(it.hasNext() && !mapa_criado){
				if(criaMapa(it.next())){
					mapa_criado = true;
				}
			}
			
			// se um mapa não foi criado corretamente, dá output correspondente
			if(!mapa_criado){ 
				System.out.println("No solution.");
				System.out.println();
				continue;
			}
			
			Iterator<String> it2 = set.iterator();
			
			// limpa a resposta anterior
			resposta.clear();
			
			// usa o mapa criado para dar todas as saídas correspondentes
			for(int j = 0; j<set.size(); j++){
				if(!traduzir(it2.next())){
					System.out.println("No solution.");
					break;
				}
			}
			
			// printa a resposta
			Iterator<String> it4 = resposta.iterator();
			for (int j = 0; j < resposta.size(); j++) {
				System.out.println(it4.next());
			}
			System.out.println();
			
		}
		
		
		sc.close();

	}
}
