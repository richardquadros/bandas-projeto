package dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Musica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private float duracao;
	
	@ManyToOne
	private Album album;
	
	public Musica() {}
	
	public Musica(String titulo, float duracao) {
		this.titulo = titulo;
		this.duracao = duracao;
	}

	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public float getDuracao() {
		return duracao;
	}
	public Album getAlbum() {
		return album;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDuracao(float duracao) {
		this.duracao = duracao;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
}