package com.gerenciamentoDeShow.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamentoDeShow.Entities.Show;
import com.gerenciamentoDeShow.Service.ShowService;

@RestController
@RequestMapping("/shows")
public class ShowController {

	private final ShowService showService;

	public ShowController(ShowService showService) {
		this.showService = showService;
	}
	@GetMapping("/")
	public ResponseEntity<List<Show>> getAllShow(){
		List<Show> shows = showService.getShowAll();
		return ResponseEntity.ok(shows);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Show> getShowById(@PathVariable Long id){
		Show show = showService.getShowBydId(id);
		if (show != null) {
			return ResponseEntity.ok(show);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping("/")
	public ResponseEntity<Show> criarShow(@RequestBody Show show){
		Show criarShow = showService.salvaShow(show);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarShow);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Show>alterarShow(@PathVariable Long id, @RequestBody Show show){
		Show alterarShow = showService.alterarShow(id, show);
		if (alterarShow != null) {
			return ResponseEntity.ok(alterarShow);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteShow (@PathVariable Long id){
		boolean deleted = showService.deleteShow(id);
		if(deleted) {
			return ResponseEntity.ok().body("Agendamento de show deletado com sucesso!");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
