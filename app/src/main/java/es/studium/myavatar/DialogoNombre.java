package es.studium.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoNombre extends DialogFragment
{
    InterfaceSiguiente mListener;
    EditText nombre;
    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Construir el diálogo y hacerlo modal
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View MyView = inflater.inflate(R.layout.dialogo_nombre, null);
        nombre = MyView.findViewById(R.id.editNombre);
        builder.setView(MyView)
                .setTitle("Vamos a ponerle nombre")
                // Añadir el botón Aceptar
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Capturar los datos introducidos en el editText nombre
                        try
                        {
                            if(!nombre.getText().toString().isEmpty())
                            {
                                mListener.onDataSetNombre(nombre.getText().toString());
                                mListener.abrirDialogoSexo();
                            }
                            else
                            {
                                Toast.makeText(getActivity(), "Tienes que rellenar el campo nombre", Toast.LENGTH_LONG).show();
                            }
                        }
                        catch(Exception e)
                        {
                            Toast.makeText(getActivity(), "Tienes que rellenar el campo nombre", Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                    }
                })
                // Añadir el botón Cancelar
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cerrar el diálogo
                        dialog.dismiss();
                    }
                });
        // Crear el objeto y devolverlo
        return builder.create();
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        // Verificamos que la actividad principal ha implementado el interfaz
        try
        {
            // Instanciamos InterfaceSiguiente para poder enviar eventos a la clase principal
            mListener = (InterfaceSiguiente) context;
        }
        catch (ClassCastException e)
        {
            // La actividad no implementa el interfaz
            throw new ClassCastException(context.toString() + " debe implementar InterfaceSiguiente");
        }
    }
}
