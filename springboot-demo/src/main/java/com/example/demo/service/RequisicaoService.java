package com.example.demo.service;


import com.example.demo.domain.Dados;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.io.File;

@Service
public class RequisicaoService {


    public String executarRequisicao(Dados dados) throws Exception {
        String path = new ClassPathResource("breast-cancer.arff").getPath();
        ConverterUtils.DataSource ds = new ConverterUtils.DataSource(path);
        Instances ins = ds.getDataSet();
        //System.out.println(ins.toString());

        ins.setClassIndex(9);

        J48 arvore = new J48();

        arvore.buildClassifier(ins);

        Instance novo = new DenseInstance(9);
        novo.setDataset(ins);
        novo.setValue(0, dados.getAge());
        novo.setValue(1, dados.getMenopause());
        novo.setValue(2, dados.getTumorSize());
        novo.setValue(3, dados.getInvNodes());
        novo.setValue(4, dados.getNodeCaps());
        novo.setValue(5, dados.getDegMalig());
        novo.setValue(6, dados.getBreast());
        novo.setValue(7, dados.getBreastQuad());
        novo.setValue(8, dados.getIrradiat());

        double resultado[] = arvore.distributionForInstance(novo);

        Dados dadoResposta = new Dados();
        dadoResposta.alterarResposta(resultado);

        return dadoResposta.getResposta();
    }


}
