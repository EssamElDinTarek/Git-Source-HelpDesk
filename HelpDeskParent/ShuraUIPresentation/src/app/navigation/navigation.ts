import { FuseNavigation } from '@fuse/types';

export const navigation: FuseNavigation[] = [
    {
        id       : 'welcome',
        title    : 'Welcome',
        translate: 'NAV.WELCOME',
        type     : 'group',
        icon     : 'apps',
        children : [
            {
                id       : 'dashboard',
                title    : 'Dashboard',
                translate: 'NAV.DASHBOARD',
                type     : 'item',
                icon     : 'face',
                url      : '/user'
            },
            {
                id       : 'tickets',
                title    : 'Tickets',
                translate: 'NAV.TICKETS',
                type     : 'collapsable',
                icon     : 'apps',
                children      : [
                                    {
                                        id       : 'ticketview',
                                        title    : 'Ticketview',
                                        translate: 'NAV.TICKETVIEW',
                                        type     : 'item',
                                        icon     : 'face',
                                        url      : '/ticketview'
                                    },{
                                        id       : 'submitTicket',
                                        title    : 'Submit Ticket',
                                        translate: 'NAV.TICKETVIEW',
                                        type     : 'item',
                                        icon     : 'face',
                                        url      : '/submitTicket'
                                    }
                ]
            },
            {
                id       : 'teamtickets',
                title    : 'Team Inbox',
                translate: 'Team Inbox',
                type     : 'item',
                icon     : 'account_box',
                url      : '/teaminbox'
            }/* ,
            { 
                id        : 'ticketDetail',
                title     : 'Ticket Detail',
                type      : 'item',
                url       : '/teaminbox/:ticketId',
                exactMatch: true
        } */
        
            /* 
            {
                id       : 'teamtinboxickets',
                title    : 'Team Inbox Temp',
                translate: 'Team Inbox Temp',
                type     : 'item',
                icon     : 'account_box',
                url      : '/teaminboxticket'
            } */

        ]
        
    }

];
