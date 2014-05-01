package controlador.maestros;

import java.io.IOException;
import java.util.List;

import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;

import modelo.maestros.F0005;

import componentes.BuscadorUDC;

public class CF0101 extends CGenerico {

	@Wire
	private Button b;
	@Wire
	private Div buscador;
	@Wire
	private Div buscador2;
	private static final long serialVersionUID = -423722886120387655L;
	BuscadorUDC buscadorUDC;
	BuscadorUDC buscadorUDC2;
	@Override
	public void inicializar() throws IOException {
		List<F0005> listF0005 = servicioF0005.buscarTodosOrdenados();
		buscadorUDC = new BuscadorUDC("Patron fecha fiscal",10,listF0005, true) {

			@Override
			protected F0005 buscar() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		buscadorUDC2 = new BuscadorUDC("valor",10,listF0005, false) {

			@Override
			protected F0005 buscar() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		buscador.appendChild(buscadorUDC);
		buscador2.appendChild(buscadorUDC2);
	}

	@Listen("onClick = #b")
	public void dato(){
		System.out.println(buscadorUDC.obtenerCaja());
	}
}
