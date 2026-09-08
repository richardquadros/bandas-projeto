package dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Banda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String genero;
	
	@OneToMany(mappedBy = "banda")
	private List<Album> albuns = new ArrayList<>();
	
	@OneToMany(mappedBy = "banda")
	private List<Integrante> integrantes = new ArrayList<>();
	
	public Banda() {}
	
	public Banda(String nome, String genero) {
		this.nome = nome;
		this.genero = genero;
	}

	public void adicionarAlbum(Album album) {
		albuns.add(album);
		album.setBanda(this);
	}

	public void adicionarIntegrante(Integrante integrante) {
		integrantes.add(integrante);
		integrante.setBanda(this);
	}

	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public List<Album> getAlbuns() {
		return albuns;
	}
	public List<Integrante> getIntegrantes() {
		return integrantes;
	}
}