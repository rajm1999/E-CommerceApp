<?php

$connection = new mysqli("localhost","root","","online_store_db");
$fetchProductCommand = $connection->prepare("select * from electronic_products where brand=?");
$fetchProductCommand->bind_param("s", $_GET["brand"]);
//this execute is to run the sql command
$fetchProductCommand->execute();

$epResult = $fetchProductCommand->get_result();

$epArray = array();

while($row = $epResult->fetch_assoc()){
    array_push($epArray, $row);
}

echo(json_encode($epArray));
