import 'package:flutter/material.dart';

class Ej7 extends StatelessWidget {
  const Ej7({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Ejercicio 6"),
      ),
      drawer: Drawer(
        child: ListView(
          children: const [
            UserAccountsDrawerHeader(
              accountName: Text("Periplo"),
              accountEmail: Text("periplastico@gmail.com"),
              currentAccountPicture: Image(
                image: AssetImage("assets/images/chad.png"),
                fit: BoxFit.cover,
              ),
              decoration: BoxDecoration(
                image: DecorationImage(
                  image: AssetImage("assets/images/background.png"),
                  opacity: 0.4,
                  fit: BoxFit.cover,
                ),
                color: Colors.black,
              ),
            ),
            ListTile(
              title: Text("Opcion 1"),
            ),
            ListTile(
              title: Text("Opcion 2"),
            ),
            ListTile(
              title: Text("Opcion 3"),
            ),
            ListTile(
              title: Text("Opcion 4"),
            ),
          ],
        ),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: const [
            Text("Prueba el menu lateral!"),
          ],
        ),
      ),
      floatingActionButton: Padding(
        padding: const EdgeInsets.only(left: 30),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            FloatingActionButton(
              onPressed: () => Navigator.pop(context),
              child: const Icon(Icons.arrow_back),
            ),
          ],
        ),
      ),
    );
  }
}
