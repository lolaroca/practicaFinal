async function signUp(){
    try {
        var userId = await document.getElementById("userId").value;
        var username = await document.getElementById("username").value;
        var password = await document.getElementById("password").value;
        var email = await document.getElementById("email").value;
        var country = await document.getElementById("country").value;
        var address = await document.getElementById("address").value;
        var pedidoId = await document.getElementById("pedidoId").value;


        var data = {"userId": userId,
                    "username":username,
                    "password":password,
                    "email":email,
                    "country":country,
                    "address":address,
                    "pedidoId":pedidoId
                    };
        console.log(data);
        const address = 'api/v1/signup';
        fetch(address, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body:JSON.stringify(data)
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                if(data.result == "OK") {
                    alert("User Created");
                    document.location.href="/api/v1/users";
                } else {
                    alert(data.result);
                }
            });

    } catch (err) {
        console.error(err.message);
    }
    return false;

}