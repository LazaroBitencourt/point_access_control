package point_access_control.service;


import point_access_control.model.JornadaTrabalho;

public interface JornadaService {

    public JornadaTrabalho create(JornadaTrabalho jornadaTrabalho);

    public Iterable<JornadaTrabalho> findAll();

    public JornadaTrabalho findById(Long id);

    public JornadaTrabalho update(Long id, JornadaTrabalho jornadaTrabalho);

    public void delete(Long id);
}
