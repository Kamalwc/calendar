import React, {useEffect, useState} from 'react'
import axios from 'axios'

function Home(){

    const [users, setUsers] = useState([]);

    useEffect(

        ()=>{
            axios.get('/users').then(response => {
                setUsers(response.data)
            })
        }
    )

    return(
        <div>
            {users.map(user => {
              return <ul>
                  <li>{user.uuid}</li>
                  <li>{user.email}</li>
                  <li>{user.fullName}</li>
              </ul>
            })
            }
        </div>
    )
}

export default Home;