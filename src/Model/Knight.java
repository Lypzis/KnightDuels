package Model;

public class Knight {
    

    private int IDKNIGHT;
    private String nome;
    private double ataque;
    private double defesa;
    private double esquiva;
    private double ataqueEspecial;
    private String nomeAtaqueEspecial;

    public Knight(int IDKNIGHT, String nome, double ataque, 
            double defesa, double esquiva, double ataqueEspecial, String nomeAtaqueEspecial) {
        setIDKNIGHT(IDKNIGHT);
        setNome(nome);
        setAtaque(ataque);
        setDefesa(defesa);
        setEsquiva(esquiva);
        setAtaqueEspecial(ataqueEspecial);
        setNomeAtaqueEspecial(nomeAtaqueEspecial);
    }

    public String getNomeAtaqueEspecial() {
        return nomeAtaqueEspecial;
    }

    public void setNomeAtaqueEspecial(String nomeAtaqueEspecial) {
        this.nomeAtaqueEspecial = nomeAtaqueEspecial;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getDefesa() {
        return defesa;
    }

    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }

    public double getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(double esquiva) {
        this.esquiva = esquiva;
    }

    public double getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public void setAtaqueEspecial(double ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public int getIDKNIGHT() {
        return IDKNIGHT;
    }

    public void setIDKNIGHT(int IDKNIGHT) {
        this.IDKNIGHT = IDKNIGHT;
    }

}
