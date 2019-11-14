


//let makeCar = function(name, city, mail, phone, brand, type, fuel, description, price) {
/*function emailveri(email) {
    return (email.search(/^w+((-w+)|(.w+))*@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+)*.[A-Za-z0-9]+$/) != -1);
}*/

function printCar() {
    let name = document.querySelector("#name").value;
    let city = document.querySelector("#city").value;
    let email = document.querySelector("#email").value;
   
/*if (!emailveri(email.value)) {
    alert('Bitte gültige E-Mail-Adresse angeben!');
    field.focus();
    return false;
}*/
    let phone = document.querySelector("#phone").value;
    let brand = document.querySelector("#brand").value;
    let type = document.querySelector("#type").value;
    let fuel = document.querySelector("#fuel").value;
    let price = document.querySelector("#price").value;
    let description = document.querySelector("#description").value;
    let image = document.querySelector("#image").value;
    console.log(name, city, email, phone, brand, type, fuel, description, image, price);

}

/*    let car = {
        name = this.name;
        city = this.city;
        mail = this.mail;
        phone = this.phone;
        brand = this.brand;
        type = this.type;
        fuel = this.fuel;
        description = this.description;
        price = this.price;
    }
} */


