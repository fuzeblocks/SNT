const mobileNav = document.querySelector(".hamburger");
const navbar = document.querySelector(".menubar");
const close = document.querySelector(".close");

const toggleNav = () => {
  const isActive = navbar.classList.contains("active");
  
  navbar.classList.toggle("active", !isActive);

  mobileNav.classList.toggle("hamburger-active", !isActive);
};

mobileNav.addEventListener("click", () => toggleNav());
close.addEventListener("click",() => toggleNav());