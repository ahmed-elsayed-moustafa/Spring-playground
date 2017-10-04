package ume.pareva.springboot.service;

import org.springframework.stereotype.Component;

import ume.pareva.springboot.models.CredentialService;

@Component
public interface CredentialServiceService {

	Iterable<CredentialService> findAll();

	void add(CredentialService c);

	boolean remove(CredentialService c);

	void remove(int id);

	CredentialService get(int id);

}
