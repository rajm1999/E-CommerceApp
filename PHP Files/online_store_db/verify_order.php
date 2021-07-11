<?php
if( $_SERVER["REQUEST_METHOD"] == "GET"){

    include 'partials/db_connect.php';
    
    $email = $_GET['email'];
    $getTempOrderSql = "select * from temporary_place_order where email='$email' ";
    $temporaryOrdersResult = mysqli_query($conn,$getTempOrderSql); 

    $populateCommand="insert into invoice(email) values('$email')";
    $populatenvoiceWithEmailCommand = mysqli_query($conn,$populateCommand); 

    $getLatestInvoiceNumberCommand ="select max(invoice_num) as latest_invoice_num from invoice where email='$email'";
    $invoice_number_result = mysqli_query($conn,$getLatestInvoiceNumberCommand);
    $row_invoiceNumber = $invoice_number_result->fetch_assoc();

while($row = $temporaryOrdersResult->fetch_assoc()){

    $populatenvoiceWithEmailCommand ="insert into invoice_details values(".$row_invoiceNumber['latest_invoice_num'].",".$row['product_id'].",".$row['amount'].")";
    $populateInoviceResult = mysqli_query($conn,$populatenvoiceWithEmailCommand); 

    $deleteTempOrdersCommand ="delete from temporary_place_order where email=$email";
    $deleteTempOrdersResult = mysqli_query($conn,$deleteTempOrdersCommand); 
} 
echo $row_invoiceNumber["latest_invoice_num"];
}
?>