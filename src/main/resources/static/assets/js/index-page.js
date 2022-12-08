document.getElementById("searchId")
    .addEventListener("keypress", function(event) {
        if (event.code === "Enter") {
            event.preventDefault()
            const url = "http://localhost:8081/index/search-results/" + document.getElementById("searchId").value;
            window.location.href=url
        }
    });

