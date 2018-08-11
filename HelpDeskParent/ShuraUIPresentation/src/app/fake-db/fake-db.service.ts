import { InMemoryDbService } from 'angular-in-memory-web-api';

import { ProjectDashboardDb } from 'app/fake-db/dashboard-project';
import { AnalyticsDashboardDb } from 'app/fake-db/dashboard-analytics';
import { CalendarFakeDb } from 'app/fake-db/calendar';
import { ECommerceFakeDb } from 'app/fake-db/e-commerce';
import { AcademyFakeDb } from 'app/fake-db/academy';
import { MailFakeDb } from 'app/fake-db/mail';
import { ChatFakeDb } from 'app/fake-db/chat';
import { FileManagerFakeDb } from 'app/fake-db/file-manager';
import { ContactsFakeDb } from 'app/fake-db/contacts';
import { TodoFakeDb } from 'app/fake-db/todo';
import { ScrumboardFakeDb } from 'app/fake-db/scrumboard';
import { InvoiceFakeDb } from 'app/fake-db/invoice';
import { ProfileFakeDb } from 'app/fake-db/profile';
import { SearchFakeDb } from 'app/fake-db/search';
import { FaqFakeDb } from 'app/fake-db/faq';
import { KnowledgeBaseFakeDb } from 'app/fake-db/knowledge-base';
import { IconsFakeDb } from 'app/fake-db/icons';
import { QuickPanelFakeDb } from 'app/fake-db/quick-panel';
import { AdminDashboardDb } from 'app/fake-db/dashboard-admin';
import { ManagerDashboardDb } from 'app/fake-db/dashboard-mgr';
/* import { TicketHistoryFakeDb } from './ticket01_Data';
 */import { TicketssFakeDb } from './tickets';

export class FakeDbService implements InMemoryDbService
{
    createDb(): any
    {
        return {
            // Dashboards
            'project-dashboard-projects' : ProjectDashboardDb.projects,
            'project-dashboard-widgets'  : ProjectDashboardDb.widgets,
            'analytics-dashboard-widgets': AnalyticsDashboardDb.widgets,

              // AdminDashboards
              'admin-dashboard-projects' : AdminDashboardDb.projects,
              'admin-dashboard-widgets'  : AdminDashboardDb.widgets,

              //ManagerDashboards
              'mgr-dashboard-projects' : ManagerDashboardDb.projects,
              'mgr-dashboard-widgets'  : ManagerDashboardDb.widgets,

             // 'Ticket-History':TicketHistoryFakeDb.data,


            // Calendar
            'calendar': CalendarFakeDb.data,

            // E-Commerce
            'e-commerce-dashboard': ECommerceFakeDb.dashboard,
            'e-commerce-products' : ECommerceFakeDb.products,
            'e-commerce-orders'   : ECommerceFakeDb.orders,

            // Academy
            'academy-categories': AcademyFakeDb.categories,
            'academy-courses'   : AcademyFakeDb.courses,
            'academy-course'    : AcademyFakeDb.course,

            // Mail
            'mail-mails'  : MailFakeDb.mails,
            'mail-folders': MailFakeDb.folders,
            'mail-filters': MailFakeDb.filters,
            'mail-labels' : MailFakeDb.labels,

            // Chat
            'chat-contacts': ChatFakeDb.contacts,
            'chat-chats'   : ChatFakeDb.chats,
            'chat-user'    : ChatFakeDb.user,

            // File Manager
            'file-manager': FileManagerFakeDb.files,

            // Contacts
            'contacts-contacts': ContactsFakeDb.contacts,
            //'contacts-user'    : ContactsFakeDb.user,
            
            'ticket-mockup':TicketssFakeDb,

            // Todo
            'todo-todos'  : TodoFakeDb.todos,
            'todo-filters': TodoFakeDb.filters,
            'todo-tags'   : TodoFakeDb.tags,

            // Scrumboard
            'scrumboard-boards': ScrumboardFakeDb.boards,

            // Invoice
            'invoice': InvoiceFakeDb.invoice,

            // Profile
            'profile-timeline'     : ProfileFakeDb.timeline,
            'profile-photos-videos': ProfileFakeDb.photosVideos,
            'profile-about'        : ProfileFakeDb.about,

            // Search
            'search-classic': SearchFakeDb.classic,
            'search-table'  : SearchFakeDb.table,

            // FAQ
            'faq': FaqFakeDb.data,

            // Knowledge base
            'knowledge-base': KnowledgeBaseFakeDb.data,

            // Icons
            'icons': IconsFakeDb.icons,

            // Quick Panel
            'quick-panel-notes' : QuickPanelFakeDb.notes,
            'quick-panel-events': QuickPanelFakeDb.events
        };
    }
}
