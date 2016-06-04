<?php

header("Refresh: 40; URL='index.php'");
$gestor = fopen("C:\\xampp\\htdocs\\index.html", "r");



$linea = "";
$i = 0;
while(!feof($gestor)){
	$i++;
	$linea .= fgets($gestor);
	if($i==7)
	{
		$linea .= "<center><h2>El Cron inserta una nueva imagen cada 40 segundos</h2>
			 	<h3> Mientras que index.php se encarga de refrezcar cada 40 segundos
				la pagina para que se pueda ver el funcionamiento del cron.</h3></center>";
	}
	
}

echo "<center>".$linea."</center>";

fclose($gestor);

?>