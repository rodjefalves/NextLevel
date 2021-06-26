package desafio.api.exception;

public class EmpresaNaoEncontradaException extends RuntimeException {
    public EmpresaNaoEncontradaException(Integer id) {
        super("A empresa de id " + id + " não foi encontrada.");
    }
}
