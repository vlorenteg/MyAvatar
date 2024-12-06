package es.studium.myavatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements InterfaceSiguiente, View.OnClickListener {

    DialogoNombre dialogoNombre;
    DialogoSexo dialogoSexo;
    DialogoEspecie dialogoEspecie;
    DialogoProfesion dialogoProfesion;

    Button btnAvatar;
    TextView txtNombre;
    String sexoElegido = "";
    String especieElegida = "";
    String profesionElegida = "";
    ImageView imgAvatar;
    Button btnLimpiar;

    Random random = new Random();
    TextView txtVida;
    TextView txtMagia;
    TextView txtFuerza;
    TextView txtVelocidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAvatar = findViewById(R.id.btnAvatar);
        txtNombre = findViewById(R.id.txt_nombre_elegido);
        imgAvatar = findViewById(R.id.img_avatar);
        txtVida = findViewById(R.id.txt_vida);
        txtMagia = findViewById(R.id.txt_magia);
        txtFuerza = findViewById(R.id.txt_fuerza);
        txtVelocidad = findViewById(R.id.txt_velocidad);
        btnLimpiar = findViewById(R.id.btn_limpiar);

        btnAvatar.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public void clickAvatar(View v) {
        dialogoNombre = new DialogoNombre();
        dialogoNombre.setCancelable(false);
        dialogoNombre.show(getSupportFragmentManager(), "Nombre");
    }

    public void clickLimpiar(View v) {
        txtNombre.setText("");
        sexoElegido = "";
        especieElegida = "";
        profesionElegida = "";
        txtVida.setText("");
        txtMagia.setText("");
        txtFuerza.setText("");
        txtVelocidad.setText("");
        imgAvatar.setImageResource(R.drawable.baseline_account_box_24);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(btnAvatar)) {
            clickAvatar(btnAvatar);
        } else if (v.equals(btnLimpiar)) {
            clickLimpiar(btnLimpiar);
        }
    }

    @Override
    public void abrirDialogoSexo() {
        dialogoSexo = new DialogoSexo();
        dialogoSexo.setCancelable(false); // convertir de no modal a modal
        dialogoSexo.show(getSupportFragmentManager(), "Sexo");
    }

    @Override
    public void abrirDialogoEspecie() {
        dialogoEspecie = new DialogoEspecie();
        dialogoEspecie.setCancelable(false);
        dialogoEspecie.show(getSupportFragmentManager(), "Especie");
    }

    @Override
    public void abrirDialogoProfesion() {
        dialogoProfesion = new DialogoProfesion();
        dialogoProfesion.setCancelable(false);
        dialogoProfesion.show(getSupportFragmentManager(), "Profesión");
    }

    @Override
    public void onDataSetNombre(String nombre) {
        txtNombre.setText(nombre);
    }

    @Override
    public void onDataSetSexo(String sexo) {
        sexoElegido = sexo;
        actualizarImagenAvatar(sexoElegido, especieElegida, profesionElegida);
    }

    @Override
    public void onDataSetEspecie(String especie) {
        especieElegida = especie;
        actualizarImagenAvatar(sexoElegido, especieElegida, profesionElegida);
    }

    @Override
    public void onDataSetProfesion(String profesion) {
        profesionElegida = profesion;
        actualizarImagenAvatar(sexoElegido, especieElegida, profesionElegida);
    }

    private void actualizarImagenAvatar(String sexo, String especie, String profesion) {
        if (sexo.equals("M")) { // Femenino
            if (especie.equals("enano")) {
                if (profesion.equals("arquero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_enana_arquera);
                } else if (profesion.equals("guerrero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_enana_guerrera);
                } else if (profesion.equals("mago")) {
                    imgAvatar.setImageResource(R.drawable.mujer_enana_maga);
                } else if (profesion.equals("herrero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_enana_herrera);
                } else if (profesion.equals("minero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_enana_minera);
                }
            } else if (especie.equals("elfo")) {
                if (profesion.equals("arquero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_elfo_arquera);
                } else if (profesion.equals("guerrero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_elfo_guerrera);
                }else if (profesion.equals("mago")) {
                    imgAvatar.setImageResource(R.drawable.mujer_elfo_mago);
                } else if (profesion.equals("herrero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_elfo_herrero);
                } else if (profesion.equals("minero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_elfo_minera);
                }
            } else if (especie.equals("hobbit")) {
                if (profesion.equals("arquero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_hobbit_arquera);
                } else if (profesion.equals("guerrero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_hobbit_guerrera);
                }else if (profesion.equals("mago")) {
                    imgAvatar.setImageResource(R.drawable.mujer_hobbit_maga);
                } else if (profesion.equals("herrero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_hobbit_herrero);
                } else if (profesion.equals("minero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_hobbit_minero);
                }
            } else if (especie.equals("humano")) {
                if (profesion.equals("arquero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_humana_arquero);
                } else if (profesion.equals("guerrero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_humana_guerrero);
                }else if (profesion.equals("mago")) {
                    imgAvatar.setImageResource(R.drawable.mujer_humano_mago);
                } else if (profesion.equals("herrero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_humano_herrero);
                } else if (profesion.equals("minero")) {
                    imgAvatar.setImageResource(R.drawable.mujer_humano_minero);
                }
            }

        } else if (sexo.equals("H")) { // Masculino
            if (especie.equals("enano")) {
                if (profesion.equals("arquero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_enano_arquero);
                } else if (profesion.equals("guerrero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_enano_guerrero);
                } else if (profesion.equals("mago")) {
                    imgAvatar.setImageResource(R.drawable.hombre_enano_mago);
                } else if (profesion.equals("herrero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_enano_herrero);
                } else if (profesion.equals("minero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_enano_minero);
                }
            } else if (especie.equals("elfo")) {
                if (profesion.equals("arquero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_elfo_arquero);
                } else if (profesion.equals("guerrero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_elfo_guerrero);
                }else if (profesion.equals("mago")) {
                    imgAvatar.setImageResource(R.drawable.hombre_elfo_mago);
                } else if (profesion.equals("herrero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_elfo_herrero);
                } else if (profesion.equals("minero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_elfo_minero);
                }
            } else if (especie.equals("hobbit")) {
                if (profesion.equals("arquero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_hobbit_arquero);
                } else if (profesion.equals("guerrero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_hobbit_guerrero);
                }else if (profesion.equals("mago")) {
                    imgAvatar.setImageResource(R.drawable.hombre_hobbit_mago);
                } else if (profesion.equals("herrero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_hobbit_herrero);
                } else if (profesion.equals("minero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_hobbit_minero);
                }
            } else if (especie.equals("humano")) {
                if (profesion.equals("arquero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_humano_arquero);
                } else if (profesion.equals("guerrero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_humano_guerrero);
                }else if (profesion.equals("mago")) {
                    imgAvatar.setImageResource(R.drawable.hombre_humano_mago);
                } else if (profesion.equals("herrero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_humano_herrero);
                } else if (profesion.equals("minero")) {
                    imgAvatar.setImageResource(R.drawable.hombre_humano_minero);
                }
            }
            // Añadir más especies para el sexo masculino
        }
    }

    @Override
    public void random() {
        int vida = random.nextInt(100) + 1;
        txtVida.setText("Vida: " + vida);
        int magia = random.nextInt(10) + 1;
        txtMagia.setText("Magia: " + magia);
        int fuerza = random.nextInt(20) + 1;
        txtFuerza.setText("Fuerza: " + fuerza);
        int velocidad = random.nextInt(5) + 1;
        txtVelocidad.setText("Velocidad: " + velocidad);
    }
}
