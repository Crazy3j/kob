<template>
  <ContentField>
    我的bot
  </ContentField>
</template>

<script>
import ContentField from "@/components/ContentField.vue";
import user from "@/store/user";
import $ from 'jquery'

export default {
  components: {
    ContentField
  },
  setup() {

    $.ajax({
      url: "http://127.0.0.1:3000/user/bot/add/",
      type: "post",
      data: {
        title: "Bot的标题",
        description: "Bot的描述",
        content: "Bot的代码",
      },
      headers: {
        Authorization: "Bearer " + user.state.token,
      },
      success(resp) {
        console.log(resp);
      },
      error(resp) {
        console.log(resp);
      }
    })
  }
}


</script>

<style scoped>

</style>