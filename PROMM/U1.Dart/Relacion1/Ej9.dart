class Coche {
  String _nombre = "Default", _matricula = "00000XXX";

  Coche(String nombre, String matricula) {
    this._nombre = nombre;
    this._matricula = matricula;
  }

  String getNombre() {
    return _nombre;
  }

  String getMatricula() {
    return _matricula;
  }

  set setNombre(String nombre) {
    _nombre = nombre;
  }

  set setMatricula(String matricula) {
    _matricula = matricula;
  }
}

void main(List<String> args) {
  Coche coche = new Coche("Pedro", "12345ABC");

  print(coche.getNombre() + " " + coche.getMatricula());
}
