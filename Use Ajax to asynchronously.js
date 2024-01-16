/* Use Ajax to asynchronously communicate with the servlets and update the user interface without refreshing the page. */





function convertCurrency() {
    var amount = document.getElementById("amount").value;
    var from = document.getElementById("from").value;
    var to = document.getElementById("to").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("result").innerHTML = "Converted Amount: " + this.responseText;
        }
    };
    xhttp.open("POST", "CurrencyConverterServlet", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("from=" + from + "&to=" + to + "&amount=" + amount);
}