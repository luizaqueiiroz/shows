package com.gerenciamentoDeShow.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gerenciamentoDeShow.Entities.Show;
import com.gerenciamentoDeShow.Repository.ShowRepository;

@Service
public class ShowService {

	private final ShowRepository showRepository;
	
	public ShowService (ShowRepository showRepository) {
		this.showRepository = showRepository;
	}
	public Show salvaShow (Show show) {
		return showRepository.save(show);
	}
	public Show getShowBydId (Long id) {
		return showRepository.findById(id).orElse(null);
	}
	public List<Show> getShowAll(){
		return showRepository.findAll();
	}
	public Show alterarShow (Long id, Show alterarShow) {
		Optional<Show> existeShow = showRepository.findById(id);
		if(existeShow.isPresent()) {
			alterarShow.setId(id);
			return showRepository.save(alterarShow);
		}else {
			return null;
		}
	}
	public boolean deleteShow(Long id) {
		Optional<Show> existeShow = showRepository.findById(id);
		if(existeShow.isPresent()) {
			showRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
