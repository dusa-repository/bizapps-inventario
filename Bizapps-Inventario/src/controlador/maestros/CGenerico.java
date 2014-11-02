package controlador.maestros;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import modelo.maestros.F00021;
import modelo.pk.F00021PK;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Div;
import org.zkoss.zul.Tab;

import componentes.Mensaje;
import servicio.maestros.SF00021;
import servicio.maestros.SF0004;
import servicio.maestros.SF0005;
import servicio.maestros.SF0006;
import servicio.maestros.SF0008;
import servicio.maestros.SF0010;
import servicio.maestros.SF0013;
import servicio.maestros.SF0015;
import servicio.maestros.SF0101;
import servicio.maestros.SF0111;
import servicio.maestros.SF0115;
import servicio.maestros.SF01151;
import servicio.maestros.SF0116;
import servicio.maestros.SF4008;
import servicio.maestros.SF40203;
import servicio.maestros.SF40205;
import servicio.maestros.SF4100;
import servicio.maestros.SF41002;
import servicio.maestros.SF4101;
import servicio.maestros.SF41021;
import servicio.maestros.SF4105;
import servicio.maestros.SF4108;
import servicio.maestros.SF4301;
import servicio.seguridad.SArbol;
import servicio.seguridad.SGrupo;
import servicio.seguridad.SUsuario;
import servicio.transacciones.SF4111;
import servicio.transacciones.SF4211;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public abstract class CGenerico extends SelectorComposer<Component> {

	private static final long serialVersionUID = -3701148488846104476L;

	@WireVariable("SArbol")
	protected SArbol servicioArbol;
	@WireVariable("SF0004")
	protected SF0004 servicioF0004;
	@WireVariable("SF0005")
	protected SF0005 servicioF0005;
	@WireVariable("SF0006")
	protected SF0006 servicioF0006;
	@WireVariable("SF0008")
	protected SF0008 servicioF0008;
	@WireVariable("SF0010")
	protected SF0010 servicioF0010;
	@WireVariable("SF0013")
	protected SF0013 servicioF0013;
	@WireVariable("SF0015")
	protected SF0015 servicioF0015;
	@WireVariable("SF0101")
	protected SF0101 servicioF0101;
	@WireVariable("SF0111")
	protected SF0111 servicioF0111;
	@WireVariable("SF0115")
	protected SF0115 servicioF0115;
	@WireVariable("SF01151")
	protected SF01151 servicioF01151;
	@WireVariable("SF0116")
	protected SF0116 servicioF0116;
	@WireVariable("SF4008")
	protected SF4008 servicioF4008;
	@WireVariable("SF40205")
	protected SF40205 servicioF40205;
	@WireVariable("SF4100")
	protected SF4100 servicioF4100;
	@WireVariable("SF00021")
	protected SF00021 servicioF00021;
	@WireVariable("SF40203")
	protected SF40203 servicioF40203;
	@WireVariable("SF4211")
	protected SF4211 servicioF4211;
	@WireVariable("SF4101")
	protected SF4101 servicioF4101;
	@WireVariable("SF41002")
	protected SF41002 servicioF41002;
	@WireVariable("SF4111")
	protected SF4111 servicioF4111;
	@WireVariable("SF41021")
	protected SF41021 servicioF41021;
	@WireVariable("SF4105")
	protected SF4105 servicioF4105;
	@WireVariable("SF4108")
	protected SF4108 servicioF4108;
	@WireVariable("SF4301")
	protected SF4301 servicioF4301;
	@WireVariable("SGrupo")
	protected SGrupo servicioGrupo;
	@WireVariable("SUsuario")
	protected SUsuario servicioUsuario;
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"/META-INF/ConfiguracionAplicacion.xml");
	protected static SimpleDateFormat formatoFecha = new SimpleDateFormat(
			"dd-MM-yyyy");
	public List<Tab> tabs = new ArrayList<Tab>();
	protected DateFormat df = new SimpleDateFormat("HH:mm:ss");
	public Calendar calendario = Calendar.getInstance();
	public static double id = 0;

	// Cambio en la hora borrados los :

	public static SF4101 getServicioF4101() {
		return applicationContext.getBean(SF4101.class);
	}

	public static SF4111 getServicioF4111() {
		return applicationContext.getBean(SF4111.class);
	}

	public static SF4211 getServicioF4211() {
		return applicationContext.getBean(SF4211.class);
	}

	public static SF41021 getServicioF41021() {
		return applicationContext.getBean(SF41021.class);
	}

	public static SF4105 getServicioF4105() {
		return applicationContext.getBean(SF4105.class);
	}

	public String horaAuditoria = String.valueOf(calendario
			.get(Calendar.HOUR_OF_DAY))
			+ String.valueOf(calendario.get(Calendar.MINUTE))
			+ String.valueOf(calendario.get(Calendar.SECOND));
	public java.util.Date fecha = new Date();
	public Timestamp fechaHora = new Timestamp(fecha.getTime());
	public Mensaje msj = new Mensaje();
	public static boolean nextNumber = true;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		inicializar();
	}

	public BigDecimal transformarGregorianoAJulia(Date fecha) {
		String valor = "";

		calendario = new GregorianCalendar();
		calendario.setTime(fecha);
		String dia = "";
		if (calendario.get(Calendar.DAY_OF_YEAR) < 10)
			dia = "00";
		else {
			if (calendario.get(Calendar.DAY_OF_YEAR) >= 10
					&& calendario.get(Calendar.DAY_OF_YEAR) < 100)
				dia = "0";
		}
		if ((fecha.getYear() + 1900) < 2000)
			valor = "";
		else
			valor = "1";
		long al = Long.valueOf(valor
				+ String.valueOf(calendario.get(Calendar.YEAR)).substring(2)
				+ dia + String.valueOf(calendario.get(Calendar.DAY_OF_YEAR)));
		BigDecimal a = BigDecimal.valueOf(al);
		return a;
	}

	public Date transformarJulianaAGregoria(BigDecimal valor) {
		String j = valor.toString();
		Date date = new Date();
		String primerValor = "";
		if (j.length() == 5) {
			try {
				date = new SimpleDateFormat("yyD").parse(j);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			primerValor = j.substring(0, 1);
			if (primerValor.equals("1")) {
				String anno = j.substring(1, 3);
				date.setYear(Integer.valueOf("20" + anno) - 1900);
				String s = j.substring(3);
				Date fecha = new Date();
				try {
					fecha = new SimpleDateFormat("D").parse(s);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fecha.setYear(date.getYear());
				return fecha;
			}
		}

		return date;

	}

	public Date transformarJulianaAGregoriadeLong(Long valor) {
		String j = valor.toString();
		Date date = new Date();
		String primerValor = "";
		if (j.length() == 5) {
			try {
				date = new SimpleDateFormat("yyD").parse(j);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			primerValor = j.substring(0, 1);
			if (primerValor.equals("1")) {
				String anno = j.substring(1, 3);
				date.setYear(Integer.valueOf("20" + anno) - 1900);
				String s = j.substring(3);
				Date fecha = new Date();
				try {
					fecha = new SimpleDateFormat("D").parse(s);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				fecha.setYear(date.getYear());
				return fecha;
			}
		}

		return date;

	}

	public abstract void inicializar() throws IOException;

	public void cerrarVentana(Div div, String id, List<Tab> tabs2) {
		div.setVisible(false);
		tabs = tabs2;
		for (int i = 0; i < tabs.size(); i++) {
			if (tabs.get(i).getLabel().equals(id)) {
				if (i == (tabs.size() - 1) && tabs.size() > 1) {
					tabs.get(i - 1).setSelected(true);
				}
				tabs.get(i).onClose();
				tabs.remove(i);
			}
		}
	}

	public String nombreUsuarioSesion() {
		Authentication sesion = SecurityContextHolder.getContext()
				.getAuthentication();
		return sesion.getName();
	}

	/* Metodo que permite enviar un correo electronico a cualquier destinatario */
	public boolean enviarEmailNotificacion(String correo, String mensajes) {
		try {

			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props);
			String asunto = "Notificacion de SITEG";
			String remitente = "siteg.ucla@gmail.com";
			String contrasena = "Equipo.2";
			String destino = correo;
			String mensaje = mensajes;

			String destinos[] = destino.split(",");

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(remitente));

			Address[] receptores = new Address[destinos.length];
			int j = 0;
			while (j < destinos.length) {
				receptores[j] = new InternetAddress(destinos[j]);
				j++;
			}

			message.addRecipients(Message.RecipientType.TO, receptores);
			message.setSubject(asunto);
			message.setText(mensaje);

			Transport t = session.getTransport("smtp");
			t.connect(remitente, contrasena);
			t.sendMessage(message,
					message.getRecipients(Message.RecipientType.TO));

			t.close();

			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected double nextNumber(String numero, String user) {
		synchronized (this) {
			while (!nextNumber) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			nextNumber = false;
			try {
				double numeroNext = servicioF00021.Numero(numero, user);
				if (numeroNext != 0) {
					id = numeroNext + 1;
					F00021 f021 = servicioF00021.buscar(numero, user);
					f021.setNln001(id);
					servicioF00021.guardar(f021);
				} else {
					id = 1;
					F00021 f021 = new F00021();
					F00021PK clave21 = new F00021PK();
					clave21.setNldct(user);
					clave21.setNlkco(numero);
					clave21.setNlctry((double) 0);
					clave21.setNlfy((double) 0);
					f021.setId(clave21);
					f021.setNln001(id);
					servicioF00021.guardar(f021);
				}
			} catch (Exception a) {
				nextNumber = true;
				a.printStackTrace();
				return 0;
			}
		}
		synchronized (this) {
			nextNumber = true;
			notifyAll();
			return id;
		}
	}

	public String damePath() {
		return Executions.getCurrent().getContextPath() + "/";
	}
}