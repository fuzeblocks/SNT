
document.querySelector("form").addEventListener("submit", function (event) {
    event.preventDefault();

    const password = document.getElementById("userPassword").value;

    fetch("https://api.fuzeblocks.icu/passwordTest?password=" + encodeURIComponent(password) , {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        },
    })
    .then(response => response.text())
    .then(text => {
        const note =  document.getElementById("passwordStrength")
         note.textContent = text + "/100";
         note.style.backgroundColor = getColorFromInt(text);
         note.style.padding = '5px';
         note.style.borderRadius = '10px';
         note.style.color = "black";
    })
    .catch(error => {
        console.error("Erreur :", error);
        document.getElementById("passwordStrength").textContent = "Erreur lors de la vérification : " + error;
    });
});

function getColorFromInt(i) {
    const num = parseInt(i, 10);

    switch(true) {
        case (num >= 10 && num <= 20):
            return "red";   
        case (num > 20 && num <= 40):
            return "orange"; 
        case (num > 40 && num <= 60):
            return "yellow";
        case (num > 60 && num <= 80):
            return "green";  
        case (num > 80 && num <= 100):
            return "blue";  
        default:
            return "white"; 
    }
}

    

    function generatePassword() {
        fetch('https://api.motdepasse.xyz/create/?include_digits&include_lowercase&include_special_characters&include_uppercase&password_length=32&quantity=1')
            .then(response => response.json())
            .then(data => {
                var container = document.getElementById('returnPassword');
                container.innerHTML = data.passwords ? `<p>${data.passwords[0]}</p> <button id="copyPassword" onclick="copy()"><i class="fa-solid fa-copy"></i></button>` : 'Erreur lors de la génération.';
            })
            .catch(() => {
                document.getElementById('returnPassword').innerHTML = 'Une erreur est survenue.';
            });
    }
    function copy() {
    var element = document.getElementById('returnPassword').querySelector('p');
    
    var range = document.createRange();
    range.selectNodeContents(element);

    var selection = window.getSelection();
    selection.removeAllRanges(); 
    selection.addRange(range); 

  
    document.execCommand('copy');

    var changeEmoji = document.getElementById('returnPassword').querySelector('i');
    changeEmoji.className = "fa-solid fa-paste";

    timer();
    }

    function timer(){
    var sec = 3;
    var timer = setInterval(function(){
        sec--;
        if (sec < 0) {
            var changeEmoji = document.getElementById('returnPassword').querySelector('i');
            changeEmoji.className = "fa-solid fa-copy";
            clearInterval(timer);
        }
    }, 1000);

}
