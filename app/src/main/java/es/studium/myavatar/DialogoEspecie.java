package es.studium.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoEspecie extends DialogFragment
{
    InterfaceSiguiente mListener;
    RadioButton elfo;
    RadioButton enano;
    RadioButton hobbit;
    RadioButton humano;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        // Construir el diálogo y hacerlo modal
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View MyView = inflater.inflate(R.layout.dialogo_especie, null);
        elfo = MyView.findViewById(R.id.rb_elfo);
        enano = MyView.findViewById(R.id.rb_enano);
        hobbit = MyView.findViewById(R.id.rb_hobbit);
        humano = MyView.findViewById(R.id.rb_humano);

        builder.setView(MyView)
                .setTitle("Ahora una especie")
                // Configurar los botones
                .setPositiveButton("Aceptar", null)
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cerrar el diálogo
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();

        // Configurar el botón "Aceptar" para validación manual
        dialog.setOnShowListener(dialogInterface -> {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(view -> {
                if (elfo.isChecked()) {
                    mListener.onDataSetEspecie("elfo");
                    mListener.abrirDialogoProfesion();
                    dialog.dismiss();
                } else if (enano.isChecked()) {
                    mListener.onDataSetEspecie("enano");
                    mListener.abrirDialogoProfesion();
                    dialog.dismiss();
                } else if (hobbit.isChecked()) {
                    mListener.onDataSetEspecie("hobbit");
                    mListener.abrirDialogoProfesion();
                    dialog.dismiss();
                } else if (humano.isChecked()) {
                    mListener.onDataSetEspecie("humano");
                    mListener.abrirDialogoProfesion();
                    dialog.dismiss();
                } else {
                    // Mostrar mensaje de error si no se selecciona ninguna especie
                    Toast.makeText(getActivity(), "Debes seleccionar una especie", Toast.LENGTH_SHORT).show();
                }
            });
        });

        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verificamos que la actividad principal ha implementado el interfaz
        try {
            // Instanciamos InterfaceSiguiente para poder enviar eventos a la clase principal
            mListener = (InterfaceSiguiente) context;
        } catch (ClassCastException e) {
            // La actividad no implementa el interfaz
            throw new ClassCastException(context.toString() + " debe implementar InterfaceSiguiente");
        }
    }
}
