package com.example.calculogas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment(R.layout.fragment_result) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textResultado = view.findViewById<TextView>(R.id.textResultado)
        val btnVoltar = view.findViewById<Button>(R.id.btnVoltar)

        // Recupera o argumento passado pelo InputFragment
        val melhorOpcao = arguments?.getString("MELHOR_OPCAO") ?: "Erro ao calcular"

        textResultado.text = melhorOpcao

        // Botão para voltar à tela inicial
        btnVoltar.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
}