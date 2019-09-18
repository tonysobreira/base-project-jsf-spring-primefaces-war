package br.com.controlefinanceiro.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class TemaBean {

	private List<Tema> temas;

	@PostConstruct
	public void init() {
		temas = new ArrayList<Tema>();
		temas.add(new Tema(0, "afterdark"));
		temas.add(new Tema(1, "afternoon"));
		temas.add(new Tema(2, "afterwork"));
		temas.add(new Tema(3, "aristo"));
		temas.add(new Tema(4, "black-tie"));
		temas.add(new Tema(5, "blitzer"));
		temas.add(new Tema(6, "bluesky"));
		temas.add(new Tema(7, "bootstrap"));
		temas.add(new Tema(8, "casablanca"));
		temas.add(new Tema(9, "cupertino"));
		temas.add(new Tema(10, "cruze"));
		temas.add(new Tema(11, "dark-hive"));
		temas.add(new Tema(12, "delta"));
		temas.add(new Tema(13, "dot-luv"));
		temas.add(new Tema(14, "eggplant"));
		temas.add(new Tema(15, "excite-bike"));
		temas.add(new Tema(16, "flick"));
		temas.add(new Tema(17, "glass-x"));
		temas.add(new Tema(18, "home"));
		temas.add(new Tema(19, "hot-sneaks"));
		temas.add(new Tema(20, "humanity"));
		temas.add(new Tema(21, "le-frog"));
		temas.add(new Tema(22, "midnight"));
		temas.add(new Tema(23, "mint-choc"));
		temas.add(new Tema(24, "omega"));
		temas.add(new Tema(25, "overcast"));
		temas.add(new Tema(26, "pepper-grinder"));
		temas.add(new Tema(27, "redmond"));
		temas.add(new Tema(28, "rocket"));
		temas.add(new Tema(29, "sam"));
		temas.add(new Tema(30, "smoothness"));
		temas.add(new Tema(31, "south-street"));
		temas.add(new Tema(32, "start"));
		temas.add(new Tema(33, "sunny"));
		temas.add(new Tema(34, "swanky-purse"));
		temas.add(new Tema(35, "trontastic"));
		temas.add(new Tema(36, "ui-darkness"));
		temas.add(new Tema(37, "ui-lightness"));
		temas.add(new Tema(38, "vader"));
		
		// Quebrando layout
//		temas.add(new Tema(39, "nova-light"));
//		temas.add(new Tema(40, "nova-dark"));
//		temas.add(new Tema(41, "nova-colored"));
//		temas.add(new Tema(42, "luna-blue"));
//		temas.add(new Tema(43, "luna-amber"));
//		temas.add(new Tema(44, "luna-green"));
//		temas.add(new Tema(45, "luna-pink"));
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

}
