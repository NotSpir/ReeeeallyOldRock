package com.example.rock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickRock(view: View) {
        playGame("Камень");
    }

    fun onClickPaper(view: View) {
        playGame("Бумага");
    }

    fun onClickScissors(view: View) {
        playGame("Ножницы");
    }

    fun onClickLihzard(view: View) {
        playGame("Ящерица");
    }

    fun onClickSpok(view: View) {
        playGame("Спок");
    }

    fun playGame(userChoice: String) {
        val options = arrayOf("Камень", "Ножницы", "Бумага", "Ящерица", "Спок");
        val gameChoice = getGameChoice(options);
        getResult(userChoice, gameChoice);
    }

    fun getGameChoice(optionsParam: Array<String>) =
        optionsParam[(Math.random() * optionsParam.size).toInt()]

    fun getResult(userChoice: String, gameChoice: String) {
        val result: String = if (userChoice == gameChoice) {
            "Ничья!!!"
        } else {
            if (((userChoice == "Камень" || userChoice == "Спок") && gameChoice == "Ножницы") || ((userChoice == "Бумага" || userChoice == "Спок") && gameChoice == "Камень") || ((userChoice == "Ножницы" || userChoice == "Ящерица") && gameChoice == "Бумага") || ((userChoice == "Камень" || userChoice == "Ножницы") && gameChoice == "Ящерица") || ((userChoice == "Бумага" || userChoice == "Ящерица") && gameChoice == "Спок")) {
                "Вы выиграли!!!"
            } else {
                "Вы проиграли..."
            }
        }
        binding.textView4.text = userChoice;
        binding.textView5.text = gameChoice;
        binding.textView6.text = result;
    }
}