void main(List<String> args) {
  print("antes");
  prueba(10).then((value) => print(value));
  print("despues");
}

Future<int> prueba(int vueltas) {
  int total = 0;
  for (var i = 0; i < vueltas; i++) {
    total += i;
  }
  return Future.delayed(Duration(seconds: 3), () => total);
}
