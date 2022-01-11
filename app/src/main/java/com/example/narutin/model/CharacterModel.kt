package com.example.narutin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "character")
class CharactersModel {

    @ColumnInfo(name = "about")
    @SerializedName("about")
    lateinit var about: List<String>

    @ColumnInfo(name = "info")
    @SerializedName("info")
    lateinit var info : Info

    @ColumnInfo(name = "page")
    @SerializedName("page")
    var page : String = ""

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name : String = ""

    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id : Int = 0

    @ColumnInfo(name = "images")
    @SerializedName("images")
    lateinit var images : List<String>

    override fun toString(): String {
        return "CharactersModel(about=$about, info=$info, page='$page', name='$name', images=$images)"
    }
}

class Info {

    @ColumnInfo(name = "sexo")
    @SerializedName("Sexo")
    var sexo: String = ""

    @ColumnInfo(name = "aniversario")
    @SerializedName("Aniversário")
    var aniversario: String = ""

    @ColumnInfo(name = "idade")
    @SerializedName("Idade")
    var idade: String = ""

    @ColumnInfo(name = "altura")
    @SerializedName("Altura")
    var altura: String = ""

    @ColumnInfo(name = "peso")
    @SerializedName("Peso")
    var peso: String = ""

    @ColumnInfo(name = "tipoSanguineo")
    @SerializedName("TipoSanguíneo")
    var tipoSanguineo: String = ""

    @ColumnInfo(name = "ocupacao")
    @SerializedName("Ocupação")
    var ocupacao: String = ""

    @ColumnInfo(name = "afiliacao")
    @SerializedName("Afiliação")
    var afiliacao: String = ""

    @ColumnInfo(name = "parceiro")
    @SerializedName("Parceiro")
    var parceiro: String = ""

    @ColumnInfo(name = "patenteNinja")
    @SerializedName("Patente Ninja")
    var patenteNinja: String = ""

    @ColumnInfo(name = "registroNinja")
    @SerializedName("Registro Ninja")
    var registroNinja: String = ""

    override fun toString(): String {
        return "Info(sexo='$sexo', aniversario='$aniversario', idade='$idade', altura='$altura', peso='$peso', tipoSanguineo='$tipoSanguineo', ocupacao='$ocupacao', afiliacao='$afiliacao', parceiro='$parceiro', patenteNinja='$patenteNinja', registroNinja='$registroNinja')"
    }

}