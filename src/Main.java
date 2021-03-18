import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s =new Scanner(System.in);
		int jogador=1;
		
		
		System.out.println("Nome do jogador 1: ");
		Jogador jog1= new Jogador(s.next(),jogador);
		jogador++;
		System.out.println("Nome do jogador 2: ");
		Jogador jog2= new Jogador(s.next(),jogador);
		
		

		boolean parar=false;
		
		
		do{
			
			boolean terminou=false;
			System.out.println("O jogo vai começar!");
			System.out.println("Escolha o tamanho do tabuleiro: ");
			JogoDaVelha jo= new JogoDaVelha(s.nextInt());
			
				do{
					
					System.out.println(jo.toString());
					jo.realizaJogada();
					
						if(jo.verificaGanhador()) {
								if(jo.getJogador()!=jog1.getPlay()){
									jog1.IncrementaPontos();
									System.out.println("Jogador 1 Venceu!");
									terminou=true;
									if(jo.continuar()) {
									parar=false;	
									}else {parar=true;}
								}else {
									jog2.IncrementaPontos();
									System.out.println("Jogador 2 Venceu!");
									terminou=true;
									if(jo.continuar()) {
										parar=false;	
									}else {parar=true;}
									}
							
					}
						if(jo.empatou()) {
						System.out.println("Empatou!");
						terminou=true;
						if(jo.continuar()) {
							parar=false;	
						}else {parar=true;}
					}	
				}while(terminou==false);
			}while(parar==true);
		
		System.out.println("Pontuação final: ");
		
		if(jog1.getPontos()>jog2.getPontos()) {
			System.out.println(jog1.toString());
			
		}else if(jog1.getPontos()==jog2.getPontos()) {
				System.out.println(jog1.toString());
				System.out.println(jog2.toString());
		
		}else{System.out.println(jog2.toString());}

	
	s.close();
	}

}
