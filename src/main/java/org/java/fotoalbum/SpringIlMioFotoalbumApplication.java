package org.java.fotoalbum;

import org.java.fotoalbum.pojo.Categoria;
import org.java.fotoalbum.pojo.Foto;
import org.java.fotoalbum.serv.CategoriaService;
import org.java.fotoalbum.serv.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner{
	
	
	@Autowired
	private FotoService fotoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	
	@Override
	public void run(String...args)throws Exception{
		
		Categoria c1=new Categoria("Paesaggio");
		Categoria c2=new Categoria("Città");
		Categoria c3=new Categoria("Montagna");
		Categoria c4=new Categoria("Lago");
		Categoria c5=new Categoria("Cibo");
		
		categoriaService.save(c1);
		
		Foto f1= new Foto("Lago di Braies", "Lago molto bello ma tanto turistico","https://static2-viaggi.corriereobjects.it/wp-content/uploads/2017/08/lago-di-braies-come-arrivare-dove-si-trova-alto-adige-estate.jpg?v=1597768260" , true);
		Foto f2=new Foto("Lago di Carezza","Lago molto particolare","https://d1b7rr0nby25az.cloudfront.net/cache-buster-1678910037/activities/karersee-42171578/image-thumb__20026223__header-fullscreen/karer-see--1443447969.jpg",true );
		Foto f3=new Foto("Tokyo","Città molto bella","https://www.aviontourism.com/images/1260-1260-fix/1ccb6aee-a04b-45a9-85dd-4bbdd2eb95dc",true );
		Foto f4=new Foto("Firenze","Citta storica","https://tourismmedia.italia.it/is/image/mitur/20210401173629-firenze-toscana-gettyimages-1145040590?wid=1600&hei=900&fit=constrain,1&fmt=webp",true );
		Foto f5=new Foto("Monte Everest","Molto alto","https://lowamedia.blob.core.windows.net/expeditions/2019_luisstitzinger_nepal-mounteverest/luis-stitzinger-am-gipfel-des-everest-8848-m_foto_stitzinger_goclimbamountainde.jpg",true );
		
		
		fotoService.save(f1);
		fotoService.save(f2);
		fotoService.save(f3);
		fotoService.save(f4);
		fotoService.save(f5);
	}
}
