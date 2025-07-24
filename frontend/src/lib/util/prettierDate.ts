export const prettierDate = (date: Date): string => {
  const CurrDate = Date.now()
  if(date === null)
    return "null"
  const inputDate = new Date(date)
  if (CurrDate - inputDate.getTime() > 24*60*60*1000) {
    const y = inputDate.getFullYear()
    const m = inputDate.getMonth()
    const d = inputDate.getDay()

    return y + '-' + m.toString().padStart(2, '0') + '-' + d.toString().padStart(2, '0')
  }
  const h = inputDate.getHours()
  const m = inputDate.getMinutes()
  return h.toString().padStart(2,'0') + ":" + m.toString().padStart(2,'0')
}