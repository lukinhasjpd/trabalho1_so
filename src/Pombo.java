public class Pombo implements Runnable {

	int N, tc, tv, td;

	public Pombo(int n, int tc, int tv, int td) {

		super();

		N = n; // Quantidade de mensagens que devem ser transportadas pelo pombo

		this.tc = tc; // tempo de carga

		this.tv = tv; // tempo de v�o

		this.td = td; // tempo de descarga

	}

	private void voando() {
		long startTime = System.currentTimeMillis();

		while (this.tv >= (System.currentTimeMillis() - startTime)) {
			System.out.println("Aguarde!");
		}
	}
	
	private void carregar() {
		long startTime = System.currentTimeMillis();

		while (this.tc >= (System.currentTimeMillis() - startTime)) {
			System.out.println("Descarregando!");
		}
	}


	private void descarregar() {
		long startTime = System.currentTimeMillis();

		while (this.td >= (System.currentTimeMillis() - startTime)) {
			System.out.println("Descarregando!");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(CaixaPostal.getInstance().MaxQtCartasnaCaixa - 
					CaixaPostal.getInstance().getM().availablePermits() < this.N){
				try {
					System.out.println("Dormiu!");
					CaixaPostal.getInstance().getP().acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			carregar();
			CaixaPostal.getInstance().getM().release(this.N);
			voando();
			descarregar();
			voando();
		}
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int getTc() {
		return tc;
	}

	public void setTc(int tc) {
		this.tc = tc;
	}

	public int getTv() {
		return tv;
	}

	public void setTv(int tv) {
		this.tv = tv;
	}

	public int getTd() {
		return td; 
	}

	public void setTd(int td) {
		this.td = td;
	}

}