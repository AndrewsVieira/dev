<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Manipulando Formulários</title>
</head>
<body>
    <h1>Manipulando formulários com PHP</h1>
    <form action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>"
        method="post">
        <fieldset>
            <legend>Novo Usuário</legend>
            Nome: *<br/>
            <input type="text" name="nome"/><br/>

            E-mail: *<br/>
            <input type="text" name="email"/><br/>

            Senha: *<br/>
            <input type="text" name="senha"/><br/>

            Confirmar senha: *<br/>
            <input type="text" name="conf_senha"/><br/>

            Cidade:<br/>
            <select name=cidade">
                <option value="-1" selected>--Selecione</option>
                <option value="1">Florianópolis</option>
                <option value="2">São José</option>
                <option value="99">Outro</option>
            </select><br/>

            Idade:<br/>
            <input type="text" name="idade"/><br/>

            Comentários:<br/>
            <textarea name="comentarios" rows="4" cols="30"></textarea><br/>

            Sexo:<br/>
            <input type="radio" name="sexo" value="m">Masculino</input>
            <input type="radio" name="sexo" value="f">Feminino</input>
            <input type="radio" name="sexo" value="o">Outro</input>
            <br/>

            <input type="checkbox" name="termos"/> Concordo com os termos de uso *
            <br/><hr/>

            <input type="submit" value="Enviar"/>
            <input type="reset" value="Limpar"/>
            
        </fieldset>
    </form>

    <?php
        function preprocessa($entrada) {
            $entrada = trim($entrada); // tira os espaços no início e no final do campo
            $entrada = stripslashes($entrada); // tirar caracteres especiais com barra invertida "\n \t"
            $entrada = htmlspecialchars($entrada); // evita injeção de código pelo form
            return $entrada;            
        }

        $nome = "";
        $email = "";
        $senha = "";
        $conf_senha = "";
        $cidade = "";
        $idade = "";
        $comentarios = "";
        $sexo = "";
        $termos = "";

        if($_SERVER["REQUEST_METHOD"] == "POST") {
            $nome = preprocessa($_POST["nome"]);
            $email = preprocessa($_POST["email"]);
            $senha = preprocessa($_POST["senha"]);
            $conf_senha = preprocessa($_POST["conf_senha"]);
            $cidade = preprocessa($_POST["cidade"]);
            $idade = preprocessa($_POST["idade"]);
            $comentarios  = preprocessa($_POST["comentarios"]);
            $sexo = preprocessa($_POST["sexo"]);
            $termos = preprocessa($_POST["termos"]);

            $erros = array();

            if(empty($nome)) {
                array_push($erros, "Nome é campo obrigatório.");
            }
            if(empty($email)) {
                array_push($erros, "E-mail é campo obrigatório.");
            } else if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
                array_push($erros, "E-mail inválido.");
            }
            if(empty($senha)) {
                array_push($erros, "Senha é campo obrigatório.");
            }
            if(empty($conf_senha)) {
                array_push($erros, "Confirmar senha é campo obrigatório.");
            } else if ($conf_senha != $senha) {
                array_push($erros, "Senhas não conferem.");
            }

            $idade_opt = array("options" => array("min_range" => 0));
            if (!empty($idade) && !filter_var($idade, FILTER_VALIDATE_INT, $idade_opt)) {
                array_push($erros, "Idade deve ser um inteiro maior ou igual a 0.");
            }

            if (empty($termos)) {
                array_push($erros, "Você precisa concordar com os termos de uso.");
            }

            if (count($erros) > 0) {
                echo "<ul>";
                foreach ($erros as $erro) {
                    echo "<li>$erro</li>";
                }
                echo "</ul>";

            } else {
                echo "<h2>Dados recebidos:</h2>";
                echo "<ul>";
                echo "<li><b>Nome: </br> $nome</li>";
                echo "<li><b>E-mail: </br> $email</li>";
                echo "<li><b>Senha: </br> $senha</li>";
                echo "<li><b>Confirmar senha: </br> $conf_senha</li>";
                echo "<li><b>Cidade: </br> $cidade</li>";
                echo "<li><b>Idade: </br> $idade</li>";
                echo "<li><b>Comentários: </br> $comentarios</li>";
                echo "<li><b>Sexo: </br> $sexo</li>";
                echo "<li><b>Termos: </br> $temos</li>";
                echo "</ul>";
            }
        }
    ?>
</body>
</html>