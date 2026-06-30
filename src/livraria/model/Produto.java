package livraria.model;

public abstract class Produto {
	private int id;
	private String titulo;
	private String autor;
	private int categoria;
	private float preco;
	
	public Produto(int id, String titulo, String autor, int categoria, float preco) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
public void visualizar() {
		
		String categoria = " ";
		
		switch(this.categoria) {
			case 1 -> categoria = "Livro Físico";
			case 2 -> categoria = "E-book";
			default -> categoria = "Inválido";
		}
		
		System.out.println("\n********************************************");
		System.out.println("DADOS DO LIVRO");
		System.out.println("********************************************");
		System.out.printf("Id do livro: %d%n", this.id);
		System.out.printf("Categoria do livrp: %s%n", categoria);
		System.out.printf("Título do livro: %s%n", this.titulo);
		System.out.printf("Autor do livro: %s%n", this.titulo);
		System.out.printf("Preço do livro: R$ %.2f%n", this.preco);
	}
	
}
