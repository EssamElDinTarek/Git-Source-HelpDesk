export class ProjectDashboardDb
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
        'widget5'      : {
            'title'     : 'Weekely Tasks',
            'ranges'    : {
                 'TW': 'Last Week',
                '2W': '2 Weeks Ago'
            },
            'mainChart' : {
                '2W': [
                    {
                        'name'  : '12-07-2018',
                        'series': [
                            {
                                'name' : 'Tickets',
                                'value': 37
                            },
                            {
                                'name' : 'closed tickets',
                                'value': 9
                            }
                        ]
                    },
                    {
                        'name'  : '13-07-2018',
                        'series': [
                            {
                                'name' : 'Tickets',
                                'value': 32
                            },
                            {
                                'name' : 'closed tickets',
                                'value': 12
                            }
                        ]
                    },
                    {
                        'name'  : '14-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 39
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 9
                            }
                        ]
                    },
                    {
                        'name'  : '15-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 27
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 12
                            }
                        ]
                    },
                    {
                        'name'  : '16-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 18
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 7
                            }
                        ]
                    },
                    {
                        'name'  : '17-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 24
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 8
                            }
                        ]
                    },
                    {
                        'name'  : '18-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 20
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 16
                            }
                        ]
                    }            
                ],
                'TW': [
                    {
                        'name'  : '12-07-2018',
                        'series': [
                            {
                                'name' : 'Tickets',
                                'value': 37
                            },
                            {
                                'name' : 'closed tickets',
                                'value': 9
                            }
                        ]
                    },
                    {
                        'name'  : '13-07-2018',
                        'series': [
                            {
                                'name' : 'Tickets',
                                'value': 32
                            },
                            {
                                'name' : 'closed tickets',
                                'value': 12
                            }
                        ]
                    },
                    {
                        'name'  : '14-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 39
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 9
                            }
                        ]
                    },
                    {
                        'name'  : '15-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 27
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 12
                            }
                        ]
                    },
                    {
                        'name'  : '16-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 18
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 7
                            }
                        ]
                    },
                    {
                        'name'  : '17-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 24
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 8
                            }
                        ]
                    },
                    {
                        'name'  : '18-07-2018',
                        'series': [
                            {
                                'name' : 'ticket',
                                'value': 20
                            },
                            {
                                'name' : 'closed ticket',
                                'value': 16
                            }
                        ]
                    }
                ]
            },
            'supporting': {
                'created'  : {
                    'label': 'CREATED',
                    'count': {
                        '2W': 48,
                        'LW': 46,
                        'TW': 54
                    },
                    'chart': {
                        '2W': [
                            {
                                'name'  : 'CREATED',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 8
                                    },
                                    {
                                        'name' : 'Wed',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Thu',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Fri',
                                        'value': 7
                                    },
                                    {
                                        'name' : 'Sat',
                                        'value': 8
                                    },
                                    {
                                        'name' : 'Sun',
                                        'value': 7
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
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 3
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
                        ],
                        'TW': [
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
                        ]
                    }
                },
                'closed'   : {
                    'label': 'CLOSED',
                    'count': {
                        '2W': 27,
                        'LW': 31,
                        'TW': 26
                    },
                    'chart': {
                        '2W': [
                            {
                                'name'  : 'CLOSED',
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
                        'LW': [
                            {
                                'name'  : 'CLOSED',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Wed',
                                        'value': 4
                                    },
                                    {
                                        'name' : 'Thu',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Fri',
                                        'value': 7
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
                        ],
                        'TW': [
                            {
                                'name'  : 'CLOSED',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 3
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
                'reOpened' : {
                    'label': 'RE-OPENED',
                    'count': {
                        '2W': 4,
                        'LW': 5,
                        'TW': 2
                    },
                    'chart': {
                        '2W': [
                            {
                                'name'  : 'RE-OPENED',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 3
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
                        ],
                        'LW': [
                            {
                                'name'  : 'RE-OPENED',
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
                                'name'  : 'RE-OPENED',
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
                        ]
                    }
                },
                'wontFix'  : {
                    'label': 'WON\'T FIX',
                    'count': {
                        '2W': 6,
                        'LW': 3,
                        'TW': 4
                    },
                    'chart': {
                        '2W': [
                            {
                                'name'  : 'WON\'T FIX',
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
                                        'value': 4
                                    },
                                    {
                                        'name' : 'Thu',
                                        'value': 6
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
                                        'value': 2
                                    }
                                ]
                            }
                        ],
                        'LW': [
                            {
                                'name'  : 'WON\'T FIX',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 3
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
                        ],
                        'TW': [
                            {
                                'name'  : 'WON\'T FIX',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Wed',
                                        'value': 4
                                    },
                                    {
                                        'name' : 'Thu',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Fri',
                                        'value': 7
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
                'needsTest': {
                    'label': 'NEEDS TEST',
                    'count': {
                        '2W': 10,
                        'LW': 7,
                        'TW': 8
                    },
                    'chart': {
                        '2W': [
                            {
                                'name'  : 'NEEDS TEST',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Wed',
                                        'value': 4
                                    },
                                    {
                                        'name' : 'Thu',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Fri',
                                        'value': 7
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
                        ],
                        'LW': [
                            {
                                'name'  : 'NEEDS TEST',
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
                                'name'  : 'NEEDS TEST',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 3
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
                'fixed'    : {
                    'label': 'FIXED',
                    'count': {
                        '2W': 21,
                        'LW': 17,
                        'TW': 14
                    },
                    'chart': {
                        '2W': [
                            {
                                'name'  : 'FIXED',
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
                        'LW': [
                            {
                                'name'  : 'FIXED',
                                'series': [
                                    {
                                        'name' : 'Mon',
                                        'value': 6
                                    },
                                    {
                                        'name' : 'Tue',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Wed',
                                        'value': 4
                                    },
                                    {
                                        'name' : 'Thu',
                                        'value': 5
                                    },
                                    {
                                        'name' : 'Fri',
                                        'value': 7
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
                        ],
                        'TW': [
                            {
                                'name'  : 'FIXED',
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
                                        'value': 4
                                    },
                                    {
                                        'name' : 'Thu',
                                        'value': 6
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
                                        'value': 2
                                    }
                                ]
                            }
                        ]
                    }
                }
            }
        },
        'widget6'      : {
            'title'      : 'Tickets Status',
            'ranges'     : {
                'TW': 'This Week',
                'LW': 'Last Week',
                '2W': '2 Weeks Ago'
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
                'title': 'Tasks Added',
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
            'title'   : 'Tickets Details',
            'ranges'  : {
                'T' : 'Helpdesk',
                'TM': 'Webshpere Portal',
                'T03':'FileNet'
            },
            'schedule': {
                'T' : [
                    {
                        'status'   : 'Open',
                        'title'    : 'Exception Handling',
                    },
                    {
                        'status'   : 'Fixed',
                        'title'    : 'Login Module',
                    },
                    {
                        'status'   : 'Re-Opened',
                        'title'    : 'FileNet',
                    },
                    {
                        'status'   : 'Closed',
                        'title'    : 'Integration',
                    }
                ],
                'TM': [
                    {
                        'status'   : 'Open',
                        'title'    : 'Exception Handling',
                    },
                    {
                        'status'   : 'Closed',
                        'title'    : 'Integration',
                    }
                ],
                'T03': [
                    {
                        'status'   : 'Fixed',
                        'title'    : 'Login Module',
                    },
                    {
                        'status'   : 'Open',
                        'title'    : 'Exception Handling',
                    },
                    {
                        'status'   : 'Closed',
                        'title'    : 'Integration',
                    }
                ]
            }
        },
        'widget8'      : {
            'title'    : 'Budget Distribution',
            'mainChart': [
                {
                    'name' : 'Wireframing',
                    'value': 12
                },
                {
                    'name' : 'Design',
                    'value': 17
                },
                {
                    'name' : 'Coding',
                    'value': 28
                },
                {
                    'name' : 'Marketing',
                    'value': 25
                },
                {
                    'name' : 'Extra',
                    'value': 15
                }
            ]
        },
        'widget9'      : {
            'title'         : 'Spent',
            'ranges'        : {
                'TW': 'This Week',
                'LW': 'Last Week',
                '2W': '2 Weeks Ago'
            },
            'weeklySpent'   : {
                'title': 'WEEKLY SPENT',
                'count': {
                    '2W': '2,682.85',
                    'LW': '1,445.34',
                    'TW': '3,630.15'
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
                'title': 'TOTAL SPENT',
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
                'title': 'REMAINING',
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
                'count': '124.000,00'
            },
            'totalBudget'   : {
                'title': 'TOTAL BUDGET',
                'count': '124.000,00'
            }
        },
        'widget10'     : {
            'title': 'Budget Details',
            'table': {
                'columns': [
                    {
                        'title': 'Budget Type'
                    },
                    {
                        'title': 'Total Budget'
                    },
                    {
                        'title': 'Spent ($)'
                    },
                    {
                        'title': 'Spent (%)'
                    },
                    {
                        'title': 'Remaining ($)'
                    },
                    {
                        'title': 'Remaining (%)'
                    }
                ],
                'rows'   : [
                    [
                        {
                            'value'  : 'Wireframing',
                            'classes': 'mat-primary-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$14,880.00',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$14,000.00',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%94.08',
                            'classes': 'text-success',
                            'icon'   : 'trending_up'
                        },
                        {
                            'value'  : '$880.00',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%5.92',
                            'classes': '',
                            'icon'   : ''
                        }
                    ],
                    [
                        {
                            'value'  : 'Design',
                            'classes': 'mat-green-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$21,080.00',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$17,240.34',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%81.78',
                            'classes': 'text-success',
                            'icon'   : 'trending_up'
                        },
                        {
                            'value'  : '$3,839.66',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%18.22',
                            'classes': '',
                            'icon'   : ''
                        }
                    ],
                    [
                        {
                            'value'  : 'Coding',
                            'classes': 'mat-red-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$34,720.00',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$3,518.00',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%10.13',
                            'classes': 'text-danger',
                            'icon'   : 'trending_down'
                        },
                        {
                            'value'  : '$31,202.00',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%89.87',
                            'classes': '',
                            'icon'   : ''
                        }
                    ],
                    [
                        {
                            'value'  : 'Marketing',
                            'classes': 'mat-accent-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$34,720.00',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$0.00',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%0.00',
                            'classes': 'text-info',
                            'icon'   : 'trending_flat'
                        },
                        {
                            'value'  : '$34,720.00',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%100.00',
                            'classes': '',
                            'icon'   : ''
                        }
                    ],
                    [
                        {
                            'value'  : 'Extra',
                            'classes': 'mat-orange-bg',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$18,600.00',
                            'classes': 'text-bold',
                            'icon'   : ''
                        },
                        {
                            'value'  : '$0.00',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%0.00',
                            'classes': 'text-info',
                            'icon'   : 'trending_flat'
                        },
                        {
                            'value'  : '$34,720.00',
                            'classes': '',
                            'icon'   : ''
                        },
                        {
                            'value'  : '%100.00',
                            'classes': '',
                            'icon'   : ''
                        }
                    ]
                ]
            }
        },
        'widget11'     : {
            'title': 'Team Members',
            'table': {
                'columns': ['avatar','username',  'email'],
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
