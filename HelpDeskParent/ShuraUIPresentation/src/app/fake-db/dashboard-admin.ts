export class AdminDashboardDb
{
    public static projects = [
        {
            'name': 'ACME Corp. Backend App'
        },
        {
            'name': 'ACME Corp. Frontend App'
        },
        {
            'name': 'Creapond'
        },
        {
            'name': 'Withinpixels'
        }
    ];

    public static widgets = {
        'widget1'      : {
            'ranges'      : {
                'DY' : 'Yesterday',
                'DT' : 'Today',
                'DTM': 'Tomorrow'
            },
            'currentRange': 'DT',
            'data'        : {
                'label': 'DUE TASKS',
                'count': {
                    'DY' : 21,
                    'DT' : 25,
                    'DTM': 19
                },
                'extra': {
                    'label': 'Completed',
                    'count': {
                        'DY' : 6,
                        'DT' : 7,
                        'DTM': '-'
                    }

                }
            },
            'detail'      : 'You can show some detailed information about this widget in here.'
        },
        'widget2'      : {
            'title' : 'Overdue',
            'data'  : {
                'label': 'TASKS',
                'count': 4,
                'extra': {
                    'label': 'Yesterday\'s overdue',
                    'count': 2
                }
            },
            'detail': 'You can show some detailed information about this widget in here.'
        },
        'widget3'      : {
            'title' : 'Project Tasks',
            'data'  : {
                'label': 'OPEN',
                'count': 5,
                'extra': {
                    'label': 'Closed today',
                    'count': 3
                }
            },
            'detail': 'You can show some detailed information about this widget in here.'
        },
        'widget4'      : {
            'title' : 'Features',
            'data'  : {
                'label': 'PROPOSALS',
                'count': 42,
                'extra': {
                    'label': 'Implemented',
                    'count': 8
                }
            },
            'detail': 'You can show some detailed information about this widget in here.'
        },
        
        'widget6'      : {
            'title'      : 'Project Status',
            'ranges'     : {
                'TW': 'Shura',
                'LW': 'SBM Sales',
                '2W': 'IBM'
            },
            'mainChart'  : {
                'TW': [
                    {
                        'name' : 'Open',
                        'value': 43
                    },
                    {
                        'name' : 'Fixed',
                        'value': 7
                    },
                    {
                        'name' : 'Closed',
                        'value': 30
                    },
                    {
                        'name' : 'In progress',
                        'value': 10
                    }
                ],
                'LW': [
                    {
                        'name' : 'Open',
                        'value': 12
                    },
                    {
                        'name' : 'Fixed',
                        'value': 20
                    },
                    {
                        'name' : 'Closed',
                        'value': 33
                    },
                    {
                        'name' : 'In progress',
                        'value': 5
                    }
                ],
                '2W': [
                    {
                        'name' : 'Open',
                        'value': 50
                    },
                    {
                        'name' : 'Fixed',
                        'value': 30
                    },
                    {
                        'name' : 'Closed',
                        'value': 30
                    },
                    {
                        'name' : 'In progress',
                        'value': 40
                    }
                ]
            },
            'footerLeft' : {
                'title': 'Portofolio Added',
                'count': {
                    '2W': 150,
                    'LW': 70,
                    'TW': 90
                }
            },
            'footerRight': {
                'title': 'Tasks Completed',
                'count': {
                    '2W': 60,
                    'LW': 55,
                    'TW': 37
                }
            }
        },
        'widget7'      : {
            'title'   : 'Portfolios',
            'ranges'  : {
                'T' : 'SBM',
                'TM': 'STC',
                'r3':'Mobily'
            },
            'schedule': {
                'T' : [
                    {
                        'title'   : 'Shura',
                        'time'    : 'System Analysis Team',
                    },
                    {
                        'title'   : 'Helpdesk',
                        'time'    : 'Support Team',
                    },
                    {
                        'title'   : 'FileNet',
                        'time'    : 'FileNet Manager',
                    },
                    {
                        'title'   : 'Message Broker',
                        'time'    : 'Integration',
                    }
                ],
                'TM': [
                    {
                        'title'   : 'Webshpere Portal',
                        'time'    : 'Portal',
                    },
                    {
                        'title'   : 'Helpdesk',
                        'time'    : 'Dev Team',
                    },
                    {
                        'title'   : 'ESB',
                        'time'    : 'Middlware',
                    },
                    {
                        'title'   : 'FileNet',
                        'time'    : 'FileNet',
                    }
                ],
                'r3':[
                    {
                        'title'   : 'Webshpere Portal',
                        'time'    : 'Portal',
                    },
                    {
                        'title'   : 'Helpdesk',
                        'time'    : 'Dev Team',
                    }
                ]
            }
        },
        'widget8'      : {
            'title'    : 'Portofolios',
            'mainChart': [
                {
                    'name' : 'SBM Projects',
                    'value': 50
                },
                {
                    'name' : 'Mobily Projects',
                    'value': 12
                },
                {
                    'name' : 'STC Projects',
                    'value': 7
                },
                {
                    'name' : 'RiyadhBank Projects',
                    'value': 20
                },
                {
                    'name' : 'Other Projects',
                    'value': 11
                }
                
            ]
        },
        'widget9'      : {
            'title'         : 'Projects',
            'ranges'        : {
                'TW': 'SBM',
                'LW': 'IBM'
            },
            'weeklySpent'   : {
                'title': 'HelpDesk',
                'count': {
                    'TW': '25,682.85',
                    'LW': '18,445.34'
                                },
                'chart': {
                    '2W': [
                        {
                            'name'  : 'CREATED',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 6
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 1
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 3
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 4
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 5
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 5
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 2
                                }
                            ]
                        }
                    ],
                    'LW': [
                        {
                            'name'  : 'Created',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 4
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 6
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 2
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 2
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 1
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 3
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 4
                                }
                            ]
                        }
                    ],
                    'TW': [
                        {
                            'name'  : 'Created',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 2
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 6
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 5
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 4
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 5
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 3
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 6
                                }
                            ]
                        }
                    ]
                }
            },
            'totalSpent'    : {
                'title': 'Shura',
                'count': {
                    '2W': '29,682.85',
                    'LW': '31,128.19',
                    'TW': '34,758.34'
                },
                'chart': {
                    '2W': [
                        {
                            'name'  : 'CREATED',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 3
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 2
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 2
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 4
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 7
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 7
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 4
                                }
                            ]
                        }
                    ],
                    'LW': [
                        {
                            'name'  : 'Created',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 5
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 7
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 8
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 8
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 6
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 4
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 1
                                }
                            ]
                        }
                    ],
                    'TW': [
                        {
                            'name'  : 'Created',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 6
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 4
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 7
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 5
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 5
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 4
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 7
                                }
                            ]
                        }
                    ]
                }
            },
            'remaining'     : {
                'title': 'FileNet',
                'count': {
                    '2W': '94.317,15',
                    'LW': '92.871,81',
                    'TW': '89.241,66'
                },
                'chart': {
                    '2W': [
                        {
                            'name'  : 'CREATED',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 1
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 4
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 5
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 7
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 8
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 2
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 4
                                }
                            ]
                        }
                    ],
                    'LW': [
                        {
                            'name'  : 'Created',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 3
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 2
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 1
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 4
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 8
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 8
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 4
                                }
                            ]
                        }
                    ],
                    'TW': [
                        {
                            'name'  : 'Created',
                            'series': [
                                {
                                    'name' : 'Mon',
                                    'value': 2
                                },
                                {
                                    'name' : 'Tue',
                                    'value': 4
                                },
                                {
                                    'name' : 'Wed',
                                    'value': 8
                                },
                                {
                                    'name' : 'Thu',
                                    'value': 6
                                },
                                {
                                    'name' : 'Fri',
                                    'value': 2
                                },
                                {
                                    'name' : 'Sat',
                                    'value': 5
                                },
                                {
                                    'name' : 'Sun',
                                    'value': 1
                                }
                            ]
                        }
                    ]
                }
            },
            'totalRemaining': {
                'title': 'TOTAL BUDGET',
                'count': '149.682,85'
            },
            'totalBudget'   : {
                'title': 'TOTAL BUDGET',
                'count': '142.445,34'
            }
        },
        'widget10'     : {
            'title': 'Portofolio Details',
            'table': {
                'columns': [
                    {
                        'title': 'Portofolio Name'
                    },
                    {
                        'title': 'No.Of projects'
                    },
                    {
                        'title': 'Open'
                    },
                    {
                        'title': 'Closed'
                    }
                ],
                'rows'   : [
                    [
                        {
                            'value'  : 'SBM',
                            'classes': 'mat-primary-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '50',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'34',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'16',
                            'classes': 'text-bold',
                            'icon'   : ''   
                        }
                    ],
                    
                    [
                        {
                            'value'  : 'STC',
                            'classes': 'mat-red-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '7',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'2',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'5',
                            'classes': 'text-bold',
                            'icon'   : ''   
                        }
                    ],
                    [
                        {
                            'value'  : 'Mobily',
                            'classes': 'mat-orange-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '12',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'6',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'6',
                            'classes': 'text-bold',
                            'icon'   : ''   
                        }
                    ],
                    [
                        {
                            'value'  : 'RiyadhBank',
                            'classes': 'mat-blue-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '20',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'11',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'9',
                            'classes': 'text-bold',
                            'icon'   : ''   
                        }
                    ],
                    [
                        {
                            'value'  : 'Others',
                            'classes': 'mat-default-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '11',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'5',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value':'6',
                            'classes': 'text-bold',
                            'icon'   : ''   
                        }
                    ],
                ],
                
            }
        },
        'widget11'     : {
            'title': 'Users',
            'table': {
                'columns': ['avatar', 'name', 'position',  'email', 'phone'],
                'rows'   : [
                    {
                        avatar  : 'assets/images/avatars/james.jpg',
                        name    : 'Jack Gilbert',
                        position: 'Design Manager',
                        email   : 'jgilbert48@mail.com',
                        phone   : '+16 298 032 7774'
                    },
                    {
                        avatar  : 'assets/images/avatars/katherine.jpg',
                        name    : 'Kathy Anderson',
                        position: 'Recruiting Manager',
                        email   : 'kanderson49@mail.com.br',
                        phone   : '+23 572 311 1136'
                    },
                    {
                        avatar  : 'assets/images/avatars/andrew.jpg',
                        name    : 'Mark Turner',
                        position: 'Recruiting Manager',
                        email   : 'mturner4a@mail.com',
                        phone   : '+01 139 803 9263'
                    },
                    {
                        avatar  : 'assets/images/avatars/jane.jpg',
                        name    : 'Kathryn Martinez',
                        position: 'Director of Sales',
                        email   : 'kmartinez4b@mail.com',
                        phone   : '+25 467 022 5393'
                    },
                    {
                        avatar  : 'assets/images/avatars/alice.jpg',
                        name    : 'Annie Gonzales',
                        position: 'Actuary',
                        email   : 'agonzales4c@mail.edu',
                        phone   : '+99 891 619 7138'
                    },
                    {
                        avatar  : 'assets/images/avatars/vincent.jpg',
                        name    : 'Howard King',
                        position: 'Human Resources',
                        email   : 'hking4d@mail.gov',
                        phone   : '+46 984 348 1409'
                    },
                    {
                        avatar  : 'assets/images/avatars/joyce.jpg',
                        name    : 'Elizabeth Dixon',
                        position: 'Electrical Engineer',
                        email   : 'edixon4e@mail.gov',
                        phone   : '+33 332 067 9063'
                    },
                    {
                        avatar  : 'assets/images/avatars/danielle.jpg',
                        name    : 'Dorothy Morris',
                        position: 'Office Assistant',
                        email   : 'dmorris4f@mail.com',
                        phone   : '+05 490 958 6120'
                    },
                    {
                        avatar  : 'assets/images/avatars/carl.jpg',
                        name    : 'Mark Gonzales',
                        position: 'Quality Control',
                        email   : 'mgonzales4g@mail.com',
                        phone   : '+03 168 394 9935'
                    },
                    {
                        avatar  : 'assets/images/avatars/profile.jpg',
                        name    : 'Catherine Rogers',
                        position: 'Programmer Analyst',
                        email   : 'crogers4h@mail.com',
                        phone   : '+86 235 407 5373'
                    }        
                ]
            }
        },
        'weatherWidget': {
            'locations'      : {
                'NewYork': {
                    'name'           : 'New York',
                    'icon'           : 'icon-rainy2',
                    'temp'           : {
                        'C': '22',
                        'F': '72'
                    },
                    'windSpeed'      : {
                        'KMH': 12,
                        'MPH': 7.5
                    },
                    'windDirection'  : 'NW',
                    'rainProbability': '98%',
                    'next3Days'      : [
                        {
                            'name': 'Sunday',
                            'icon': 'icon-rainy',
                            'temp': {
                                'C': '21',
                                'F': '70'
                            }
                        },
                        {
                            'name': 'Sunday',
                            'icon': 'icon-cloudy',
                            'temp': {
                                'C': '19',
                                'F': '66'
                            }
                        },
                        {
                            'name': 'Tuesday',
                            'icon': 'icon-windy3',
                            'temp': {
                                'C': '24',
                                'F': '75'
                            }
                        }
                    ]
                }
            },
            'currentLocation': 'NewYork',
            'tempUnit'       : 'C',
            'speedUnit'      : 'KMH'
        }
    };
}
