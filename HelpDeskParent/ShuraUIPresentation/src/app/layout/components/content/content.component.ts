import { Component, ViewEncapsulation } from '@angular/core';
import { SharedDataService } from '../../../services/shared-data.service';

@Component({
    selector     : 'content',
    templateUrl  : './content.component.html',
    styleUrls    : ['./content.component.scss'],
    encapsulation: ViewEncapsulation.None
})
export class ContentComponent
{
    /**
     * Constructor
     */
    constructor(private _sharedService:SharedDataService)
    {
    }
}
