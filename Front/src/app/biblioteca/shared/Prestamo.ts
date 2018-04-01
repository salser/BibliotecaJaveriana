import { Libro } from './libro';
import { Usuario } from './Usuario';

export class Prestamo {

    idPrestamo: number;
    fechaPrestamo: Date;
    fechaVencimiento: Date;
    fechaDevolucion: Date;
    libro: Libro;
    usuario: Usuario;

    constructor() {
    }

}
