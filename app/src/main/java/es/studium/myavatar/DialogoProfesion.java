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

public class DialogoProfesion extends DialogFragment
{
    InterfaceSiguiente mListener;
    RadioButton arquero;
    RadioButton guerrero;
    RadioButton mago;
    RadioButton herrero;
    RadioButton minero;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Construir el diálogo y hacerlo modal
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View MyView = inflater.inflate(R.layout.dialogo_profesion, null);
        arquero = MyView.findViewById(R.id.rb_arquero);
        guerrero = MyView.findViewById(R.id.rb_guerrero);
        mago = MyView.findViewById(R.id.rb_mago);
        herrero = MyView.findViewById(R.id.rb_herrero);
        minero = MyView.findViewById(R.id.rb_minero);

        builder.setView(MyView)
                .setTitle("Para terminar escoge una profesión")
                // Configurar los botones
                .setPositiveButton("Aceptar", null) // Configuraremos manualmente el comportamiento
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
                if (arquero.isChecked()) {
                    mListener.onDataSetProfesion("arquero");
                    mListener.random();
                    dialog.dismiss();
                } else if (guerrero.isChecked()) {
                    mListener.onDataSetProfesion("guerrero");
                    mListener.random();
                    dialog.dismiss();
                } else if (mago.isChecked()) {
                    mListener.onDataSetProfesion("mago");
                    mListener.random();
                    dialog.dismiss();
                } else if (herrero.isChecked()) {
                    mListener.onDataSetProfesion("herrero");
                    mListener.random();
                    dialog.dismiss();
                } else if (minero.isChecked()) {
                    mListener.onDataSetProfesion("minero");
                    mListener.random();
                    dialog.dismiss();
                } else {
                    // Mostrar mensaje de error si no se selecciona ninguna profesión
                    Toast.makeText(getActivity(), "Debes seleccionar una profesión", Toast.LENGTH_SHORT).show();
                }
            });
        });

        return dialog;
    }

    @Override
    public void onAttach(Context context)
    {
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
