<?php

$connection = new mysqli("localhost","root","","online_store_db");
$getTemporaryOrdersCommand =$connection->prepare("select * from temporary_place_order where email=?");
$getTemporaryOrdersCommand->bind_param("s",$_GET["email"]);
$getTemporaryOrdersCommand->execute();
$temporaryOrdersResult = $getTemporaryOrdersCommand->get_result();

$populatenvoiceWithEmailCommand = $connection->prepare("insert into invoice(email) values(?)");
$populatenvoiceWithEmailCommand->bind_param("s",$_GET["email"] );
$populatenvoiceWithEmailCommand->execute();

$getLatetInvoiceNumberCommand = $connection->prepare("select max(invoice_num) as latest_invoice_num from invoice where email=?");
$getLatetInvoiceNumberCommand->bind_param("s",$_GET["email"]);
$getLatetInvoiceNumberCommand->execute();
$invoice_number_result = $getLatetInvoiceNumberCommand->get_result();
$row_invoiceNumber = $invoice_number_result->fetch_assoc();

while($row = $temporaryOrdersResult->fetch_assoc()){
    $populatenvoiceWithEmailCommand = $connection->prepare("insert into invoice_details values(?,?,?)");
    $populatenvoiceWithEmailCommand->bind_param("iii",$row_invoiceNumber["latest_invoice_num"],$row["product_id"],$row["amount"]);
    $populatenvoiceWithEmailCommand->execute();
    
    $deleteTempOrdersCommand =$connection->prepare("delete from temporary_place_order where email=?");
    $deleteTempOrdersCommand->bind_param("s", $_GET["email"]);
    $deleteTempOrdersCommand->execute();
} 
echo $row_invoiceNumber["latest_invoice_num"]; 

        
