package br.edu.ifrs.banda.dao;

import java.util.List;
import dominio.Banda;

public interface BandaDAO {
    void salvar(Banda banda);
    Banda buscarPorId(Long id);
    List<Banda> listarTodos();
    void atualizar(Banda banda);
    void remover(Long id);
    List<Banda> listarPorGenero(String genero);
}