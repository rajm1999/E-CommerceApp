<?php
if( $_SERVER["REQUEST_METHOD"] == "GET"){

    include 'partials/db_connect.php';
    
    $email = $_GET['email'];
    $sql = "DELETE FROM `temporary_place_order` where email='$email' ";
    $sqlResult = mysqli_query($conn,$sql);   
    if($sqlResult)
    echo "the Record was Inserted successfully<br>";
    else
    echo "the Table was not Inserted successfully".mysqli_error($conn);
}

?>