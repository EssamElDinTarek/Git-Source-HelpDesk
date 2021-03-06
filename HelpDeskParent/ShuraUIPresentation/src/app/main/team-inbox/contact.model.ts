import { FuseUtils } from '@fuse/utils';

export class Contact
{
    ticketId: number;
    title: string;
    creationdate: string;
    description: string;
    status: string;
    ticketnumber: string;
    severityList:string;


    /**
     * Constructor
     *
     * @param contact
     */
    constructor(contact)
    {
        {
            this.ticketId = contact.ticketId || FuseUtils.generateGUID();
            this.title = contact.title ;
            this.creationdate = contact.creationdate;
            this.description = contact.description;
            this.status = contact.status ;
            this.ticketnumber = contact.ticketnumber;
            this.severityList=contact.severityList;
        }
    }
}
