package caatsoft.studio.com.desafio4all

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var dateFormat: SimpleDateFormat? = null
    var dataHoraString: String? = null
    var seconds: String? = null
    //var dataTimestamp: Timestamp? = null
    var buttonPegarOTempoAtual: Button? = null
    var textViewExibirValor: TextView? = null
    var textViewGo4all: TextView? = null
    var relativeLayout: RelativeLayout? = null

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "   Desafio 4ALL "
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setLogo(R.drawable.ic_logo)
        toolbar.setBackgroundResource(R.color.black)
        setSupportActionBar(toolbar)

        buttonPegarOTempoAtual = findViewById(R.id.buttonPegarOTempoAtual)
        textViewExibirValor = findViewById(R.id.textViewExibirValor)
        textViewGo4all = findViewById(R.id.textViewGo4all)
        relativeLayout = findViewById(R.id.id_relativeLayout)

        buttonPegarOTempoAtual!!.setOnClickListener {
            dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
            dataHoraString = dateFormat!!.format(Date())
            seconds = Date().seconds.toString()
            //dataTimestamp = Timestamp.valueOf(millisInString) Não tem sentido deixar um arquivo no formato Timestamp
            // já que ele não vai para nenhum banco de dados, mas de qualquer forma a Sring terá o output em arquivos data e hora do Timestamp.
            textViewExibirValor!!.text = dataHoraString
            corDeFundo()
        }

    }
    fun corDeFundo() {
        /**Funciona da seguinte maneira: o último valor do arquivo Timestamp é sempre os segundos.
        Então o que eu fiz foi pegar os segundos e transformei em inteiros, depois fiz o calculo
        a partir do módulo da variável dos segundos, no caso "secondsInt", como o módulo é sempre
        o que sobra de uma divisão. Eu fiz a partir do módulo de 10 que é a quantidade de algarismos
        do sistema decimal. Isso retorna o último dígito do valor dos segundos**/

        val ultimoDigito = seconds!!.toInt() % 10

        //Esse when pega o número do útimo dígito e seleciona qual deve se a cor do background (fundo)
        when (ultimoDigito) {
            0 -> relativeLayout!!.setBackgroundResource(R.color.branca)
            1 -> relativeLayout!!.setBackgroundResource(R.color.preta)
            2 -> relativeLayout!!.setBackgroundResource(R.color.azul)
            3 -> relativeLayout!!.setBackgroundResource(R.color.verde)
            4 -> relativeLayout!!.setBackgroundResource(R.color.rosa)
            5 -> relativeLayout!!.setBackgroundResource(R.color.vermelho)
            6 -> relativeLayout!!.setBackgroundResource(R.color.roxo)
            7 -> relativeLayout!!.setBackgroundResource(R.color.amarelo)
            8 -> relativeLayout!!.setBackgroundResource(R.color.cinza)
            9 -> relativeLayout!!.setBackgroundResource(R.color.lilás)
        }

        //Esse "if" é somente caso seja a cor preta ou roxa, porque fica invisível a preta já que o botão
        // e as letras que exibem o valor ambos são na cor preta e o roxo fica escuro também
        if (ultimoDigito == 1 || ultimoDigito == 6){
            textViewGo4all!!.setTextColor(Color.WHITE)
            textViewExibirValor!!.setTextColor(Color.WHITE)
            buttonPegarOTempoAtual!!.setTextColor(Color.BLACK)
            buttonPegarOTempoAtual!!.setBackgroundColor(Color.WHITE)
        } else{
            textViewGo4all!!.setTextColor(Color.BLACK)
            textViewExibirValor!!.setTextColor(Color.BLACK)
            buttonPegarOTempoAtual!!.setTextColor(Color.WHITE)
            buttonPegarOTempoAtual!!.setBackgroundColor(Color.BLACK)
        }
    }
}