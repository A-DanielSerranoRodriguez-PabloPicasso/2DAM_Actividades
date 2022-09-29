abstract class Vehiculo {
  String _nombre = "Default", _matricula = "Default";

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

class Coche extends Vehiculo {
  Coche(String nombre, String matricula) {
    if (nombre.isEmpty)
      _nombre = getNombre();
    else
      _nombre = nombre;

    if (matricula.isEmpty)
      _matricula = getMatricula();
    else
      _matricula = matricula;
  }
}

class Moto extends Vehiculo {
  Moto(String nombre, String matricula) {
    if (nombre.isEmpty)
      _nombre = getNombre();
    else
      _nombre = nombre;

    if (matricula.isEmpty)
      _matricula = getMatricula();
    else
      _matricula = matricula;
  }
}

void main(List<String> args) {
  Coche coche = new Coche("Pedrito", "");
  Moto moto = new Moto("", "Piqueras");

  print(coche.getNombre() + " " + coche.getMatricula());
  print(moto.getNombre() + " " + moto.getMatricula());
}
