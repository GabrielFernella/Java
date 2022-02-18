package com.domain.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.domain.cursomc.domain.Cliente;
import com.domain.cursomc.domain.enuns.TipoCliente;
import com.domain.cursomc.dto.ClienteDTO;
import com.domain.cursomc.repositories.ClienteRepository;
import com.domain.cursomc.resources.exception.FieldMessage;
import com.domain.cursomc.services.validation.utils.BR;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id")); // Nesse trexo de cod. estmaos pegando atributos do header e transformando para integer
		
		List<FieldMessage> list = new ArrayList<>();
		
		
		Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
		if(aux!= null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "E-mail já existente"));
		}
		

		// inclua os testes aqui, inserindo erros na lista

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}