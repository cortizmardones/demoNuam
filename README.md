
# Proyecto Spring Boot — Factory + Strategy

En este proyecto implementamos los patrones de diseño **Factory + Strategy** para decidir dinámicamente qué implementación de servicio utilizar en función del campo `companyRut` recibido en el request.

---

## 🚀 Ejemplo de request

```bash
curl --location 'localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
    "productName": "Nombre Test",
    "productPrice": 12500,
    "companyRut": "76000002-1"
}'
```

---

## 🧩 Cómo funciona

1. **Interfaz común**  
   Definimos una interfaz `ProductService` que expone el contrato de negocio.

2. **Múltiples implementaciones**  
   Creamos varias clases que implementan `ProductService`, cada una asociada a una empresa distinta (`companyRut`).

3. **Factory centralizado**  
   Usamos un `ProductFactory` que recibe todas las implementaciones inyectadas por Spring en un `List<ProductService> services`.

4. **Selección dinámica (Strategy)**  
   Cuando llega un request, el factory selecciona la estrategia adecuada según el `companyRut` y delega la ejecución a la implementación concreta.

---

## ✅ Ventajas de este enfoque

- **Extensible**: agregar una nueva empresa solo requiere una nueva implementación de la interfaz.
- **Desacoplado**: el controlador no necesita saber qué implementación usar, solo pasa el `companyRut`.
- **Mantenible**: se evita el uso de `if/else` o `switch` en cada request.
- **Testable**: cada estrategia se puede probar de forma aislada.

---

## 📊 Flujo resumido

1. El cliente envía un `POST /product` con `companyRut`.
2. El controlador delega al `ProductFactory`.
3. El factory selecciona la implementación correcta de `ProductService`.
4. La estrategia concreta procesa el request.


---

De esta forma, el sistema **elige automáticamente la implementación correcta** según el `companyRut` recibido en el request.
