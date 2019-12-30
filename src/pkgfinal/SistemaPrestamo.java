
package pkgfinal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SistemaPrestamo {
    ArrayList <Copia> lib;
    ArrayList <Lector> socio;
    ArrayList <Autor> escritor;
    
    public SistemaPrestamo(){
        lib = new ArrayList();
        socio = new ArrayList();
        escritor = new ArrayList();
        proceso();
    }
    private void proceso(){
        String s;
        int opc,cuenta;
	Scanner sc = new Scanner (System.in);
           do{
            System.out.println("Seleccione una opcion:\n1)Agregar Libro\n2)Agregar Lector\n3)Agregar Autor");
            System.out.println("4)Activar Lector\n5)Desactivar Lector\n6)Prestamo\n7)Devolucion\n8)Multar");
            System.out.println("9)Buscar Libro\n10)Buscar Lector\n11)Salir");
            opc = getOpc(1,11);
            switch(opc){
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    agregarLector ();
                    break;
                case 3:
                   agregarAutor();
                    break;
                case 4:
                    System.out.println("Numero de socio");
                    cuenta = sc.nextInt();
                    activarLector(cuenta);
                    break;
                case 5:
                    System.out.println("Numero de socio");
                    cuenta = sc.nextInt();
                    desactivarLector(cuenta);
                    break;
                case 6:
                     System.out.println("Nombre del libro:");
                     s = sc.next();
                     System.out.println("Numero de socio");
                     cuenta = sc.nextInt();
                     prestamo(s,cuenta);
                    break;
                case 7:
                     System.out.println("Nombre del libro:");
                     s = sc.next();
                     System.out.println("Numero de socio");
                     cuenta = sc.nextInt();
                    devolver(s,cuenta);
                    break;
                case 8:
                    System.out.println("Numero de socio");
                    cuenta = sc.nextInt();
                   multar(cuenta);
                    break;
                case 9:
                    System.out.println("Numero de copia");
                    cuenta = sc.nextInt();
                    buscarLibro(cuenta);
                    break;
                case 10:
                    System.out.println("Numero de socio");
                    cuenta = sc.nextInt();
                    buscarLector(cuenta);
                    break;
                case 11:
                    System.out.println("Hasta pronto!!");
                    break;
            }
            if (opc != 11){
		System.out.println("Desea otra opcion? 1)si  2)no");
		opc = getOpc (1,2);
                if (opc == 2){
                    opc = 11;
                    System.out.println("Hasta pronto !!");
                }
            }
	}while( opc != 11);
    }
    //metodo getOpc para validar los datos que son metidos por el usuario
    private int getOpc (int valor1 , int valor2){
        int valor = 0;
       do{
           try{
               System.out.print("Eliga una opcion: ");
               Scanner o = new Scanner (System.in);
               valor = o.nextInt();
           }catch(InputMismatchException ex){
               System.out.println("Error de lectura "+ex.getMessage());
           }
       }while (valor < valor1 || valor > valor2);
       return valor;
    }
    
    //metodo agregar libro
    private void agregarLibro(){
        Scanner sc = new Scanner(System.in);
        Copia nuevo = new Copia();
        System.out.print("Nombre del Libro: ");
        nuevo.titulo = sc.next();
        System.out.print("Tipo del libro: ");
        nuevo.tipo= sc.next();
        System.out.print("Editorial: ");
        nuevo.editorial = sc.next();
        System.out.print("Año: ");
        nuevo.anio= sc.next();
        System.out.print("Numero de copia: ");
        nuevo.numCopia = sc.nextInt();
        System.out.print("Numero del libro: ");
        nuevo.numero = sc.nextInt();
        lib.add(nuevo);
    }
     //METODO PARA AGREGAR A UN LECTOR 
     private void agregarLector(){
        Scanner sc = new Scanner(System.in);
        Lector nuevo = new Lector();
        System.out.print("Nombre del Lector ");
        nuevo.nombre = sc.next();
        System.out.print("Telefono: ");
        nuevo.telefono = sc.next();
        System.out.print("Direccion: ");
        nuevo.direccion = sc.next();
        System.out.print("Numero de socio: ");
        nuevo.numSocio= sc.nextInt();
        socio.add(nuevo);
    }
     
     //METODO AGREGAR AUTOR
     
     private void agregarAutor(){
         Scanner sc = new Scanner(System.in);
        Autor nuevo = new Autor();
        System.out.print("Nombre del Autor ");
        nuevo.nombre = sc.next();
        System.out.print("Nacionalidad: ");
        nuevo.nacionalidad = sc.next();
        System.out.print("Fecha de Nacimiento: ");
        nuevo.fechaNac = sc.next();
        escritor.add(nuevo);
     }
     //METODO ACTIVAR LECTOR
     
     private void activarLector(int variable){
       for(Lector nombre:socio){
           if(nombre.numSocio == variable){
               nombre.estado = "Activado";
               System.out.println("Activacion correcta");
           }
           else{
               nombre.estado = "Desactivado";
               System.out.println("Activacion fallida");
           }
       }
     }
     
     //METODO DESACTIVAR LECTOR
     private void desactivarLector(int variable){
       for(Lector nombre:socio){
           if(nombre.numSocio == variable){
               nombre.estado = "Desactivado";
               System.out.println("desactivacion correcta");
           }
           else{
               System.out.println("Activacion fallida");
           }
       }
     }
     //METODO PRESTAMO
     private void prestamo(String nombre, int numero){
         for(Lector a:socio){
             if(a.numSocio == numero){
                 if (a.estado.compareToIgnoreCase("Activado")==0){
                    if(a.multa.compareToIgnoreCase("no multado")==0){
                        a.prestamos++;
                        for(Copia x:lib){
                                if (x.titulo.compareToIgnoreCase(nombre)==0){
                                     if(x.estado.compareToIgnoreCase("Disponible")==0){
                                      System.out.println("Prestamo realizado");
                                      x.estado = "Prestado";
                                     }
                                    else{
                                        System.out.println("Libro no disponible");
                                     }
                                }
                                else{
                                    System.out.println("Libro inexitente");
                                }
                            }
                        }
                        else{
                            System.out.println("Lector multado. No se pueden realizar prestamos");
                        }
                 }
                 else{
                 System.out.println("Lector inhabilitado. Active primero su cuenta");
             }
             
            }
         }
    }
     //METDO DEVOLVER
     private void devolver (String nombre, int numero){
         for(Lector x:socio){
             if(x.numSocio==numero){
                     for(Copia a:lib){
                        if(a.titulo.compareToIgnoreCase(nombre)==0){
                            if(a.estado.compareToIgnoreCase("Prestado")==0){
                                 a.estado = "Disponible";
                                 System.out.println("Libro devuelto");
                            }
                            else{
                                System.out.println("Este libro no fue prestado");
                            }
                        }
                        else{
                            System.out.println("LIbro inexistente");
                        }
                    }
                    x.prestamos--;
             }
             else{
                 System.out.println("Numero de socio incorrecto");
             }
         }
     }
     //METODO MULTAR
     private void multar (int variable){
         for(Lector nombre:socio){
           if(nombre.numSocio == variable){
               nombre.multa = "Multado";
               System.out.println("Completado con exito");
           }
           else{
               System.out.println("error");
           }
       }
     }
     
    //METODO BUSCAR LIBRO   
     private void buscarLibro(int variable){
        for(Copia x: lib){
            if(x.numCopia == variable){
                System.out.println(x);
            }
            else{
                System.out.println("Libro Inexistente");
            }
        }
    }
    //METODO BUSCAR LECTOR
     
    private void buscarLector(int variable){
        for(Lector x: socio){
            if(x.numSocio == variable){
                System.out.println(x);
            }
            else{
                System.out.println("Lector Inexistente");
            }
        }
    }
    public static void main(String[] args) {
        SistemaPrestamo hoy = new SistemaPrestamo ();
 
    }
    
}
