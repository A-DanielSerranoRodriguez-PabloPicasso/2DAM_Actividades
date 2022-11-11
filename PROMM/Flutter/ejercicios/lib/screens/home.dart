import 'package:ejercicios/router/router.dart';
import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    List rutas = AppRoutes.rutas;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Ejercicios de Flutter'),
      ),
      body: ListView.separated(
        itemBuilder: (context, index) => ListTile(
          title: Text(rutas[index].nombre),
          onTap: () => Navigator.pushNamed(context, rutas[index].ruta),
        ),
        separatorBuilder: (context, index) => const Divider(),
        itemCount: rutas.length,
      ),
    );
  }
}
