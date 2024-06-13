package com.example.Haulage.Service;

import java.util.List;

import jakarta.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Haulage.Entity.*;
import com.example.Haulage.Repository.*;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public List<State> getAll() {

		return stateRepository.findAll();
	}

	public void saveState(@Valid State state) {

		stateRepository.save(state);
	}

	public State update(Long id) {

		return stateRepository.getOne(id);

	}

	public void delete(Long id) {

		stateRepository.deleteById(id);
	}

	public List<State> getStateByCountryId(Long id) {

		return stateRepository.getStateByCountryId(id);
	}

}
