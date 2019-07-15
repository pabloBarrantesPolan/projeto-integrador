package br.com.generation.projeto.ateliedigital.ateliedigital.cliente;

import com.github.javafaker.Faker;

import java.util.Locale;

public  class ClienteMock {

       public static Cliente getClienteMock(){

           Faker faker = new Faker(new Locale("pt-BR"));


           Cliente cliente = new Cliente();
           cliente.setNome(faker.name().firstName());
           cliente.setEmail(faker.internet().emailAddress());
           cliente.setCep(faker.number().numberBetween(1000000, 99999999));
           cliente.setNumero(faker.number().numberBetween(1, 9999));
           cliente.setSenha(faker.internet().password());

           return cliente;
       }
    }


