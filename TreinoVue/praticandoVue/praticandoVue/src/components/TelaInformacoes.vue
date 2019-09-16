<template>
  <div class="fundo">

    <div class="classe4">
      <img class="classe4" src="https://upload.wikimedia.org/wikipedia/commons/b/b5/Pink_ribbon.svg" alt="Logo" width="90px"
           height="90px"/>
      <h1 class="classe4">Breast-Cancer</h1>
    </div>


    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-alert show variant="danger" class="alerta">
        <b-form-group id="input-group-1" label="Age:" label-for="input-1" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.age"
            :options="ageArray"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-2" label="Menopause:" label-for="input-2" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.menopause"
            :options="menopauseArray"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-3" label="Tumor-size:" label-for="input-3" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.tumorSize"
            :options="tumor_sizeArray"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-4" label="Inv-nodes:" label-for="input-4" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.invNodes"
            :options="inv_nodesArray"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-5" label="Node-caps:" label-for="input-5" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.nodeCaps"
            :options="node_capsArray"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-6" label="Deg-malig:" label-for="input-6" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.degMalig"
            :options="deg_maligArray"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-7" label="Breast:" label-for="input-7" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.breast"
            :options="breastArray"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-8" label="Breast-quad:" label-for="input-8" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.breastQuad"
            :options="breast_quadArray"
            required
          ></b-form-select>
        </b-form-group>

        <b-form-group id="input-group-9" label="Irradiat:" label-for="input-9" class="classe1">
          <b-form-select
            id="input-3"
            v-model="dados.irradiat"
            :options="irradiatArray"
            required
          ></b-form-select>
        </b-form-group>
      </b-alert>

      <div class="resultado">
      <b-alert v-model="aparecer" :variant="tipoAlert" show>{{ mensagem }}</b-alert>
      </div>
      <!--<b-button @click="showDismissibleAlert=true">-->
      <!--Show dismissible alert-->
      <!--</b-button>-->


      <div class="classe2">
        <b-button type="submit" variant="primary">Submit</b-button>
        <b-button type="reset" variant="danger">Reset</b-button>
      </div>
    </b-form>
  </div>
</template>


<script>
  export default {
    data() {
      return {
        ageArray: [{
          text: 'Select One',
          value: null
        }, '10-19', '20-29', '30-39', '40-49', '50-59', '60-69', '70-79', '80-89', '90-99'],
        menopauseArray: [{text: 'Select One', value: null}, 'lt40', 'ge40', 'premeno'],
        tumor_sizeArray: [{
          text: 'Select One',
          value: null
        }, '0-4', '5-9', '10-14', '15-19', '20-24', '25-29', '30-34', '35-39', '40-44', '45-49', '50-54', '55-59'],
        inv_nodesArray: [{
          text: 'Select One',
          value: null
        }, '0-2', '3-5', '6-8', '9-11', '12-14', '15-17', '18-20', '21-23', '24-26', '27-29', '30-32', '33-35', '36-39'],
        node_capsArray: [{text: 'Select One', value: null}, 'yes', 'no'],
        deg_maligArray: [{text: 'Select One', value: null}, '1', '2', '3'],
        breastArray: [{text: 'Select One', value: null}, 'left', 'right'],
        breast_quadArray: [{
          text: 'Select One',
          value: null
        }, 'left_up', 'left_low', 'right_up', 'right_low', 'central'],
        irradiatArray: [{text: 'Select One', value: null}, 'yes', 'no'],
        show: true,
        dados: {
          age: null,
          menopause: null,
          tumorSize: null,
          invNodes: null,
          nodeCaps: null,
          degMalig: null,
          breast: null,
          breastQuad: null,
          irradiat: null,
        },
        tipoAlert: null,
        resultado: '',
        aparecer: false,
        mensagem: '',
        resposta: null
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        // this.exibirMensagem("ABC");

        this.$http.post('http://localhost:9002/requisicao', this.dados).then(response => {
          this.resposta = response.bodyText;
          this.exibirMensagem(this.resposta);
        });

      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.dados.age = null
        this.dados.menopause = null
        this.dados.tumorSize = null
        this.dados.invNodes = null
        this.dados.nodeCaps = null
        this.dados.degMalig = null
        this.dados.breast = null
        this.dados.breastQuad = null
        this.dados.irradiat = null
        this.aparecer = false
        this.mensagem = '';
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      exibirMensagem(mensagem) {
        if (mensagem == "no-recurrence-events") {
          this.tipoAlert = "info"
        } else {
          this.tipoAlert = "danger"
        }
        this.mensagem = mensagem
        this.aparecer = true
      },

      countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
      },
      showAlert() {
        this.dismissCountDown = this.dismissSecs
      }
    }
  }
</script>

<style scoped>
  .classe1 {
    display: inline-block;
    margin-left: 10px;
  }

  .classe2 {
    margin-top: 200px;

  }

  .fundo {
    padding: 30px;
    background-color: antiquewhite;
    /*!*background-repeat: no-repeat;*!*/
    position: absolute;
    width: 100%;
    height: 100%;
    font-family: 'Chilanka', cursive;

  }

  .alerta {
    margin-top: 50px;
    padding-top: 30px;
    padding-left: 10px;
  }

  .classe4 {
    display: inline-block;
  }

  .resultado {
    margin-top: 50px;
  }


</style>
