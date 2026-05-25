package com.example.calculogas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class InputFragment : Fragment(R.layout.fragment_input) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editAlcool = view.findViewById<EditText>(R.id.editAlcool)
        val editGasolina = view.findViewById<EditText>(R.id.editGasolina)
        val btnCalcular = view.findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            val precoAlcoolStr = editAlcool.text.toString()
            val precoGasolinaStr = editGasolina.text.toString()

            // Validação simples para evitar crash se os campos estiverem vazios
            if (precoAlcoolStr.isEmpty() || precoGasolinaStr.isEmpty()) {
                Toast.makeText(context, "Preencha ambos os valores!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val precoAlcool = precoAlcoolStr.toDouble()
            val precoGasolina = precoGasolinaStr.toDouble()

            // Lógica do cálculo
            val resultado = precoAlcool / precoGasolina
            val melhorOpcao = if (resultado < 0.7) "Álcool" else "Gasolina"

            // Preparando o Fragment de resultado e passando os dados
            val resultFragment = ResultFragment()
            val bundle = Bundle()
            bundle.putString("MELHOR_OPCAO", melhorOpcao)
            resultFragment.arguments = bundle

            // Trocando de Fragment
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, resultFragment)
                .addToBackStack(null) // Permite voltar para a tela anterior
                .commit()
        }
    }
}