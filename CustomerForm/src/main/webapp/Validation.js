function validateName(){

let Name = document.getElementById("name").value
let error = document.getElementById("nameError")

if(Name.length<3||Name.length>20){
error.textContent ="Name must be between the size of 3 and 20"
}else{
error.textContent =" "
}

}


function validateEmail(){

let email = document.getElementById("email").value
let error = document.getElementById("emailError")

let pattern = /^[A-Za-z0-9._%+-]+@gmail\.com$/;

if(!pattern.test(email)){
error.textContent= "Please enter valid email :(eg: user@gmail.com)";
}else{
error.textContent = "";
}
}

function validatePassword(){

let password = document.getElementById("password").value
let error = document.getElementById("passwordError")

let pattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])?[A-Za-z\d!@#$%^&*]{6,}$/;

if(!pattern.test(password)){
error.textContent = "Password must have at least 1 capital, 1 number, and may include 1 special character (min 6 chars)";
}else{
error.textContent ="";
}
}

function validateConfirmPassword(){
let confirmPassword = document.getElementById("confirmPassword").value
let password = document.getElementById("password").value
let error = document.getElementById("confirmPasswordError")

if(confirmPassword!=password){
error.textContent = "Password do not match";
}else{
error.textContent ="";
}

}

function validateAge(){

let age = document.getElementById("age").value
let error = document.getElementById("ageError")

if(age<18||age>140){
error.textContent ="Age must be greater than 18 and less than 140"
}else{
error.textContent ="";
}

}

function validateAddress(){
let address = document.getElementById("address").value
let error = document.getElementById("AddressError")

if(address.length<3){
error.textContent = "Address must be greater than 3"
}else{
error.textContent = "";
}

}

function validatePhoneNumber(){

let number = document.getElementById("phoneNumber").value
let error = document.getElementById("phoneNumberError")

if(number.length!=10){
error.textContent ="Phone Number should be 10 digits"
}else{
error.textContent ="";
}
}


