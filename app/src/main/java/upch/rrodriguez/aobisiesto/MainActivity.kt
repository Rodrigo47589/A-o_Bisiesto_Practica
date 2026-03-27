package upch.rrodriguez.aobisiesto

import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import upch.rrodriguez.aobisiesto.ui.theme.AñoBisiestoTheme
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AñoBisiestoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    botonbisiesto()
                }
            }
        }
    }
}

@Composable
fun botonbisiesto() {

    var result by remember { mutableStateOf("")}

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                val calendario = android.icu.util.Calendar.getInstance()
                val año = calendario.get(android.icu.util.Calendar.YEAR)
                val mes = calendario.get(android.icu.util.Calendar.MONTH) + 1
                val dia = calendario.get(android.icu.util.Calendar.DAY_OF_MONTH)

                if ((año % 4 == 0 && año % 100 != 0 ) || (año % 400 == 0)){
                    result = " $dia / $mes / $año  es año bisiesto"
                } else {
                    result = "$dia / $mes / $año no es año bisiesto"
                }

            }
        ) {
            Text("presionar para ver si estamos en año bisiesto")
        }
        Text(text = result)
    }
}






