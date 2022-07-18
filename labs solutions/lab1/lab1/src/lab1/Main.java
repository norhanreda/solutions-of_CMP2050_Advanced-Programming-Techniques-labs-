package lab1;
import lab1.matrix;
import java.lang.Integer;
import java.lang.Double;
import java.lang.System;
import java.util.ArrayList;
public class Main {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// @SuppressWarnings("unchecked")
		
		System.out.print("------------class matrix test------------  \n");
		////////integer/////////
		
		matrix <Integer> intmat=new matrix<Integer> (2,3);
		ArrayList<Integer> x= new ArrayList<>();
		x.add(0,1);
		x.add(1,2);
		x.add(2,3);
		x.add(3,4);
		x.add(4,5);
		x.add(5,6);
		
		
		System.out.print(intmat.setNumbers(x));
		System.out.print("\n");
		System.out.print("integer matrix : \n");
		intmat.print();	 
		 intmat.transpose();
			
			System.out.print("transposed integer matrix : \n");
		intmat.print();	
		
		///////end integer//////////
			
			
			
			
			///////////float /////////
			
			matrix <Float> floatmat=new matrix<Float> (2,3);
			ArrayList<Float> y= new ArrayList<>();
			y.add(0,1.1f);
			y.add(1,2.2f);
			y.add(2,3.3f);
			y.add(3,4.4f);
			y.add(4,5.5f);
			y.add(5,6.6f);
			
			
			System.out.print(floatmat.setNumbers(y));
			
			System.out.print("\n");
			System.out.print("float matrix : \n");
		    	floatmat.print();	 
			 floatmat.transpose();
				
				System.out.print("transposed float matrix : \n");
				floatmat.print();	
				
			///////////////end float////////////
				
				
				
		///////////double /////////
				
				matrix <Double> doublemat=new matrix<Double> (3,3);
				ArrayList<Double> z= new ArrayList<>();
				z.add(0,1.7);
				z.add(1,8.6);
				z.add(2,3.7);
				z.add(3,1.3);
				z.add(4,5.9);
				z.add(5,9.6);
				z.add(6,0.5);
				z.add(7,7.5);
				z.add(8,9.9);
				
				System.out.print(doublemat.setNumbers(z));
				
				System.out.print("\n");
				
				System.out.print("double matrix : \n");
			    	doublemat.print();	 
				 doublemat.transpose();
				
					System.out.print("transposed double matrix : \n");
			doublemat.print();	
			
	///////////////end double////////////
			
	////////size mismatch/////////
			
			matrix <Integer> miss=new matrix<Integer> (2,3);
			ArrayList<Integer> xs= new ArrayList<>();
			xs.add(0,1);
			xs.add(1,2);
			xs.add(2,3);
			
			System.out.print(miss.setNumbers(xs));
			System.out.print("\n");
			System.out.print("size missmatch  matrix : \n");
			miss.print();	 
			miss.transpose();
				
				System.out.print("transposed size missmatch matrix : \n");
			miss.print();	
			
			///////end size missmatch //////////
				
				
			System.out.print("\n------------class identity matrix test------------  \n");
			
			
	////////not square and not identity/////////
			
			IdentityMatrix<Integer> i1=new IdentityMatrix<Integer> (2,3);
			ArrayList<Integer> x1= new ArrayList<>();
			x1.add(0,1);
			x1.add(1,2);
			x1.add(2,3);
			
			System.out.print(i1.setNumbers(x1));
			System.out.print("\n");
			System.out.print("non square and non identity matrix : \n");
			i1.print();	 
			 i1.transpose();
				
				System.out.print("transposed on square and non identity matrix : \n");
			i1.print();	
			
			///////not square and not identity //////////
			
	//////// identity/////////
			
				IdentityMatrix<Integer> i2=new IdentityMatrix<Integer> (3,3);
				ArrayList<Integer> x2= new ArrayList<>();
				x2.add(0,1);
				x2.add(1,0);
				x2.add(2,0);
				
				x2.add(3,0);
				x2.add(4,1);
				x2.add(5,0);
				
				x2.add(6,0);
				x2.add(7,0);
				x2.add(8,1);
				
				System.out.print(i2.setNumbers(x2));
				System.out.print("\n");
				System.out.print("identity matrix  : \n");
				i2.print();	 
				 i2.transpose();
					
					System.out.print("transposed  identity matrix : \n");
				i2.print();	
				
		////////not identity/////////
				

				IdentityMatrix<Integer> i3=new IdentityMatrix<Integer> (2,3);
				ArrayList<Integer> x3= new ArrayList<>();
				x3.add(0,1);
				x3.add(1,0);
				x3.add(2,0);
				
				x3.add(3,0);
				x3.add(4,1);
				x3.add(5,0);
				
				System.out.print(i3.setNumbers(x3));
				System.out.print("\n");
				System.out.print("not square matrix  : \n");
				i3.print();	 
				 i3.transpose();
					
					System.out.print("transposed  not square matrix : \n");
				i3.print();	
			
				
				//////////////////////////
				
				
///////////////double identity  matrix 
				IdentityMatrix<Double> i4=new IdentityMatrix<Double> (3,3);
				ArrayList<Double> x4= new ArrayList<>();
				x4.add(0,1.0);
				x4.add(1,0.0);
				x4.add(2,0.0);
				
