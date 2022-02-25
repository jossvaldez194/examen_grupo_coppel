package com.example.marvelcharacters.ui.single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelcharacters.databinding.FragmentSecondBinding
import com.example.marvelcharacters.utils.Status
import com.example.marvelcharacters.utils.Utils.Companion.editorial
import com.example.marvelcharacters.utils.Utils.Companion.textSpan
import com.squareup.picasso.Picasso

class SecondFragment : Fragment() {

    private val secondViewModel: SecondViewModel by viewModels()
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: SecondFragmentArgs by navArgs()
        val idCharacter = args.idCharacter

        setUpObserver(idCharacter)
    }

    private fun setUpObserver(idCharacter: Int) {
        secondViewModel.getSingleUser(idCharacter).observe(viewLifecycleOwner) {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { data ->
                            //Titulos
                            binding.txtName.text = data.name
                            binding.txtEmploye.text = data.work.occupation
                            Picasso.get().load(data.images.lg).into(binding.imgProfile)
                            Picasso.get().load(editorial(data.biography.publisher))
                                .into(binding.imgEditorial)

                            //Apearence
                            binding.txtGender.text = textSpan(
                                title = "Genero:\n",
                                value = data.appearance.gender,
                                requiredSize = true
                            )
                            binding.txtRace.text = textSpan(
                                title = "Raza:\n",
                                value = data.appearance.race,
                                requiredSize = true
                            )
                            binding.txtHeigth.text = textSpan(
                                title = "Ojos:\n",
                                value = data.appearance.eyeColor,
                                requiredSize = true
                            )

                            //Biografia
                            binding.txtFullName.text = textSpan(
                                title = "Nombre completo: ",
                                value = data.biography.fullName
                            )
                            binding.txtAlterEgos.text =
                                textSpan(title = "Alteregos: ", value = data.biography.alterEgos)
                            binding.txtPlaceOfBirth.text = textSpan(
                                title = "Lugar de nacimiento: ",
                                value = data.biography.placeOfBirth
                            )
                            binding.txtFirstAppearance.text = textSpan(
                                title = "Primera aparición: ",
                                value = data.biography.firstAppearance
                            )
                            binding.txtPublisher.text =
                                textSpan(title = "Editorial: ", value = data.biography.publisher)
                            binding.txtAligment.text =
                                textSpan(title = "Alineación: ", value = data.biography.alignment)

                            //Poder
                            binding.txtIntelligence.text = textSpan(
                                title = "Inteligencia: ",
                                value = "${data.powerstats.intelligence} / 100"
                            )
                            binding.progressIntelligence.progress = data.powerstats.power

                            binding.txtStrength.text = textSpan(
                                title = "Fuerza: ",
                                value = "${data.powerstats.strength} / 100"
                            )
                            binding.progressStrength.progress = data.powerstats.strength

                            binding.txtSpeed.text = textSpan(
                                title = "Velocidad: ",
                                value = "${data.powerstats.speed} / 100"
                            )
                            binding.progressSpeed.progress = data.powerstats.speed

                            binding.txtDurability.text = textSpan(
                                title = "Durabilidad: ",
                                value = "${data.powerstats.durability} / 100"
                            )

                            binding.progressDurability.progress = data.powerstats.durability

                            binding.txtPower.text = textSpan(
                                title = "Poder: ",
                                value = "${data.powerstats.power} / 100"
                            )

                            binding.progressPower.progress = data.powerstats.power

                            binding.txtCombat.text = textSpan(
                                title = "Combate: ",
                                value = "${data.powerstats.combat} / 100"
                            )

                            binding.progressCombat.progress = data.powerstats.combat

                            //Conexiones

                            binding.txtGroup.text = textSpan(
                                title = "Afiliaciones: ",
                                value = data.connections.groupAffiliation
                            )
                            binding.txtRelatives.text = textSpan(
                                title = "Familiares: ",
                                value = data.connections.relatives
                            )

                        }
                        binding.containerViews.visibility = View.VISIBLE
                        binding.lottieMainLoading.visibility = View.GONE
                    }
                    Status.ERROR -> {
                        binding.containerViews.visibility = View.GONE
                        binding.lottieMainLoading.visibility = View.GONE
                        print(it.message)
                    }
                    Status.LOADING -> {
                        binding.containerViews.visibility = View.GONE
                        binding.lottieMainLoading.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}