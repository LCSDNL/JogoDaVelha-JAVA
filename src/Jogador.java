
public class Jogador {
	private String nome;
	private int pontos;
	private int play;

	public Jogador(String n, int j) {
		this.nome=n;
		this.pontos=0;
		this.play=j;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getPlay() {
		return this.play;
	}
	
	public String toString() {
		return "Jogador"+getPlay()+": "+getNome()+"| |"+"Pontuação: "+getPontos(); 
	}

	public void IncrementaPontos() {
		this.pontos++;
	}
	
}
