
    export const dataHandler = {

    addProductToCart: async function(product){
        await apiPost("/api/add-to-cart", product);
    }

    }


    async function apiGet(url) {
        const response = await fetch(url, {
            method : "GET",
        });
        if(response.status < 300) {
            return response.json();
        }
    }


    async function apiPost(url, data) {
        const response = await fetch(url, {
            method : "POST",
            headers : {
                "Content-type" : "application/json"
            },
            body : JSON.stringify(data)
        });
        return await response.json();
    }

    async function apiDelete(url) {
        await fetch(url, {
            method: "DELETE"
        });
    }