package desafio.api.rest.controller;

import desafio.api.rest.dto.ProfileDTO;
import desafio.api.service.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api( tags = "Profiles")
public class ProfilesController {

    @Autowired
    private ProfileService profileService;

    @CrossOrigin
    @GetMapping("/usuarios/{id}")
    @ApiOperation(value = "Endpoint de busca de único profile de profissional.")
    public ProfileDTO buscarUmProfile(@PathVariable(value = "id") Integer id){
        return profileService.buscarUmProfile(id);
    }
}
