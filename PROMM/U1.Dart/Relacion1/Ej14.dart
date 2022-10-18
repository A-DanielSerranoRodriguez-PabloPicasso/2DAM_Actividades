void main(List<String> args) async {
  print("antes");
  await prueba(10).then((value) => print(value));

  print("despues");
}

Future<int> prueba(int vueltas) async {
  int total = 0;
  for (var i = 0; i < vueltas; i++) {
    total += i;
  }
  total = await extra();
  return Future.delayed(const Duration(seconds: 3), () => total);
}

int extra() {
  return 100;
}
