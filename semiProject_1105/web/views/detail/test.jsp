<!doctype html>
<head>
<meta charset="utf-8" />
<title>Workshop.rs: News Ticker in 4 lines of jQuery</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
<style>
.ticker {
 height: 40px;
/*  overflow: hidden; */
 margin: 0;
 padding: 0;
 list-style: none;

}
.ticker li {
 height: 30px;
 padding: 5px;
 margin: 0px 5px;
}
</style>


<script>
 function tick(){
  $('.ticker_01 li:first').slideUp( function () { $(this).appendTo($('.ticker_01')).slideDown();});

 }
 setInterval(function(){ tick () }, 3000);
</script>


</head>

<body>


<div>
<ul class="ticker_01 ticker">

  <li><a href="#">111</li>
        <li><a href="#">222</li>
  <li><a href="#">333</li>
  <li><a href="#">444</li>
  <li><a href="#">555</li>
  <li><a href="#">666</li>
  <li><a href="#">777</li>
 </ul>
</div>


</div>

</body>