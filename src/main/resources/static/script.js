
function connect()
{

        let socket=new SockJS("/server1")

        stompClient=Stomp.over(socket)

        stompClient.connect({},function(frame){

            console.log("Connected : "+frame)

            $("#name-from").addClass('d-none')
              $("#chat-room").removeClass('d-none')


                //subscribe
                stompClient.subscribe("/topic/return-to",function(response){
                        console.log(JSON.parse(response.body))
                        document.getElementById('display').innerHTML = JSON.parse(response.body).name;
                   // document.getElementById("user_input").value;

                })



        })

}




$(document).ready((e)=>{
	
	connect();
	$("#login").click(()=>{
		
		alert("testing")
	})
})