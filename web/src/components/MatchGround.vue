<template>

  <div class="matchground">
    <div class="row">
      <div class="col-6">
        <div class="user-photo">
          <img :src="$store.state.user.photo" alt="">
        </div>
        <div class="user-username">
          {{ $store.state.user.username }}
        </div>
      </div>
      <div class="col-6">
        <div class="user-photo">
          <img :src="$store.state.pk.opponent_photo" alt="">
        </div>
        <div class="user-username">
          {{ $store.state.pk.opponent_username }}
        </div>
      </div>
    </div>
  </div>

</template>

<script>


export default {}
</script>

<style scoped>
div.matchground {
  width: 60vw;
  height: 70vh;
  margin: 40px auto;
  background-color: rgba(50,50,50,0.5);
}
div.user-photo{
  text-align: center;
  padding-top: 10vh;
}
div.user-photo>img{
  border-radius: 50%;
  width: 20vh;
}
div.user-username{
  text-align: center;
  font-size: 24px;
  font-weight: 600;
  color: white;
}
</style>