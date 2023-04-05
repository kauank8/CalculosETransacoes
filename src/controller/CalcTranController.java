package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CalcTranController extends Thread {
	int id;
	Semaphore semaforo;
	public CalcTranController(int id, Semaphore semaforo) {
		this.id=id;
		this.semaforo=semaforo;			
	}
	
	@Override
	public void run() {
		VerificaResto();
	}
	
	//Verifica Resto E chama Calc
	private void VerificaResto() {
		if(id % 3 ==0) {
			CalcResto0();
		}
		if(id % 3 ==1) {
			CalcResto1();
		}
		if(id % 3 ==2) {
			CalcResto2();
		}
	}
	
	//Resto1
	private void CalcResto1() {
		Random gerador = new Random();
		
		//Inicia Primeiro Calculo
			double tempo = gerador.nextDouble(0.8) + 0.2;
			System.out.printf("Thread #" +id + " comecou um calculo, aguarde (segundos) %.2f %n", tempo);
			try {
			sleep((long) (tempo*1000));
			System.out.println("Thread #" + id + " Terminou seu calculo" );
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		//Inicia Primeira Transação
			try {
			semaforo.acquire();
			System.out.println("A Thread #" + id + " Iniciou a transacao, aguarde 1 segundo");
			TransacaoBD1S();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			semaforo.release();
			}
		
		//Chama Proximo Calculo
			double tempo2 = gerador.nextDouble(0.8) + 0.2;
			System.out.printf("Thread #" + id + " comecou o 2º calculo, aguarde (segundos) %.2f %n", tempo2);
			try {
			sleep((long) (tempo2 * 1000));
			System.out.println("Thread #" + id + " Terminou seu calculo");
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		// Chama Segunda Transacao
				try {
					semaforo.acquire();
					System.out.println("A Thread #" + id + " Iniciou a 2º transacao, aguarde 1 segundo");
					TransacaoBD1S();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaforo.release();
				}
		
	}
	
	//Resto 2
	private void CalcResto2() {
		Random gerador = new Random();
		
		//Inicia Primeiro Calculo
			double tempo = gerador.nextDouble(1.0) + 0.5;
			System.out.printf("Thread #" +id + " comecou um calculo, aguarde (segundos) %.2f %n", tempo);
			try {
			sleep((long) (tempo*1000));
			System.out.println("Thread #" + id + " Terminou seu calculo" );
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		//Inicia Primeira Transação
			try {
			semaforo.acquire();
			System.out.println("A Thread #" + id + " Iniciou a transacao, aguarde 1,5 segundo");
			TransacaoBD15S();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			semaforo.release();
			}
		
		//Inicia Segundo Calculo
			double tempo2 = gerador.nextDouble(1.0) + 0.5;
			System.out.printf("Thread #" +id + " comecou o 2º calculo, aguarde (segundos) %.2f %n", tempo2);
			try {
			sleep((long) (tempo2*1000));
			System.out.println("Thread #" + id + " Terminou seu calculo" );
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		//Inicia Segunda Transação
			try {
			semaforo.acquire();
			System.out.println("A Thread #" + id + " Iniciou a 2º transacao, aguarde 1,5 segundo");
			TransacaoBD15S();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			semaforo.release();
			}
			
		//Inicia Terceiro Calculo
			double tempo3 = gerador.nextDouble(1.0) + 0.5;
			System.out.printf("Thread #" +id + " comecou o 3º calculo, aguarde (segundos) %.2f %n", tempo3);
			try {
			sleep((long) (tempo2*1000));
			System.out.println("Thread #" + id + " Terminou seu calculo" );
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		//Inicia Terceira Transação
			try {
			semaforo.acquire();
			System.out.println("A Thread #" + id + " Iniciou a 3º transacao, aguarde 1,5 segundo");
			TransacaoBD15S();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			semaforo.release();
			}
		

	}
	
	//Rest0
	private void CalcResto0() {
		Random gerador = new Random();
		
		//Inicia Primeiro Calculo
			double tempo = gerador.nextDouble(1.0) + 1.0;
			System.out.printf("Thread #" +id + " comecou um calculo, aguarde (segundos) %.2f %n", tempo);
			try {
			sleep((long) (tempo*1000));
			System.out.println("Thread #" + id + " Terminou seu calculo" );
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		//Inicia Primeira Transação
			try {
			semaforo.acquire();
			System.out.println("A Thread #" + id + " Iniciou a transacao, aguarde 1,5 segundo");
			TransacaoBD15S();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			semaforo.release();
			}
		
		//Inicia Segundo Calculo
			double tempo2 = gerador.nextDouble(1.0) + 1.0;
			System.out.printf("Thread #" +id + " comecou o 2º calculo, aguarde (segundos) %.2f %n", tempo2);
			try {
			sleep((long) (tempo2*1000));
			System.out.println("Thread #" + id + " Terminou seu calculo" );
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		//Inicia Segunda Transação
			try {
			semaforo.acquire();
			System.out.println("A Thread #" + id + " Iniciou a 2º transacao, aguarde 1,5 segundo");
			TransacaoBD15S();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			semaforo.release();
			}
			
		//Inicia Terceiro Calculo
			double tempo3 = gerador.nextDouble(1.0) + 1.0;
			System.out.printf("Thread #" +id + " comecou o 3º calculo, aguarde (segundos) %.2f %n", tempo3);
			try {
			sleep((long) (tempo2*1000));
			System.out.println("Thread #" + id + " Terminou seu calculo" );
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
		//Inicia Terceira Transação
			try {
			semaforo.acquire();
			System.out.println("A Thread #" + id + " Iniciou a 3º transacao, aguarde 1,5 segundo");
			TransacaoBD15S();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}finally {
			semaforo.release();
			}
		

	}
	
	//Transacao de 1 segundo
	private void TransacaoBD1S() {
		
		try {
			sleep(1000);
			System.out.println("A Thread #" + id + " Finalizou a transacao");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Transacao de 1,5 s
	private void TransacaoBD15S() {
		try {
			sleep(1500);
			System.out.println("A Thread #" + id + " Finalizou a transacao");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

