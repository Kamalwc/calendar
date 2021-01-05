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

    return(
        <div className={'Calendar'}>
            {renderHeader()}
        </div>
    )
}

export default Home;