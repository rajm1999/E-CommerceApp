<?php

include 'partials/db_connect.php';

$sql = "select DISTINCT brand from electronic_products ";

$brandsResult = mysqli_query($conn,$sql); ;  

$brands = array();      

while($row = $brandsResult->fetch_assoc()){
      array_push($brands,$row);
  }
  $json = json_encode($brands);
  echo $json;

?>