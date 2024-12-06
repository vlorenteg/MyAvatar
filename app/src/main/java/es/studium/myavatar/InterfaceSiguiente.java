package es.studium.myavatar;

import android.view.View;

public interface InterfaceSiguiente {

    // Método para el clic en el avatar
    void clickAvatar(View v);

    // Métodos para abrir los diálogos
    void abrirDialogoSexo();
    void abrirDialogoEspecie();
    void abrirDialogoProfesion();

    // Métodos para obtener datos de los diálogos
    void onDataSetSexo(String sexo);
    void onDataSetNombre(String nombre);
    void onDataSetEspecie(String especie);
    void onDataSetProfesion(String profesion);

    // Método para obtener poderes aleatorios
    void random();
}
