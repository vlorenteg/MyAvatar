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

public class DialogoSexo extends DialogFragment
{
    InterfaceSiguiente mListener;
    RadioButton hombre;
    RadioButton mujer;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle saveInstanceState)
    {
        // Construir el diálogo y hacerlo modal
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View MyView = inflater.inflate(R.layout.dialogo_sexo, null);
        hombre = MyView.findViewById(R.id.rb_hombre);
        mujer = MyView.findViewById(R.id.rb_mujer);

        builder.setView(MyView)
                .setTitle("Elige tu género")
                // Configurar botones
                .setPositiveButton("Aceptar", null) // Configuraremos el comportamiento manualmente
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cerrar el diálogo
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();

        // Configurar el comportamiento del botón "Aceptar"
        dialog.setOnShowListener(dialogInterface -> {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(view -> {
                if (hombre.isChecked()) {
                    mListener.onDataSetSexo("H");
                    mListener.abrirDialogoEspecie();
                    dialog.dismiss();
                } else if (mujer.isChecked()) {
                    mListener.onDataSetSexo("M");
                    mListener.abrirDialogoEspecie();
                    dialog.dismiss();
                } else {
                    // Mostrar mensaje de error si no se selecciona nada
                    Toast.makeText(getActivity(), "Debes seleccionar un género", Toast.LENGTH_SHORT).show();
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
