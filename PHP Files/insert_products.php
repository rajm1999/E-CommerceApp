<?php

$connection = new mysqli("localhost","root","","online_store_db");
$sqlCommand = $connection->prepare("insert into electronic_products values(?,?,?,?,?)");
$sqlCommand->bind_param("isiss",$_GET["id"],$_GET["name"],$_GET["price"],$_GET["brand"],$_GET["picture"]);
$sqlCommand->execute();
        
