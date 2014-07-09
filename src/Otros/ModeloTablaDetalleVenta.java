package Otros;


import java.util.ArrayList;

/**
 *
 * @author elaprendiz <http://www.elaprendiz.net63.net>
 */
public class ModeloTablaDetalleVenta  {

    private Class[] tipoColumnas;
    private Double subTotal = 0.0;
    private Integer numItems = 0;  
    
    public ModeloTablaDetalleVenta() {
       
    }


    
    

    

    
    public Class<?> getColumnClass(int columnIndex) {
        return tipoColumnas[columnIndex];
    }
    
    

   
    

    
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //super.setValueAt(aValue, rowIndex, columnIndex);
       
    }
    
    
    
    
    
   
    
   
    public void quitarFila(int fila)
    {
       
    }
    

    
    public Double getSubTotal()
    {
        Double tmpSt = 0.0;
        
        this.subTotal = tmpSt;
        return this.subTotal;
    }
    
    public void contarItems()
    {
        numItems = 0;
                   
                numItems++;
            }
        }
    
    
   

   
   
    
    
    
    
        
    

