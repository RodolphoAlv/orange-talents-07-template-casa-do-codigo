package com.zup.rodolpho.validators;

import com.zup.rodolpho.model.Categoria;
import com.zup.rodolpho.repository.CategoriaRepository;
import com.zup.rodolpho.request.CategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaUnicaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoriaRequest categoriaRequest = (CategoriaRequest) target;

        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoriaRequest.getNome());
        if(possivelCategoria.isPresent())
            errors.rejectValue("nome", null, "Categoria " + categoriaRequest.getNome() + " já cadastrada no sistema");
    }
}
