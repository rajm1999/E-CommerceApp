<?php

 if( $_SERVER["REQUEST_METHOD"] == "GET"){

    include 'partials/db_connect.php';
    
    $brand = $_GET['brand'];
        
    $sql = "SELECT * FROM `electronic_products` WHERE `brand`='$brand'";
    $brandsResult = mysqli_query($conn,$sql);   
    $num = mysqli_num_rows($brandsResult);
    $brands = array();      
     if ($num >0 ){
    
    while($row = $brandsResult->fetch_assoc()){
       array_push($brands,$row);
    }
     $json = json_encode($brands);
    echo $json;
    }
    // if($result){
    //     $num = mysqli_num_rows($result);
    //     echo $num." records found in the database";
    // }
    // $epArray = array();

    // if ($num >0 ){
    //     while($row = mysqli_fetch_assoc($fetchProductCommand)){
    //         array_push($epArray, $row);
    //     }
    // }
    
    // $json = json_encode($epArray);
    // echo $json;
}
?>