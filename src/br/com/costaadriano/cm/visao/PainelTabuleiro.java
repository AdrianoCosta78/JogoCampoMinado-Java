package br.com.costaadriano.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.costaadriano.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel{

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		
		
		tabuleiro.paraCada(c -> add(new BotaoCampo(c)));
		
		tabuleiro.registarObservador(e -> {
			
			SwingUtilities.invokeLater(() -> {
				if(e.isGanhou()) {
					JOptionPane.showMessageDialog(this,"Parabens!!! Você é fera, Ganhou!!!" );
				}else {
					JOptionPane.showMessageDialog(this,"Que vacilo!!! Você perdeu, ainda bem que não era na vida real" );
				}
				
				tabuleiro.reiniciar();
			});
			
			
		});
		
		
		
		/*int total = tabuleiro.getLinhas() * tabuleiro.getColunas();
		
		for(int i = 0; i<total; i++) {
			add(new BotaoCampo(null));
		}*/
	}
	
}
