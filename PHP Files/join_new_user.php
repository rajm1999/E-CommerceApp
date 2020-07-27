<?php

//Sign Up Part

//this line helps to connect to the database
$connection =new mysqli("localhost","root","","online_store_db");


//$sqlCommand = $connection->prepare("insert into app_users_table values(?,?,?)");
//$sqlCommand->bind_param("sss",$_GET["email"],$_GET["username"],$_GET["pass"]);
//$sqlCommand->execute();

//
$emailCheckSQLCommand = $connection->prepare("select * from app_users_table where email=?");
$emailCheckSQLCommand->bind_param("s",$_GET["email"]);
$emailCheckSQLCommand->execute();
$emailResult =$emailCheckSQLCommand->get_result();

//if email already exist do not add the user again
if($emailResult->num_rows==0){
$sqlCommand = $connection->prepare("insert into app_users_table values(?,?,?)");
$sqlCommand->bind_param("sss",$_GET["email"],$_GET["username"],$_GET["pass"]);
$sqlCommand->execute();
echo 'Congratulations! The registrarion process is successful';
} else{
    echo 'A user with this Email Address already exists';
}
