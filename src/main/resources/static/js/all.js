document.addEventListener('DOMContentLoaded', function(){ 
var elementos = Array.prototype.slice.call(document.getElementsByClassName("values_list"));
elementos.forEach(function(li) {
    var t = Array.prototype.slice.call(li.getElementsByTagName("li"));

    t.forEach(function(e) {
        e.addEventListener("mouseover", function() {
            t.forEach(function(t) {
                t.className = t.className.replace(/\bactive\b/, "")
            });
            var e = this;
            e.className += " active";
            var a = this.closest("div").getElementsByTagName("p");
            a[0].innerHTML = e.getAttribute("data-title");
            a[1].innerHTML = e.getAttribute("data-value");
            e.getAttribute("data-caps") ? a[1].style.textTransform = "lowercase" : a[1].style.textTransform = "capitalize"
        })
    })
});
}, false);