package dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private int ano_lancamento;
	
	@ManyToOne
	private Banda banda;
	
	@OneToMany(mappedBy = "album")
	private List<Musica> musicas = new ArrayList<>();
	
	public Album() {}
	
	public Album(String titulo, int ano_lancamento) {
		this.titulo = titulo;
		this.ano_lancamento = ano_lancamento;
	}

	public void adicionarMusica(Musica musica) {
		musicas.add(musica);
		musica.setAlbum(this);
	}

	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public int getAno_lancamento() {
		return ano_lancamento;
	}
	public Banda getBanda() {
		return banda;
	}
	public List<Musica> getMusicas() {
		return musicas;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}
	public void setBanda(Banda banda) {
		this.banda = banda;
	}
}