<?php
if( $_SERVER["REQUEST_METHOD"] == "GET"){

    include 'partials/db_connect.php';
    
    $invoiceNum = $_GET['invoice_num'];
    $sql="select price,amount from electronic_products INNER JOIN invoice_details on electronic_products.id = invoice_details.product_id where invoice_details.invoice_num='$invoiceNum'";   
    $result=mysqli_query($conn,$sql);
    $totalPrice = 0; 
    while($row = $result->fetch_assoc()){
        $totalPrice = $totalPrice +($row["price"]*$row["amount"]);
    }
    echo $totalPrice;
}

?>