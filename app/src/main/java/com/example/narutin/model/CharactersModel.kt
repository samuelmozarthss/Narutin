package com.example.narutin

import com.google.gson.annotations.SerializedName

class CharactersModel {

    lateinit var about: List<String>
    lateinit var info : Info
    var page : String = ""
    var name : String = ""
    var id : Int = 0
    lateinit var images : List<String>

    override fun toString(): String {
        return "CharactersModel(about=$about, info=$info, page='$page', name='$name', images=$images)"
    }
}

class Info {
    @SerializedName("Sexo")
    var sexo: String = ""

    @SerializedName("Aniversário")
    var aniversario: String = ""

    @SerializedName("Idade")
    var idade: String = ""

    @SerializedName("Altura")
    var altura: String = ""

    @SerializedName("Peso")
    var peso: String = ""

    @SerializedName("TipoSanguíneo")
    var tipoSanguineo: String = ""

    @SerializedName("Ocupação")
    var ocupacao: String = ""

    @SerializedName("Afiliação")
    var afiliacao: String = ""

    @SerializedName("Parceiro")
    var parceiro: String = ""

    @SerializedName("Patente Ninja")
    var patenteNinja: String = ""

    @SerializedName("Registro Ninja")
    var registroNinja: String = ""

    override fun toString(): String {
        return "Info(sexo='$sexo', aniversario='$aniversario', idade='$idade', altura='$altura', peso='$peso', tipoSanguineo='$tipoSanguineo', ocupacao='$ocupacao', afiliacao='$afiliacao', parceiro='$parceiro', patenteNinja='$patenteNinja', registroNinja='$registroNinja')"
    }

}