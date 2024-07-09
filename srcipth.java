const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
const xInput = document.getElementById('x');
const yInput = document.getElementById('y');
const radioInput = document.getElementById('radio');
const dibujarButton = document.getElementById('dibujar');
const resetButton = document.getElementById('reset');

function dibujarPlanoCartesiano() {
  ctx.beginPath();
  ctx.moveTo(0, canvas.height / 2);
  ctx.lineTo(canvas.width, canvas.height / 2);
  ctx.stroke();

  ctx.beginPath();
  ctx.moveTo(canvas.width / 2, 0);
  ctx.lineTo(canvas.width / 2, canvas.height);
  ctx.stroke();
}

function dibujarCircunferencia() {
  ctx.clearRect(0, 0, canvas.width, canvas.height); // Limpia el canvas
  dibujarPlanoCartesiano(); // Dibuja el plano cartesiano de nuevo

  ctx.beginPath();
  ctx.arc(
    parseInt(xInput.value) + canvas.width / 2, // Ajusta el centro X
    parseInt(yInput.value) * -1 + canvas.height / 2, // Ajusta el centro Y
    parseInt(radioInput.value), 
    0, 
    2 * Math.PI
  );
  ctx.stroke();
}

dibujarButton.addEventListener('click', dibujarCircunferencia);

function resetInputs() {
  xInput.value = 0;
  yInput.value = 0;
  radioInput.value = 50;
  ctx.clearRect(0, 0, canvas.width, canvas.height); // Limpia el canvas
  dibujarPlanoCartesiano(); // Dibuja el plano cartesiano de nuevo
}

resetButton.addEventListener('click', resetInputs);

// Dibuja el plano cartesiano al cargar la página
dibujarPlanoCartesiano(); 