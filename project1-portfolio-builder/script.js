const inputs = document.querySelectorAll("input, textarea");

inputs.forEach(input => {
  input.addEventListener("input", updateProfile);
});

function updateProfile() {
  const name = document.getElementById("name").value;
  const role = document.getElementById("role").value;
  const bio = document.getElementById("bio").value;
  const skills = document.getElementById("skills").value.split(",");

  document.getElementById("pname").innerText = name || "Your Name";
  document.getElementById("prole").innerText = role || "Your Role";
  document.getElementById("pbio").innerText = bio || "Your bio will appear here...";

  const skillsContainer = document.getElementById("pskills");
  skillsContainer.innerHTML = "";

  skills.forEach(skill => {
    if (skill.trim() !== "") {
      const span = document.createElement("span");
      span.innerText = skill.trim();
      skillsContainer.appendChild(span);
    }
  });
}

/* IMAGE UPLOAD */
document.getElementById("imageInput").addEventListener("change", function() {
  const file = this.files[0];
  if (file) {
    const reader = new FileReader();
    reader.onload = function(e) {
      document.getElementById("profileImg").src = e.target.result;
    };
    reader.readAsDataURL(file);
  }
});

/* DOWNLOAD */
function downloadCard() {
  html2canvas(document.getElementById("card")).then(canvas => {
    const link = document.createElement("a");
    link.download = "profile.png";
    link.href = canvas.toDataURL();
    link.click();
  });
}