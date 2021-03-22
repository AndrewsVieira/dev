import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.validator.routines.EmailValidator;

@WebServlet("/meuservlet")
public class MeuServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serveReq(request, response);
    } // fim do método doGet()

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serveReq(request, response);
    } // fim do método doPost()

    private void serveReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println(
                "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                        "<title>Manipulando formulários com Java Servlets</title>" +
                    "</head>" +
                    "<body>" +
                        "<h1>Manipulando formulários com Java Servlets</h1>" +
                        "<form method=\"post\">" +
                            "<fieldset>" +
                                "<legend>Novo Usuário</legend>" +
                                "Nome: *<br/>" +
                                "<input type=\"text\" name=\"nome\"/><br/>" +
                                "E-mail: *<br/>" +
                                "<input type=\"text\" name=\"email\"/><br/>" +
                                "Senha: *<br/>" +
                                "<input type=\"password\" name=\"senha\"/><br/>" +
                                "Confirmar senha: *<br/>" +
                                "<input type=\"password\" name=\"conf_senha\"/><br/>" +
                                "Cidade:<br/>" +
                                "<select name=\"cidade\">" +
                                    "<option value=\"-1\" selected>--Selecione</option>" +
                                    "<option value=\"1\">Florianópolis</option>" +
                                    "<option value=\"2\">São José</option>" +
                                    "<option value=\"99\">Outro</option>" +
                                "</select><br/>" +
                                "Idade:<br/>" +
                                "<input type=\"text\" name=\"idade\"/><br/>" +
                                "Comentários:<br/>" +
                                "<textarea name=\"comentarios\" rows=\"4\" cols=\"30\"></textarea><br/>" +
                                "Sexo:<br/>" +
                                "<input type=\"radio\" name=\"sexo\" value=\"m\">Masculino</input>" +
                                "<input type=\"radio\" name=\"sexo\" value=\"f\">Feminino</input>" +
                                "<input type=\"radio\" name=\"sexo\" value=\"o\">Outro</input></br>" +
                                "<br/>" +
                                "<input type=\"checkbox\" name=\"termos\"/> Concordo com os termos de uso *<br/>" +
                                "<hr/>" +
                                "<input type=\"submit\" value=\"Enviar\"/>" +
                                "<input type=\"reset\" value=\"Limpar\"/>" +
                                "<p>* Campos obrigatórios</p>" +
                            "</fieldset>" +
                        "</form>");
            if (request.getMethod().equals("POST")) {
                List<String> erros = new ArrayList<>();
                EmailValidator emailValidator = EmailValidator.getInstance();

                String nome = preProcessa(request.getParameter("nome"));
                String email = preProcessa(request.getParameter("email"));
                String senha = preProcessa(request.getParameter("senha"));
                String confSenha = preProcessa(request.getParameter("confSenha"));
                String cidade = preProcessa(request.getParameter("cidade"));
                String idade = preProcessa(request.getParameter("idade"));
                String comentarios = preProcessa(request.getParameter("comentarios"));
                String sexo = preProcessa(request.getParameter("sexo"));
                String termos = preProcessa(request.getParameter("termos"));

                if (nome.isEmpty()) {
                    erros.add("Nome é campo obrigatório.");
                }
                if (email.isEmpty()) {
                    erros.add("E-mail é campo obrigatório.");
                } else if (!emailValidator.isValid(email)) {
                    erros.add("E-mail inválido");
                }
                if (senha.isEmpty()) {
                    erros.add("Senha é um campo obrigatório.");
                }
                if (confSenha.isEmpty()) {
                    erros.add("Confirmar senha é campo obrigatório");
                } if (!confSenha.equals(senha)) {
                    erros.add("Senhas não conferem.");
                }
                if (!idade.isEmpty()) {
                    try {
                        int idadeInt = Integer.parseInt(idade);
                        if (idadeInt < 0) {
                            erros.add("Idade de ser um número inteiro maior ou igual a 0.");
                        }   
                    } catch (NumberFormatException e) {
                        erros.add("Idade deve ser um número inteiro maior ou igual a 0.");
                    }
                }
                if (termos.isEmpty()) {
                    erros.add("Você precisa concordar com os termos de uso.");
                }
                if (erros.size() > 0) {
                    out.println("<ul>");
                    erros.forEach(erro -> out.println("<li>" + erro + "</li>"));
                    out.println("</ul>");
                }
                out.println("<h2>Dados Recebidos:</h2>" +
                            "<ul>" +
                            "<li><b>Nome:</b> " + nome + "</li>" +
                            "<li><b>E-mail:</b> " + email + "</li>" +
                            "<li><b>Senha:</b> " + senha + "</li>" +
                            "<li><b>Confirmar senha:</b> " + confSenha + "</li>" +
                            "<li><b>Cidade:</b> " + cidade + "</li>" +
                            "<li><b>Idade:</b> " + idade + "</li>" +
                            "<li><b>Comentários:</b> " + comentarios + "</li>" +
                            "<li><b>Sexo:</b> " + sexo + "</li>" +
                            "<li><b>Termos:</b> " + termos + "</li>" +
                            "<ul>");
            }

            out.println("</body></html>");
        } // from do try...catch

    } // fim do método serveReq()
    private String preProcessa(String entrada) {
        String saida = "";
        if (entrada != null) {
            saida = StringEscapeUtils.escapeHtml4(entrada.trim().replace("\\", ""));
        }
        return saida;
    } // fim do método preProcessa()
} // fim da classe MeuServlet