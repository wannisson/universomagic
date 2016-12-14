package br.com.universomagic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import br.com.universomagic.entidade.Carts;
import br.com.universomagic.pojo.Cards;
import br.com.universomagic.pojo.CardsResponse;
import br.com.universomagic.pojo.ForeignNames;
import br.com.universomagic.repositorio.CartsRepository;

@Controller
public class CartsController {
	@Autowired
	CartsRepository cartsRepository;
	String PORTUGUES = "Portuguese (Brazil)";

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("carts", cartsRepository.findAll());
		return "inicio";
	}


	@GetMapping(value="/login")
	public String login() {
		return "inicio";
	}
	
	@GetMapping(value="/buscar")
	public   String buscar(@RequestParam(value="nome", required=false, defaultValue="") String nome, Model model) {
		model.addAttribute("carts", cartsRepository.findByNameIgnoreCaseContaining(nome));
		
	return "inicio";
	}
	
	@GetMapping(value="/import")
	public String importarCartas(@RequestParam(value="url", required=true, defaultValue="") String url, Model model) {
		
		CardsResponse objCardsResponse = carregarCartas(url);
		
		List<Cards> lsCards = objCardsResponse.getCards();
		
		
		for(Cards objCard : lsCards) {
			
			List<ForeignNames> lsForeignNames = objCard.getForeignNames();
		
			for(ForeignNames objForeNames : lsForeignNames) {
				
				if(PORTUGUES.equals(objForeNames.getLanguage())) {
					objCard.setImageUrl(objForeNames.getImageUrl());
					objCard.setName(objForeNames.getName());
					
					if(objCard.getPower() == null){
						objCard.setPower("0");
					}
					if(objCard.getToughness() == null){
						objCard.setToughness("0");
					}
					
					cartsRepository.save(new Carts(objCard));
					
					break;
				}
			}
		}
		return "redirect:/";
	}

	
	public CardsResponse carregarCartas(String url) {
		
		try {
			
			HttpHeaders objHeaders = new HttpHeaders();
			objHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0");
			HttpEntity<CardsResponse> objEntity = new HttpEntity<CardsResponse>(objHeaders);
			ResponseEntity<CardsResponse> objResponse = new RestTemplate().exchange(url, HttpMethod.GET, objEntity, CardsResponse.class);
			
			return objResponse.getBody();
			
		} catch (Exception e) {
			
			return new CardsResponse();
		}
		
	}
	
	private Cards atualizarCarts(Cards cards) {
		System.out.println(cards);
		if(cards != null && cards.getPower().equals(null) || ("").equals(cards.getPower())){
			cards.setPower("0");
		}else if(cards != null && cards.getToughness().equals(null) || ("").equals(cards.getToughness())){
			cards.setToughness("0");
		}else if(cards != null && cards.getManaCost() != null){
			cards.getManaCost().replace("{", "");
			cards.getManaCost().replace("}", " ");
		}
		
		
		return cards;
	}
 
}
