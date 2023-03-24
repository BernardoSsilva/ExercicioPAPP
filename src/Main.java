import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String continuar = "S";
        String nome, maisCaro = null, maisBarato = null;
        float preco, precodesconto = 0, maiorP, menorP, total;
        int quantidade, codigo, descEsp, cont;
        maiorP = 0;
        menorP = 9000;
        total = 0;
        cont = 0;
        descEsp = 0;

        System.out.println("Aperte enter para iniciar");
        Scanner scan = new Scanner(System.in);
        while(continuar.equals("S")){

            scan.nextLine();
            System.out.print("Digite o nome da mercadoria: ");
            nome = scan.nextLine();
            System.out.print("Digite o preço da mercadoria: ");
            preco = scan.nextFloat();
            System.out.print("Digite o codigo do produto: ");
            codigo = scan.nextInt();
            if ((codigo == 1 || codigo == 3 || codigo == 5)&& preco >= 1000){
                precodesconto = (float) (preco - (preco*0.015));
                descEsp++;
                System.out.println("O código deste produto contem desconto de 1.5% ficou R$: "+ (precodesconto));
            } else {
                precodesconto = preco;
                System.out.println("O produto não contem desconto");
            }
            System.out.print("Digite a quantidade comprada: ");
            quantidade = scan.nextInt();
            System.out.println("Total de compra deste produto: " + (precodesconto*quantidade));
            if (preco > maiorP){
                maiorP = preco;
                maisCaro = nome;
            }
            if (preco < menorP){
                menorP = preco;
                maisBarato = nome;
            }
            total += precodesconto;
            cont++;
            System.out.print("Deseja continuar?(S/N): ");
            continuar = scan.next().toUpperCase();
            System.out.println("================================");
        }

        System.out.println("O produto mais barato é: "+ maisBarato +" por R$"+menorP);
        System.out.println("O produto mais barato é: "+ maisCaro +" por R$"+maiorP);
        System.out.printf("Sua compra total foi de: R$ %.2f",total);

        if (total <= 5000){
            System.out.println(" Sem desconto");
        } else if (total <= 10000) {
            System.out.println("O valor total foi de R$"+total+". teve um desconto de 3% R$"+(total * 0.03)+". Novo valor R$"+(total - (total * 0.03)));
        } else if (total > 10000) {
            System.out.println("O valor total foi de R$"+total+". teve um desconto de 5% R$"+(total * 0.05)+". Novo valor R$"+(total - (total * 0.05)));
        }

        System.out.println("Total de produtos com desconto especial: "+descEsp);
        System.out.println("A media geral de vendas foi de: R$" +((precodesconto)/cont));


    }
}