package com.example.demo.domain;

public class Dados {

    private String age;
    private String breast;
    private String breastQuad;
    private String degMalig;
    private String invNodes;
    private String irradiat;
    private String menopause;
    private String nodeCaps;
    private String tumorSize;
    private String resposta;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMenopause() {
        return menopause;
    }

    public void setMenopause(String menopause) {
        this.menopause = menopause;
    }

    public String getTumorSize() {
        return tumorSize;
    }

    public void setTumorSize(String tumorSize) {
        this.tumorSize = tumorSize;
    }

    public String getInvNodes() {
        return invNodes;
    }

    public void setInvNodes(String invNodes) {
        this.invNodes = invNodes;
    }

    public String getNodeCaps() {
        return nodeCaps;
    }

    public void setNodeCaps(String nodeCaps) {
        this.nodeCaps = nodeCaps;
    }

    public String getDegMalig() {
        return degMalig;
    }

    public void setDegMalig(String degMalig) {
        this.degMalig = degMalig;
    }

    public String getBreast() {
        return breast;
    }

    public void setBreast(String breast) {
        this.breast = breast;
    }

    public String getBreastQuad() {
        return breastQuad;
    }

    public void setBreastQuad(String breastQuad) {
        this.breastQuad = breastQuad;
    }

    public String getIrradiat() {
        return irradiat;
    }

    public void setIrradiat(String irradiat) {
        this.irradiat = irradiat;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void alterarResposta(double resposta[]) {
        double vetor[] = new double[2];
        vetor = resposta;
        if (vetor[1] > vetor[0]) {
            this.resposta = "recurrence-events";
        } else {
            this.resposta = "no-recurrence-events";
        }
    }
}
