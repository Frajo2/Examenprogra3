import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Lista {

    private Nodo inicio;
    private int tamanio;

    public Lista() {

        this.inicio = null;
        this.tamanio = 0;
    }

    public int getTamanio() {

        return this.tamanio;
    }

    public Nodo getNodo() {

        return this.inicio;
    }



    public boolean isEmpty(){

        boolean flag = false;

        if(this.inicio == null)
            flag = true;

        return flag;
    }


    public void agregarThunderbolth(Thunderbolts thunderbolt){

        Nodo nuevoNodo = new Nodo(thunderbolt);

        if(isEmpty()){

            this.inicio = nuevoNodo;
        }else{

            nuevoNodo.setNext(this.inicio);
            this.inicio = nuevoNodo;
            this.tamanio++;
        }
    }


    public int busquedaLineal(int codigoThunderbolt) {

        Nodo actual = this.inicio;

        while (actual != null) {

            if (actual.getThunderbolt().getCodigo() == codigoThunderbolt) {

                return actual.getThunderbolt().getCodigo();
            }

            actual = actual.getNext();
        }

        return -1; // Retorna -1 si no se encuentra
    }



    public void mostrar(JTable table, int codigo, boolean flag){

        Nodo aux = this.inicio;

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Codigo", "Nombre", "Poder Especial", "Nivel de habilidad", "Mision Activa"}, 0);
        model.addRow(new Object[]{"Codigo", "Nombre", "Poder Especial", "Nivel de habilidad", "Mision Activa"});

        if(flag){

            while(aux != null){

                model.addRow(new Object[]{aux.getThunderbolt().getCodigo(), aux.getThunderbolt().getNombre(), aux.getThunderbolt().getPoderEspecial(), aux.getThunderbolt().getNivelHabilidad(), aux.getThunderbolt().getMisionActiva()});
                aux = aux.getNext();

            }

            table.setModel(model);
        }else{

            while(aux != null){

                if(codigo == aux.getThunderbolt().getCodigo()){

                    model.addRow(new Object[]{aux.getThunderbolt().getCodigo(), aux.getThunderbolt().getNombre(), aux.getThunderbolt().getPoderEspecial(), aux.getThunderbolt().getNivelHabilidad(), aux.getThunderbolt().getMisionActiva()});
                }

                aux = aux.getNext();
            }

            table.setModel(model);
        }
    }


    public void ordenar(){

        if (this.inicio == null || this.inicio.getNext() == null) return;

        boolean swapped;
        do {
            swapped = false;
            Nodo actual = this.inicio;
            Nodo siguiente = this.inicio.getNext();
            while (siguiente != null) {

                if (actual.getThunderbolt().getNivelHabilidad() > siguiente.getThunderbolt().getNivelHabilidad()) {

                    Thunderbolts temp = actual.getThunderbolt();
                    actual.setThunderbolt(siguiente.getThunderbolt());
                    siguiente.setThunderbolt(temp);
                    swapped = true;
                }
                actual = siguiente;
                siguiente = siguiente.getNext();
            }
        } while (swapped);
    }



    public int contarElementos(Lista listaSimple, int indice) {

        if(isEmpty()){

            return 0;
        }else{

            if (indice == this.tamanio + 1) {

                return 0;
            }

            return 1 + contarElementos(listaSimple, indice + 1);
        }
    }



    public Lista filtrar(String poderEspecial, boolean flag) {
        Nodo aux = this.inicio;
        Lista lista = new Lista();

        if (flag) {
            while (aux != null) {
                if (poderEspecial.equals(aux.getThunderbolt().getPoderEspecial())) {
                    lista.agregarThunderbolth(aux.getThunderbolt());
                }
                aux = aux.getNext();
            }
        } else {
            while (aux != null) {
                if (!poderEspecial.equals(aux.getThunderbolt().getPoderEspecial())) {
                    lista.agregarThunderbolth(aux.getThunderbolt());
                }
                aux = aux.getNext();
            }
        }

        return lista;
    }

    public int contarMisionesPorHabilidad(String habilidad, Nodo nodo) {

        if (nodo == null) {
            return 0;
        }

        int contarActual = nodo.getThunderbolt().getPoderEspecial().equals(habilidad) ? 1 : 0;

        return contarActual + contarMisionesPorHabilidad(habilidad, nodo.getNext());
    }
    public void ordenarPorNivelRedencion() {
        if (this.inicio == null || this.inicio.getNext() == null) return;

        boolean swapped;
        do {
            swapped = false;
            Nodo actual = this.inicio;
            Nodo siguiente = this.inicio.getNext();

            while (siguiente != null) {

                if (actual.getThunderbolt().getNivelHabilidad() > siguiente.getThunderbolt().getNivelHabilidad()) {

                    Thunderbolts temp = actual.getThunderbolt();
                    actual.setThunderbolt(siguiente.getThunderbolt());
                    siguiente.setThunderbolt(temp);
                    swapped = true;
                }
                actual = siguiente;
                siguiente = siguiente.getNext();
            }
        } while (swapped);
    }
    public Thunderbolts buscarPorCodigo(int codigo) {
        Nodo actual = this.inicio;

        while (actual != null) {
            if (actual.getThunderbolt().getCodigo() == codigo) {
                return actual.getThunderbolt(); // Retorna el Thunderbolt si se encuentra
            }
            actual = actual.getNext();
        }

        return null; // Retorna null si no se encuentra
    }


}

