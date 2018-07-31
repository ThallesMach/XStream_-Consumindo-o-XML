package br.com.alura.xstream;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class ProdutoTest {

	@Test
	public void deveGerar0XmlCom0NomePrecoEDescricaoAdequados() {
		String xmlEsperado = "<produto codigo=\"1587\">\n" + 
	            "  <nome>geladeira</nome>\n" +
				"  <preco>1000.0</preco>\n"+ 
				"  <descrição>deladeira duas portas</descrição>\n" + 
				"</produto>";

		Produto geladeira = new Produto("geladeira", 1000.0, "deladeira duas portas", 1587);
		
		XStream xstream = new XStream();
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		
		String xmlGerado =  xstream.toXML(geladeira);
		
		assertEquals(xmlEsperado, xmlGerado);
		
	}

}
