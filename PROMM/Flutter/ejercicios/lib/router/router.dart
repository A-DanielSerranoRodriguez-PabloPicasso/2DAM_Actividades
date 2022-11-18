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
    ),
    MenuOption(
      ruta: "ej4",
      nombre: "Ejercicio 4",
      pantalla: const Ej4(),
    ),
    MenuOption(
      ruta: "ej5",
      nombre: "Ejercicio 5",
      pantalla: const Ej5(),
    ),
    MenuOption(
      ruta: "ej7",
      nombre: "Ejercicio 7",
      pantalla: const Ej7(),
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
