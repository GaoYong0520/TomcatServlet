document.write("Hello, js");

function changeImg() {
    var img = document.getElementById("passimg")
    img.src = "/passimg?time=" + new Date().getTime()
}
