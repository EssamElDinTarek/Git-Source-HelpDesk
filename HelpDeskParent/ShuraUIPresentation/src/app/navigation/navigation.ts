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
                id       : 'ticketview',
                title    : 'Ticketview',
                translate: 'NAV.TICKETVIEW',
                type     : 'item',
                icon     : 'face',
                url      : '/ticketview'
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
