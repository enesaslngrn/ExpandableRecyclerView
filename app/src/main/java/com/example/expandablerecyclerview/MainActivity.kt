package com.example.expandablerecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expandablerecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val languageList = arrayListOf(
            LanguageData("Java",R.drawable.java,"Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible."),
            LanguageData("Kotlin",R.drawable.kotlin,"Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise."),
            LanguageData("C++",R.drawable.cplusplus,"C++ is a high-level general-purpose programming language created by Danish computer scientist Bjarne Stroustrup as an extension of the C programming language, or C with Classes."),
            LanguageData("C#",R.drawable.csharp, "C# is a general-purpose, high-level multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented, and component-oriented programming disciplines."),
            LanguageData("Swift",R.drawable.swift,"Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community."),
            LanguageData("HTML",R.drawable.html,"The HyperText Markup Language or HTML is the standard markup language for documents designed to be displayed in a web browser."),
            LanguageData("Python",R.drawable.python,"Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation."),
            LanguageData("JavaScript",R.drawable.javascript, "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS. As of 2022, 98% of websites use JavaScript on the client side for webpage behavior, often incorporating third-party libraries.")
        )

        val adapter = RecyclerAdapter(languageList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


    }
}