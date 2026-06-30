package livraria.model;

public class LivroFisico extends Produto{
	
	private int numeroPaginas;


	public LivroFisico(int id, String titulo, String autor, int categoria, float preco, int numeroPaginas) {
		super(id, titulo, autor, categoria, preco);
		this.numeroPaginas = numeroPaginas;
	}


	public int getNumeroPaginas() {
		return numeroPaginas;
	}


	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.printf("Número de páginas: %d%n",this.numeroPaginas);
	}
}
