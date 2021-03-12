<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Orientação a Objetos com PHP</title>
</head>
<body>
<?php
abstract class Veiculo {
    private $terreno;

    public function getTerreno() {
        return $this->terreno;
    }

    public function setTerreno($terreno) {
        $this->terreno = $terreno;
    }

    abstract public function mover();

} // fim da classe Veiculo
    
class Carro extends Veiculo {
    public function __construct() {
        parent::setTerreno("terra");
    }

    public function mover() {
        print "<p>Carro percorreu 100 metros na " . $this->getTerreno() . "</p>";
    }
}// fim da classe Carro

class Barco extends Veiculo {
    public function __construct() {
        parent::setTerreno("agua");
    }

    public function mover() {
        print "<p>Barco navegou 50 metros na " . $this->getTerreno() . "</p>";
    }
}// fim da classe Barco

$veiculos = array();
$veiculos[0] = new Carro();
$veiculos[1] = new Barco();

foreach ($veiculos as $veiculo) {
    $veiculo->mover();
}
    
?>
</body>
</html>