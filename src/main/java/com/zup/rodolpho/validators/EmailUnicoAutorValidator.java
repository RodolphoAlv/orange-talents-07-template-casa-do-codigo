package com.zup.rodolpho.validators;

import com.zup.rodolpho.model.Autor;
import com.zup.rodolpho.repository.AutorRepository;
import com.zup.rodolpho.request.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailUnicoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) return;
        AutorRequest request = (AutorRequest) target;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());

        if(possivelAutor.isPresent())
            errors.rejectValue(
                    "email",
                    null,
                    "Já existe um(a) autor(a) com este email " + request.getEmail()
            );
    }
}
