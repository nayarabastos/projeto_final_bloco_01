package livraria.model;

public class Ebook extends Produto{

private int tamanhoArquivo;

	public Ebook(int id, String titulo, String autor, int categoria, float preco, int tamanho) {
		super(id, titulo, autor, categoria, preco);
	}

	public int getTamanhoArquivo() {
		return tamanhoArquivo;
	}

	public void setTamanhoArquivo(int tamanhoArquivo) {
		this.tamanhoArquivo = tamanhoArquivo;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Tamanho do Arquivo: %d MB",this.tamanhoArquivo);
	}
}
