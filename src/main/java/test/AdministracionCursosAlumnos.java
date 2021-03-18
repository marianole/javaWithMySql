package test;

import ejercicio.alumno.curso.Alumno;
import ejercicio.alumno.curso.Curso;

import java.sql.*;
import java.util.GregorianCalendar;

public class AdministracionCursosAlumnos {

    public static void main(String[]args){
        Alumno jorge= new Alumno(88,"Jorge","Fernandez", new GregorianCalendar(1990,4,24).getTime());
        String sentenciaDeleteFromAlumno="DELETE FROM Alumno WHERE codigo=? AND nombre=?";

        Alumno daniel = new Alumno(50,"Daniel", "Perez",new GregorianCalendar(1995,8,24).getTime());
        String sentenciaInsertIntoAlumno="INSERT INTO Alumno(codigo, nombre, apellido) values (?,?,?)";

        Curso c= new Curso (2929,"Programacion en Java");
        String sentInsertIntoCurso="INSERT INTO Curso(codigo, nombreCurso) values (?,?)";

        String insertIntoAlumnoCurso="INSERT INTO Alumno_Curso(codigoAlumno, codigoCurso) values (?,?)";

        try{

            //1.Crear conexion
            Connection miConexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/curso", "root","");

            //2.Crear objeto Statement
            Statement miStatement= miConexion.createStatement();

            //3.PreparedStatement

            /*A. Alumno:*/
            PreparedStatement preparedStatement=miConexion.prepareStatement(sentenciaInsertIntoAlumno);
            preparedStatement.setInt(1,daniel.getId());
            preparedStatement.setString(2, daniel.getNombre());
            preparedStatement.setString(3, daniel.getApellido());


            /*A(bis). Alumno:*/
            PreparedStatement preparedStatement3 = miConexion.prepareStatement(sentenciaInsertIntoAlumno);
            preparedStatement3.setInt(1,jorge.getId());
            preparedStatement3.setString(2,jorge.getNombre());
            preparedStatement3.setString(3,jorge.getApellido());

            PreparedStatement preparedStatement4= miConexion.prepareStatement(sentenciaDeleteFromAlumno);
            preparedStatement4.setInt(1,jorge.getId());
            preparedStatement4.setString(2, jorge.getNombre());


            /*B. Curso:*/
            PreparedStatement preparedStatement1=miConexion.prepareStatement(sentInsertIntoCurso);
            preparedStatement1.setInt(1,c.getId());
            preparedStatement1.setString(2,c.getNombreCurso());

            /*C. Registar alumno en curso:*/
            PreparedStatement preparedStatement2=miConexion.prepareStatement(insertIntoAlumnoCurso);
            preparedStatement2.setInt(1,daniel.getId());
            preparedStatement2.setInt(2,c.getId());


            //4.Execute insert SQL statement
            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            preparedStatement3.executeUpdate();
            preparedStatement4.executeUpdate();


            //5.ResulSet & .executeQuery()
            /*Lista de alumnos:*/
            ResultSet miResulSet= miStatement.executeQuery("Select * From Alumno");
            while (miResulSet.next()){
                System.out.println("Alumno/a:" + miResulSet.getString("nombre") + " " + miResulSet.getString("apellido"));
            }

            /*Lista de cursos:*/
            ResultSet miResult1 = miStatement.executeQuery("SELECT * FROM Curso");
            while(miResult1.next()){
                System.out.println("Cursos: " + miResult1.getString("nombreCurso"));
            }


        }catch (SQLException e){
            System.out.println("Erorr");
            e.printStackTrace();
        }

    }

}
