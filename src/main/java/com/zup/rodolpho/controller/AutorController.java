package com.zup.rodolpho.controller;

import com.zup.rodolpho.model.Autor;
import com.zup.rodolpho.repository.AutorRepository;
import com.zup.rodolpho.request.AutorRequest;
import com.zup.rodolpho.response.AutorResponse;
import com.zup.rodolpho.validators.EmailUnicoAutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EmailUnicoAutorValidator emailUnicoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailUnicoAutorValidator);
    }


    @PostMapping
    public ResponseEntity<AutorResponse> cadastrar(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autor = autorRepository.save(autorRequest.toModel());
        return ResponseEntity.ok(AutorResponse.toResponse(autor));
    }
}
