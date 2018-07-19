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
                id       : 'welcome',
                title    : 'Welcome',
                translate: 'NAV.WELCOME',
                type     : 'item',
                icon     : 'face',
                url      : '/welcome'
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
                id       : 'Permission',
                title    : 'Permission',
                translate: 'NAV.PERMISSION',
                type     : 'item',
                icon     : 'flag',
                url      : '/perm'
            },
        ]
    }

];
