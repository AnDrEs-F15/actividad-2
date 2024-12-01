export const useValidatedBudget = () =>{
    const inputField = [
        {
            name:"valueBudget",
            label: "Valor presupuesto" ,
            type: "number",
            fullWidth: "span 2",

        },
        {
            name:"dateStart",
            label: "Fecha presupuesto mes" ,
            type: "date",
            shrink:true   
        },
        {
            name:"dateEnd",
            label: "Fecha fin presupuesto" ,
            type: "date", 
            shrink:true
        },

        {
            name:"description",
            label: "Descripcion" ,
            type: "textarea",
            fullWidth: "span 2",
            multiline : true,
            rows:"3"
        }
    ]

    return{
        inputField
    }
}