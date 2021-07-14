public class Tamagotchi {

    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int idadeMax;
    private int energiaAtual;
    private int saciedadeAtual;
    private int limpezaAtual;
    private int idadeAtual;
    private int diamantes;
    private boolean estado;


    public Tamagotchi(int energiaMax, int saciedadeMax, int limpezaMax, int idadeMax){
        this.energiaAtual = this.energiaMax = energiaMax;
        this.saciedadeAtual = this.saciedadeMax = saciedadeMax;
        this.limpezaAtual = this.limpezaMax = limpezaMax;
        this.idadeMax = idadeMax;
        this.estado = true;
    }

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getSaciedadeMax() {
        return saciedadeMax;
    }

    public int getLimpezaMax() {
        return limpezaMax;
    }

    public int getIdadeMax() {
        return idadeMax;
    }

    public int getEnergiaAtual() {
        return energiaAtual;
    }

    public int getSaciedadeAtual() {
        return saciedadeAtual;
    }

    public int getLimpezaAtual() {
        return limpezaAtual;
    }

    public int getIdadeAtual() {
        return idadeAtual;
    }

    public int getDiamantes() {
        return diamantes;
    }

    public boolean getEstaVivo(){
        return estado;
    }

    private boolean setEnergia(int energia){
        if(this.energiaAtual <= this.energiaMax){
            this.energiaAtual += energia;

            if(this.energiaAtual <= 0){
                this.estado = false;
                this.energiaAtual = 0;
            }else if(this.energiaAtual > this.energiaMax)
                this.energiaAtual = this.energiaMax;

            return true;
        }
        return false;
    }

    private boolean setSaciedade(int saciedade){
        if(this.saciedadeAtual <= this.saciedadeMax){
            this.saciedadeAtual += saciedade;

            if(this.saciedadeAtual <= 0){
                this.estado = false;
                this.saciedadeAtual = 0;
            }else if(this.saciedadeAtual > this.saciedadeMax)
                this.saciedadeAtual = this.saciedadeMax;

            return true;
        }
        return false;
    }

    private boolean setLimpeza(int limpeza){
        if(this.limpezaAtual <= this.limpezaMax){
            this.limpezaAtual += limpeza;

            if(this.limpezaAtual <= 0){
                this.estado = false;
                this.limpezaAtual = 0;
            }else if(this.limpezaAtual > this.limpezaMax)
                this.limpezaAtual = this.limpezaMax;

            return true;
        }
        return false;
    }

    private boolean setIdade(int idade) {
        if (this.idadeAtual <= this.idadeMax) {
            this.idadeAtual += idade;

            if (this.idadeAtual > this.idadeMax) {
                this.estado = false;
                this.idadeAtual = this.idadeMax;
            }

            return true;
        }
        return false;
    }

    public boolean brincar(){
        if(estado){
            setEnergia(-2);
            setSaciedade(-1);
            setLimpeza(-3);
            setIdade(1);
            this.diamantes++;

            return true;
        }
        return false;
    }

    public boolean comer(){
        if(estado){
            setEnergia(-1);
            setSaciedade(4);
            setLimpeza(-2);
            setIdade(1);

            return true;
        }
        return false;
    }

    public boolean dormir(){
        if(estado){
            if(this.energiaAtual <= (this.energiaMax - 5)){
                setSaciedade(-2);
                setIdade(this.energiaMax - this.energiaAtual);
                this.energiaAtual = this.energiaMax;

                return true;
            }
        }
        return false;
    }

    public boolean banhar(){
        if(estado){
            this.limpezaAtual = this.limpezaMax;
            setEnergia(-3);
            setSaciedade(-1);
            setIdade(2);

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "E:" + getEnergiaAtual() + "/" + getEnergiaMax() + ", " +
               "S:" + getSaciedadeAtual() + "/" + getSaciedadeMax() + ", " +
               "L:" + getLimpezaAtual() + "/" + getLimpezaMax() + ", " +
               "D:" + getDiamantes() + ", " +
               "I:" + getIdadeAtual();
    }
}
