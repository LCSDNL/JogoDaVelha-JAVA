import java.util.Arrays;
import java.util.Scanner;



public class JogoDaVelha {
	
	Scanner s =new Scanner(System.in);
	
	boolean empate=false;
	char[]compare;
	int rodada;
	char[]tablX;
	char[]tablO;
	char[][]tab;
	int jogador=1;
	
	public JogoDaVelha(int x) {
		
		rodada=x*x; 
		tab =new char[x][x];
		tablX=new char[x];
		tablO=new char[x];

		 
		 for(int l=0;l<tab.length;l++) {
				tablX[l]='X';
				}
		 
		 for(int l=0;l<tab.length;l++) {
				for(int c=0;c<tab.length;c++){
					tablO[l]='O';
					}
		 		}
		 }

	
	
	public boolean verificaGanhador() {
		boolean res=false;
		
//		FOR das linhas
			for(int l=0;l<tab.length;l++) {
				compare=new char[tab.length];
				
							for(int c=0;c<tab.length;c++){
							compare[c]=tab[l][c];}
																	
					if(Arrays.equals(compare, tablX)==true) {
						res=true;}
					
					if(Arrays.equals(compare, tablO)==true) {
						res=true;}				
			}
			
//			FOR das colunas
			for(int c=0;c<tab.length;c++) {
				compare=new char[tab.length];
						
						for(int l=0;l<tab.length;l++) {
							compare[l]=tab[l][c];}
					
					if(Arrays.equals(compare,tablX)==true) {
						res=true;}
					
					if(Arrays.equals(compare,tablO)==true) {
						res=true;}
					}
			
//			FOR das diagonais
			
//			Descendente
			for(int i=0;i<1;i++) {
				compare=new char[tab.length];
				for(int c=0;c<tab.length;c++) {
					compare[c]=tab[c][c];}
					
					if(Arrays.equals(compare,tablX)) {
						res=true;}
					if(Arrays.equals(compare,tablO)==true) {
						res=true;}
				}
				
			
//			Ascendente
			for(int i=0;i<1;i++) {
				int d=0;
				compare=new char[tab.length];
				for(int l=tab.length-1;l>=0;l--) {
						compare[l]=tab[l][d];
						d++;}
				
				if(Arrays.equals(compare,tablX)==true) {
					res=true;}
				if(Arrays.equals(compare,tablO)==true) {
					res=true;}
			}
						
			
				
			
		return res;	
			}
		
	
	public boolean realizaJogada() {
		
		System.out.println("Faça sua jogada player "+jogador+" !");
		System.out.println("Linha?");
		int linha = s.nextInt();
		System.out.println("Coluna?");
		int coluna = s.nextInt();
		
		try {
			if(tab[linha][coluna] !='X' && tab[linha][coluna] !='O') {
				if(jogador==1) {
					tab[linha][coluna] = 'X';
					jogador++;
					rodada--;
					return true;
				}if(jogador==2) {
					tab[linha][coluna] = 'O';
					jogador--;
					rodada--;
					return true;
					}
			}else{
				System.out.println("Jogada Invalida");
				}
			
		}catch(ArrayIndexOutOfBoundsException i){
			System.out.println("\n Posição fora do tabuleiro! Tamanho atual: "+tab.length+" !\n");
			}
		
		if(rodada<=0) {
			empate=true;
		}	
		return false;
	}
	
	
	public boolean empatou() {
		return empate;
	}
	
	
	public String toString() {
		StringBuilder tabuleiro = new StringBuilder();
		
		for(int l=0 ; l<tab.length; l++) {
			
			for(int c=0;c<tab.length;c++) {
				if(c>0) {
					tabuleiro.append("|");
				}
				tabuleiro.append(tab[l][c]);
			}
			tabuleiro.append("\n");
		} 
						
		return tabuleiro.toString();
		
	}
	
	
	public int getJogador() {
		return jogador;
	}
	
	
	public boolean continuar() {
		System.out.println("Gostaria de parar? S=sim / N=não");
		String co= s.next();
		if(co.equalsIgnoreCase("n")||co.equalsIgnoreCase("nao")||co.equalsIgnoreCase("não")) {
			return false;
		}else return true;
	}
	
}
