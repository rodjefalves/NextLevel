package desafio.api.service;

import desafio.api.exception.ProfileNaoEncontradoException;
import desafio.api.repository.ProfileRepository;
import desafio.api.rest.dto.ProfileDTO;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
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
}
