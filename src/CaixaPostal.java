
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;


public final class CaixaPostal {
	private static final CaixaPostal INSTANCE = new CaixaPostal();
	private static Semaphore M; // SEMAFORO DOS USUARIOS
	private static Semaphore P = new Semaphore(0);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CaixaPostal window = new CaixaPostal();
	}

	/**
	 * Create the application.
	 */
	private CaixaPostal() {
		int k = 1;
		k = Integer
				.parseInt(JOptionPane
						.showInputDialog("Insira a capacidade da caixa postal :"));
		this.setM(new Semaphore(k));
		int a = Integer.parseInt(JOptionPane.showInputDialog("Quantas mensagens o pombo pode transportar?"));
		int b = Integer.parseInt(JOptionPane.showInputDialog("Qual o tempo de carga?"));
		int c = Integer.parseInt(JOptionPane.showInputDialog("Qual o tempo de voo?"));
		int d = Integer.parseInt(JOptionPane.showInputDialog("Qual o tempo de descarga?"));
		Pombo p = new Pombo(a,b,c,d);
		Thread t = new Thread(p);
		t.start();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public static CaixaPostal getInstance() {
		return INSTANCE;
	}

	public static Semaphore getM() {
		return M;
	}

	public static void setM(Semaphore m) {
		M = m;
	}

	public static Semaphore getP() {
		return P;
	}

	public static void setP(Semaphore p) {
		P = p;
	}

}