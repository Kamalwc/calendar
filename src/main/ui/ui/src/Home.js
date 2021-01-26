
import React, {useEffect, useState} from 'react'
import axios from 'axios'
import FullCalendar from '@fullcalendar/react'
import dayGridPlugin from '@fullcalendar/daygrid'
import "../src/styles/CalendarStyles.css"
import moment from "moment";
import { ChevronLeft , ChevronRight} from '@material-ui/icons';
import {Typography} from "@material-ui/core";

function Home(){

    const [currMonth, setCurrMonth] = useState(null)

    useEffect(() =>{
        setCurrMonth(moment().format('MMMM YYYY'))
    },[])

    const renderHeader = () =>{
        return(
            <div style={{ display: "flex", justifyContent: "space-between"}}>
                <ChevronLeft onClick={subMonth}/>
                <Typography variant={"h4"}> {currMonth}</Typography>
                <ChevronRight onClick={addMonth}/>
            </div>
        )
    }
    const addMonth = () =>{
        setCurrMonth(moment(currMonth).add(1,'M').format('MMMM YYYY'))
    }

    const subMonth = () => {
        setCurrMonth(moment(currMonth).subtract(1,'M').format('MMMM YYYY'))
    }

    const renderDays = () =>{
        let days = [];

        for(let i = 0; i < 7; i++){
            days.push(<div>{moment().day("Sunday").add(i,'d').format('dddd')}</div>)
        }
        return(
            <div id={"days"}>
                {days}
            </div>
        )
    }

    const renderCells = () =>{
        // start of the month
        // start of the week of the month
        // last day of the month
        // last day of the week of the last day of the month
        const monthStart = moment(currMonth).startOf('month');
        const monthEnd = moment(currMonth).endOf('month');
        const calendarStart = moment(monthStart).startOf('week');
        const calendarEnd = moment(monthEnd).endOf('week');

        // while day doestn equal last day render cells
        let day = calendarStart;
        let rows = []
        while(day < calendarEnd){
            let tempRow = [];
            for (let i = 0; i < 7; i++) {
                tempRow.push(<div className={moment(currMonth).isSame(day,'month')? "cells" : "cells-disabled"}>
                    {day.format('D')}
                </div>)
                day.add(1,'days');
            }
            {rows.push(<div style={{display: "flex", justifyContent:"left"}}>{tempRow}</div>)}
            tempRow = [];
        }

        return(
            <div>
                {rows}
            </div>
        )
    }


    const add = () =>{
        setCurrMonth(moment(currMonth).add(1 ,"months").format('MMMM YYYY'))
    }

    const sub = () =>{
        setCurrMonth(moment(currMonth).subtract(1, "months").format('MMMM YYYY'))
    }

    const wheel = (e) =>{
        if(e.deltaY > 0){
            sub();
        }else if(e.deltaY < 0){
            add();
        }

    const renderDays = () =>{
        let days = [];

        for(let i = 0; i < 7; i++){
            days.push(<div>{moment().day("Sunday").add(i,'d').format('dddd')}</div>)
        }
        return(
            <div id={"days"}>
                {days}
            </div>
        )
    }

    const renderCells = () =>{
      // start of the month
    // start of the week of the month
    // last day of the month
    // last day of the week of the last day of the month
    const monthStart = moment(currMonth).startOf('month');
    const monthEnd = moment(currMonth).endOf('month');
    const calendarStart = moment(monthStart).startOf('week');
    const calendarEnd = moment(monthEnd).endOf('week');

        // while day doestn equal last day render cells
        let day = calendarStart;
        let rows = []
        while(day < calendarEnd){
            let tempRow = [];
            for (let i = 0; i < 7; i++) {
                tempRow.push(<div className={moment(currMonth).isSame(day,'month')? "cells" : "cells-disabled"}>
                                    {day.format('D')}
                            </div>)
                day.add(1,'days');
            }
            {rows.push(<div style={{display: "flex", justifyContent:"left"}}>{tempRow}</div>)}
            tempRow = [];
        }

        return(
            <div>
                {rows}
            </div>
        )

    }

    return(
        <div className={'Calendar'} onWheel={wheel}>
            {renderHeader()}
            {renderDays()}
            {renderCells()}
        </div>
    )
}

export default Home;

