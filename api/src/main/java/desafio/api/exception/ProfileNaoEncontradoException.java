package desafio.api.exception;

public class ProfileNaoEncontradoException extends RuntimeException{

    public ProfileNaoEncontradoException(Integer id) {
        super("O profile de id " + id + " não foi encontrado.");
    }
}