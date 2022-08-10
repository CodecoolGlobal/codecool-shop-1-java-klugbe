import {dataHandler} from "./DataHandler.js";

main();


function main(){
    const addProductButtons = document.querySelector(".addProduct");
    addProductButtons.forEach((button)=> button.addEventListener("click", addProductToCart))

    console.log("cart.js works")
}

function addProductToCart(event){
    console.log(event)
}
