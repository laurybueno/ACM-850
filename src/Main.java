import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


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
			if(mapa.get(atual.charAt(1))!='o'){
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
			if(mapa.get(atual.charAt(0))!='o'){
				sc.close();
				return false;
			}

			if(mapa.get(atual.charAt(3))!='r'){
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
			if(mapa.get(atual.charAt(0))!='t'){
				sc.close();
				return false;
			}

			if(mapa.get(atual.charAt(1))!='h'){
				sc.close();
				return false;
			}

			if(mapa.get(atual.charAt(2))!='e'){
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
			if(mapa.get(atual.charAt(1))!='o'){
				sc.close();
				return false;
			}
			

		}
		else{
			sc.close();
			return false;
		}		
		
		// se chegou até aqui, o mapa foi criado corretamente
		sc.close();
		return true;

	}

	public static void main(String[] args) {
		
		// para testes no eclipse
		try {
			System.setIn(new FileInputStream("entrada.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		Set<String> set = new TreeSet<String>();
		String atual;
		sc.nextLine();
		
		// loop dos casos de input
		for(int i = 0; i<casos; i++){
			
			// limpa o set do caso anterior
			set.clear();
			sc.nextLine();
			
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
			while(it.hasNext()){
				if(criaMapa(it.next())){
					mapa_criado = true;
				}
			}
			
			// se um mapa não foi criado corretamente, dá output correspondente
			if(!mapa_criado){ 
				System.out.println("No solution.");
				continue;
			}
			
			// usa o mapa criado para dar todas as saídas correspondentes
			System.out.println(mapa);
			
		}
		
		
		sc.close();

	}

	
	
	
	
	
	
	
	
	
}
