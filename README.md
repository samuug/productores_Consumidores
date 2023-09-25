# productores_Consumidores

## Nota:
Mi repositorio es: https://github.com/samuug/productores_Consumidores.git

## Enunciado:
Problema: productores y consumidores.

En un cierto programa se tienen procesos que producen números y procesos que leen esos números. Todos los números se introducen en una cola (o vector) limitada.

Todo el mundo lee y escribe de/en esa cola. Cuando un productor quiere poner un número tendrá que comprobar si la cola está llena. Si está llena, espera un tiempo al azar. Si no está llena pone su número en la última posición libre.

Cuando un lector quiere leer, examina si la cola está vacía. Si lo está espera un tiempo al azar, y sino coge el número que haya al principio de la cola y ese número ya no está disponible para el siguiente.

Crear un programa que simule el comportamiento de estos procesos evitando problemas de entrelazado e inanición.
Solución

En primer lugar necesitamos una cola que sea «a prueba de hilos» y que permita encolar y desencolar elementos de una manera segura.

Sabemos que antes de encolar hay que comprobar si la cola está llena. También sabemos que antes de desencolar hay que comprobar si la cola está vacía.

Sin embargo ¡¡CUIDADO!! es posible programar mal aunque las operaciones de nuestra cola estén protegidas con el método «synchronized». Supongamos que un productor tiene código como este:

while (true){
        if (!cola.estaLlena()){
                cola.encolar(4);
        }
}

Puede que pensemos que este código está bien pero ESTÁ MAL. Está mal porque puede que en el tiempo transcurrido entre que un productor ejecuta estaLlena y encolar OTRO HILO SE HAYA COLADO ENTRE MEDIAS Y HAYA ALTERADO LA EJECUCIÓN. Eso significa que aunque llamemos a dos métodos synchronized uno detrás de otro es posible que la ejecución sea incorrecta. Así, necesitaremos hacer operaciones encolar y desencolar que funcionen de manera atómica y nos avisen de si consiguen hacer la operación o no.
