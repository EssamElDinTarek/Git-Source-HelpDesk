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
                                        id       : 'createticket',
                                        title    : 'Create Ticket',
                                        translate: 'NAV.TICKETVIEW',
                                        type     : 'item',
                                        icon     : 'face',
                                        url      : '/createticket'
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

            {
                id       : 'dashboard',
                title    : 'User-DashBoard',
                translate: 'NAV.USERDASHBOARDS',
                type     : 'item',
                icon     : 'flag',
                url       :'/user'
            },

            {
                id       : 'dashboard',
                title    : 'Admin-DashBoard',
                translate: 'NAV.ADMINDASHBOARDS',
                type     : 'item',
                icon     : 'flag',
                url       :'/admin'
            },
            {
                id       : 'dashboard',
                title    : 'Manager-DashBoard',
                translate: 'NAV.MGRDASHBOARDS',
                type     : 'item',
                icon     : 'flag',
                url       :'/manager'
            }

        ]
        
    }

];
