const {defineStore} = Pinia
// replyStore 
const useRecipeStore=defineStore('recipe',{
	// state : 공통 사용 변수 , props 
	state:()=>({
		list:[],
		curpage:1,
		totalpage:0,
		startPage:0,
		endPage:0
	}),
	actions:{
		// default 매개변수 => recipeListDate() recipeListDate(2)
		async recipeListData(){
			const res=await api.get('/recipe/list_vue/',{
				params:{
					page:this.curpage
				}
			})
			this.setPageData(res.data)
		},
		// 
		setPageData(data){
			this.list=data.list
			this.curpage=data.curpage
			this.totalpage=data.totalpage
			this.startPage=data.startPage
			this.endPage=data.endPage
		},
		// prev / next / pageChange 
	    movePage(page){
			this.curpage=page
			this.recipeListData()
		}	
		// 상세보기 
	}
})