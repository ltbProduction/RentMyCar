

function emailveri(email) {
    return (email.search(/^w+((-w+)|(.w+))*@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+)*.[A-Za-z0-9]+$/) != -1);
}

function printCar() {
    let name = $('#name').value;
    let city = $('#city').value;
    let email = $('#email').value;

if (!emailveri(email)) {
    alert('Bitte gültige E-Mail-Adresse angeben!');
    field.focus();
    return false;
}

    let phone = $('#phone').value;;
    let brand = $('#brand').value;;
    let type = $('#type').value;;
    let fuel = $('#fuel').value;;
    let price = $('#price').value;;
    let description = $('#description').value;;
    let image = $('#image').value;
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


