// const {defineStore} = Pinia
// replyStore 
// vuex => pinia
const initialState=()=>({
	reply_list:[],
	cno:0,
	type:2,
	msg:'',
	upReplyNo:null,
	sessionId:'',
	updateMsg:{}
})
const useReplyStore=defineStore('reply',{
	// state 
	state:initialState,
	// getters
	// actions 
	actions:{
		toggleUpdate(no){
			this.upReplyNo=this.upReplyNo===no?null:no
		},
		// 목록 읽기
		async replyListData(cno){
			this.cno=cno
			const {data} = await api.get('/reply/list_vue/',{
				params:{
					cno:this.cno,
					type:this.type
				}
			})
			this.reply_list=data.list
			this.cno=data.cno
			this.type=data.type
		},
		// 수정 
		// 추가
		async replyInsert(){
			if(!this.msg.trim()) return
			const {data} = await api.post('/reply/insert_vue/',{
				cno:this.cno,
				type:this.type,
				msg:this.msg
			})
			this.reply_list=data.list
			this.cno=data.cno
			this.type=data.type
			this.msg=''
		} 
		// 삭제 
		// toggle 
	}
})