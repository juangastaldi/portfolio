package jgastaldi.portfolio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jgastaldi.portfolio.dto.AssetsProfitDTO;
import jgastaldi.portfolio.dto.PortfolioDTO;
import jgastaldi.portfolio.model.Person;
import jgastaldi.portfolio.service.PortfolioService;

@RestController
public class PortfolioController {

	@Autowired
	private PortfolioService transactionService;

	@GetMapping("/sell")
	public String sell() {
		return "sell";
	}

	@GetMapping("/buy")
	public String buy() {
		return "buy";
	}

	@PostMapping("/portfolio")
	public ResponseEntity<PortfolioDTO> buildPortfolio(@RequestBody Person person) {
		return ResponseEntity.ok(transactionService.builPorfolio(person));
	}

	@PostMapping("/portfolio/value")
	public ResponseEntity<Double> getPortfolioValue(@RequestBody Person person) {
		return ResponseEntity.ok(transactionService.getPortfolioValue(person));
	}

	@PostMapping("/portfolio/profit")
	public ResponseEntity<List<AssetsProfitDTO>> getPortfolioProfit(@RequestBody Person person) {
		return ResponseEntity.ok(transactionService.getPortfolioProfit(person));

	}
}