package com.example.ejemplo1composeridgs903

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


private val tarjetas : List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protegonista de la serie, conociddo por su gran poder."),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. A pesar de que a inicios de Dragon Ball Z, Vegeta cumple un papel antagónico, poco después decide rebelarse ante el Imperio de Freeza, volviéndose un aliado clave para los Guerreros Z. Con el paso del tiempo llegaría a cambiar su manera de ser, optando por permanecer y vivir en la Tierra para luchar a su lado contra las inminentes adversidades que superar. Junto con Piccolo, él es de los antiguos enemigos de Goku que ha evolucionando al pasar de ser un villano y antihéroe, a finalmente un héroe a lo largo del transcurso de la historia, convirtiéndose así en el deuteragonista de la serie."),
    PersonajeTarjeta("Piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación. Aunque en un principio fue el archienemigo de Son Goku, con el paso del tiempo fue haciéndose menos malvado hasta finalmente convertirse en un ser bondadoso y miembro de los Guerreros Z. A través del tiempo, también comenzó a tomarle cariño a su discípulo Son Gohan, a quien veía como una especie de vástago y formando un lazo de amistad con este."),
    PersonajeTarjeta("Bulma", "Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es hija del Dr. Brief y su esposa Panchy, hermana menor de Tights y una gran amiga de Son Goku con quien inicia la búsqueda de las Esferas del Dragón. En Dragon Ball Z tuvo a Trunks, primogénito de quien sería su esposo Vegeta, a su hija Bra[3] y su hijo adulto del tiempo alterno Trunks del Futuro Alternativo."),
    PersonajeTarjeta("Freezer", "Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Zarbon", "Zarbon es uno de los secuaces de Freezer y un luchador poderoso."),
    PersonajeTarjeta("Dodoria", "Dodoria es otro secuaz de Freezer conocido por su brutalidad."),
    PersonajeTarjeta("Gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. Es un mestizo entre saiyano y humano terrícola. Es el primer hijo de Son Goku y Chi-Chi, hermano mayor de Son Goten, esposo de Videl y padre de Pan."),
    PersonajeTarjeta("Krilin", "Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball. Es uno de los principales discípulos de Kame-Sen'nin, Guerrero Z, y el mejor amigo de Son Goku. Es junto a Bulma uno de los personajes de apoyo principales de Dragon Ball, Dragon Ball Z y Dragon Ball Super. Aparece en Dragon Ball GT como personaje secundario. En el Arco de Majin Boo, se retira de las artes marciales, optando por formar una familia, como el esposo de la Androide Número 18 y el padre de Marron."),
    PersonajeTarjeta("Tenshinhan", "Maestro de las artes marciales y miembro de los Z Fighters.  Es un personaje que aparece en el manga y en el anime de Dragon Ball, Dragon Ball Z, Dragon Ball GT y posteriormente en Dragon Ball Super.")

)

data class PersonajeTarjeta(val title: String, val body: String)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(tarjetas)
            }

        }
    }
}

/*data class MyMessage(val title: String, val body: String)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMessages(mesajes: List<MyMessage>) {
    Scaffold {
        AppBarWhitImage()
    }
}*/

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        //ImagenHeroe()
        items(personajes){ personaje ->
            MyPersonajes(personaje)
        }
    }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){
    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
    }
        Row (
            modifier = Modifier.padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ){
    ImagenHeroe()
    Personajes(personaje)
    }
}

@Composable
fun Personaje(name:String, color:Color, style: TextStyle){
    Column {
        Text(text = name)
    }
}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineSmall)
        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)

    }
}

@Composable
fun ImagenHeroe(){
    Image(
        painter = painterResource(R.drawable.logo_dragonballapi),
        contentDescription = "Goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}

@Preview
@Composable
fun GreetingPreview() {
    Tarjeta(tarjetas)
}