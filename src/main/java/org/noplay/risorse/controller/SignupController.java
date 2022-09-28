package org.noplay.risorse.controller;

import org.noplay.risorse.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {
	@Autowired
	private AuthService authService;

	@PostMapping
	public String signup(@RequestParam String email, @RequestParam String username, @RequestParam String password) {
		authService.signup(email, username, password);
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
				+ "    <a class=\"navbar-brand\" href=\"#\">NoPlay</a>\n"
				+ "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
				+ "      <span class=\"navbar-toggler-icon\"></span>\n"
				+ "    </button>\n"
				+ "    <div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n"
				+ "      <ul class=\"navbar-nav ms-auto\">\n"
				+ "        <li class=\"nav-item active\">\n"
				+ "          <a class=\"nav-link\" href=\"/login.html\">LOGIN</a>\n"
				+ "          \n"
				+ "        </li>\n"
				+ "\n"
				+ "        \n"
				+ "         <li class=\"nav-item\">\n"
				+ "          <a class=\"nav-link\" href=\"/logout\">LOGOUT</a>\n"
				+ "        </li>\n"
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
				+ "      <h1 class=\"fw-light\">Azienda di consulenza informatica</h1>\n"
				+ "      <div class=\"alert alert-success\">\n"
				+ "  <strong>Registrazione effetuata!</strong><br>Ora puoi avere accesso ai contenuti della pagina.\n"
				+ "  <div><br>\n"
				+ "  \n"
				+ "\n"
				+ "    <a class=\"btn btn-success w-25\" href=\"http://localhost:8080\" role=\"button\">OK</a>\n"
				+ "  </div>\n"
				+ "</div>\n"
				+ "      \n"
				+ "      <div style=\"height: 500px\"></div>\n"
				+ "      \n"
				+ "    </div>\n"
				+ "  </div>\n"
				+ "</div>\n"
				+ "\n"
				+ "  <!-- FOOTER -->\n"
				+ "  \n"
				+ "  <div\n"
				+ "    class=\"d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-dark\">\n"
				+ "    <!-- Copyright -->\n"
				+ "    <div class=\"text-white mb-3 mb-md-0\">\n"
				+ "      Copyright © 2022. PROJECTWORK2022.\n"
				+ "    </div>\n"
				+ "\n"
				+ "  </div>\n"
				+ "\n"
				+ "	\n"
				+ "	\n"
				+ "	\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\" integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\" crossorigin=\"anonymous\"></script>\n"
				+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js\" integrity=\"sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz\" crossorigin=\"anonymous\"></script>\n"
				+ "</body>\n"
				+ "</html>"
				;
			
	}
}
