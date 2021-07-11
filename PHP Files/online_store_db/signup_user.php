<?php

//$showAlert=false;
$showError = false;
include 'partials/db_connect.php';
if( $_SERVER["REQUEST_METHOD"] == "POST"){
   
    $email = $_POST["email"];
    $username = $_POST["username"];
    $password = $_POST["password"];
   
    //To check wheather this username exits or not
    $existsql = "SELECT * FROM `signup_users` WHERE email = '$email' ";
    $result = mysqli_query( $conn, $existsql );
    $num_exist_rows = mysqli_num_rows($result);

    if($num_exist_rows > 0){
    echo "A user with this Email Address already exists";    
    }
    else{   
            //to secure our password it do one way hashing
            //hence if a hacker gets the hash value he can't get the
            //password
            $hash = password_hash($password , PASSWORD_DEFAULT);

            $sql = "INSERT INTO `signup_users` (`email`,`username`, `password`, `dt`) 
                    VALUES ('$email','$username', '$hash', current_timestamp());";  
        
            $result = mysqli_query($conn,$sql);   
            // if($result){
            //     $showAlert=true;
            // }  
    }
}


?>