-- 1.- Mostrar el nombre del producto y el nombre de la categoría de todos los productos que contengan la letra Q en el nombre.
SELECT c.categoria, p.producto
FROM categorias c INNER JOIN productos p
    ON p.categoria_id = c.id
WHERE p.producto LIKE '%q%'
ORDER by c.categoria, p.producto;

-- 2.- Mostrar el número de pedido y el país del cliente de los pedidos de mayo del año 1997
SELECT p.id 'Numero pedido', c.pais, p.fecha_pedido
FROM pedidos p 
  INNER JOIN clientes c
    ON cliente_id = c.id
WHERE fecha_pedido BETWEEN '1997-05-01' AND '1997-05-31'
ORDER BY p.fecha_pedido, p.id;


-- 3.- Mostrar fecha del pedido, cantidad y el nombre producto, y el código del pedido para 
-- los códigos de pedido 10285 o 10298.
SELECT d.pedido_id, p.fecha_pedido, d.cantidad, s.producto, d.precio_unidad
FROM (pedidos p
  INNER JOIN detalles d ON p.id = pedido_id)
  INNER JOIN productos s ON s.id = producto_id
WHERE p.id = 10285 
   OR p.id = 10298
ORDER BY p.id, p.fecha_pedido;
   

-- 4.- ¿Cuánto se factura cada mes? Mostrar el año, el mes y el total.
SELECT year(fecha_pedido) año, month(fecha_pedido) mes,
  SUM(cantidad *  precio_unidad * (1 - descuento)) total
FROM pedidos INNER JOIN detalles ON id = pedido_id
GROUP BY 1, 2
ORDER BY 3;

-- 5.- Los pedidos que hizo la empleada Nancy
SELECT * 
FROM pedidos
WHERE empleado_id = (SELECT id FROM empleados  WHERE nombre = 'Nancy');

-- 6.- Mostrar los pedidos de Anton (código cliente).
SELECT * 
FROM pedidos 
WHERE cliente_id = (SELECT id FROM clientes WHERE codigo = 'ANTON');

-- 7.- Cuántos productos hay de cada categoría y el precio medio
SELECT categoria, COUNT(p.id), AVG(precio_unidad) precio_medio
FROM productos p
  LEFT JOIN categorias c ON p.categoria_id = c.id
GROUP BY categoria;

-- 8.- Mostrar los pedidos que tienen productos en la categoría 2 o 3
SELECT DISTINCT pedido_id
FROM detalles
WHERE producto_id IN (
  SELECT id
  FROM productos
  WHERE categoria_id IN (2,3))
ORDER BY 1;

-- 9.- Clientes que pidieron queso en julio de 1997
SELECT DISTINCT empresa
FROM clientes c
  INNER JOIN pedidos p ON c.id = p.cliente_id
  INNER JOIN detalles d ON p.id = d.pedido_id
  INNER JOIN productos r ON r.id = d.producto_id
WHERE fecha_pedido BETWEEN '1997-07-01' AND '1997-07-31'
  AND producto LIKE '%queso%';

-- Otra manera
SELECT DISTINCT empresa
FROM clientes
WHERE id IN (
   SELECT cliente_id
   FROM pedidos INNER JOIN detalles ON id = pedido_id
   WHERE fecha_pedido BETWEEN '1997-05-01' AND '1997-05-31'
     AND producto_id IN (
       SELECT id
       FROM productos
       WHERE producto LIKE '%queso%'
     )
);
