package br.unesp.farma;

import br.unesp.farma.repos.Stock;
import br.unesp.farma.utils.DemonstrationUtils;

public class Test {
    public static void main(String[] args) {
        DemonstrationUtils.startDemo();

        Stock stock = DemonstrationUtils.loadStockFromJson();

        System.out.println(stock.toString());

    }
}
