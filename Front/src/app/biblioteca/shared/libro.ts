export class Libro {

    id: number;
    nombre: string;
    ISBN: string;
    autores: string;

    setData(id: number, nombre: string, isbn: string, autores: string) {
        this.id = id;
        this.autores = autores;
        this.ISBN = isbn;
        this.nombre = nombre;
    }

    constructor() {
    }

}
