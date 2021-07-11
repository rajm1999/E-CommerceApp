<?php
$login=false;
$showError = false;
if( $_SERVER["REQUEST_METHOD"] == "POST"){
   
    include 'partials/db_connect.php';
    $email = $_POST["email"];
    $password = $_POST["password"];

     //First thing is password and confirm password should be same
        $sql = "Select * from signup_users where email ='$email' ";
        $result = mysqli_query($conn,$sql);   
        $num = mysqli_num_rows($result);

            if($num == 1 ){
                while($row = mysqli_fetch_assoc($result)){
                    if(password_verify($password,$row['password'])){
                        $login ="The user does exist";
                        session_start();
                        $_SESSION['loggedin'] = true;
                        $_SESSION['username'] = $username;
                    }
                    else{
                        $showError="Invalid Credentials";
                    }
                }
            }  
        else{
            $showError="Invalid Credentials";
        }
     if($login==false)   
     echo $showError; 
     else
     echo $login;  
}


?>