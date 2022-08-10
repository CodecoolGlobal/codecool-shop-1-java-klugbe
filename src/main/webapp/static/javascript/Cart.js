import {dataHandler} from "./DataHandler.js";

main();


function main(){
    const addProductButtons = document.querySelectorAll(".addProduct");
    addProductButtons.forEach((button)=> button.addEventListener("click", addProductToCart))

    console.log("cart.js works")
}

async function addProductToCart(event){
    const productId = event.currentTarget.getAttribute("data-id");
    await dataHandler.addProductToCart(productId);
}
