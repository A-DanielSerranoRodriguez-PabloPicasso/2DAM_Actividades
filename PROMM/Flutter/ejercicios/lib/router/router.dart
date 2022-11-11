import 'package:flutter/material.dart';

import 'package:ejercicios/screens/app_screens.dart';
import 'package:ejercicios/models/models.dart';

class AppRoutes {
  static const home = 'home';
  static final rutas = <MenuOption>[
    MenuOption(
      ruta: "ej2",
      nombre: "Ejercicio 2",
      pantalla: const Ej2(),
    ),
    MenuOption(
      ruta: "ej3",
      nombre: "Ejercicio 3",
      pantalla: const Ej3(),
    )
  ];
  static Map<String, Widget Function(BuildContext)> getAppRoutes() {
    Map<String, Widget Function(BuildContext)> rutasFinal = {};

    rutasFinal.addAll({'home': (BuildContext context) => const Home()});
    for (var ruta in rutas) {
      rutasFinal.addAll({ruta.ruta: (BuildContext context) => ruta.pantalla});
    }

    return rutasFinal;
  }

  static Route<dynamic> onGenerateRoute(settings) {
    return MaterialPageRoute(builder: (context) => const Home());
  }
}