				x4.add(3,0.0);
				x4.add(4,1.0);
				x4.add(5,0.0);
				
				x4.add(6,0.0);
				x4.add(7,0.0);
				x4.add(8,1.0);
				
				//System.out.print(x3.get(0).getClass().getName()==Integer.class.getName());
				
				System.out.print(i4.setNumbers(x4));
				System.out.print("\n");
				System.out.print("Double identity matrix  : \n");
				i4.print();	 
				 i4.transpose();
					
					System.out.print("transposed  Double identity  matrix : \n");
				i4.print();	
			//////////////////////////////////
				///////////float identity\\\\\\\\\\\\\\
				IdentityMatrix<Float> i5=new IdentityMatrix<Float> (3,3);
				ArrayList<Float> x5= new ArrayList<>();
				x5.add(0,1.0f);
				x5.add(1,0.0f);
				x5.add(2,0.0f);
				
				x5.add(3,0.0f);
				x5.add(4,1.0f);
				x5.add(5,0.0f);
				
				x5.add(6,0.0f);
				x5.add(7,0.0f);
				x5.add(8,1.0f);
				
				//System.out.print(x3.get(0).getClass().getName()==Integer.class.getName());
				
				System.out.print(i5.setNumbers(x5));
				System.out.print("\n");
				System.out.print("Float identity matrix  : \n");
				i5.print();	 
				 i5.transpose();
					
					System.out.print("transposed   Float identity matrix : \n");
				i5.print();	
				////////////////////////
				//////////long identityt///////////////////
				IdentityMatrix<Long> i6=new IdentityMatrix<Long> (3,3);
				ArrayList<Long> x6= new ArrayList<>();
				x6.add(0,1L);
				x6.add(1,0L);
				x6.add(2,0L);
				
				x6.add(3,0L);
				x6.add(4,1L);
				x6.add(5,0L);
				
				x6.add(6,0L);
				x6.add(7,0L);
				x6.add(8,1L);
				
				//System.out.print(x3.get(0).getClass().getName()==Integer.class.getName());
				
				System.out.print(i6.setNumbers(x6));
				System.out.print("\n");
				System.out.print("long identity matrix  : \n");
				i6.print();	 
				 i6.transpose();
					
					System.out.print("transposed  long identity matrix : \n");
				i6.print();	
		////////////////////////////
	       
				///////////////short identity/////////
				IdentityMatrix<Short> i7=new IdentityMatrix<Short> (3,3);
				ArrayList<Short> x7= new ArrayList<>();
				x7.add(0,(short)1);
				x7.add(1,(short)0);
				x7.add(2,(short)0);
				
				x7.add(3,(short) 0);
				x7.add(4,(short)1);
				x7.add(5,(short)0);
				
				x7.add(6,(short)0);
				x7.add(7,(short)0);
				x7.add(8,(short)1);
				
				//System.out.print(x3.get(0).getClass().getName()==Integer.class.getName());
				
				System.out.print(i7.setNumbers(x7));
				System.out.print("\n");
				System.out.print("short identity matrix  : \n");
				i7.print();	 
				 i7.transpose();
					
					System.out.print("transposed  short identity matrix : \n");
				i7.print();	
				
				
				/////////////
				
				
				///////////////short identity/////////
				IdentityMatrix<Byte> i8=new IdentityMatrix<Byte> (3,3);
				ArrayList<Byte> x8= new ArrayList<>();
				x8.add(0,(byte)1);
				x8.add(1,(byte)0);
				x8.add(2,(byte)0);
				
				x8.add(3,(byte)0);
				x8.add(4,(byte)1);
				x8.add(5,(byte)0);
				
				x8.add(6,(byte)0);
				x8.add(7,(byte)0);
				x8.add(8,(byte)1);
				
				//System.out.print(x3.get(0).getClass().getName()==Integer.class.getName());
				
				System.out.print(i8.setNumbers(x8));
				System.out.print("\n");
				System.out.print("Byte identity matrix  : \n");
				i8.print();	 
				 i8.transpose();
					
					System.out.print("transposed  Byte identity matrix : \n");
				i8.print();	
				
				
				/////////////
				
				/////////double not identity //////////
				IdentityMatrix<Double> i9=new IdentityMatrix<Double> (3,3);
				ArrayList<Double> x9= new ArrayList<>();
				x9.add(0,1.5);
				x9.add(1,0.3);
				x9.add(2,0.5);
				
				x9.add(3,0.5);
				x9.add(4,1.9);
				x9.add(5,0.9);
				
				x9.add(6,0.2);
				x9.add(7,0.7);
				x9.add(8,1.9);
				
				//System.out.print(x3.get(0).getClass().getName()==Integer.class.getName());
				
				System.out.print(i9.setNumbers(x9));
				System.out.print("\n");
				System.out.print("Double not identity matrix  : \n");
				i9.print();	 
				 i9.transpose();
					
					System.out.print("transposed  Double not identity  matrix : \n");
				i9.print();	
				
	}
	

}
