package sv.edu.udb.desafio1_mr171225.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import sv.edu.udb.desafio1_mr171225.R;
import sv.edu.udb.desafio1_mr171225.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private Button bt_calcular;
    private EditText id_a, id_b, id_c;
    private TextView id_x1, id_x2, id_res;

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.fragment_home, container, false);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}