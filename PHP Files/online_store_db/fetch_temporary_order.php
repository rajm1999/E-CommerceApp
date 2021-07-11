<?php
if( $_SERVER["REQUEST_METHOD"] == "GET"){

    include 'partials/db_connect.php';
    
    $email = $_GET['email'];
        
    $sql = "Select id,name,price,email,amount FROM temporary_place_order INNER JOIN electronic_products ON electronic_products.id=temporary_place_order.product_id where email='$email'";

    $sqlResult = mysqli_query($conn,$sql);   
    $temporderarray = array();

    while($row = $sqlResult->fetch_assoc()){
        array_push($temporderarray, $row);
    }
    
    echo json_encode($temporderarray);
}
?>