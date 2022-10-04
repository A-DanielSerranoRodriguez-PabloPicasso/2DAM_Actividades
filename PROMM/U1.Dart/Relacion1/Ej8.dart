class Coche {
  String nombre = "Default", matricula = "00000XXX";

  Coche(String nombre, String matricula) {
    this.nombre = nombre;
    this.matricula = matricula;
  }

  String getNombre() {
    return nombre;
  }

  String getMatricula() {
    return matricula;
  }
}

void main(List<String> args) {
  Coche coche = new Coche("Pedro", "12345ABC");

  print(coche.getNombre() + " " + coche.getMatricula());
}
