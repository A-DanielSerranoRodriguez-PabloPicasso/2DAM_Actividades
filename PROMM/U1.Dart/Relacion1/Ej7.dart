void main(List<String> args) {
  List lista = new List.filled(0, 1, growable: true),
      multX3 = new List.filled(0, 0, growable: true);

  for (int i = 1; i <= 50; i++) {
    lista.add(i);
  }

  for (int i = 0; i < lista.length; i++) {
    if (lista[i] % 3 == 0) multX3.add(lista[i]);
  }
  print(multX3);
}
