package code.model

import com.zaxxer.hikari.{HikariDataSource, HikariConfig}

import scala.slick.driver.MySQLDriver.simple._

object DataBase {

  Class.forName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource")
  Class.forName("com.mysql.jdbc.Driver")


  private val config = new HikariConfig()

  config.setMaximumPoolSize(5)
  config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource")
  config.addDataSourceProperty("serverName", "localhost")
  config.addDataSourceProperty("port", "3306")
  config.addDataSourceProperty("databaseName", "viajes_ifai")
  config.addDataSourceProperty("user", "neto")
  config.addDataSourceProperty("password", "neto11235")


  val ds = new HikariDataSource(config)


  //  val db = Database.forURL("jdbc:mysql://localhost:3306/viajes", "root", "mysql", driver = "com.mysql.jdbc.Driver")
  //  val db = Database.forURL("jdbc:mysql://localhost:3306/viajes", "root", "neto", driver = "com.mysql.jdbc.Driver")
  val db = Database.forDataSource(ds)
  val comisiones = TableQuery[Comisiones]
  val eventos = TableQuery[Eventos]
  val funcionarios = TableQuery[Funcionarios]
  val mecanismoOrigen = TableQuery[MecanismosOrigen]
  val temas = TableQuery[Temas]
  val tiposComisiones = TableQuery[TiposComision]
  val tiposMoneda = TableQuery[TiposMoneda]
  val tiposRepresentación = TableQuery[TiposRepresentacion]
  val tiposViaje = TableQuery[TiposViaje]
  val tiposPasaje = TableQuery[TiposPasaje]
  val viajes = TableQuery[Viajes]
  val viáticos = TableQuery[Viaticos]
  val roles = TableQuery[Roles]
  val usuarios = TableQuery[Usuarios]

  def initDatabase(): Unit = {

    db.withSession {
      implicit session =>
        try {

          (roles.ddl ++
            usuarios.ddl ++
            funcionarios.ddl ++
            mecanismoOrigen.ddl ++
            temas.ddl ++
            tiposComisiones.ddl ++
            tiposMoneda.ddl ++
            tiposRepresentación.ddl ++
            tiposViaje.ddl ++
            tiposPasaje.ddl ++
            comisiones.ddl ++
            eventos.ddl ++
            viajes.ddl ++
            viáticos.ddl).create
          println("Tablas creadas correctamente")
        } catch {
          case ex: Exception =>
            println(ex.getMessage)
        }
        temas.map(t => t.descripción).insertAll("Políticas de acceso a la información",
          "Asuntos internacionales",
          "Normativa de acceso a la información",
          "Capacitacion y cultura de la transparencia",
          "Gestión documental de archivos",
          "Indicadores y evaluación",
          "Normatividad de datos personales",
          "Supervisión, vigilancia, verificación y sanciones",
          "Tecnologías de la Información",
          "Gobierno abierto y transparencia",
          "Vinculación con Estados y Municipios",
          "Vinculación con nuevos sujetos obligados",
          "Vinculación y promoción del derecho",
          "Protección de Datos").run

        tiposComisiones.map(tc => tc.descripción).insertAll(
          "Recibir Capacitación",
          "Impartir Capacitación",
          "Participación en Evento Público",
          "Notificación",
          "Verificación",
          "Reunión de Trabajo",
          "Asuntos Legales",
          "Impartir Conferencia",
          "Seguimiento a Averiguación Previa",
          "Cobertura Informativa",
          "Logística",
          "Agenda de Comunicación Social",
          "Participar como Testigo de honor en convenio de colaboración"
        ).run

        mecanismoOrigen.map(m => m.descripción).insertAll(
          "Invitación",
          "Requerimiento UR",
          "No Disponible",
          "No Aplica"
        ).run

        tiposRepresentación.map(t => t.descripción).insertAll(
          "Técnico",
          "Alto Nivel"
        ).run

        tiposViaje.map(t => t.descripción).insertAll(
          "Nacional",
          "Internacional"
        ).run

        tiposPasaje.map(t => t.descripción).insertAll(
          "Terrestre",
          "Aereo",
          "Marítimo",
          "No Aplica"
        ).run

        tiposMoneda.map(t => t.descripción).insertAll(
          "MXP",
          "USD"
        ).run

        roles.map(r => r.descripción).insertAll(
          "admin",
          "funcionario"
        ).run

        usuarios.map(u => (u.nombreUsuario, u.contraseña, u.nombre, u.apellidoPaterno, u.apellidoMaterno, u.imagenPerfil, u.roleId)).insertAll(
          ("admin", "admin123", "Ernesto", "Huerta", "Ortiz", None, 1),
          ("funcionario", "funcionario123", "Roberto", "Pérez", "Fulanito", None, 2)
        )
    }
  }

}
