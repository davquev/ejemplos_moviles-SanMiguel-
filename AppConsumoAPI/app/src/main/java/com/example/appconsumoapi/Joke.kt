package com.example.appconsumoapi

import com.google.gson.annotations.SerializedName

class Joke (
    @SerializedName("joke")
    var joke: String
)