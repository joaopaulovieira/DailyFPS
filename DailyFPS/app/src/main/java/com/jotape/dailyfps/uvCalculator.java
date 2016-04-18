package com.jotape.dailyfps;


public class uvCalculator {

    public String recommendedFPS(String uv_index) {

        Integer uv = Integer.parseInt(uv_index);

        if (uv < 3) {
            return "O índice de raios UV na sua localidade é: " + uv_index +
                    "\nUse óculos de sol em dias claros; usar protetor solar se há neve no chão, " +
                    "o que reflete a radiação UV, ou se você tem a pele particularmente justa.";
        } else if (3 <= uv && uv < 6) {
            return "O índice de raios UV na sua localidade é: " + uv_index +
                    "\nTome precauções se você vai estar fora de locais abrigados do Sol." +
                    "Fique na sombra perto do meio-dia quando o sol é mais forte.";
        } else if (6 <= uv && uv < 8) {
            return "O índice de raios UV na sua localidade é: " + uv_index +
                    "\nCobrir o corpo com roupa que proteja partes do corpo mais expostas ao sol. " +
                    "Usar protetor solar FPS 30+, usar um chapéu, reduzir o tempo no sol " +
                    "dentro de três horas de meio-dia solar, e usar óculos escuros.";
        } else if (8 <= uv && uv < 11) {
            return "O índice de raios UV na sua localidade é: " + uv_index +
                    "\nUsar FPS 30+ protetor solar, uma camisa, óculos de sol e chapéu de abas largas. " +
                    "Não ficar no sol por muito tempo.";
        } else {
            return "O índice de raios UV na sua localidade é: " + uv_index +
                    "\nTomar todas as precauções: Usar protetor solar FPS 30+, uma camisa de mangas " +
                    "compridas e calças, óculos de sol, e um chapéu muito amplo. " +
                    "Evite o sol dentro de três horas de meio-dia solar.";
        }
    }
}
