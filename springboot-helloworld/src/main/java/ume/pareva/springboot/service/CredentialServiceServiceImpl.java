package ume.pareva.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ume.pareva.springboot.Dao.CredentialDao;
import ume.pareva.springboot.models.CredentialService;

@Component
@Transactional
public class CredentialServiceServiceImpl implements CredentialServiceService{

	@Autowired
	private CredentialDao credential;
	
	@Override
	public Iterable<CredentialService> findAll() {
		return credential.findAll();
	}

	@Override
	public void add(CredentialService c) {
		credential.save(c);
	}

	@Override
	public boolean remove(CredentialService c) {
		credential.delete(c);
		return false;
	}

	@Override
	public void remove(int id) {
		credential.delete(id);
	}

	@Override
	public CredentialService get(int id) {
		return credential.findOne(id);
	}
}
