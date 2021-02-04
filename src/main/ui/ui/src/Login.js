import React, {useEffect, useState} from 'react'
import axios from "axios";
import CircularProgress from '@material-ui/core/CircularProgress';


const Login = () =>{
    const [users, setUsers] =useState();
    const [loading, setLoading] = useState(true)


    useEffect(() =>{
        axios.get("/users").then(x => {
            setUsers(x.data)
            setLoading(false)
        }) }, [])
        return(
            <div>
                {
                    loading ?
                        <CircularProgress/> :
                        users.map(x=>{
                            return(<h1> {x.fullName}</h1>)
                        })
                }
            </div>
        )
    }

    export default Login;