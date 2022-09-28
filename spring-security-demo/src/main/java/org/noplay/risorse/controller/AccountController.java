package org.noplay.risorse.controller;

import org.noplay.risorse.auth.Utente;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profilo")
public class AccountController {
	
	@GetMapping
	public String get() {
		return "<html>\n"
				+ "<head>\n"
				+ " <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT\" crossorigin=\"anonymous\">\n"
				+ " <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n"
				+ "<title>No play</title>\n"
				+ "</head>\n"
				+ "<body >\n"
				+ "  \n"
				+ "  <!-- NAVBAR -->\n"
				+ "  <nav class=\"navbar navbar-expand-lg navbar-light bg-light static-top mb-5 shadow\">\n"
				+ "  <div class=\"container\">\n"
				+ "    <a class=\"navbar-brand\" href=\"/home.html\">NoPlay</a>\n"
				+ "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
				+ "      <span class=\"navbar-toggler-icon\"></span>\n"
				+ "    </button>\n"
				+ "    <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n"
				+ "      <ul class=\"navbar-nav ms-auto\">\n"
				+ "      \n"
				+ "      		<li class=\"nav-item\">\n"
				+ "      			<a class=\"nav-link\" href=\"/home.html\">HOME</a>\n"
				+ "      		</li>\n"
				+ "        \n"
				+ "            <li class=\"nav-item active\">\n"
				+ "          		<a class=\"nav-link\" href=\"/loggedout.html\">LOGOUT</a>\n"
				+ "        	</li>\n"
				+ "      </ul>\n"
				+ "    </div>\n"
				+ "  </div>\n"
				+ "</nav>\n"
				+ "\n"
				+ "\n"
				+ "<!-- CONTENUTO PAGINA -->\n"
				+ "\n"
				+ "<div class=\"container\">\n"
				+ "  <div class=\"card border-0 shadow my-5\">\n"
				+ "    <div class=\"card-body p-5\">\n"
				+ "      <h1 class=\"fw-light\">NoPlay</h1>\n"
				+ "      <h2 class=\"fw-light\">Il tuo profilo</h2><br>\n"
				+ "	  <p class=\"lead\">Username: </p>\n"
				+ "	  <p class=\"lead\">E-mail: </p>\n"
				+ "	  <p class=\"lead\">Ruolo: </p>\n"
				+ "      \n"
				+ "      <div style=\"height: 700px\"></div>\n"
				+ "      \n"
				+ "    </div>\n"
				+ "  </div>\n"
				+ "</div>\n";
	}

	@GetMapping("/detail")
	public Utente test(@AuthenticationPrincipal Utente utente) {
		return utente;
	}
}
