<?php
if( $_SERVER["REQUEST_METHOD"] == "GET"){

    include 'partials/db_connect.php';
    
    $email = $_GET['email'];
    $product_id = $_GET['product_id'];
    $amount = $_GET['amount'];

    $sql = "INSERT INTO `temporary_place_order` (`email`, `product_id`, `amount`) VALUES ('$email', '$product_id', '$amount');";
    $brandsResult = mysqli_query($conn,$sql); 
    if($brandsResult)
    echo "the Record was Inserted successfully<br>";
    else
    echo "the Table was not Inserted successfully".mysqli_error($conn);

}
?>