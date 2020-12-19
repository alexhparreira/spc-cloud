package com.spcbrasil.api.users.run;


import com.spcbrasil.api.converters.ZonedDateTimeReadConverter;
import com.spcbrasil.api.converters.ZonedDateTimeWriteConverter;
import com.spcbrasil.api.data.model.Consumidor;
import com.spcbrasil.api.data.model.Pagamento;
import com.spcbrasil.api.util.Constants;
import com.spcbrasil.api.util.DateUtils;
import com.spcbrasil.api.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();


    MongoDbFactory mongoDbFactory;



    public void getDbSeeder(MongoDbFactory mongoDbFactory, MongoTemplate mongoTemplate) {

        System.out.println(mongoTemplate);

       /* this.mongoDbFactory = mongoDbFactory;

        converters.add(new ZonedDateTimeReadConverter());
        converters.add(new ZonedDateTimeWriteConverter());


        MappingMongoConverter converter = new MappingMongoConverter(
                new DefaultDbRefResolver(mongoDbFactory), new MongoMappingContext());

        converter.setCustomConversions(new CustomConversions(CustomConversions.StoreConversions.NONE, converters));


        try {
            this.mongoTemplate = new MongoTemplate(mongoDbFactory,converter);
        } catch (Exception e) {
            e.printStackTrace();
        }


        */
    }

    @Override
    public void run(String... args) {



        List<Consumidor> consumidores = this.mongoTemplate.findAll(Consumidor.class);


 try{

       if(consumidores==null || consumidores.size()==0) {

           Consumidor consumidor1 = new Consumidor();
           consumidor1.setCpf(75876528734L);
           consumidor1.setDataNascimento(StringUtil.addOrSubtractDaysToDate(new Date(), -7300));
           consumidor1.setEmail("marcosdasilva@spcbrasil.org.br");
           consumidor1.setNome("Marcos da Silva");
           this.mongoTemplate.insert(consumidor1);

           Consumidor consumidor2 = new Consumidor();
           consumidor2.setCpf(97776528734L);
           consumidor2.setDataNascimento(StringUtil.addOrSubtractDaysToDate(new Date(), -9300));
           consumidor2.setEmail("carloscarvalho@spcbrasil.org.br");
           consumidor2.setNome("Carlos Carvalho");
           this.mongoTemplate.insert(consumidor2);

           Pagamento pgto1 = new Pagamento();
           pgto1.setConsumidorId(consumidor1.getId());
           pgto1.setDataVencimento(StringUtil.addOrSubtractDaysToDate(new Date(), 30));
           pgto1.setEmpresaNome("Casas Bahia");
           pgto1.setStatus(false);
           pgto1.setEmpresaId("456789567890");
           pgto1.setValor(200.0);
           this.mongoTemplate.insert(pgto1);

           Pagamento pgto2 = new Pagamento();
           pgto2.setConsumidorId(consumidor1.getId());
           pgto2.setDataVencimento(StringUtil.addOrSubtractDaysToDate(new Date(), 60));
           pgto2.setEmpresaNome("Casas Bahia");
           pgto2.setStatus(false);
           pgto2.setEmpresaId("456789567890");
           pgto2.setValor(200.0);
           this.mongoTemplate.insert(pgto2);

           Pagamento pgto3 = new Pagamento();
           pgto3.setConsumidorId(consumidor1.getId());
           pgto3.setDataVencimento(StringUtil.addOrSubtractDaysToDate(new Date(), 30));
           pgto3.setEmpresaNome("Casas Bahia");
           pgto3.setStatus(false);
           pgto3.setEmpresaId("657999");
           pgto3.setValor(200.0);
           this.mongoTemplate.insert(pgto3);


           Pagamento pgto4 = new Pagamento();
           pgto4.setConsumidorId(consumidor2.getId());
           pgto4.setDataVencimento(StringUtil.addOrSubtractDaysToDate(new Date(), 30));
           pgto4.setEmpresaNome("Extra");
           pgto4.setStatus(false);
           pgto4.setEmpresaId("658000");
           pgto4.setValor(150.0);
           this.mongoTemplate.insert(pgto4);

           Pagamento pgto5 = new Pagamento();
           pgto5.setConsumidorId(consumidor2.getId());
           pgto5.setDataVencimento(StringUtil.addOrSubtractDaysToDate(new Date(), 30));
           pgto5.setEmpresaNome("Extra");
           pgto5.setStatus(false);
           pgto5.setEmpresaId("658000");
           pgto5.setValor(150.0);
           this.mongoTemplate.insert(pgto5);

           Pagamento pgto6 = new Pagamento();
           pgto6.setConsumidorId(consumidor2.getId());
           pgto6.setDataVencimento(StringUtil.addOrSubtractDaysToDate(new Date(), 30));
           pgto6.setEmpresaNome("Extra");
           pgto6.setStatus(false);
           pgto6.setEmpresaId("658000");
           pgto6.setValor(150.0);
           this.mongoTemplate.insert(pgto6);


       }

     } catch(Exception e) {

        e.getCause();
    }



       }



    public MappingMongoConverter getDefaultMongoConverter() throws Exception {


        MappingMongoConverter converter = new MappingMongoConverter(
                new DefaultDbRefResolver(mongoDbFactory), new MongoMappingContext());

        converter.setCustomConversions(new CustomConversions(CustomConversions.StoreConversions.NONE, converters));
        return converter;
    }
}
