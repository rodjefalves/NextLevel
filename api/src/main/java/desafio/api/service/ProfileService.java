package desafio.api.service;

import desafio.api.exception.ProfileNaoEncontradoException;
import desafio.api.repository.EmpresaRepository;
import desafio.api.repository.ProfileRepository;
import desafio.api.rest.dto.ProfileDTO;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    private final EmpresaService empresaService;

    public ProfileService(ProfileRepository profileRepository, EmpresaService empresaService) {
        this.profileRepository = profileRepository;
        this.empresaService = empresaService;
    }

    public ProfileDTO buscarUmProfile(Integer id){

        return profileRepository.findById(id)
                .map(profile -> ProfileDTO
                        .builder()
                        .id(profile.getId())
                        .nome(profile.getNome())
                        .telefone(profile.getTelefone())
                        .email(profile.getEmail())
                        .data_nascimento(profile.getData_nascimento())
                        .link_foto(profile.getLink_foto())
                        .build())
                .orElseThrow(() -> new ProfileNaoEncontradoException(id));
    }

    public String enviarProfile(Integer idProfile, Integer idEmpresa){

        //TODO Aqui pode ser feito uma lógica para enviar via SpringMail.

        String nomeProfile = buscarUmProfile(idProfile).getNome();
        String nomeEmpresa = empresaService.buscarUmaEmpresa(idEmpresa).getNome();

        return "E-mail com os dados de " + nomeProfile + " enviados para a empresa " + nomeEmpresa;
    }
}
