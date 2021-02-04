import React, {useState} from 'react';
import Dialog from "@material-ui/core/Dialog";
import DialogContent from "@material-ui/core/DialogContent";
import DialogTitle from "@material-ui/core/DialogTitle";
import {Typography} from "@material-ui/core";
import MenuItem from "@material-ui/core/MenuItem";
import Select from "@material-ui/core/Select";
import InputLabel from '@material-ui/core/InputLabel';

function CreateDialog(props) {
    const {openCreateDialog} = props;
    const [form, setForm] = useState({
         title: "",
         day:"",
         time:"",
         description: "",
         type: "",
         notification:""
    });
    return (
        <Dialog open={openCreateDialog}>
            <DialogContent>
                <DialogTitle>
                    <Typography variant={"subtitle1"}>
                        {"Create a Date"}
                    </Typography>
                </DialogTitle>
            {/*    YOU MUST ADD VALIDATION FOR ALL OF THESE FEILDS */}
            {/*    select a type */}
                <InputLabel>Type</InputLabel>
                <Select>
                    <MenuItem value={"Engagement"}>Engagement</MenuItem>
                    <MenuItem value={"Task"}>Task</MenuItem>
                    <MenuItem value={"Reminder"}>Reminder</MenuItem>
                </Select>
            {/*select day and time */}
            {/* input feild date description*/}
            {/*add notification*/}
            </DialogContent>
        </Dialog>
    );
}

export default CreateDialog;