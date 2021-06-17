import React, {useState} from 'react';
import Dialog from "@material-ui/core/Dialog";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import {Button, Typography} from "@material-ui/core";
import MenuItem from "@material-ui/core/MenuItem";
import Select from "@material-ui/core/Select";
import InputLabel from '@material-ui/core/InputLabel';
import axios from "axios";
import {TextFields} from "@material-ui/icons";
import TextField from "@material-ui/core/TextField";
import ClickAwayListener from "@material-ui/core/ClickAwayListener";

function CreateDialog( {openCreateDialog, handleCloseCreateDialog}) {

    const [uuid, setUuid] = useState();
    const [title, setTitle] = useState();
    const [day, setDay] = useState(null);
    const [time, setTime] = useState(null);
    const [description, setDescription] = useState();
    const [type, setType] = useState(null);
    const [titleError, setTitleError] = useState(false);
    const [descError, setDescError] = useState(false);

    const createEvent = async () =>{

        if(!titleError || !day || !time || !descError || !type){
            axios.post("/createEvent", {
                uuid: 1147,
                title: title,
                day: day,
                time: time,
                description: description,
                type: type
            });
        } else{
            return null
        }
        handleCloseCreateDialog();
    }

    const updateEvent = () =>{
        // if input if validated
        // axios.put(`/updateEvent${4545}`, event);
    }

    const deleteEvent = () =>{
        axios.delete(`/deleteEvent/${3}`);
    }

    const selectOption = (e) =>{
       setType(e.target.value)
    }

    const handleTitleChange = (e) => {
        if(e.target.value.toString().length > 30){
            setTitleError(true);
        }else{
            setTitleError(false)
            setTitle(e.target.value)
        }
    }

    const handleDescChange = (e) => {
        if(e.target.value.toString().length > 50){
            setDescError(true);
        }else{
            setDescError(false)
            setDescription(e.target.value)
        }
    }

    const handleDayChange = (e) => {
        // const dateInput = e.target.value.toString()
        // if(dateInput.match('/((1[0-2]|0?[1-9]):([0-5][0-9]) ?([AaPp][Mm]))/gm') ){
        //     setDayError(true)
        // }else{
        //     setDay(e.target.value)
        // }
        setDay(e.target.value)
    }

    const handleTimeChange = (e) => {
        setTime(e.target.value);
    }

    return (
            <Dialog open={openCreateDialog} maxWidth={"lg"} onClose={handleCloseCreateDialog}>
                <DialogContent>
                    <DialogTitle>
                        <Typography variant={"subtitle1"} align={"center"} >
                            {"Create a Date"}
                        </Typography>
                    </DialogTitle>
                    <form style={{display: "flex", flexDirection: "column"}}>
                        <InputLabel>Type</InputLabel>
                        <Select onChange={selectOption} variant={"outlined"}>
                            <MenuItem value={"Engagement"}>Engagement</MenuItem>
                            <MenuItem value={"Task"}>Task</MenuItem>
                            <MenuItem value={"Reminder"}>Reminder</MenuItem>
                        </Select>
                        <TextField
                            error={titleError}
                            onChange={handleTitleChange}
                            value={title} label={"Title"}
                            label={!titleError ? "Enter Title": "Title too long"}
                            variant={"outlined"}
                        />
                        <TextField
                            variant={"outlined"}
                            onChange={handleDayChange}
                            value={day}
                            type={"date"}
                        />
                        <TextField variant={"outlined"}onChange={handleTimeChange} value={time} type={"time"}/>
                        <TextField
                            variant={"outlined"}
                            onChange={handleDescChange}
                            value={description}
                            multiline
                            label={!descError ? "Enter description" : "Description too long" }
                            error={descError}
                        />
                        {/*// if validated false disable button and make glow red */}
                        <Button style={{backgroundColor: "#e38686"}} onClick={createEvent}>Post event</Button>
                    </form>
                </DialogContent>
            </Dialog>
    );
}

export default CreateDialog;